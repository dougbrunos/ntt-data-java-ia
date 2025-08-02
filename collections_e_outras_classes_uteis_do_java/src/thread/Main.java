package thread;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Explique o conceito de thread
    // Uma thread é uma unidade de execução dentro de um processo. 
    // Em Java, as threads permitem que você execute tarefas simultaneamente, melhorando a eficiência e a capacidade de resposta do seu aplicativo.
    // De um exemplo de uma aplicativo real que utiliza threads
    // Um exemplo comum é um servidor web que lida com múltiplas requisições de clientes simultaneamente, utilizando uma thread para cada requisição.
    // Sincronização é o mecanismo que garante que apenas uma thread possa acessar um recurso compartilhado por vez, evitando condições de corrida e inconsistências nos dados.

    private final static List<Integer> numbers = new ArrayList<>();

    private synchronized static void inc(int number) {
            numbers.add(number);
    }

    private synchronized static void show() {
            System.out.println(numbers);
    }

    public static void main(String[] args) {
        Runnable inc = () -> {
            for (int i = 0; i < 10; i++) {
                inc(i);
            }
        };

        Runnable dec = () -> {
            for (int i = 10; i > 0; i--) {
                numbers.add(i);
            }
        };

        Runnable show = () -> {
            for (int i = 0; i < 25; i++) {
                show();
            }
        };

        new Thread(inc).start();
        new Thread(dec).start();
        new Thread(show).start();

    }

}
