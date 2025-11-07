package com.agibank.gerenciador_tarefas.repository;

import com.agibank.gerenciador_tarefas.model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefas, Long> {
}
