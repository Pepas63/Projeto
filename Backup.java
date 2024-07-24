package Projeto;

import java.io.*;
import java.util.ArrayList;

public class Backup {
		public static void gravaClientes(ArrayList<Cliente> clientes, String fichaclientes) {
		File f = new File(fichaclientes);
		try{
			f.createNewFile();				// Criar um novo ficheiro
			ObjectOutputStream ficheiro = new ObjectOutputStream(new FileOutputStream(fichaclientes));
			ficheiro.writeObject(clientes); // Escrever o arraylist no ficheiro
			System.out.println("Backup de clientes executado com sucesso.");
			System.out.println("no ficheiro: " + f.getAbsolutePath());
			ficheiro.flush();
			ficheiro.close();
			
		}catch (IOException e) {
			e.printStackTrace();      // Se a operação der erro mostra o erro...
		}
}
@SuppressWarnings("unchecked")
public static ArrayList<Cliente> lerClientes(String fichaclientes)
	{
	ArrayList<Cliente> clientes = new ArrayList <>();
	File ficheiro = new File(fichaclientes);
	if (!ficheiro.exists())
		ficheiro = new File(fichaclientes);
	else {
		ObjectInputStream f;
		try {
			f = new ObjectInputStream(new FileInputStream(fichaclientes));
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
