package br.com.algoritimo.cartoes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cartoes {
    public static void main(String[] args) throws IOException {
        // Defina o caminho para o arquivo de teste
        String caminhoArquivo = "src/main/resources/arquivo.txt";

        try (var br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String line;

            while ((line = br.readLine()) != null && !line.isEmpty()) {
                int N = Integer.parseInt(line.trim());
                int[] a = new int[N];
                String[] valores = br.readLine().trim().split("\\s+");

                for (int i = 0; i < N; i++) {
                    a[i] = Integer.parseInt(valores[i]);
                }

                int left = 0;
                int right = N - 1;
                int total = 0;

                while (left <= right) {
                    // Escolha do cartão com maior valor
                    int escolhido;
                    if (a[left] >= a[right]) {
                        escolhido = a[left];
                        left++;
                    } else {
                        escolhido = a[right];
                        right--;
                    }
                    total += escolhido;

                    // Verifica se ainda há cartas para descartar
                    if (left > right) break;

                    // Descarte do cartão com menor valor
                    if (a[left] <= a[right]) {
                        left++;
                    } else {
                        right--;
                    }
                }

                System.out.println(total);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
