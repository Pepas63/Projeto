package Projeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Clientes> clientes = new ArrayList<>();
    private static List<Tickets> tickets = new ArrayList<>();
    private static final String CAMINHO_FICHEIRO = "clientes.dat";

    public static void main(String[] args) {
        clientes = Backup.listarClientes(CAMINHO_FICHEIRO);
        tickets = Backup.listarTickets(CAMINHO_FICHEIRO);
        
        menu();

        Backup.salvarTickets(tickets, CAMINHO_FICHEIRO);
        Backup.salvarClientes(clientes, CAMINHO_FICHEIRO);
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("");
            System.out.println("Menu:");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar ticket");
            System.out.println("3. Consultar tickets");
            System.out.println("4. Fechar ticket");
            System.out.println("5. Mostrar clientes");
            System.out.println("6. Sair");
            System.out.println("");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    cadastrarTicket();
                    break;
                case 3:
                    consultarTickets();
                    break;
                case 4:
                    fecharTicket(scanner);
                    break;
                case 5:
                    mostrarClientes();
                    break;        
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarCliente(Scanner scanner) {
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

        Backup.salvarTickets(tickets, CAMINHO_FICHEIRO);
        System.out.println("Ticket cadastrado com sucesso!");
    }


    
    
    
    
    
    private static void consultarTickets() {
        System.out.println("Tickets:");
        for (Tickets ticket : tickets) {
            System.out.println("ID: " + ticket.getId());
            System.out.println("Cliente: " + ticket.getCliente().getNome());
            System.out.println("Tipo: " + ticket.getTipo());
            System.out.println("Descrição: " + ticket.getDescricao());
            System.out.println("Valor dos serviços: " + ticket.getValorServicos());
            System.out.println("Valor das peças: " + ticket.getValorPecas());
            System.out.println();
        }
    }

    private static void fecharTicket(Scanner scanner) {
        System.out.print("Selecione o ticket a fechar: ");
        for (int i = 0; i < tickets.size(); i++) {
            System.out.println((i + 1) + ". " + tickets.get(i).getDescricao());
        }
        int ticketId = scanner.nextInt();
        Tickets ticket = tickets.get(ticketId - 1);

        ticket.setDataFechamento(new Date());
        System.out.println("Ticket fechado com sucesso!");
    }

    private static void mostrarClientes() {
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
