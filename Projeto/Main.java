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
            System.out.println("|3 - Consultas                |");
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
                case 3:
                    // Ir para o menu de consultas
                	menuconsultas();
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
            System.out.print("Desconto por Pagamento Pronto(sim/não): ");
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
                    modificarTicket();
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
    private static void modificarTicket() {
        // Solicitar ID do ticket original
        System.out.print("ID do Ticket a modificar: ");
        int idOriginal = MyFunc.recebeInt();
        Tickets ticketOriginal = gestorTickets.buscarTicket(idOriginal);

        if (ticketOriginal == null) {
            System.out.println("Ticket não encontrado!");
            return;
        }

        // Solicitar o novo ID e tipo do ticket
        System.out.print("Novo ID do Ticket: ");
        int novoId = MyFunc.recebeInt();
        System.out.print("Novo Tipo do Ticket (1 - Orçamento, 2 - Reparação, 3 - Relatório): ");
        int novoTipo = MyFunc.recebeInt();

        // Criar o novo ticket conforme o tipo escolhido
        Tickets novoTicket;
        Date dataAbertura = new Date();
        switch (novoTipo) {
            case 1: // Orçamento
                novoTicket = new Orçamento(novoId, ticketOriginal.getCliente(), dataAbertura, null, ticketOriginal.getDescricao(), ticketOriginal.getValorServicos(), ticketOriginal.getValorPecas(), false);
                break;
            case 2: // Reparação
                if (ticketOriginal instanceof Orçamento || ticketOriginal instanceof Relatório) {
                    novoTicket = new Reparação(novoId, ticketOriginal.getCliente(), dataAbertura, null, "Originado de ID: " + ticketOriginal.getId(), ticketOriginal.getValorServicos(), ticketOriginal.getValorPecas());
                } else {
                    System.out.println("Uma reparação só pode ser originada de Orçamento ou Relatório.");
                    return;
                }
                break;
            case 3: // Relatório
                if (ticketOriginal instanceof Orçamento) {
                    novoTicket = new Relatório(novoId, ticketOriginal.getCliente(), dataAbertura, null, "Originado de ID: " + ticketOriginal.getId(), ticketOriginal.getValorServicos(), ticketOriginal.getValorPecas());
                } else {
                    System.out.println("Somente Orçamentos podem originar Relatórios.");
                    return;
                }
                break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }

        // Adicionar o novo ticket sem remover o original
        gestorTickets.adicionarTicket(novoTicket);
        Backup.salvarTickets(gestorTickets.listarTickets(), CAMINHO_FICHEIRO2);

        System.out.println("Novo ticket criado com sucesso!");
    }

    private static void menuconsultas() {
        while (true) {
            System.out.println("\n");
            System.out.println("+------------------------------+");
            System.out.println("|       Consultar Tickets      |");
            System.out.println("+------------------------------+");
            System.out.println("|1 - Listar todos os tickets   |");
            System.out.println("|2 - Listar tickets por tipo   |");
            System.out.println("|3 - Listar tickets por cliente|");
            System.out.println("|0 - Voltar                    |");
            System.out.println("+------------------------------+");
            System.out.print("Escolha uma opção: ");

            int opcao = MyFunc.recebeInt();
            switch (opcao) {
                case 1:
                	mostrarTickets();
                    break;
                case 2:
                    mostrarTicketsPorTipo();
                    break;
                case 3:
                	mostrarTicketsPorCliente();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente");
            }
        }
    }
    private static void mostrarTicketsPorTipo() {
        System.out.print("Digite o tipo de ticket (1 - Orçamento, 2 - Reparação, 3 - Relatório): ");
        int tipo = MyFunc.recebeInt();
        String tipoString;

        switch (tipo) {
            case 1:
                tipoString = "Orçamento";
                break;
            case 2:
                tipoString = "Reparação";
                break;
            case 3:
                tipoString = "Relatório";
                break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }

        List<Tickets> tickets = gestorTickets.buscarTicketsPorTipo(tipoString);
        if (tickets.isEmpty()) {
            System.out.println("Nenhum ticket encontrado para o tipo especificado.");
            return;
        }

        System.out.println("\n");
        System.out.println("+-----------------------------------------------------------------+");
        System.out.println("|                         Lista de Tickets                        |");
        System.out.println("+-----------------------------------------------------------------+");

        for (Tickets ticket : tickets) {
            // Aplicar desconto se necessário
            double valorServicos = ticket.getValorServicos();
            double valorPecas = ticket.getValorPecas();

            if (ticket.getCliente() instanceof ClienteFinal) {
                ClienteFinal clienteFinal = (ClienteFinal) ticket.getCliente();
                if (clienteFinal.isDescontoProntoPagamento()) {
                    valorServicos *= 0.9; // Aplicar 10% de desconto
                    valorPecas *= 0.9; // Aplicar 10% de desconto
                }
            }

            // Exibir informações do ticket com formatação
            System.out.printf("| ID: %-60d|\n", ticket.getId());
            System.out.printf("| Cliente: %-55s|\n", ticket.getCliente().getNome());
            System.out.printf("| Tipo: %-58s|\n", tipoString);
            System.out.printf("| Descrição: %-53s|\n", ticket.getDescricao());
            System.out.printf("| Valor dos Serviços: %-44s|\n", String.format("%.2f", valorServicos));
            System.out.printf("| Valor das Peças: %-47s|\n", String.format("%.2f", valorPecas));
            System.out.println("+-----------------------------------------------------------------+");
        }
    }
    
    private static void mostrarTicketsPorCliente() {
        System.out.print("Digite o ID do cliente: ");
        int clienteId = MyFunc.recebeInt();
        List<Tickets> tickets = gestorTickets.buscarTicketsPorCliente(clienteId);

        if (tickets.isEmpty()) {
            System.out.println("Nenhum ticket encontrado para o cliente especificado.");
            return;
        }

        System.out.println("\n");
        System.out.println("+-----------------------------------------------------------------+");
        System.out.println("|                         Lista de Tickets                        |");
        System.out.println("+-----------------------------------------------------------------+");

        for (Tickets ticket : tickets) {
            double valorServicos = ticket.getValorServicos();
            double valorPecas = ticket.getValorPecas();

            if (ticket.getCliente() instanceof ClienteFinal && ((ClienteFinal) ticket.getCliente()).isDescontoProntoPagamento()) {
                valorServicos *= 0.9;
                valorPecas *= 0.9;
            }

            String tipoString = (ticket instanceof Orçamento) ? "Orçamento" :
                                (ticket instanceof Reparação) ? "Reparação" : "Relatório";

            System.out.printf("| ID: %-60d|\n", ticket.getId());
            System.out.printf("| Cliente: %-55s|\n", ticket.getCliente().getNome());
            System.out.printf("| Tipo: %-58s|\n", tipoString);
            System.out.printf("| Descrição: %-53s|\n", ticket.getDescricao());
            System.out.printf("| Valor dos Serviços: %-44s|\n", String.format("%.2f", valorServicos));
            System.out.printf("| Valor das Peças: %-47s|\n", String.format("%.2f", valorPecas));
            System.out.println("+-----------------------------------------------------------------+");
        }
    }


}