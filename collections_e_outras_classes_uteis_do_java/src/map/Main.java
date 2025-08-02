package map;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, User> users = new HashMap<>();
        users.put("joao@email.com", new User("João", 30));
        users.put("maria@email.com", new User("Maria", 25));
        users.put("pedro@email.com", new User("Pedro", 28));

        /*
        System.out.println(users);
        System.out.println("==================");
        users.keySet().forEach(System.out::println);
        System.out.println("==================");
        users.values().forEach(System.out::println);
        System.out.println("==================");

        System.out.println(users.containsKey("maria@email.com"));
        System.out.println(users.containsValue(new User("Maria", 25)));
        */

        users.remove("joao@email.com");
        System.out.println(users);
    }
}
