package com.project.facereconhecimento.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.facereconhecimento.dto.PessoaDTO;
import jakarta.validation.Valid;
import com.project.facereconhecimento.model.Pessoa;
import com.project.facereconhecimento.service.PessoaService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaControler {

    private PessoaService service;

    public PessoaControler(PessoaService service){
        this.service = service;
    }

    @PostMapping("/create")
    public Pessoa create(@RequestBody @Valid PessoaDTO pessoaDTO){
        var pessoas = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoas); //converte o dto para um model
        return service.createPessoas(pessoas);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Pessoa>> getPessoas(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllPessoas());
        
    }
    @GetMapping("/busca/{id}")
    public ResponseEntity<Object> getIdPessoas(@PathVariable(value = "id") Long id){
        Optional<Pessoa> optionalPessoa = service.getPessoaById(id);
        if(!optionalPessoa.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalPessoa.get());
    }


    @GetMapping("/listagem/{pageNumber}/{pageSize}")
    public List <Pessoa> getPessoa(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
        Page <Pessoa> data = service.findByNome(pageNumber, pageSize, null);
        return data.getContent();
  }
}
