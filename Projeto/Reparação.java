package Projeto;

import java.util.Date;

public class Reparação extends Tickets {
    private static final long serialVersionUID = 1L;

    /**
     * Construtor para a classe Reparação.
     * @param numero Número do ticket.
     * @param cliente Cliente associado ao ticket.
     * @param dataInicio Data de início do ticket.
     * @param dataFechamento Data de fechamento do ticket.
     * @param descricao Descrição do serviço ou trabalho realizado.
     * @param valorServicos Valor dos serviços descritos no ticket.
     * @param valorPecas Valor das peças descritas no ticket.
     */
    public Reparação(int numero, Clientes cliente, Date dataInicio, Date dataFechamento, String descricao, double valorServicos, double valorPecas) {
        // Chama o construtor da classe base (Tickets) para inicializar os atributos comuns
        super(numero, cliente, "Reparação", dataInicio, dataFechamento, descricao, valorServicos, valorPecas);
    }
    
    /**
     * Calcula o valor final dos serviços, considerando o desconto aplicável ao cliente.
     * @return Valor final dos serviços após aplicar o desconto.
     */
    @Override
    public double getValorServicos() {
        // Aplica o desconto ao valor dos serviços, se aplicável
        return getCliente().calcularValorFinal(super.getValorServicos(), false);
    }

    /**
     * Calcula o valor final das peças, considerando o desconto aplicável ao cliente.
     * @return Valor final das peças após aplicar o desconto.
     */
    @Override
    public double getValorPecas() {
        // Aplica o desconto ao valor das peças, se aplicável
        return getCliente().calcularValorFinal(super.getValorPecas(), true);
    }
}
