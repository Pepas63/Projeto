package Projeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;




public class Main {
    // Lista de clientes
	private static List<Clientes> clientes = new ArrayList<>();
    // Lista de tickets
    private static List<Tickets> tickets = new ArrayList<>();
    // Caminho do arquivo de clientes
    private static final String CAMINHO_FICHEIRO = "clientes.dat";
    // Caminho do arquivo de tickets
    private static final String CAMINHO_FICHEIRO2 = "tickets.dat";
    // Gestor de tickets
    private static GestorTickets gestorTickets;

    public static void main(String[] args) {
        // Carregar clientes do arquivo
        clientes = Backup.listarClientes(CAMINHO_FICHEIRO);
        // Carregar tickets do arquivo
        tickets = Backup.listarTickets(CAMINHO_FICHEIRO2);
        // Criar gestor de tickets
        gestorTickets = new GestorTickets(tickets);
        
        // Entrar no loop do menu
        menu();
        
        // Salvar clientes e tickets antes de sair
        Backup.salvarTickets(tickets, CAMINHO_FICHEIRO2);
        Backup.salvarClientes(clientes, CAMINHO_FICHEIRO);
    }
    
    // Menu principal
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
                    // Ir para o menu de gestão de clientes
                	menuGestaoClientes();
                    break;
                case 2:
                    // Ir para o menu de gestão de tickets
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
    
    // Menu de gestão de clientes
    private static void menuGestaoClientes() {
        while (true) {
            System.out.println("\n");
            System.out.println("+-----------------------------+");
            System.out.println("|      Gestão de Clientes     |");
            System.out.println("+-----------------------------+");
            System.out.println("|1 - Adicionar Cliente        |");
            System.out.println("|2 - Mostrar Clientes         |");
            System.out.println("|3 - Remover Cliente          |");
            System.out.println("|0 - Voltar                   |");
            System.out.println("+-----------------------------+");
            System.out.print("Escolha uma opção: ");

            int opcao = MyFunc.recebeInt();
            switch (opcao) {
                case 1:
                    // Cadastrar novo cliente
                	cadastrarCliente();
                    break;
                case 2:
                    // Mostrar lista de clientes
                	mostrarClientes();
                    break;
                case 3:
                    // Remover cliente
                    removerCliente();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente");
            }
        }
    }
    // Cadastrar novo cliente
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
    // Remover cliente
    private static void removerCliente() {
        System.out.print("Informe o ID do cliente a ser removido: ");
        int clienteId = MyFunc.recebeInt();

        // Localiza o cliente a ser removido
        boolean removido = clientes.removeIf(cliente -> cliente.getId() == clienteId);

        if (removido) {
            System.out.println("Cliente removido com sucesso!");
            // Atualiza o arquivo de clientes após remoção
            Backup.salvarClientes(clientes, CAMINHO_FICHEIRO);
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }
    // Mostrar lista de clientes
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

    // Menu de gestão de tickets
    private static void menuGestaoTickets() {
        while (true) {
            System.out.println("\n");
            System.out.println("+-----------------------------+");
            System.out.println("|       Gestão de Tickets     |");
            System.out.println("+-----------------------------+");
            System.out.println("|1 - Adicionar Ticket         |");
            System.out.println("|2 - Mostrar Tickets          |");
            System.out.println("|3 - Modificar Ticket         |");
            System.out.println("|4 - Remover Ticket           |");
            System.out.println("|0 - Voltar                   |");
            System.out.println("+-----------------------------+");
            System.out.print("Escolha uma opção: ");

            int opcao = MyFunc.recebeInt();
            switch (opcao) {
                case 1:
                    // Cadastrar novo ticket
                	cadastrarTicket();
                    break;
                case 2:
                    // Mostrar lista de tickets
                	mostrarTickets();
                    break;
                    
                case 3:
                    // Modificar ticket
                    modificarTicket(opcao, opcao, null, opcao, opcao, false, null);
                    break;
                    
                case 4:
                    // Remover ticket
                    removerTicket();
                    break;
                   
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente");
            }
        }
    }
    // Cadastrar novo ticket
    private static void cadastrarTicket() {
        System.out.println("Selecione o cliente: ");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + "." + clientes.get(i).getNome());
        }
        System.out.println("");
        System.out.print("Insira o Id:");
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
                
