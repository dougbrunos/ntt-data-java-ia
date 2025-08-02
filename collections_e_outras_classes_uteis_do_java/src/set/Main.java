package set;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Set é uma coleção que não permite elementos duplicados e não garante a ordem de inserção.
        // HashSet é uma implementação de Set que usa uma tabela hash para armazenar os elementos, oferecendo operações de inserção, remoção e busca em tempo constante, em média.
        Set<User> users = new HashSet<>();
        users.add(new User(1, "Alice"));
        users.add(new User(2, "Bob"));
        users.add(new User(3, "Charlie"));

        System.out.println(new User(21, "Alice").hashCode());
        System.out.println(new User(12, "Ailce").hashCode());
        
        System.out.println(users.contains(new User(3, "Charlie")));

        // users.forEach(System.out::println);

        var iterator = users.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}