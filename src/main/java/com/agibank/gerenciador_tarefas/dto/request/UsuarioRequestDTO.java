package com.agibank.gerenciador_tarefas.dto.request;

import com.agibank.gerenciador_tarefas.model.enums.Cargo;
import com.agibank.gerenciador_tarefas.model.enums.Setor;
import com.agibank.gerenciador_tarefas.model.enums.Situacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Setter;

import java.time.LocalDateTime;

public record UsuarioRequestDTO(
        String nome,
        Long matricula,
        String email,
        String senha,
        LocalDateTime dataAdmissao,
        Cargo cargo,
        Setor setor,
        Situacao situacao
) {
}
