package com.project.facereconhecimento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_log;

    private LocalDateTime data_log;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @ManyToOne
    private Controlador controlador;

}
