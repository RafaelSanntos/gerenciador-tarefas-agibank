package com.agibank.gerenciador_tarefas.dto.request;

import com.agibank.gerenciador_tarefas.model.enums.Cargo;
import com.agibank.gerenciador_tarefas.model.enums.Setor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequestDTO(@NotBlank String nome,
                                @NotBlank String email,
                                @NotBlank String senha,
                                @NotNull Long matricula,
                                Cargo cargo,
                                Setor setor) {
}
