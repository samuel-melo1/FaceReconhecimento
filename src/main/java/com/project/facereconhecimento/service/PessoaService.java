package com.project.facereconhecimento.service;

import com.project.facereconhecimento.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.facereconhecimento.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private PessoaRepository repository;

    PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public Pessoa createPessoas(Pessoa pessoas) {
        return repository.save(pessoas);
    }

    public List<Pessoa> getAllPessoas() {
        return repository.findAll();
    }

    public Optional<Pessoa> getPessoaById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public boolean excluirUsuario(Long id_pessoa) {
        Optional<Pessoa> optionalPessoa = repository.findById(id_pessoa);
        if (optionalPessoa.isPresent()) {
            repository.deleteById(id_pessoa);
            return true;
        }
        return false;
    }

    public Page<Pessoa> findByNome(Integer pageNumber, Integer pageSize) {
        PageRequest pageable = null;
        pageable = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(pageable);
    }


}
