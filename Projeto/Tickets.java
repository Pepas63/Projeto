package Projeto;

import java.io.Serializable;
import java.util.Date;

public abstract class Tickets implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // Declaração das variáveis de instância
    private int id; // Identificador único do ticket
    private Clientes cliente; // Cliente associado ao ticket
    private String tipo; // Tipo do ticket (e.g., "Reparação", "Orçamento")
    private Date dataCriacao; // Data em que o ticket foi criado
    private Date dataFechamento; // Data em que o ticket foi fechado
    private String descricao; // Descrição do serviço ou trabalho realizado
    private double valorServicos; // Valor dos serviços descritos no ticket
    private double valorPecas; // Valor das peças descritas no ticket

    /**
     * Construtor da classe Tickets.
     * @param id Identificador único do ticket.
     * @param cliente Cliente associado ao ticket.
     * @param tipo Tipo do ticket (e.g., "Reparação", "Orçamento").
     * @param dataCriacao Data em que o ticket foi criado.
     * @param dataFechamento Data em que o ticket foi fechado.
     * @param descricao Descrição do serviço ou trabalho realizado.
     * @param valorServicos Valor dos serviços descritos no ticket.
     * @param valorPecas Valor das peças descritas no ticket.
     */
    public Tickets(int id, Clientes cliente, String tipo, Date dataCriacao, Date dataFechamento, String descricao, double valorServicos, double valorPecas) {
        this.id = id;
        this.cliente = cliente;
        this.tipo = tipo;
        this.dataCriacao = dataCriacao;
        this.dataFechamento = dataFechamento;
        this.descricao = descricao;
        this.valorServicos = valorServicos;
        this.valorPecas = valorPecas;
    }

    // Getters e setters para os atributos da classe

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorServicos() {
        return valorServicos;
    }

    public void setValorServicos(double valorServicos) {
        this.valorServicos = valorServicos;
    }

    public double getValorPecas() {
        return valorPecas;
    }

    public void setValorPecas(double valorPecas) {
        this.valorPecas = valorPecas;
    }
}
