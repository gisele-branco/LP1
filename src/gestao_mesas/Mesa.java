package gestao_mesas;

public class Mesa {
    private int numeroMesa;
    private int capacidade;
    private boolean ocupada;

    public Mesa(int numeroMesa, int capacidade) {
        this.numeroMesa = numeroMesa;
        this.capacidade = capacidade;
        this.ocupada = false;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    @Override
    public String toString() {
        return "Mesa " + numeroMesa + " (Capacidade: " + capacidade + ") - " + (ocupada ? "Ocupada" : "Livre");
    }
}