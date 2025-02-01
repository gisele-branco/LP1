package gestao_dia_a_dia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulacao {
    private int unidadesTempoDia; /**Total de unidades de tempo no dia*/
    private int tempoAtual; /** Unidade de tempo atual*/
    private int totalMesas; /**Total de mesas no restaurante*/
    private boolean[] mesasOcupadas;

    public Simulacao(int unidadesTempoDia, int totalMesas) {
        this.unidadesTempoDia = unidadesTempoDia;
        this.tempoAtual = 0;
        this.totalMesas = totalMesas;
        this.mesasOcupadas = new boolean[totalMesas];
    }

    /**Iniciar o dia*/
    public void iniciarDia(String caminhoArquivoClientes) {
        try {
            File arquivo = new File(caminhoArquivoClientes);
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                System.out.println("Cliente chegou: " + linha);
                /**processar os dados do cliente (nome, número de pessoas, etc.)*/
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo de clientes não encontrado.");
        }
    }

    /**Método para avançar o tempo*/
    public void avancarTempo() {
        if (tempoAtual < unidadesTempoDia) {
            tempoAtual++;
            System.out.println("Tempo avançado: " + tempoAtual);

            /**Simular eventos que acontecem ao avançar o tempo*/
            simularEventos();
        } else {
            System.out.println("O dia já terminou!");
        }
    }

    private void simularEventos() {

        System.out.println("Simulando eventos no tempo " + tempoAtual);
    }

    /**Método para atribuir uma mesa a um cliente*/
    public boolean atribuirMesa() {
        for (int i = 0; i < totalMesas; i++) {
            if (!mesasOcupadas[i]) {
                mesasOcupadas[i] = true; /**Ocupa a mesa*/
                System.out.println("Mesa " + (i + 1) + " atribuída a um cliente.");
                return true;
            }
        }
        System.out.println("Todas as mesas estão ocupadas.");
        return false;
    }

    public void liberarMesa(int numeroMesa) {
        if (numeroMesa >= 1 && numeroMesa <= totalMesas) {
            mesasOcupadas[numeroMesa - 1] = false; /**Libera a mesa*/
            System.out.println("Mesa " + numeroMesa + " liberada.");
        } else {
            System.out.println("Número de mesa inválido.");
        }
    }
}