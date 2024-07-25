package Projeto;

public class ClienteRevendedor extends Clientes {
    private static final long serialVersionUID = 1L;

    public ClienteRevendedor(int id, String nome, String email, String telefone) {
        super(id, nome, email, telefone);
    }

    @Override
    public String getTipo() {
        return "Revendedor";
    }

    @Override
    public double calcularDesconto(double valor, boolean emPecas) {
        if (emPecas) {
            return valor * 0.20; // 20% de desconto em peças
        } else {
            return valor * 0.10; // 10% de desconto em serviços
        }
    }
}