package com.github.viniciusvk1.TicketAnalyzer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statusTicket;
    private String ticket;
    private String descricaoTicket;
    private String tipoAssociacao;
    private String identificacaoAssociacao;
    private String descricaoAssociacao;
    private String nomeSolicitante;
    private String nomeAvaliadorTecnico;
    private String tipoDesenvolvedor;
    private String nomeDesenvolvedor;
    private String prioridade;
    private String motivoSolicitacao;
    private String equipeTrabalho;
    private String modulo;
    private String etapa;
    private LocalDateTime dataCriacaoTicket;
    private LocalDateTime dataEncerramentoTicket;
    private String statusDocumento;
    private String tipoSolicitacao;
    private String documentoReprovado;
    private String motivoReprovacao;
    private String complexidade;
    private Double volumeTrabalho;
    private Double totalEsforcoPrevisto;
    private LocalDateTime prazoEntregaDesenvolvimento;
    private Double totalEsforcoAdicional;
    private Double esforcoPrevistoMaisHorasAdicionais;
    private Double esforcoReal;
    private LocalDateTime terminoRealDesenvolvimento;
    private String statusDesenvolvimento;
    private String changeRequests;
    private LocalDateTime dataAtual;
    private LocalDateTime dataTratada;
    private LocalDateTime dataConvertida;
}