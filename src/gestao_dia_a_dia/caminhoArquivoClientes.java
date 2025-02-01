import java.util.Scanner;

public class caminhoArquivoClientes {
    public void iniciarDia(String ".idea/clientes.txt") {
        try {
            File arquivo = new File(".idea/clientes.txt");
            Scanner scanner = new Scanner(arquivo);


            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dadosCliente = linha.split(","); // Divide a linha em campos

                String nome = dadosCliente[0];
                int numeroPessoas = Integer.parseInt(dadosCliente[1]);
                int entradas = Integer.parseInt(dadosCliente[2]);
                int sobremesas = Integer.parseInt(dadosCliente[3]);
                int tempoEsperaMesa = Integer.parseInt(dadosCliente[4]);
                int tempoEsperaAtendimento = Integer.parseInt(dadosCliente[5]);
                int tempoChegada = Integer.parseInt(dadosCliente[6]);

                // Exibir os dados do cliente
                System.out.println("Cliente chegou: " + nome);
                System.out.println("Número de pessoas: " + numeroPessoas);
                System.out.println("Entradas: " + entradas);
                System.out.println("Sobremesas: " + sobremesas);
                System.out.println("Tempo de espera para mesa: " + tempoEsperaMesa);
                System.out.println("Tempo de espera para atendimento: " + tempoEsperaAtendimento);
                System.out.println("Tempo de chegada: " + tempoChegada);
                System.out.println("-----------------------------");
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo de clientes não encontrado.");
        }
    }
}