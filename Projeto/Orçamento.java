package Projeto;

import java.util.Date;

public class Orçamento extends Tickets {
    private static final long serialVersionUID = 1L;
    private boolean aprovado;

    public Orçamento(int numero, Clientes cliente, Date dataInicio, Date dataFechamento, String descricao, double valorServicos, double valorPecas, boolean aprovado) {
        super(numero, cliente, "Orçamento", dataInicio, dataFechamento, descricao, valorServicos, valorPecas);
        this.aprovado = aprovado;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
}
