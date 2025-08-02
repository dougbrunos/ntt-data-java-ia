import java.util.ArrayList;
import java.util.List;

import collections.User;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        List<String> test = new ArrayList<>();
        test.add("a");
        test.add("1");
        System.out.println(test.get(0));
        
        int[] codes = new int[2];
        codes[0] = 123;
        codes[1] = 456;
        for (int code : codes) System.out.println(code);

        System.out.println("=======");

        List<Integer> codes2 = new ArrayList<>();
        codes2.add(codes[0]);
        codes2.add(codes[1]);
        codes2.forEach(System.out::println);
        codes2.add(1);
        */

        List<User> users = new ArrayList<>();
        User user = new User(123, "Douglas");
        users.add(user);
        users.add(new User(987, "Joao"));
        users.add(new User(456, "Maria"));
        System.out.println(users.contains(user));
        System.out.println(users.contains(new User(456, "Maria")));
        System.out.println(users.size());
        System.out.println(users.isEmpty());
        System.out.println(users.isEmpty());
        System.out.println(users.get(0).toString());
    }
}
