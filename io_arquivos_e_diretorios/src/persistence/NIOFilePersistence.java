package persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class NIOFilePersistence implements FilePersistence {

    private final String currentDir = System.getProperty("user.dir"); // Current working directory
    private final String storedDir = "/managedFiles/NIO/"; // Directory for managed files
    private final String fileName;

    public NIOFilePersistence(String fileName) throws IOException {
        this.fileName = fileName;
        var file = new File(currentDir + storedDir);
        if (!file.exists() && !file.mkdirs())
            throw new IOException("Erro ao criar diretório!");
        clearFile(); // Clear the file at initialization
    }

    @Override
    public String write(String data) {
        try (var file = new RandomAccessFile(new File(currentDir + storedDir + fileName), "rw");) {
            file.seek(file.length()); // Move to the end of the file
            file.writeBytes(data); // Write the data to the file
            file.writeBytes(System.lineSeparator()); // Add a new line after the data
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean remove(String sentence) {
        var contentList = toListString();
        if (contentList.stream().noneMatch(c -> c.contains(sentence)))
            return false;

        clearFile(); // Clear the file before rewriting
        contentList.stream()
                .filter(c -> !c.contains(sentence))
                .forEach(this::write);

        return true;
    }

    @Override
    public String replace(String oldContent, String newContent) {
        var contentList = toListString();
        if (contentList.stream().noneMatch(c -> c.contains(oldContent)))
            return "";

        clearFile(); // Clear the file before rewriting
        contentList.stream()
                .map(c -> c.contains(oldContent) ? newContent : c)
                .forEach(this::write);

        return newContent;
    }

    @Override
    public String findAll() {
        var content = new StringBuilder();
        try (
                var file = new RandomAccessFile(new File(currentDir + storedDir + fileName), "r");
                var channel = file.getChannel();) {
            var buffer = ByteBuffer.allocate(256);
            var bytesReader = channel.read(buffer);
            while (bytesReader != -1) {
                buffer.flip(); // Prepare the buffer for reading
                while (buffer.hasRemaining()) {
                    content.append((char) buffer.get()); // Read each byte as a character
                }
                buffer.clear(); // Clear the buffer for the next read
                bytesReader = channel.read(buffer); // Read more bytes
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    @Override
    public String findBy(String sentence) {
        var content = new StringBuilder();
        try (
                var file = new RandomAccessFile(new File(currentDir + storedDir + fileName), "r");
                var channel = file.getChannel();) {
            var buffer = ByteBuffer.allocate(256);
            var bytesReader = channel.read(buffer);
            while (bytesReader != -1) {
                buffer.flip(); // Prepare the buffer for reading
                while (buffer.hasRemaining()) {
                    while (!content.toString().endsWith(System.lineSeparator())) {
                        content.append((char) buffer.get()); // Read each byte as a character
                    }
                    if (content.toString().contains(sentence)) {
                        break;
                    } else {
                        content.setLength(0); // Clear the content if not found
                    }
                    if (!content.isEmpty())
                        break;
                }
                buffer.clear(); // Clear the buffer for the next read
                bytesReader = channel.read(buffer); // Read more bytes
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private List<String> toListString() {
        var content = findAll();
        return new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());
    }

    private void clearFile() {
        try (OutputStream outputStream = new FileOutputStream(currentDir + storedDir + fileName)) {
            System.out.printf("Inicializando recursos (%s) \n", currentDir + storedDir + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}