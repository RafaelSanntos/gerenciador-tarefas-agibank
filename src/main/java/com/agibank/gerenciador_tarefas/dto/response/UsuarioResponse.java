package com.agibank.gerenciador_tarefas.dto.response;

import com.agibank.gerenciador_tarefas.model.Usuario;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

public record UsuarioResponse(UUID uuid,
                              String email,
                              String nome,
                              Long matricula) {

}
