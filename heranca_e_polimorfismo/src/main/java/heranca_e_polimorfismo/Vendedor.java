package heranca_e_polimorfismo;

public non-sealed class Vendedor extends Colaborador {

    private double porcentagemPorVenda;

    public Vendedor() {
    }

    public double getPorcentagemPorVenda() {
        return porcentagemPorVenda;
    }

    public void setPorcentagemPorVenda(double porcentagemPorVenda) {
        this.porcentagemPorVenda = porcentagemPorVenda;
    }

}
