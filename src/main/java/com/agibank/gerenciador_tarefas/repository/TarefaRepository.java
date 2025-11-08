package com.agibank.gerenciador_tarefas.repository;

import com.agibank.gerenciador_tarefas.model.Tarefas;
import com.agibank.gerenciador_tarefas.model.enums.Situacao;
import com.agibank.gerenciador_tarefas.model.enums.SituacaoTarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefas, Long> {

   List<Tarefas> findByMatricula(Long matricula);

    List<Tarefas> findBySituacao(SituacaoTarefa situacaoTarefa);
}
