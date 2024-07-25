package Projeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;




public class Main {
	private static List<Clientes> clientes = new ArrayList<>();
    private static List<Tickets> tickets = new ArrayList<>();
    private static final String CAMINHO_FICHEIRO = "clientes.dat";
    private static final String CAMINHO_FICHEIRO2 = "tickets.dat";
    private static GestorTickets gestorTickets;

    public static void main(String[] args) {
        clientes = Backup.listarClientes(CAMINHO_FICHEIRO);
        tickets = Backup.listarTickets(CAMINHO_FICHEIRO2);
        gestorTickets = new GestorTickets(tickets);
        
        menu();

        Backup.salvarTickets(tickets, CAMINHO_FICHEIRO2);
        Backup.salvarClientes(clientes, CAMINHO_FICHEIRO);
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
        	System.out.println("+-----------------------------+");
            System.out.println("|           MENU              |");
            System.out.println("+-----------------------------+");
            System.out.println("|1 - Gestão de Clientes       |");
            System.out.println("|2 - Gestão de Tickets        |");
            System.out.println("|0 - Sair                     |");
            System.out.println("+-----------------------------+");
            System.out.print("Escolha uma opção: ");

            int opcao = MyFunc.recebeInt();
            switch (opcao) {
                case 1:
                	menuGestaoClientes();
                    break;
                case 2:
                	menuGestaoTickets();
                    break;      
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    private static void menuGestaoClientes() {
        while (true) {
            System.out.println("\n");
            System.out.println("+-----------------------------+");
            System.out.println("|      Gestão de Clientes     |");
            System.out.println("+-----------------------------+");
            System.out.println("|1 - Adicionar Cliente        |");
            System.out.println("|2 - Mostrar Clientes         |");
            System.out.println("|3 - Remover Cliente (WIP)    |");
            System.out.println("|0 - Voltar                   |");
            System.out.println("+-----------------------------+");
            System.out.print("Escolha uma opção: ");

            int opcao = MyFunc.recebeInt();
            switch (opcao) {
                case 1:
                	cadastrarCliente();
                    break;
                case 2:
                	mostrarClientes();
                    break;
                case 3:
                    //removerCliente();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente");
            }
        }
    }

    private static void cadastrarCliente() {
        System.out.print("Id do Cliente: ");
        int id = MyFunc.recebeInt();
        System.out.print("Nome do cliente: ");
        String nome = MyFunc.recebeString();
        System.out.print("Tipo do cliente (1- Final / 2- Revendedor): ");
        int tipo = MyFunc.recebeInt();
        System.out.print("Email do cliente: ");
        String email = MyFunc.recebeString();
        System.out.print("Telefone do cliente: ");
        String telefone = MyFunc.recebeString();

        if (tipo == 1) {
            System.out.print("Desconto por Pronto Pagamento (sim/não): ");
            boolean desconto = MyFunc.recebeBoolean();
            clientes.add(new ClienteFinal(id, nome, email, telefone, desconto));
        } else if (tipo == 2) {
            clientes.add(new ClienteRevendedor(id, nome, email, telefone));
        } else {
            System.out.println("Tipo inválido! Tente novamente.");
        }
        Backup.salvarClientes(clientes, CAMINHO_FICHEIRO);
    }

    
    
    private static void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("\n");
        System.out.println("+----------------------------------+");
        System.out.println("|          Lista de Clientes       |");
        System.out.println("+----------------------------------+");
        for (Clientes cliente : clientes) {
            System.out.printf("| ID: %-29d|\n", cliente.getId());
            System.out.printf("| Nome: %-27s|\n", cliente.getNome());
            System.out.printf("| Tipo: %-27s|\n", cliente.getTipo());
            System.out.printf("| Email: %-26s|\n", cliente.getEmail());
            System.out.printf("| Telefone: %-23s|\n", cliente.getTelefone());
            System.out.println("+----------------------------------+");
        }
    }

    
    private static void menuGestaoTickets() {
        while (true) {
            System.out.println("\n");
            System.out.println("+-----------------------------+");
            System.out.println("|       Gestão de Tickets     |");
            System.out.println("+-----------------------------+");
            System.out.println("|1 - Adicionar Ticket         |");
            System.out.println("|2 - Mostrar Tickets          |");
            System.out.println("|3 - Remover Ticket  (WIP)    |");
            System.out.println("|0 - Voltar                   |");
            System.out.println("+-----------------------------+");
            System.out.print("Escolha uma opção: ");

            int opcao = MyFunc.recebeInt();
            switch (opcao) {
                case 1:
                	cadastrarTicket();
                    break;
                case 2:
                	mostrarTickets();
                    break;
                case 3:
                    //removerTicket();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente");
            }
        }
    }
    
    private static void cadastrarTicket() {
        System.out.print("Selecione o cliente: ");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
        int clienteId = MyFunc.recebeInt();
        Clientes cliente = clientes.get(clienteId - 1);

        System.out.print("Tipo do Ticket (1 - Orçamento, 2 - Reparação, 3 - Relatório): ");
        int tipo = MyFunc.recebeInt();

        System.out.print("Descrição do ticket: ");
        String descricao = MyFunc.recebeString();
        System.out.print("Valor dos serviços: ");
        double valorServicos = MyFunc.recebeDouble();
        System.out.print("Valor das peças: ");
        double valorPecas = MyFunc.recebeDouble();

        Tickets ticket;
        switch (tipo) {
            case 1:
                System.out.print("Aprovado (sim/não): ");
                boolean aprovado = MyFunc.recebeBoolean();
                ticket = new Orçamento(gestorTickets.listarTickets().size() + 1, cliente, new Date(), null, descricao, valorServicos, valorPecas, aprovado);
                break;
            case 2:
                ticket = new Reparação(gestorTickets.listarTickets().size() + 1, cliente, new Date(), null, descricao, valorServicos, valorPecas);
                break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }

        gestorTickets.adicionarTicket(ticket);
        Backup.salvarTickets(gestorTickets.listarTickets(), CAMINHO_FICHEIRO2);
        System.out.println("Ticket cadastrado com sucesso!");
    }


    private static void mostrarTickets() {

        if (tickets.isEmpty()) {
            System.out.println("Nenhum ticket cadastrado.");
            return;
        }
        System.out.println("\n");
        System.out.println("+-----------------------------------------------------------------+");
        System.out.println("|                         Lista de Tickets                        |");
        System.out.println("+-----------------------------------------------------------------+");
        for (Tickets ticket : tickets) {
            System.out.printf("| ID: %-60d|\n", ticket.getId());
            System.out.printf("| Cliente: %-55s|\n", ticket.getCliente().getNome());
            System.out.printf("| Tipo: %-58s|\n", ticket.getClass().getSimpleName());
            System.out.printf("| Descrição: %-53s|\n", ticket.getDescricao());
            System.out.printf("| Valor dos serviços: %-44f|\n", ticket.getValorServicos());
            System.out.printf("| Valor das peças: %-47f|\n", ticket.getValorPecas());
            System.out.println("+-----------------------------------------------------------------+");
        }
    }

    
  
   
}
