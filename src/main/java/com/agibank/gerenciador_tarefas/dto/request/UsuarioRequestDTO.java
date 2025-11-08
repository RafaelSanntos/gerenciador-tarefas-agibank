package com.agibank.gerenciador_tarefas.dto.request;

import com.agibank.gerenciador_tarefas.model.enums.Cargo;
import com.agibank.gerenciador_tarefas.model.enums.Setor;

public record UsuarioRequestDTO(
        String nome,
        String email,
        String senha,
        Cargo cargo,
        Setor setor) {
}
