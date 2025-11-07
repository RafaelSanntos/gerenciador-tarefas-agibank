package com.agibank.gerenciador_tarefas.repository;

import com.agibank.gerenciador_tarefas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
