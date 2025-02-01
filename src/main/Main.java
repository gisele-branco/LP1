package main;

import gestao_dia_a_dia.Simulacao;
import estatisticas.Estatisticas;
import gestao_menus.GestaoMenus;
import gestao_mesas.GestaoMesas;
public class Main {
    public static void main(String[] args) {

        GestaoMenus gestaoMenus = new GestaoMenus(10);

        /**entradas*/
        gestaoMenus.adicionarPrato("Pão de Queijo", "entrada", 1.0, 3.0, 2);
        gestaoMenus.adicionarPrato("Coxinha", "entrada", 1.5, 4.0, 3);
        gestaoMenus.adicionarPrato("Bolinho de Bacalhau", "entrada", 2.0, 5.0, 4);

        /**pratos principais*/
        gestaoMenus.adicionarPrato("Feijoada", "principal", 5.0, 12.0, 10);
        gestaoMenus.adicionarPrato("Moqueca de Peixe", "principal", 6.0, 15.0, 9);
        gestaoMenus.adicionarPrato("Churrasco", "principal", 7.0, 18.0, 8);

        /**sobremesas*/
        gestaoMenus.adicionarPrato("Brigadeiro", "sobremesa", 1.0, 4.0, 3);
        gestaoMenus.adicionarPrato("Pudim de Leite", "sobremesa", 2.0, 6.0, 5);
        gestaoMenus.adicionarPrato("Quindim", "sobremesa", 1.5, 5.0, 4);

        /**Listar os pratos*/
        gestaoMenus.listarPratos();
        GestaoMesas gestaoMesas = new GestaoMesas(25);

        int totalLugares = 0;
        for (int i = 1; i <= 25; i++) {
            int capacidade = (i % 2 == 0) ? 2 : 4;
            gestaoMesas.adicionarMesa(i, capacidade);
            totalLugares += capacidade;
        }

        System.out.println("\nTotal de mesas: 25");
        System.out.println("Total de lugares: " + totalLugares);
        System.out.println("\n--- Lista de Mesas ---");
        gestaoMesas.listarMesas();

        Estatisticas estatisticas = new Estatisticas();

        /** Simular alguns dados
         estatisticas.adicionarClientesAtendidos(10);
         estatisticas.adicionarPedidoAtendido(50.0, 20.0);
         estatisticas.adicionarPedidoAtendido(30.0, 15.0);
         estatisticas.adicionarPedidoNaoAtendido(); */

        System.out.println("Total de clientes atendidos: " + estatisticas.getTotalClientesAtendidos());
        System.out.println("Total de pedidos atendidos: " + estatisticas.getTotalPedidosAtendidos());
        System.out.println("Total de pedidos não atendidos: " + estatisticas.getTotalPedidosNaoAtendidos());
        System.out.println("Total faturado: " + estatisticas.getTotalFaturado());
        System.out.println("Total gastos: " + estatisticas.getTotalGastos());
        System.out.println("Lucro: " + estatisticas.getLucro());

        Simulacao simulacao = new Simulacao(10, 5); // 10 unidades de tempo, 5 mesas

        /** Iniciar o dia (ler clientes do arquivo)*/
        simulacao.iniciarDia("clientes.txt");

        /**Simular o avanço do tempo*/
        for (int i = 0; i < 12; i++) { /** Pode Avançar 12 unidades de tempo (2 a mais que o limite)*/
            simulacao.avancarTempo();

            if (i % 2 == 0) { /**A cada 2 unidades de tempo, tenta atribuir uma mesa*/
                simulacao.atribuirMesa();
            }

            /**Liberar uma mesa após 5 unidades de tempo*/
            if (i == 5) {
                simulacao.liberarMesa(1); // Libera a mesa 1
            }
        }
        simulacao.iniciarDia(".idea/clientes.txt");
    }
}