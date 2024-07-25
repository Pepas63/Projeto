package Projeto;

import java.io.Serializable;
import java.util.Date;

public abstract class Tickets implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //Declaração de variáveis
    private int id;
    private Clientes cliente;
    private String tipo;
    private Date dataCriacao;
    private Date dataFechamento;
    private String descricao;
    private double valorServicos;
    private double valorPecas;

    //Construtor da class Ticket
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

    // Getters e setters
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
