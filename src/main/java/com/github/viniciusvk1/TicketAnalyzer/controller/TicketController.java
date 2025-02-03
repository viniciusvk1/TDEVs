package com.github.viniciusvk1.TicketAnalyzer.controller;

import com.github.viniciusvk1.TicketAnalyzer.model.Ticket;
import com.github.viniciusvk1.TicketAnalyzer.service.ExcelService;
import com.github.viniciusvk1.TicketAnalyzer.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private ExcelService excelService;

    @GetMapping("/{ticket}")
    public Ticket getTicketByTicket(@PathVariable String ticket) {
        Optional<Ticket> ticketOptional = ticketService.getTicketByTicket(ticket);
        return ticketOptional.orElse(null);
    }

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

    @GetMapping("/contagem-por-status")
    public Map<String, Long> countTicketsByStatus() {
        return ticketService.countTicketsByStatus();
    }

    @GetMapping("/avaliador/{nomeAvaliador}/tdevs-ativas")
    public List<Ticket> getActiveTDevsByAvaliador(@PathVariable String nomeAvaliador) {
        return ticketService.getTicketsByAvaliadorExcludingCancelledAndCompleted(nomeAvaliador);
    }

    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            excelService.readExcelFile(file);
            // Retorna sucesso com a mensagem
            return ResponseEntity.ok(Map.of("message", "Arquivo enviado com sucesso!"));
        } catch (IOException e) {
            e.printStackTrace();
            // Retorna erro com a mensagem
            return ResponseEntity.status(500).body(Map.of("message", "Falha ao enviar o arquivo."));
        }

    }
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();  // Método que deve ser implementado no serviço TicketService
    }
}