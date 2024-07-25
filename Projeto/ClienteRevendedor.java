package Projeto;

// A classe ClienteRevendedor herda da classe Clientes
public class ClienteRevendedor extends Clientes {
    private static final long serialVersionUID = 1L; // Identificador único para serialização

    // Construtor que inicializa os atributos da classe
    public ClienteRevendedor(int id, String nome, String email, String telefone) {
        super(id, nome, email, telefone); // Chama o construtor da classe pai (Clientes)
    }

    // Sobrescreve o método getTipo da classe Clientes
    @Override
    public String getTipo() {
        return "Revendedor"; // Retorna o tipo do cliente
    }

    // Sobrescreve o método calcularDesconto da classe Clientes
    @Override
    public double calcularDesconto(double valor, boolean emPecas) {
        if (emPecas) { // Verifica se o desconto é em peças
            return valor * 0.20; // Calcula 20% de desconto em peças
        } else { // Caso contrário, o desconto é em serviços
            return valor * 0.10; // Calcula 10% de desconto em serviços
        }
    }
}
