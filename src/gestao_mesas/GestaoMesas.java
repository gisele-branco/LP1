package gestao_mesas;

public class GestaoMesas {
    private Mesa[] mesas;
    private int totalMesas;


    public GestaoMesas(int maxMesas) {
        mesas = new Mesa[maxMesas];
        totalMesas = 0;
    }

    public void adicionarMesa(int numeroMesa, int capacidade) {
        if (totalMesas < mesas.length) {
            mesas[totalMesas] = new Mesa(numeroMesa, capacidade);
            totalMesas++;
            System.out.println("Mesa " + numeroMesa + " adicionada com sucesso!");
        } else {
            System.out.println("Não é possível adicionar mais mesas. Limite atingido.");
        }
    }

    /**Listar todas as mesas*/
    public void listarMesas() {
        for (int i = 0; i < totalMesas; i++) {
            System.out.println(mesas[i]);
        }
    }

    /**Atribuir clientes a uma mesa disponível*/
    public boolean atribuirClientesAMesa(int numeroClientes) {
        for (int i = 0; i < totalMesas; i++) {
            if (!mesas[i].isOcupada() && mesas[i].getCapacidade() >= numeroClientes) {
                mesas[i].setOcupada(true);
                System.out.println("Clientes atribuídos à Mesa " + mesas[i].getNumeroMesa());
                return true;
            }
        }
        System.out.println("Nenhuma mesa disponível para " + numeroClientes + " clientes.");
        return false;
    }
}