package Projeto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Backup {

    // Método para salvar a lista de clientes em um arquivo
    public static void salvarClientes(List<Clientes> clientes, String caminhoFicheiro) {
        // Cria um novo arquivo com o caminho especificado
        File f = new File(caminhoFicheiro);
        try {
            f.createNewFile(); // Cria o arquivo se ele não existir
            // Cria um ObjectOutputStream para escrever a lista de clientes no arquivo
            ObjectOutputStream ficheiro = new ObjectOutputStream(new FileOutputStream(caminhoFicheiro));
            ficheiro.writeObject(clientes); // Escreve a lista de clientes no arquivo
            System.out.println("Lista de clientes foi arquivada com sucesso.");
            System.out.println("No ficheiro: " + f.getAbsolutePath());
            ficheiro.flush(); // Limpa o stream
            ficheiro.close(); // Fecha o stream
        } catch (IOException e) {
            e.printStackTrace(); // Imprime a pilha de exceção em caso de erro
        }
    }

    // Método para listar clientes a partir de um arquivo
    @SuppressWarnings("unchecked")
    public static ArrayList<Clientes> listarClientes(String caminhoFicheiro) {
        ArrayList<Clientes> clientes = new ArrayList<>(); // Cria uma nova lista de clientes
        File ficheiro = new File(caminhoFicheiro); // Cria um novo arquivo com o caminho especificado
        if (!ficheiro.exists()) { // Verifica se o arquivo não existe
            ficheiro = new File(caminhoFicheiro); // Cria um novo arquivo
        } else {
            try (ObjectInputStream f = new ObjectInputStream(new FileInputStream(caminhoFicheiro))) {
                clientes = (ArrayList<Clientes>) f.readObject(); // Lê a lista de clientes do arquivo
                System.out.println("Restauro dos dados realizado com sucesso.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace(); // Imprime a pilha de exceção em caso de erro
            }
        }
        return clientes; // Retorna a lista de clientes
    }
    
    // Método para salvar a lista de tickets em um arquivo
    public static void salvarTickets(List<Tickets> tickets, String caminhoFicheiro2) {
        // Cria um novo arquivo com o caminho especificado
        File f = new File(caminhoFicheiro2);
        try {
            f.createNewFile(); // Cria o arquivo se ele não existir
            // Cria um ObjectOutputStream para escrever a lista de tickets no arquivo
            ObjectOutputStream ficheiro = new ObjectOutputStream(new FileOutputStream(caminhoFicheiro2));
            ficheiro.writeObject(tickets); // Escreve a lista de tickets no arquivo
            System.out.println("Lista de tickets foi arquivada com sucesso.");
            System.out.println("No ficheiro: " + f.getAbsolutePath());
            ficheiro.flush(); // Limpa o stream
            ficheiro.close(); // Fecha o stream
        } catch (IOException e) {
            e.printStackTrace(); // Imprime a pilha de exceção em caso de erro
        }
    }

    // Método para listar tickets a partir de um arquivo
    @SuppressWarnings("unchecked")
    public static ArrayList<Tickets> listarTickets(String caminhoFicheiro2) {
        ArrayList<Tickets> tickets = new ArrayList<>(); // Cria uma nova lista de tickets
        File ficheiro = new File(caminhoFicheiro2); // Cria um novo arquivo com o caminho especificado
        if (!ficheiro.exists()) { // Verifica se o arquivo não existe
            ficheiro = new File(caminhoFicheiro2); // Cria um novo arquivo
        } else {
            try (ObjectInputStream f = new ObjectInputStream(new FileInputStream(caminhoFicheiro2))) {
                tickets = (ArrayList<Tickets>) f.readObject(); // Lê a lista de tickets do arquivo
                System.out.println("Restauro dos dados realizado com sucesso.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace(); // Imprime a pilha de exceção em caso de erro
            }
        }
        return tickets; // Retorna a lista de tickets
    }
}
