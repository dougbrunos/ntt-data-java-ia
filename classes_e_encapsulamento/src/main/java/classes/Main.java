package classes;

public class Main {
    public static void main(String[] args) {
        var pessoa1 = new Pessoa("João");
        // pessoa1.setIdade(30);

        pessoa1.incIdade(); // Incrementa a idade de João, depois de um ano

        var pessoa2 = new Pessoa("Maria");
        System.out.println("Pessoa 1: " + pessoa1.getNome() + ", Idade: " + pessoa1.getIdade());
        System.out.println("Pessoa 2: " + pessoa2.getNome() + ", Idade: " + pessoa2.getIdade());
    }
}