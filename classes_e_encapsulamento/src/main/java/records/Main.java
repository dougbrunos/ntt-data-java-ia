package records;

public class Main {
    public static void main(String[] args) {
        var pessoa = new Pessoa("João", 12);
        //System.out.println(pessoa);
        System.out.println(pessoa.nome());
        System.out.println(pessoa.idade());
    }
}
