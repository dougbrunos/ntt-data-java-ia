import java.io.IOException;

import persistence.FilePersistence;
import persistence.IOFilePersistence;
import persistence.NIOFilePersistence;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
         * FilePersistence persistence = new IOFilePersistence("user.csv");
         * persistence.write("Douglas;douglas@gmail.com;01/02/2000;");
         * persistence.write("Joao;joao@gmail.com;01/03/2001;");
         * persistence.write("Marcos;marcos@gmail.com;01/01/2002;");
         * System.out.println(persistence.findAll());
         * System.out.println(persistence.findBy("Joao;"));
         * System.out.println(persistence.findBy(";marcos@"));
         * System.out.println(persistence.findBy("02"));
         * System.out.println("--------------------");
         * System.out.println(persistence.remove("Joao;"));
         * System.out.println(persistence.findBy("Joao;"));
         * System.out.println("--------------------");
         * System.out.println(persistence.replace(
         * "Douglas;","Douglas Silva;douglas@gmail.com;01/02/2000;"));
         * System.out.println(persistence.findAll());
         */
        FilePersistence persistence = new NIOFilePersistence("user.csv");
        System.out.println(persistence.write("Douglas;douglas@gmail.com;01/02/2000;"));
        System.out.println("==========================");
        System.out.println(persistence.write("Joao;joao@gmail.com;01/03/2001;"));
        System.out.println("==========================");
        System.out.println(persistence.findAll());
        System.out.println("==========================");
        System.out.println(persistence.findBy("Joao;"));
        System.out.println("==========================");
        System.out.println(persistence.remove(";douglas@"));
        System.out.println("==========================");
        System.out.println(persistence.findAll());
        System.out.println("==========================");
        System.out.println(persistence.replace("Joao;", "Joao Silva;joao@gmail.com;01/03/2001;"));
        System.out.println("==========================");
        System.out.println(persistence.findAll());
    }

}