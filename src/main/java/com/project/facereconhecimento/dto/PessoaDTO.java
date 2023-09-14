package com.project.facereconhecimento.dto;

import com.project.facereconhecimento.enums.EnumPessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    @NotBlank
    private String nome;
    @NotBlank
    @Size(max = 15)
    private String cpf;
    @NotNull
    private EnumPessoa tipo;
    @NotNull
    private boolean ativo;

}
