package util;
import modelo.financiamento;
import java.io.*;
import java.util.List;

    public class ArquivoPersistencia {

        public static void salvar(String nomeArquivo, List<financiamento> lista) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
                for (financiamento f : lista) {
                    bw.write(f.getClass().getSimpleName() + ";" + f.getValorImovel() + ";" +
                            f.getPrazoAnos() + ";" + f.getTaxaJurosAnual());
                    bw.newLine();
                }
                System.out.println("Dados salvos em " + nomeArquivo);
            } catch (IOException e) {
                System.out.println("Erro ao salvar: " + e.getMessage());
            }
        }
    }


