package modelo;

public class apartamento extends financiamento {

    public apartamento(double valorImovel, int prazoAnos, double taxaJurosAnual) {
        super(valorImovel, prazoAnos, taxaJurosAnual);
    }

    @Override
    public double calcularParcelaMensal() {
        double taxaMensal = this.taxaJurosAnual / 12;
        int meses = this.prazoAnos * 12;

        double numerador = this.valorImovel * Math.pow(1 + taxaMensal, meses) * taxaMensal;
        double denominador = Math.pow(1 + taxaMensal, meses) - 1;

        double parcelaBase = numerador / denominador;

        // Adiciona o acréscimo de 2% sobre o valor já com juros
        return parcelaBase * 1.02;
    }
}
