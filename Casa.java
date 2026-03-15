package modelo;
import util.AumentoMaiorDoQueJurosException;

public class Casa extends financiamento {

    public Casa(double valorImovel, int prazoAnos, double taxaJurosAnual) {
        super(valorImovel, prazoAnos, taxaJurosAnual);
    }

    @Override
    public double calcularParcelaMensal() throws AumentoMaiorDoQueJurosException {
        double taxaMensal = this.taxaJurosAnual / 12;
        int totalParcelas = this.prazoAnos * 12;

        double jurosMensal = (this.valorImovel * taxaMensal);
        if (80 > jurosMensal / 2) {
            throw new AumentoMaiorDoQueJurosException(
                    "O acréscimo de R$80 é maior que a metade dos juros da parcela!"
            );
        }

        // Calcula a parcela usando a fórmula do sistema PRICE e adiciona o R$ 80
        double parcelaBase = (this.valorImovel * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -totalParcelas));

        return parcelaBase + 80;
    }
}
