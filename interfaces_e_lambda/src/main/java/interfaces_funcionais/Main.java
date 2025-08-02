package interfaces_funcionais;

import java.util.List;
import java.util.function.Function;

public class Main {
    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Alice", 30),
                new User("Bob", 25),
                new User("Charlie", 35));

        // Using lambda expressions
        /*
        users.forEach(user -> System.out.println(user));
        users.forEach(System.out::println);
         */

        printStringValue(User::name, users);
    }

    // Explique a função abaixo
    /** 
     * Receives a Function that takes a User and returns a String.
     * It applies this function to each User in the list and prints the result.
     *
     * @param callback a Function that maps User to String
     * @param users    a List of User objects
     */
    @SuppressWarnings("Convert2Lambda")
    private static void printStringValue(Function<User, String> callback, List<User> users) {
        users.forEach(u -> System.out.println(callback.apply(u)));
    }

}
