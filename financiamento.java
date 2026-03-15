package modelo;

public abstract class financiamento {
    protected double valorImovel;
    protected int prazoAnos;
    protected double taxaJurosAnual;

    public financiamento(double valorImovel, int prazoAnos, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoAnos = prazoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel() { return valorImovel; }
    public int getPrazoAnos() { return prazoAnos; }
    public double getTaxaJurosAnual() { return taxaJurosAnual; }

    // metodo abstract
    public abstract double calcularParcelaMensal() throws Exception;

    public double calcularTotalPago() throws Exception {
        return calcularParcelaMensal() * prazoAnos * 12;
    }

    public void mostrarDados() throws Exception {
        System.out.println("Imóvel: R$ " + valorImovel);
        System.out.println("Prazo: " + prazoAnos + " anos");
        System.out.println("Taxa: " + (taxaJurosAnual * 100) + "% ao ano");
        System.out.printf("Parcela mensal: R$ %.2f%n", calcularParcelaMensal());
        System.out.printf("Total pago: R$ %.2f%n", calcularTotalPago());
    }
}
