package Projeto;

import java.io.*;
import java.util.ArrayList;

public class Backup {
		public static void salvarClientes(ArrayList<Cliente> clientes, String listaclientes) {
		File f = new File(listaclientes);
		try{
			f.createNewFile();				// Criar um novo ficheiro
			ObjectOutputStream ficheiro = new ObjectOutputStream(new FileOutputStream(listaclientes));
			ficheiro.writeObject(clientes); // Escrever o arraylist no ficheiro
			System.out.println(" Lista de clientes  foi arquivada com sucesso.");
			System.out.println("no ficheiro: " + f.getAbsolutePath());
			ficheiro.flush();
			ficheiro.close();
			
		}catch (IOException e) {
			e.printStackTrace();      // Se a operação der erro mostra o erro...
		}
}
@SuppressWarnings("unchecked")
public static ArrayList<Cliente> listarClientes(String listaclientes)
	{
	ArrayList<Cliente> clientes = new ArrayList <>();
	File ficheiro = new File(listaclientes);
	if (!ficheiro.exists())
		ficheiro = new File(listaclientes);
	else {
		ObjectInputStream f;
		try {
			f = new ObjectInputStream(new FileInputStream(listaclientes));
			clientes = (ArrayList<Cliente>) f.readObject();
			System.out.println("Restauro dos dados realizado com sucesso.");
		}catch (IOException e) {
			System.out.println("Ficheiro: " + ficheiro.getAbsolutePath());
			e.printStackTrace();         // Se a operação der erro mostra o erro...
		}catch (ClassNotFoundException e) {
			System.out.println("Ficheiro: " + ficheiro.getAbsolutePath());
			e.printStackTrace();         // Se a operação der erro mostra o erro..
		}
	}
	return clientes;
	
}

}
    
