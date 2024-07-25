package Projeto;

import java.util.Date;

public class Orçamento extends Tickets {
    private static final long serialVersionUID = 1L;
    private boolean aprovado;

    /**
     * Construtor para a classe Orçamento.
     * @param numero Número do ticket.
     * @param cliente Cliente associado ao ticket.
     * @param dataInicio Data de início do ticket.
     * @param dataFechamento Data de fechamento do ticket.
     * @param descricao Descrição do serviço ou trabalho realizado.
     * @param valorServicos Valor dos serviços descritos no ticket.
     * @param valorPecas Valor das peças descritas no ticket.
     * @param aprovado Indica se o orçamento foi aprovado ou não.
     */
    public Orçamento(int numero, Clientes cliente, Date dataInicio, Date dataFechamento, String descricao, double valorServicos, double valorPecas, boolean aprovado) {
        // Chama o construtor da classe base (Tickets) para inicializar os atributos comuns
        super(numero, cliente, "Orçamento", dataInicio, dataFechamento, descricao, valorServicos, valorPecas);
        this.aprovado = aprovado;
    }

    /**
     * Verifica se o orçamento foi aprovado.
     * @return true se o orçamento foi aprovado, false caso contrário.
     */
    public boolean isAprovado() {
        return aprovado;
    }

    /**
     * Define se o orçamento foi aprovado ou não.
     * @param aprovado true se o orçamento foi aprovado, false caso contrário.
     */
    public void setaProvado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    /**
     * Calcula o valor final dos serviços aplicando o desconto, se aplicável.
     * @return O valor final dos serviços após aplicar possíveis descontos.
     */
    @Override
    public double getValorServicos() {
        // Chama o método da classe base para obter o valor dos serviços e aplica o desconto do cliente, se necessário
        return getCliente().calcularValorFinal(super.getValorServicos(), false);
    }

    /**
     * Calcula o valor final das peças aplicando o desconto, se aplicável.
     * @return O valor final das peças após aplicar possíveis descontos.
     */
    @Override
    public double getValorPecas() {
        // Chama o método da classe base para obter o valor das peças e aplica o desconto do cliente, se necessário
        return getCliente().calcularValorFinal(super.getValorPecas(), true);
    }
}
