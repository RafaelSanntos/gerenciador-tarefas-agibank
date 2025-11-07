package com.agibank.gerenciador_tarefas.dto.response;

import com.agibank.gerenciador_tarefas.model.enums.Situacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TarefaResponseDTO(
        @NotNull Long id,
        @NotBlank String Titulo,
        @NotBlank String Descricao,
        @NotBlank String Matricula,
        @NotNull LocalDateTime Inicio,
        @NotNull LocalDateTime Conclusao,
        Situacao situacao
) {
}
