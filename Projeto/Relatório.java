package Projeto;

import java.util.Date;

public class Relatório extends Tickets {
    private static final long serialVersionUID = 1L;

    /**
     * Construtor para a classe Relatório.
     * @param numero Número do ticket.
     * @param cliente Cliente associado ao ticket.
     * @param dataInicio Data de início do ticket.
     * @param dataFechamento Data de fechamento do ticket.
     * @param descricao Descrição do serviço ou trabalho realizado.
     * @param valorServicos Valor dos serviços descritos no ticket.
     * @param valorPecas Valor das peças descritas no ticket.
     */
    public Relatório(int numero, Clientes cliente, Date dataInicio, Date dataFechamento, String descricao, double valorServicos, double valorPecas) {
        // Chama o construtor da classe base (Tickets) para inicializar os atributos comuns
        super(numero, cliente, "Relatório", dataInicio, dataFechamento, descricao, valorServicos, valorPecas);
    }
}
