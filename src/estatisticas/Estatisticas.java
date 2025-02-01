package estatisticas;

public class Estatisticas {
    private int totalClientesAtendidos;
    private int totalPedidosAtendidos;
    private int totalPedidosNaoAtendidos;
    private double totalFaturado;
    private double totalGastos;

    public Estatisticas() {
        this.totalClientesAtendidos = 0;
        this.totalPedidosAtendidos = 0;
        this.totalPedidosNaoAtendidos = 0;
        this.totalFaturado = 0.0;
        this.totalGastos = 0.0;
    }

    /**atualizar estatísticas*/
    public void adicionarClientesAtendidos(int quantidade) {
        this.totalClientesAtendidos += quantidade;
    }

    public void adicionarPedidoAtendido(double valorFaturado, double custo) {
        this.totalPedidosAtendidos++;
        this.totalFaturado += valorFaturado;
        this.totalGastos += custo;
    }

    public void adicionarPedidoNaoAtendido() {
        this.totalPedidosNaoAtendidos++;
    }

    /**calcular estatísticas*/
    public int getTotalClientesAtendidos() {
        return this.totalClientesAtendidos;
    }

    public int getTotalPedidosAtendidos() {
        return this.totalPedidosAtendidos;
    }

    public int getTotalPedidosNaoAtendidos() {
        return this.totalPedidosNaoAtendidos;
    }

    public double getTotalFaturado() {
        return this.totalFaturado;
    }

    public double getTotalGastos() {
        return this.totalGastos;
    }

    public double getLucro() {
        return this.totalFaturado - this.totalGastos;
    }
}