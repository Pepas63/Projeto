package Projeto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Backup {

    public static void salvarClientes(List<Clientes> clientes, String caminhoFicheiro) {
        File f = new File(caminhoFicheiro);
        try {
            f.createNewFile();
            ObjectOutputStream ficheiro = new ObjectOutputStream(new FileOutputStream(caminhoFicheiro));
            ficheiro.writeObject(clientes);
            System.out.println("Lista de clientes foi arquivada com sucesso.");
            System.out.println("No ficheiro: " + f.getAbsolutePath());
            ficheiro.flush();
            ficheiro.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Clientes> listarClientes(String caminhoFicheiro) {
        ArrayList<Clientes> clientes = new ArrayList<>();
        File ficheiro = new File(caminhoFicheiro);
        if (!ficheiro.exists()) {
            ficheiro = new File(caminhoFicheiro);
        } else {
            try (ObjectInputStream f = new ObjectInputStream(new FileInputStream(caminhoFicheiro))) {
                clientes = (ArrayList<Clientes>) f.readObject();
                System.out.println("Restauro dos dados realizado com sucesso.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return clientes;
    }
    
    public static void salvarTickets(List<Tickets> tickets, String caminhoFicheiro) {
        File f = new File(caminhoFicheiro);
        try {
            f.createNewFile();
            ObjectOutputStream ficheiro = new ObjectOutputStream(new FileOutputStream(caminhoFicheiro));
            ficheiro.writeObject(tickets);
            System.out.println("Lista de tickets foi arquivada com sucesso.");
            System.out.println("No ficheiro: " + f.getAbsolutePath());
            ficheiro.flush();
            ficheiro.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

@SuppressWarnings("unchecked")
public static ArrayList<Tickets> listarTickets(String caminhoFicheiro) {
    ArrayList<Tickets> tickets = new ArrayList<>();
    File ficheiro = new File(caminhoFicheiro);
    if (!ficheiro.exists()) {
        ficheiro = new File(caminhoFicheiro);
    } else {
        try (ObjectInputStream f = new ObjectInputStream(new FileInputStream(caminhoFicheiro))) {
            tickets = (ArrayList<Tickets>) f.readObject();
            System.out.println("Restauro dos dados realizado com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    return tickets;
	}
}
