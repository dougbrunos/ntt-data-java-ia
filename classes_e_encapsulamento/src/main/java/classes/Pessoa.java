package classes;

import java.time.OffsetDateTime;

public class Pessoa {

    private final String nome; // Contante, valor não pode ser alterado
    private int idade;
    private int incrementarIdade = OffsetDateTime.now().getYear();

    // Construtor para inicializar o nome
    public Pessoa(String nome) {
        this.nome = nome;
        this.idade = 1;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void incIdade() {
        if (this.incrementarIdade >= OffsetDateTime.now().getYear()) return;

        this.idade += 1;
        this.incrementarIdade = OffsetDateTime.now().getYear();
    }
    
}
