package com.project.facereconhecimento.repository;

import com.project.facereconhecimento.model.Pessoa;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
Page<Pessoa> findByNome(Integer pageNumber, Pageable pageable);

    @Query("SELECT p.id_pessoa FROM Pessoa p WHERE p.cpf = :cpf")
    Long getIdPessoaByCpf(@Param("cpf") String cpf);
long count();

}
