package persistence;

public interface FilePersistence {

    String write(final String data);

    boolean remove(final String sentence);

    String replace(final String oldContente, final String newContent);

    String findAll();

    String findBy(final String sentence);

}