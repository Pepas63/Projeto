package Projeto;

import java.util.ArrayList;
import java.util.List;

public class GestorTickets {
    private List<Tickets> tickets;

    public GestorTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }

    public void adicionarTicket(Tickets ticket) {
        tickets.add(ticket);
    }

    public List<Tickets> listarTickets() {
        return tickets;
    }

    public Tickets buscarTicket(int numero) {
        return tickets.stream()
                      .filter(ticket -> ticket.getId() == numero)
                      .findFirst()
                      .orElse(null);
    }

    public void removerTicket(int numero) {
        Tickets ticket = buscarTicket(numero);
        if (ticket == null) return; // Ticket não encontrado
        
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
        tickets.removeIf(t -> t.getId() == numero);
    }

    
 // Método para buscar tickets por cliente ID
    public List<Tickets> buscarTicketsPorCliente(int clienteId) {
        List<Tickets> resultado = new ArrayList<>();
        for (Tickets ticket : tickets) {
            if (ticket.getCliente().getId() == clienteId) {
                resultado.add(ticket);
            }
        }
        return resultado;
    }
    
    
    // Novo método para buscar tickets por tipo
    public List<Tickets> buscarTicketsPorTipo(String tipo) {
        List<Tickets> ticketsPorTipo = new ArrayList<>();
        
        for (Tickets ticket : tickets) {
            if (tipo.equals("Orçamento") && ticket instanceof Orçamento) {
                ticketsPorTipo.add(ticket);
            } else if (tipo.equals("Reparação") && ticket instanceof Reparação) {
                ticketsPorTipo.add(ticket);
            } else if (tipo.equals("Relatório") && ticket instanceof Relatório) {
                ticketsPorTipo.add(ticket);
            }
        }
        
        return ticketsPorTipo;
    }
}
