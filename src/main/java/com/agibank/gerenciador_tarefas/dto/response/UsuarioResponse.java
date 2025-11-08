package com.agibank.gerenciador_tarefas.dto.response;

import java.util.UUID;

public record UsuarioResponse(UUID uuid,
                              String email,
                              String nome,
                              Long matricula) {

}
