package Projeto;

import java.util.Date;

public class Relatório extends Tickets {
    private static final long serialVersionUID = 1L;
    private String numeroSerie;

    public Relatório(int numero, Clientes cliente, Date dataInicio, Date dataFechamento, String descricao, double valorServicos, double valorPecas, String numeroSerie) {
        super(numero, cliente, "Relatório", dataInicio, dataFechamento, descricao, valorServicos, valorPecas);
        this.numeroSerie = numeroSerie;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
}
