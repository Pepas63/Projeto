package Projeto;

import java.util.Date;

public class Relatório extends Tickets {
    private static final long serialVersionUID = 1L;

    public Relatório(int numero, Clientes cliente, Date dataInicio, Date dataFechamento, String descricao, double valorServicos, double valorPecas) {
        super(numero, cliente, "Relatório", dataInicio, dataFechamento, descricao, valorServicos, valorPecas);
    }
}
