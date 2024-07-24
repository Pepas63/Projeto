package ProjetoBlackBox;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import projeto.Cliente;

public class Main {
	
	
	// Criar uma lista de clientes e tickets
	private static List<Clientes> clientes = new ArrayList<>();
	private static List<Ticket> tickets = new ArrayList<>();
	
	private static final String CAMINHO_FICHEIRO = "dados.dat";
			
    @SuppressWarnings("unused")
	private static void guardarDados(List<Clientes> clientes, List<Ticket> tickets) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(CAMINHO_FICHEIRO))) {
            outputStream.writeObject(clientes);
            outputStream.writeObject(tickets);
            System.out.println("Dados guardados com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao guardar dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings({ "unchecked", "unused" })
    private static void carregarDados() {
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(CAMINHO_FICHEIRO));
            clientes = (List<Clientes>) inputStream.readObject();
            tickets = (List<Ticket>) inputStream.readObject();
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados: classe não encontrada - " + e.getMessage());
        } finally {
            if (inputStream!= null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar arquivo: " + e.getMessage());
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        carregarDados();

        

        // Menu principal
        while (true) {
        	System.out.println("");
            System.out.println("Menu:");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar ticket");
            System.out.println("3. Consultar tickets");
            System.out.println("4. Fechar ticket");
            System.out.println("5. Sair");
            System.out.println("6. Guardar dados");
            System.out.println("7. Mostrar clientes");
            System.out.println("");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarCliente(clientes, scanner);
                    break;
                case 2:
                    cadastrarTicket(tickets, clientes, scanner);
                    break;
                case 3:
                    consultarTickets(tickets);
                    break;
                case 4:
                    fecharTicket(tickets, scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                case 6:
                    guardarDados(clientes, tickets);
                    break;
                case 7:
                    mostrarClientes(clientes); // Nova opção
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    // Métodos para cada opção do menu
    private static void cadastrarCliente(List<Clientes> clientes, Scanner scanner) {
        System.out.print("Nome do cliente: ");
        String nome = scanner.next();
        System.out.print("Tipo do cliente (Final/Revendedor): ");
        String tipo = scanner.next();
        System.out.print("Email do cliente: ");
        String email = scanner.next();
        System.out.print("Telefone do cliente: ");
        String telefone = scanner.next();

        Clientes cliente = new Clientes(clientes.size() + 1, nome, tipo, email, telefone);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println("");
    }

    private static void cadastrarTicket(List<Ticket> tickets, List<Clientes> clientes, Scanner scanner) {
        System.out.print("Selecione o cliente: ");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
        int clienteId = scanner.nextInt();
        Clientes cliente = clientes.get(clienteId - 1);

        System.out.print("Tipo do ticket (Orçamento/Reparação/Relatório): ");
        String tipo = scanner.next();
        System.out.print("Descrição do ticket: ");
        String descricao = scanner.next();
        System.out.print("Valor dos serviços: ");
        double valorServicos = scanner.nextDouble();
        System.out.print("Valor das peças: ");
        double valorPecas = scanner.nextDouble();

        Ticket ticket = new Ticket(tickets.size() + 1, cliente, tipo, new Date(), null, descricao, valorServicos, valorPecas);
        tickets.add(ticket);
        System.out.println("Ticket cadastrado com sucesso!");
    } 

    private static void consultarTickets(List<Ticket> tickets) {
        System.out.println("Tickets:");
        for (Ticket ticket : tickets) {
            System.out.println("ID: " + ticket.getId());
            System.out.println("Cliente: " + ticket.getCliente().getNome());
            System.out.println("Tipo: " + ticket.getTipo());
            System.out.println("Descrição: " + ticket.getDescricao());
            System.out.println("Valor dos serviços: " + ticket.getValorServicos());
            System.out.println("Valor das peças: " + ticket.getValorPecas());
            System.out.println();
        }
    }

    private static void fecharTicket(List<Ticket> tickets, Scanner scanner) {
        System.out.print("Selecione o ticket a fechar: ");
        for (int i = 0; i < tickets.size(); i++) {
            System.out.println((i + 1) + ". " + tickets.get(i).getDescricao());
        }
        int ticketId = scanner.nextInt();
        Ticket ticket = tickets.get(ticketId - 1);

        ticket.setDataFechamento(new Date());
        System.out.println("Ticket fechado com sucesso!");
    }
    
    private static void mostrarClientes(List<Clientes> clientes) {
        System.out.println("Clientes:");
        for (Clientes cliente : clientes) {
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Tipo: " + cliente.getTipo());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println();
        }
    }
}