package com.github.viniciusvk1.TicketAnalyzer.repository;

import com.github.viniciusvk1.TicketAnalyzer.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByStatusTicket(String statusTicket);
    List<Ticket> findByNomeDesenvolvedor(String nomeDesenvolvedor);
    List<Ticket> findByPrioridade(String prioridade);

    Optional<Ticket> findByTicket(String ticket);

    @Query("SELECT t.statusTicket, COUNT(t) FROM Ticket t GROUP BY t.statusTicket")
    List<Object[]> countTicketsByStatus();

    @Query("SELECT t FROM Ticket t WHERE t.nomeAvaliadorTecnico = :nomeAvaliador AND t.statusTicket NOT IN ('Cancelada', 'Concluída')")
    List<Ticket> findByAvaliadorTecnicoExcludingCancelledAndCompleted(@Param("nomeAvaliador") String nomeAvaliador);
}
