package com.project.facereconhecimento.service;

import com.project.facereconhecimento.model.Log;
import com.project.facereconhecimento.model.Pessoa;
import com.project.facereconhecimento.repository.LogRepository;
import com.project.facereconhecimento.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class LogService {
    private LogRepository logRepository;
    private PessoaRepository pessoaRepository;
    public LogService(LogRepository logRepository, PessoaRepository pessoaRepository){
        this.logRepository = logRepository;
        this.pessoaRepository = pessoaRepository;
    }
    public void registrarLog(Long id_pessoa){
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id_pessoa);

        if(optionalPessoa.isPresent()){
            Log log = new Log();
            log.setPessoa(optionalPessoa.get());
            log.setData_log(LocalDateTime.now());
            logRepository.save(log);
        }
    }
    public List<Log> exibirLog(){
        return logRepository.findAll();
    }
    public Page<Log> getLogsByPage(Pageable pageable) {
        return logRepository.findAll(pageable);
    }
}
