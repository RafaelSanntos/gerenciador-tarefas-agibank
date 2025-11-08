package com.agibank.gerenciador_tarefas.dto.request;

import com.agibank.gerenciador_tarefas.model.enums.SituacaoTarefa;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record TarefaRequestDTO(
        String titulo,
        String descricao,
        String matricula,
        LocalDateTime inicio,
        LocalDateTime conclusao,
        SituacaoTarefa situacao
) {


}
