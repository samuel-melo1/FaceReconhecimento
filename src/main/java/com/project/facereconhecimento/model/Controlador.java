package com.project.facereconhecimento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Controlador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_controlador;

    private String token;

    @OneToMany
    public List<Log> log;


}
