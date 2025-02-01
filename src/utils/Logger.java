package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String CAMINHO_LOG = "logs.txt";

    public static void log(String mensagem) {
        try {
            FileWriter escritor = new FileWriter(CAMINHO_LOG, true);
            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            escritor.write("[" + dataHora + "] " + mensagem + "\n");
            escritor.close();
        } catch (IOException e) {
            System.out.println("Erro ao registrar log: " + e.getMessage());
        }
    }
}