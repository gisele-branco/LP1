package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
    public static String lerArquivo(String caminho) {
        StringBuilder conteudo = new StringBuilder();
        try {
            File arquivo = new File(caminho);
            Scanner scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()) {
                conteudo.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return conteudo.toString();
    }

    public static void escreverArquivo(String caminho, String conteudo) {
        try {
            FileWriter escritor = new FileWriter(caminho);
            escritor.write(conteudo);
            escritor.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}