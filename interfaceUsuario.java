package util;

import java.util.Scanner;

public class interfaceUsuario {
    private Scanner scanner;

    public interfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public double pedirValorImovel() {
        System.out.print("Digite o valor do imóvel: R$ ");
        return scanner.nextDouble();
    }

    public int pedirPrazo() {
        System.out.print("Digite o prazo do financiamento em anos: ");
        return scanner.nextInt();
    }

    public int escolherTipo() {
        System.out.println("Escolha o tipo de imóvel:");
        System.out.println("1 - Casa");
        System.out.println("2 - Apartamento");
        System.out.println("3 - Terreno");
        System.out.print("Opção: ");
        return scanner.nextInt();
    }

    // Novo método para perguntar o valor já pago em dinheiro
    public double pedirValorPago() {
        System.out.print("Já foi pago algum valor? (1-Sim, 2-Nao): ");
        int resposta = scanner.nextInt();
        if (resposta == 1) {
            System.out.print("Digite o valor já pago: R$ ");
            return scanner.nextDouble();
        }
        return 0;
    }
}
