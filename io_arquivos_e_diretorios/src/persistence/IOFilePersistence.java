package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Stream;

public class IOFilePersistence implements FilePersistence {

    private final String currentDir = System.getProperty("user.dir"); // Current working directory
    private final String storedDir = "/managedFiles/IO/"; // Directory for managed files
    private final String fileName;

    public IOFilePersistence(String fileName) throws IOException {
        this.fileName = fileName;
        var file = new File(currentDir + storedDir);
        if (!file.exists() && !file.mkdirs())
            throw new IOException("Erro ao criar diretório!");
        clearFile(); // Clear the file at initialization
    }

    @Override
    public String write(final String data) {
        // Implementation for writing data to a file
        try (
                var fileWriter = new FileWriter(currentDir + storedDir + fileName, true);
                var bufferedWriter = new BufferedWriter(fileWriter);
                var printWriter = new PrintWriter(bufferedWriter);
        // This try-with-resources statement ensures that resources are closed
        // automatically
        ) {
            printWriter.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean remove(final String sentence) {
        var content = findAll();
        var contentList = new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());

        if (contentList.stream().noneMatch(c -> c.contains(sentence)))
            return false;

        clearFile(); // Clear the file before writing back the remaining content
        contentList.stream()
                .filter(c -> !c.contains(sentence))
                .forEach(this::write);

        return true;
    }

    @Override
    public String replace(final String oldContent, final String newContent) {
        // Implementation for replacing content in a file
        var content = findAll();
        var contentList = new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());

        if (contentList.stream().noneMatch(c -> c.contains(oldContent)))
            return "";

        clearFile();
        contentList.stream()
                .map(c -> c.contains(oldContent) ? newContent : c)
                .forEach(this::write);

        return newContent;
    }

    @Override
    public String findAll() {
        var content = new StringBuilder();
        try (var reader = new BufferedReader(new FileReader(currentDir + storedDir + fileName))) {
            String line;
            do {
                line = reader.readLine();
                if (line != null)
                    content.append(line).append(System.lineSeparator());
            } while (line != null);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return content.toString();
    }

    @Override
    public String findBy(final String sentence) {
        String found = "";
        try (var reader = new BufferedReader(new FileReader(currentDir + storedDir + fileName))) {
            String line = reader.readLine();
            while (line != null) {
                if (line.contains(sentence)) {
                    found = line;
                    break;
                }
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return found;
    }

    private void clearFile() {
        try (OutputStream outputStream = new FileOutputStream(currentDir + storedDir + fileName)) {
            System.out.printf("Inicializando recursos (%s) \n", currentDir + storedDir + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}