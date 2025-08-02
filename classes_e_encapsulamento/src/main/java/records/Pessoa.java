package records;

// O Record é uma funcionalidade do Java que permite criar classes imutáveis de forma mais concisa.
// Todo atributo declarado em um record é final(constante), ou seja, não pode ser alterado após a criação do objeto.
public record Pessoa(String nome, int idade) {
    // O construtor é gerado automaticamente e é privado.
    // O compact construtor é usado para validar os dados ou realizar outras operações.
}
 