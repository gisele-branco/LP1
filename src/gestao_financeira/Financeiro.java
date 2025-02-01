package gestao_financeira;

public class Financeiro {
    private double totalFaturado;
    private double totalGastos;

    public Financeiro() {
        this.totalFaturado = 0.0;
        this.totalGastos = 0.0;
    }

    public void adicionarFaturamento(double valor) {
        this.totalFaturado += valor;
    }

    public void adicionarGasto(double valor) {
        this.totalGastos += valor;
    }

    public double getTotalFaturado() {
        return totalFaturado;
    }

    public double getTotalGastos() {
        return totalGastos;
    }

    public double getLucro() {
        return totalFaturado - totalGastos;
    }
}