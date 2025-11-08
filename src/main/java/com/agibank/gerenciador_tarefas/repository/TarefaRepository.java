package com.agibank.gerenciador_tarefas.repository;

import com.agibank.gerenciador_tarefas.model.Tarefas;
import com.agibank.gerenciador_tarefas.model.enums.Situacao;
import com.agibank.gerenciador_tarefas.model.enums.SituacaoTarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TarefaRepository extends JpaRepository<Tarefas, Long> {

    List<Tarefas> findByMatricula(Long matricula);

    Optional<Tarefas> findById(Long id);

    List<Tarefas> findBySituacao(SituacaoTarefa situacaoTarefa);
}