            case 3:
            	ticket = new Relatório(gestorTickets.listarTickets().size() + 1, cliente, new Date(), null, descricao, valorServicos, valorPecas);
            	break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }

        gestorTickets.adicionarTicket(ticket);
        Backup.salvarTickets(gestorTickets.listarTickets(), CAMINHO_FICHEIRO2);
        System.out.println("Ticket cadastrado com sucesso!");
    }

    // Mostrar lista de tickets
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
            System.out.printf("| Tipo: %-58s|\n", ticket.getTipo());
            System.out.printf("| Descrição: %-53s|\n", ticket.getDescricao());
            System.out.printf("| Valor dos serviços: %-44s|\n", ticket.getValorServicos());
            System.out.printf("| Valor das peças: %-47s|\n", ticket.getValorPecas());
            System.out.println("+-----------------------------------------------------------------+");
        }
    }

    // Remover ticket
    private static void removerTicket() {
        System.out.print("ID do Ticket a remover: ");
        int id = MyFunc.recebeInt();
        gestorTickets.removerTicket(id);
        Backup.salvarTickets(gestorTickets.listarTickets(), CAMINHO_FICHEIRO2);
        System.out.println("Ticket removido com sucesso!");
    }
    
    //Modificar ticket
    private static void modificarTicket(int idOriginal, int novoTipo, String descricao, double valorServicos, double valorPecas, boolean aprovado, String numeroSerie) {
        // Buscar o ticket original
        Tickets ticketOriginal = gestorTickets.buscarTicket(idOriginal);

        if (ticketOriginal == null) {
            System.out.println("Ticket não encontrado!");
            return;
        }

        // Definir a variável para o novo ticket
        Tickets novoTicket = null;
        int novoId = gestorTickets.listarTickets().size() + 1;
        Date dataAbertura = new Date();

        // Criar o novo ticket conforme o tipo escolhido
        switch (novoTipo) {
            case 1: // Orçamento
                novoTicket = new Orçamento(novoId, ticketOriginal.getCliente(), dataAbertura, null, descricao, valorServicos, valorPecas, aprovado);
                break;
            case 2: // Reparação
                if (ticketOriginal instanceof Orçamento || ticketOriginal instanceof Relatório) {
                    novoTicket = new Reparação(novoId, ticketOriginal.getCliente(), dataAbertura, null, descricao, valorServicos, valorPecas);
                    // Adicionar referência ao ticket original
                    novoTicket.setDescricao(ticketOriginal.getDescricao() + " (Originado de ID: " + ticketOriginal.getId() + ")");
                } else {
                    System.out.println("Uma reparação não pode ser convertida para outro tipo de ticket.");
                    return;
                }
                break;
            case 3: // Relatório
                if (ticketOriginal instanceof Orçamento) {
                    novoTicket = new Relatório(novoId, ticketOriginal.getCliente(), dataAbertura, null, descricao, valorServicos, valorPecas);
                    // Adicionar referência ao ticket original
                    novoTicket.setDescricao(ticketOriginal.getDescricao() + " (Originado de ID: " + ticketOriginal.getId() + ")");
                } else {
                    System.out.println("Somente um orçamento pode originar um relatório.");
                    return;
                }
                break;
            default:
                System.out.println("Tipo inválido! Tente novamente.");
                return;
        }

        // Adicionar o novo ticket, remover o antigo e salvar as alterações
        gestorTickets.adicionarTicket(novoTicket);
        gestorTickets.removerTicket(idOriginal);
        Backup.salvarTickets(gestorTickets.listarTickets(), CAMINHO_FICHEIRO2);
        System.out.println("Ticket modificado com sucesso!");
    }
    
  
   
}
