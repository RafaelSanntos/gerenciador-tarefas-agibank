package com.agibank.gerenciador_tarefas.dto.response;

import jakarta.validation.constraints.NotBlank;

public record UsuarioResponse(String email,
                              String nome,
                              Long matricula) {
}
