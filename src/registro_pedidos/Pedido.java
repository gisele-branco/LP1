package registro_pedidos;

public class Pedido {
    private int numeroMesa;
    private String nomePrato;
    private int quantidade;
    private double precoVenda;

    public Pedido(int numeroMesa, String nomePrato, int quantidade, double precoVenda) {
        this.numeroMesa = numeroMesa;
        this.nomePrato = nomePrato;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public double calcularTotal() {
        return quantidade * precoVenda;
    }
}