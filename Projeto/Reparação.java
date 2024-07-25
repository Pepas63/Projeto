package Projeto;


import java.util.Date;

public class Reparação extends Tickets {
    private static final long serialVersionUID = 1L;

    public Reparação(int numero, Clientes cliente, Date dataInicio, Date dataFechamento, String descricao, double valorServicos, double valorPecas) {
        super(numero, cliente, "Reparação", dataInicio, dataFechamento, descricao, valorServicos, valorPecas);
    }
    
    @Override
    public double getValorServicos() {
        return getCliente().calcularValorFinal(super.getValorServicos(), false);
    }

    @Override
    public double getValorPecas() {
        return getCliente().calcularValorFinal(super.getValorPecas(), true);
    }
}
