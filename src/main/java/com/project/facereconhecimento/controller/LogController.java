package com.project.facereconhecimento.controller;

import com.project.facereconhecimento.model.Log;
import com.project.facereconhecimento.model.Pessoa;
import com.project.facereconhecimento.repository.LogRepository;
import com.project.facereconhecimento.service.LogService;
import com.project.facereconhecimento.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/log")
public class LogController {

    private LogService logService;
    private PessoaService pessoaService;

    public LogController(LogService logService, PessoaService pessoaService){
        this.logService = logService;
        this.pessoaService = pessoaService;
    }
    @PostMapping("/registrar_log")
    public ResponseEntity<String> registrarLog(@RequestBody Map<String, Object> data) {
        String cpf = (String) data.get("cpf");
        Long idPessoa = pessoaService.getIdPessoaByCpf(cpf);

        if (idPessoa != null) {
            logService.registrarLog(idPessoa);
            return ResponseEntity.ok("Log registrado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada.");
        }
    }

    @GetMapping("/exibirLog")
    public ResponseEntity <List<Log>> getAllLogs(){
        return ResponseEntity.status(HttpStatus.OK).body(logService.exibirLog());
    }

    @GetMapping("/exibirLogPaginado")
    public ResponseEntity<Page<Log>> getAllLogsByPage(Pageable pageable) {
        Page<Log> logs = logService.getLogsByPage(pageable);
        return ResponseEntity.ok(logs);
    }
    
}
