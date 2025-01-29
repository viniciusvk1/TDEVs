package com.github.viniciusvk1.TicketAnalyzer.service;


import com.github.viniciusvk1.TicketAnalyzer.model.Ticket;
import com.github.viniciusvk1.TicketAnalyzer.repository.TicketRepository;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Iterator;

@Service
public class ExcelService {

    @Autowired
    private TicketRepository ticketRepository;

    public void readExcelFile(MultipartFile file) throws IOException {
        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        // Pular o cabeçalho
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Ticket ticket = new Ticket();

            ticket.setStatusTicket(getCellValueAsString(row.getCell(0)));
            ticket.setTicket(getCellValueAsString(row.getCell(1)));
            ticket.setDescricaoTicket(getCellValueAsString(row.getCell(2)));
            ticket.setTipoAssociacao(getCellValueAsString(row.getCell(3)));
            ticket.setIdentificacaoAssociacao(getCellValueAsString(row.getCell(4)));
            ticket.setDescricaoAssociacao(getCellValueAsString(row.getCell(5)));
            ticket.setNomeSolicitante(getCellValueAsString(row.getCell(6)));
            ticket.setNomeAvaliadorTecnico(getCellValueAsString(row.getCell(7)));
            ticket.setTipoDesenvolvedor(getCellValueAsString(row.getCell(8)));
            ticket.setNomeDesenvolvedor(getCellValueAsString(row.getCell(9)));
            ticket.setPrioridade(getCellValueAsString(row.getCell(10)));
            ticket.setMotivoSolicitacao(getCellValueAsString(row.getCell(11)));
            ticket.setEquipeTrabalho(getCellValueAsString(row.getCell(12)));
            ticket.setModulo(getCellValueAsString(row.getCell(13)));
            ticket.setEtapa(getCellValueAsString(row.getCell(14)));
            ticket.setDataCriacaoTicket(parseDate(getCellValueAsString(row.getCell(15))));
            ticket.setDataEncerramentoTicket(parseDate(getCellValueAsString(row.getCell(16))));
            ticket.setStatusDocumento(getCellValueAsString(row.getCell(17)));
            ticket.setTipoSolicitacao(getCellValueAsString(row.getCell(18)));
            ticket.setDocumentoReprovado(getCellValueAsString(row.getCell(19)));
            ticket.setMotivoReprovacao(getCellValueAsString(row.getCell(20)));
            ticket.setComplexidade(getCellValueAsString(row.getCell(21)));
            ticket.setVolumeTrabalho(getNumericValue(row.getCell(22)));
            ticket.setTotalEsforcoPrevisto(getNumericValue(row.getCell(23)));
            ticket.setPrazoEntregaDesenvolvimento(parseDate(getCellValueAsString(row.getCell(24))));
            ticket.setTotalEsforcoAdicional(getNumericValue(row.getCell(25)));
            ticket.setEsforcoPrevistoMaisHorasAdicionais(getNumericValue(row.getCell(26)));
            ticket.setEsforcoReal(getNumericValue(row.getCell(27)));
            ticket.setTerminoRealDesenvolvimento(parseDate(getCellValueAsString(row.getCell(28))));
            ticket.setStatusDesenvolvimento(getCellValueAsString(row.getCell(29)));
            ticket.setChangeRequests(getCellValueAsString(row.getCell(30)));
            ticket.setDataAtual(parseDate(getCellValueAsString(row.getCell(31))));
            ticket.setDataTratada(parseDate(getCellValueAsString(row.getCell(32))));
            ticket.setDataConvertida(parseDate(getCellValueAsString(row.getCell(33))));

            ticketRepository.save(ticket);
        }
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return null;
        }
        try {
            switch (cell.getCellType()) {
                case STRING:
                    return cell.getStringCellValue();
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        return cell.getLocalDateTimeCellValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    } else {
                        return String.valueOf(cell.getNumericCellValue());
                    }
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                case FORMULA:
                    return cell.getCellFormula();
                default:
                    return null;
            }
        } catch (Exception e) {
            System.err.println("Erro ao ler o valor da célula: " + e.getMessage());
            return null;
        }
    }

    private Double getNumericValue(Cell cell) {
        if (cell == null || cell.getCellType() != CellType.NUMERIC) {
            return null;
        }
        return cell.getNumericCellValue();
    }

    private LocalDateTime parseDate(String dateString) {
        if (dateString == null || dateString.isEmpty() || "########".equals(dateString)) {
            return null;  // Ou qualquer outra lógica que você queira para valores inválidos
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            return LocalDateTime.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Erro ao parsear a data: " + e.getMessage());
            return null;  // Retorna null em caso de erro de parsing
        }
    }
}