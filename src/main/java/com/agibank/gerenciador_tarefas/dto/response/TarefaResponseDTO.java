package com.agibank.gerenciador_tarefas.dto.response;

import com.agibank.gerenciador_tarefas.model.enums.Situacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TarefaResponseDTO(
        Long id,
        String Titulo,
        String Descricao,
        String Matricula,
        LocalDateTime Inicio,
        LocalDateTime Conclusao,
        Situacao situacao
) {
}
