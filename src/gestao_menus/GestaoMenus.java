package gestao_menus;

public class GestaoMenus {
    private Prato[] pratos;
    private int totalPratos;

    public GestaoMenus(int maxPratos) {
        pratos = new Prato[maxPratos];
        totalPratos = 0;
    }

    public void adicionarPrato(String nome, String categoria, double precoCusto, double precoVenda, int tempoPreparacao) {
        if (totalPratos < pratos.length) {
            pratos[totalPratos] = new Prato(nome, categoria, precoCusto, precoVenda, tempoPreparacao);
            totalPratos++;
            System.out.println("Prato '" + nome + "' adicionado ao menu!");
        } else {
            System.out.println("Não é possível adicionar mais pratos. Limite atingido.");
        }
    }

    public void listarPratos() {
        System.out.println("\n--- Menu do Restaurante ---");
        for (int i = 0; i < totalPratos; i++) {
            System.out.println(pratos[i]);
        }
    }
}