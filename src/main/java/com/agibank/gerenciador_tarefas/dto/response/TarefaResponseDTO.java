package com.agibank.gerenciador_tarefas.dto.response;

import com.agibank.gerenciador_tarefas.model.enums.SituacaoTarefa;

import java.time.LocalDateTime;

public record TarefaResponseDTO(
        Long id,
        String Titulo,
        String Descricao,
        Long Matricula,
        LocalDateTime Inicio,
        LocalDateTime Conclusao,
        SituacaoTarefa situacao
) {
}
