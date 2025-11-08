package com.agibank.gerenciador_tarefas.dto.response;

import com.agibank.gerenciador_tarefas.model.enums.SituacaoTarefa;

import java.time.LocalDateTime;

public record TarefaResponseDTO(
        Long id,
        String titulo,
        String descricao,
        String matricula,
        LocalDateTime inicio,
        LocalDateTime conclusao,
        SituacaoTarefa situacao
) {
}
