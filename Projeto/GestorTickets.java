package Projeto;

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
}
