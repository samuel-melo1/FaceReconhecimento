package com.project.facereconhecimento.model;

import com.project.facereconhecimento.enums.EnumPessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pessoas")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pessoa;

    private String nome;
    private String cpf;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_nascimento;

    private EnumPessoa tipo;
    private boolean ativo;

    //@OneToMany
    //private List<Pessoa> pessoa; //dúvida 
    @OneToMany
    private List<Log> log;
}
