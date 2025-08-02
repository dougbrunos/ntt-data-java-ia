package heranca_e_polimorfismo;

public class Main {
    public static void main(String[] args) {
        Colaborador gerente = new Gerente();
        imprimirColaborador(gerente);
        imprimirColaborador(new Vendedor());
    }

    public static void imprimirColaborador(Colaborador colaborador) {
        System.out.printf("=======%s=======\n", colaborador.getClass().getCanonicalName());
        if (colaborador instanceof Gerente gerente) {
            colaborador.setNome("João");
            gerente.setUsuario("Joao");
            gerente.setSenha("123456");

            System.out.println(colaborador.getNome());
            System.out.println(gerente.getUsuario());
            System.out.println(gerente.getSenha());
        }
        System.out.println("================");

    }

}