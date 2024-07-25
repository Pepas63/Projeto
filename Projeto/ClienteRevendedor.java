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
}
