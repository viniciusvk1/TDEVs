package com.github.viniciusvk1.TicketAnalyzer.service;

import com.github.viniciusvk1.TicketAnalyzer.model.Ticket;
import com.github.viniciusvk1.TicketAnalyzer.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getTicketsByStatus(String status) {
        return ticketRepository.findByStatusTicket(status);
    }

    public Map<String, Long> getTicketsByDeveloperStatusCount(String nomeDesenvolvedor) {
        List<Ticket> tickets = ticketRepository.findByNomeDesenvolvedor(nomeDesenvolvedor);
        return tickets.stream()
                .collect(Collectors.groupingBy(Ticket::getStatusDesenvolvimento, Collectors.counting()));
    }

    public List<Ticket> getTicketsByDeveloper(String nomeDesenvolvedor) {
        return ticketRepository.findByNomeDesenvolvedor(nomeDesenvolvedor);
    }

    public List<Ticket> getTicketsByPriority(String prioridade) {
        return ticketRepository.findByPrioridade(prioridade);
    }

    public Optional<Ticket> getTicketByTicket(String ticket) {
        return ticketRepository.findByTicket(ticket);
    }

    public Map<String, Long> countTicketsByStatus() {
        List<Object[]> results = ticketRepository.countTicketsByStatus();
        Map<String, Long> statusCountMap = new HashMap<>();

        for (Object[] result : results) {
            String status = (String) result[0];
            Long count = (Long) result[1];
            statusCountMap.put(status, count);
        }

        return statusCountMap;
    }

    public List<Ticket> getTicketsByAvaliadorExcludingCancelledAndCompleted(String nomeAvaliador) {
        return ticketRepository.findByAvaliadorTecnicoExcludingCancelledAndCompleted(nomeAvaliador);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();  // Usando o repositório para buscar todos os tickets
    }

}
