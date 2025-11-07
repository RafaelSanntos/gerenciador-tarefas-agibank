package com.agibank.gerenciador_tarefas.dto.request;

import com.agibank.gerenciador_tarefas.model.enums.Situacao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public class TarefaRequestDTO {
    @NotBlank(message = "Titulo é obrigatório")
    private String titulo;

    @NotBlank(message = "Descricao é obrigatorio")
    private String descricao;

    @NotBlank(message = "Matricula é obrigatorio")
    private String matricula;

    @NotBlank(message = "Situacao é obrigatorio")
    @Enumerated(EnumType.STRING)
    private Situacao situacao;
}
