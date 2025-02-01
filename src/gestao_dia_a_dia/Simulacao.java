package gestao_dia_a_dia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulacao {
    private int unidadesTempoDia;
    private int tempoAtual;
    private int totalMesas;
    private boolean[] mesasOcupadas;
    private int[] capacidadeMesas;

    public Simulacao(int unidadesTempoDia, int totalMesas) {
        this.unidadesTempoDia = unidadesTempoDia;
        this.tempoAtual = 0;
        this.totalMesas = totalMesas;
        this.mesasOcupadas = new boolean[totalMesas];
        this.capacidadeMesas = new int[totalMesas];
        for (int i = 0; i < totalMesas; i++) {
            capacidadeMesas[i] = 4;
        }
    }

    public void iniciarDia(String caminhoArquivoClientes) {
        try {
            File arquivo = new File(caminhoArquivoClientes);
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dadosCliente = linha.split(",");

                String nome = dadosCliente[0];
                int numeroPessoas = Integer.parseInt(dadosCliente[1]);
                int entradas = Integer.parseInt(dadosCliente[2]);
                int sobremesas = Integer.parseInt(dadosCliente[3]);
                int tempoEsperaMesa = Integer.parseInt(dadosCliente[4]);
                int tempoEsperaAtendimento = Integer.parseInt(dadosCliente[5]);
                int tempoChegada = Integer.parseInt(dadosCliente[6]);

                System.out.println("Cliente chegou: " + nome);
                System.out.println("Número de pessoas: " + numeroPessoas);
                System.out.println("Entradas: " + entradas);
                System.out.println("Sobremesas: " + sobremesas);
                System.out.println("Tempo de espera para mesa: " + tempoEsperaMesa);
                System.out.println("Tempo de espera para atendimento: " + tempoEsperaAtendimento);
                System.out.println("Tempo de chegada: " + tempoChegada);
                System.out.println("-----------------------------");

                if (tempoChegada == tempoAtual) {
                    atribuirMesa(nome, numeroPessoas, tempoChegada);
                } else {
                    System.out.println("Cliente " + nome + " chegou no tempo errado.");
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo de clientes não encontrado.");
        }
    }

    public void avancarTempo() {
        if (tempoAtual < unidadesTempoDia) {
            tempoAtual++;
            System.out.println("Tempo avançado: " + tempoAtual);
            simularEventos();
        } else {
            System.out.println("O dia já terminou!");
        }
    }

    private void simularEventos() {
        if (tempoAtual == 1) {
            notificar("Cliente João chegou ao restaurante.");
            atribuirMesa("João", 4, 1);
        }

        if (tempoAtual == 3) {
            notificar("Prato X está pronto.");
        }

        if (tempoAtual == 5) {
            liberarMesa(1);
        }
    }

    public boolean atribuirMesa(String nomeCliente, int numeroPessoas, int tempoChegada) {
        if (tempoChegada != tempoAtual) {
            System.out.println("Cliente " + nomeCliente + " chegou no tempo errado.");
            return false;
        }

        for (int i = 0; i < totalMesas; i++) {
            if (!mesasOcupadas[i] && capacidadeMesas[i] >= numeroPessoas) {
                mesasOcupadas[i] = true;
                System.out.println("Mesa " + (i + 1) + " atribuída ao cliente " + nomeCliente + ".");
                notificar("Cliente " + nomeCliente + " sentou na mesa " + (i + 1) + ".");
                return true;
            }
        }

        System.out.println("Nenhuma mesa disponível para o cliente " + nomeCliente + ".");
        notificar("Cliente " + nomeCliente + " não pôde ser atendido. Todas as mesas estão ocupadas.");
        return false;
    }

    public void liberarMesa(int numeroMesa) {
        if (numeroMesa >= 1 && numeroMesa <= totalMesas) {
            mesasOcupadas[numeroMesa - 1] = false;
            System.out.println("Mesa " + numeroMesa + " liberada.");
            notificar("Mesa " + numeroMesa + " foi liberada.");
        } else {
            System.out.println("Número de mesa inválido.");
        }
    }

    private void notificar(String mensagem) {
        System.out.println("[NOTIFICAÇÃO] " + mensagem);
    }
}