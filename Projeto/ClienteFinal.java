package Projeto;

// A classe ClienteFinal herda de Clientes
public class ClienteFinal extends Clientes {
    private static final long serialVersionUID = 1L; // Identificador único para serialização

    private boolean descontoProntoPagamento; // Atributo para armazenar se há desconto para pronto pagamento

    // Construtor que inicializa os atributos
    public ClienteFinal(int id, String nome, String email, String telefone, boolean descontoProntoPagamento) {
        super(id, nome, email, telefone); // Chama o construtor da classe pai (Clientes)
        this.descontoProntoPagamento = descontoProntoPagamento; // Inicializa o atributo descontoProntoPagamento
    }

    // Método para verificar se há desconto para pronto pagamento
    public boolean isDescontoProntoPagamento() {
        return descontoProntoPagamento;
    }

    // Sobrescreve o método getTipo da classe Clientes
    @Override
    public String getTipo() {
        return "Final"; // Retorna o tipo do cliente
    }

    // Sobrescreve o método calcularDesconto da classe Clientes
    @Override
    public double calcularDesconto(double valor, boolean emPecas) {
        if (isDescontoProntoPagamento()) { // Verifica se há desconto para pronto pagamento
            return valor * 0.05; // Calcula 5% de desconto
        }
        return 0; // Retorna 0 se não houver desconto
    }
}

