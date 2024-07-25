package Projeto;

public class ClienteFinal extends Clientes {
    private static final long serialVersionUID = 1L;
    private boolean descontoProntoPagamento;

    public ClienteFinal(int id, String nome, String email, String telefone, boolean descontoProntoPagamento) {
        super(id, nome, email, telefone);
        this.descontoProntoPagamento = descontoProntoPagamento;
    }

    public boolean isDescontoProntoPagamento() {
        return descontoProntoPagamento;
    }

    @Override
    public String getTipo() {
        return "Final";
    }
}

