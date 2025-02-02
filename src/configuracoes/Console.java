package configuracoes;

import estatisticas.Estatisticas;
import gestao_dia_a_dia.SimulacaoDia;
import gestao_menus.GestaoMenus;
import gestao_mesas.GestaoMesas;

import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        GestaoMesas gestaoMesas = new GestaoMesas(25);
        GestaoMenus gestaoMenus = new GestaoMenus(10);
        Estatisticas estatisticas = new Estatisticas();
        SimulacaoDia simulacaoDia = new SimulacaoDia(gestaoMesas);

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Gerir Mesas");
            System.out.println("2. Gerir Menus");
            System.out.println("3. Iniciar Simulação do Dia");
            System.out.println("4. Consultar Estatísticas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.next();
                continue;
            }

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Função para gerir mesas ainda não implementada.");
                    break;
                case 2:
                    System.out.println("Função para gerir menus ainda não implementada.");
                    break;
                case 3:
                    System.out.println("Iniciando simulação do dia...");
                    simulacaoDia.processarReservas("clientes.txt");
                    break;
                case 4:
                    System.out.println("\n=== Estatísticas ===");
                    System.out.println("Clientes atendidos: " + estatisticas.getTotalClientesAtendidos());
                    System.out.println("Pedidos atendidos: " + estatisticas.getTotalPedidosAtendidos());
                    System.out.println("Pedidos não atendidos: " + estatisticas.getTotalPedidosNaoAtendidos());
                    System.out.println("Total faturado: R$ " + estatisticas.getTotalFaturado());
                    System.out.println("Total gasto: R$ " + estatisticas.getTotalGastos());
                    System.out.println("Lucro: R$ " + estatisticas.getLucro());
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
