package main;

import modelo.*;
import util.interfaceUsuario;
import util.ArquivoPersistencia;
import util.AumentoMaiorDoQueJurosException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        interfaceUsuario iu = new interfaceUsuario();
        List<financiamento> lista = new ArrayList<>();

        // 1. Pede os dados para um financiamento do usuário
        double valor = iu.pedirValorImovel();
        int anos = iu.pedirPrazo();
        int tipo = iu.escolherTipo();

        financiamento f = null;

        try {
            switch (tipo) {
                case 1 -> f = new Casa(valor, anos, 0.09); // 9% ao ano
                case 2 -> f = new apartamento(valor, anos, 0.08); // 8% ao ano
                case 3 -> f = new terreno(valor, anos, 0.07); // 7% ao ano
                default -> System.out.println("Opção inválida.");
            }

            if (f != null) {
                lista.add(f);
                f.mostrarDados();
            }

            // 2. Pergunta sobre o valor já pago e calcula o restante
            double valorPago = iu.pedirValorPago();
            if (valorPago > 0) {
                double parcelaMensal = f.calcularParcelaMensal();
                double totalFinanciamento = f.calcularTotalPago();

                int parcelasPagas = (int) (valorPago / parcelaMensal);
                double valorTotalRestante = totalFinanciamento - valorPago;
                int parcelasRestantes = (f.getPrazoAnos() * 12) - parcelasPagas;

                System.out.printf("\nCom R$ %.2f já pagos, isso corresponde a %d parcelas.%n", valorPago, parcelasPagas);
                System.out.printf("Faltam %d parcelas, totalizando R$ %.2f.%n", parcelasRestantes, valorTotalRestante);
            }

            // 3. Salva os dados
            ArquivoPersistencia.salvar("financiamentos.txt", lista);

        } catch (AumentoMaiorDoQueJurosException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
