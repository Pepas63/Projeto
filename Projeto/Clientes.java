package Projeto;

import java.io.Serializable;

public abstract class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String email;
    private String telefone;

    public Clientes(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public abstract String getTipo();
    
 // Método para calcular o desconto
    public abstract double calcularDesconto(double valor, boolean emPecas);

    // Método para calcular o valor final
    public double calcularValorFinal(double valor, boolean emPecas) {
        double desconto = calcularDesconto(valor, emPecas);
        return valor - desconto;
    }
}

