package main;


import gestao_menus.GestaoMenus;
import gestao_mesas.GestaoMesas;

public class Main {
    public static void main(String[] args) {



        GestaoMenus gestaoMenus = new GestaoMenus(10);
        gestaoMenus.carregarMenu("menu.txt");


        /**Inicializa a gestão de menus*/


        /** Entradas */
        gestaoMenus.adicionarPrato("Pão de Queijo", "entrada", 1.0, 3.0, 2);
        gestaoMenus.adicionarPrato("Coxinha", "entrada", 1.5, 4.0, 3);
        gestaoMenus.adicionarPrato("Bolinho de Bacalhau", "entrada", 2.0, 5.0, 4);

        /** Pratos principais */
        gestaoMenus.adicionarPrato("Feijoada", "principal", 5.0, 12.0, 10);
        gestaoMenus.adicionarPrato("Moqueca de Peixe", "principal", 6.0, 15.0, 9);
        gestaoMenus.adicionarPrato("Churrasco", "principal", 7.0, 18.0, 8);

        /** Sobremesas */
        gestaoMenus.adicionarPrato("Brigadeiro", "sobremesa", 1.0, 4.0, 3);
        gestaoMenus.adicionarPrato("Pudim de Leite", "sobremesa", 2.0, 6.0, 5);
        gestaoMenus.adicionarPrato("Quindim", "sobremesa", 1.5, 5.0, 4);

        /** Listar os pratos */
        gestaoMenus.listarPratos();

        /*Inicializa a gestão de mesas*/
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


            }

    }
