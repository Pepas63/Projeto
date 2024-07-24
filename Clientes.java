package ProjetoBlackBox;

import java.io.Serializable;

public class Clientes implements Serializable{

private static final long serialVersionUID = 1L; // Implementação do id da versão serial
	
//Declaração de variavéis
    private int id;
    private String nome;
    private String tipo; // "Final" ou "Revendedor"
    private String email;
    private String telefone;

// Construtor da class Clientes
    public Clientes(int id, String nome, String tipo, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
}
