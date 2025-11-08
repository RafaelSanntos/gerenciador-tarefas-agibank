package com.agibank.gerenciador_tarefas.model.enums;

import lombok.Getter;

@Getter
public enum Cargo {
    GESTOR("ROLE_GESTOR"),
    SUPERVISOR("ROLE_SUPERVISOR"),
    COLABORADOR("ROLE_COLABORADOR");

    private final String role;

    Cargo(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
