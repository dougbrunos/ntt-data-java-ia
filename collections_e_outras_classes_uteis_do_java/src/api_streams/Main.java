package api_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Um Stream é uma sequência de elementos que pode ser processada de forma funcional.
        // Ele permite operações como filtragem, mapeamento e redução de dados de maneira eficiente e concisa.

        /*
        var value1 = Stream.generate(() -> new Random().nextInt()).limit(5).toArray(Integer[]::new);

        for (var v: value1) {
            System.out.println(v);
        }

        System.out.println("-------------------");

        var value2 = IntStream.generate(() -> new Random().nextInt()).limit(5).toArray();

        for (var v: value2) {
            System.out.println(v);
        }
        */

        List<String> debugValues = new ArrayList<>();
        var value = Stream.of("Maria", "João", "José", "Ana")
                // .peek(System.out::println) // Peek é usado para depuração, não altera o fluxo, utilizado para debugging
                .peek(debugValues::add) // Peek adiciona os elementos ao debugValues para visualização
                .filter(name -> name.toUpperCase().endsWith("A")) // Filter filtra os elementos do Stream, neste caso, aqueles que terminam com "A"
                .map(String::toUpperCase) // Map transforma cada elemento do Stream, neste caso, converte para maiúsculas
                .toList();

        System.out.println(debugValues);
        System.out.println(value);
    }
}
