package com.github.viniciusvk1.TicketAnalyzer.controller;

import com.github.viniciusvk1.TicketAnalyzer.model.Ticket;
import com.github.viniciusvk1.TicketAnalyzer.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/status/{status}")
    public List<Ticket> getTicketsByStatus(@PathVariable String status) {
        return ticketService.getTicketsByStatus(status);
    }

    @GetMapping("/desenvolvedor/{nomeDesenvolvedor}")
    public Map<String, Long> getTicketsByDeveloperStatusCount(@PathVariable String nomeDesenvolvedor) {
        return ticketService.getTicketsByDeveloperStatusCount(nomeDesenvolvedor);
    }

    @GetMapping("/desenvolvedor/{nomeDesenvolvedor}/tickets")
    public List<Ticket> getTicketsByDeveloper(@PathVariable String nomeDesenvolvedor) {
        return ticketService.getTicketsByDeveloper(nomeDesenvolvedor);
    }

    @GetMapping("/prioridade/{prioridade}")
    public List<Ticket> getTicketsByPriority(@PathVariable String prioridade) {
        return ticketService.getTicketsByPriority(prioridade);
    }
}