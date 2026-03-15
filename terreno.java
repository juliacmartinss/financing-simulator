package modelo;

public class terreno extends financiamento {

    public terreno(double valorImovel, int prazoAnos, double taxaJurosAnual) {
        super(valorImovel, prazoAnos, taxaJurosAnual);
    }

    @Override
    public double calcularParcelaMensal() {
        double taxaMensal = this.taxaJurosAnual / 12;
        int meses = this.prazoAnos * 12;
        double parcelaBase = (this.valorImovel / meses) * (1 + taxaMensal);
        return parcelaBase * 1.02; // +2%
    }
}
