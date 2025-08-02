package heranca_e_polimorfismo;

/*
Classes seladas (sealed classes) são uma funcionalidade introduzida no Java 15 que permite aos desenvolvedores controlar quais classes podem 
estender uma classe base. Isso é útil para restringir a hierarquia de herança e garantir que apenas classes específicas possam herdar de uma classe base, 
promovendo um design mais seguro e previsível.
Neste exemplo, a classe `Colaborador` é declarada como uma classe selada, permitindo apenas que as classes `Gerente` e `Vendedor` a estendam. 
Isso significa que não é possível criar outras subclasses de `Colaborador`, garantindo que a hierarquia de herança permaneça controlada.
A classe `Colaborador` contém atributos comuns a todos os colaboradores, como `id`, `nome`, `endereco`, `idade` e `salario`. 
Esses atributos podem ser acessados e modificados através de métodos getters e setters, permitindo encapsulamento e controle sobre os dados dos colaboradores.
As classes `Gerente` e `Vendedor` devem ser definidas em outro lugar no código, e elas herdarão os atributos e métodos da classe `Colaborador`, 
podendo adicionar suas próprias características e comportamentos específicos. Isso demonstra o conceito de herança, 
onde uma classe filha herda propriedades e comportamentos da classe pai.
Além disso, o polimorfismo pode ser aplicado quando se trabalha com referências do tipo `Colaborador`. 
Por exemplo, é possível criar uma lista de colaboradores que pode conter tanto gerentes quanto vendedores, 
permitindo que métodos que operam sobre colaboradores tratem ambos os tipos de forma uniforme, mas com comportamentos específicos quando necessário.
*/

public sealed abstract class Colaborador permits Gerente, Vendedor {

    private int id;
    private String nome;
    private String endereco;
    private int idade;
    private double salario;

    public Colaborador() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}