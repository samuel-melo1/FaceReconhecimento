package com.project.facereconhecimento.repository;

import com.project.facereconhecimento.model.Pessoa;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
Page<Pessoa> findByNome(Integer pageNumber, Pageable pageable , String sort);

}
