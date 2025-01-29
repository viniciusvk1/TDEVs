package com.github.viniciusvk1.TicketAnalyzer.repository;

import com.github.viniciusvk1.TicketAnalyzer.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByStatusTicket(String statusTicket);
    List<Ticket> findByNomeDesenvolvedor(String nomeDesenvolvedor);
    List<Ticket> findByPrioridade(String prioridade);
}
