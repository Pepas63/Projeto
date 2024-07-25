package Projeto;

import java.util.ArrayList;
import java.util.List;

// Classe responsável por gerenciar os tickets
public class GestorTickets {
    private List<Tickets> tickets; // Lista de tickets

    // Construtor que inicializa a lista de tickets
    public GestorTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }

    // Método para adicionar um ticket à lista
    public void adicionarTicket(Tickets ticket) {
        tickets.add(ticket);
    }

    // Método para listar todos os tickets
    public List<Tickets> listarTickets() {
        return tickets;
    }

    // Método para buscar um ticket pelo número (ID)
    public Tickets buscarTicket(int numero) {
        return tickets.stream()
                      .filter(ticket -> ticket.getId() == numero) // Filtra pelo ID do ticket
                      .findFirst() // Encontra o primeiro ticket que corresponde ao filtro
                      .orElse(null); // Retorna null se nenhum ticket for encontrado
    }

    // Método para remover um ticket pelo número (ID)
    public void removerTicket(int numero) {
        Tickets ticket = buscarTicket(numero); // Busca o ticket pelo ID
        if (ticket == null) return; // Se o ticket não for encontrado, sai do método
        
        // Verifica condições específicas para remoção de diferentes tipos de tickets
        if (ticket instanceof Orçamento && ticket.getDataFechamento() != null) {
            System.out.println("Orçamento que deu origem a uma reparação não pode ser removido.");
            return;
        }
        if (ticket instanceof Relatório && ticket.getDataFechamento() != null) {
            System.out.println("Relatório que deu origem a outro registo não pode ser removido.");
            return;
        }
        if (ticket instanceof Reparação && ticket.getDataFechamento() != null) {
            System.out.println("Reparação fechada não pode ser removida.");
            return;
        }
        // Remove o ticket da lista se nenhuma das condições acima for atendida
        tickets.removeIf(t -> t.getId() == numero);
    }

    // Método para buscar tickets por cliente ID
    public List<Tickets> buscarTicketsPorCliente(int clienteId) {
        List<Tickets> resultado = new ArrayList<>(); // Lista de tickets do cliente especificado
        for (Tickets ticket : tickets) {
            if (ticket.getCliente().getId() == clienteId) {
                resultado.add(ticket); // Adiciona o ticket à lista de resultados se o ID do cliente corresponder
            }
        }
        return resultado; // Retorna a lista de tickets do cliente
    }
    
    // Método para buscar tickets por tipo (Orçamento, Reparação, Relatório)
    public List<Tickets> buscarTicketsPorTipo(String tipo) {
        List<Tickets> ticketsPorTipo = new ArrayList<>(); // Lista de tickets do tipo especificado
        
        for (Tickets ticket : tickets) {
            // Adiciona o ticket à lista de resultados se o tipo corresponder
            if (tipo.equals("Orçamento") && ticket instanceof Orçamento) {
                ticketsPorTipo.add(ticket);
            } else if (tipo.equals("Reparação") && ticket instanceof Reparação) {
                ticketsPorTipo.add(ticket);
            } else if (tipo.equals("Relatório") && ticket instanceof Relatório) {
                ticketsPorTipo.add(ticket);
            }
        }
        
        return ticketsPorTipo; // Retorna a lista de tickets do tipo especificado
    }
}

