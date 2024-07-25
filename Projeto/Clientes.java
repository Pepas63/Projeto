package Projeto;

import java.io.Serializable;

// Classe abstrata Clientes que implementa Serializable para permitir a serialização dos objetos
public abstract class Clientes implements Serializable {

    private static final long serialVersionUID = 1L; // Identificador único para serialização

    // Atributos privados da classe
    private int id;
    private String nome;
    private String email;
    private String telefone;

    // Construtor da classe Clientes que inicializa os atributos
    public Clientes(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Métodos getter e setter para acessar e modificar os atributos privados
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

    // Método abstrato que deve ser implementado pelas subclasses para retornar o tipo de cliente
    public abstract String getTipo();

    // Método abstrato que deve ser implementado pelas subclasses para calcular o desconto
    public abstract double calcularDesconto(double valor, boolean emPecas);

    // Método para calcular o valor final aplicando o desconto calculado
    public double calcularValorFinal(double valor, boolean emPecas) {
        double desconto = calcularDesconto(valor, emPecas); // Calcula o desconto
        return valor - desconto; // Retorna o valor final após aplicar o desconto
    }
}


