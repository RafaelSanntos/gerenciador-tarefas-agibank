package com.agibank.gerenciador_tarefas.service;

import com.agibank.gerenciador_tarefas.dto.request.TarefaRequestDTO;
import com.agibank.gerenciador_tarefas.dto.response.TarefaResponseDTO;
import com.agibank.gerenciador_tarefas.model.Tarefas;
import com.agibank.gerenciador_tarefas.model.enums.SituacaoTarefa;
import com.agibank.gerenciador_tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public TarefaResponseDTO criarTarefa(TarefaRequestDTO tarefa){
        Tarefas newTarefa = new Tarefas();
        newTarefa.setInicio(LocalDateTime.now());
        newTarefa.setTitulo(tarefa.titulo());
        newTarefa.setDescricao(tarefa.descricao());
        newTarefa.setMatricula(tarefa.matricula());
        newTarefa.setSituacao(tarefa.situacao());
        Tarefas tarefaSalva = tarefaRepository.save(newTarefa);
        TarefaResponseDTO tarefaResponseDTO = new TarefaResponseDTO(
                tarefaSalva.getId(),
                tarefaSalva.getTitulo(),
                tarefaSalva.getDescricao(),
                tarefaSalva.getMatricula(),
                tarefaSalva.getInicio(),
                tarefaSalva.getConclusao(),
                tarefaSalva.getSituacao()
        );
        return tarefaResponseDTO;
    }

    public List<TarefaResponseDTO> buscarTarefaPorSituacao(SituacaoTarefa situacao){
        List<Tarefas> tarefas = tarefaRepository.findBySituacao(situacao);
        List<TarefaResponseDTO> respostas = new java.util.ArrayList<>();
        for (Tarefas t : tarefas) {
            respostas.add(new TarefaResponseDTO(
                    t.getId(),
                    t.getTitulo(),
                    t.getDescricao(),
                    t.getMatricula(),
                    t.getInicio(),
                    t.getConclusao(),
                    t.getSituacao()
            ));
        }
        return respostas;
    }
public List<TarefaResponseDTO> buscarTarefaPorMatricula(String matricula){
        List<Tarefas> tarefas = tarefaRepository.findByMatricula(matricula);
        List<TarefaResponseDTO> respostas = new java.util.ArrayList<>();
        for (Tarefas t : tarefas) {
            respostas.add(new TarefaResponseDTO(
                    t.getId(),
                    t.getTitulo(),
                    t.getDescricao(),
                    t.getMatricula(),
                    t.getInicio(),
                    t.getConclusao(),
                    t.getSituacao()
            ));
        }
        return respostas;
    }

    public TarefaResponseDTO atualizarTarefa(Long id, TarefaRequestDTO tarefaAtualizada){
        Tarefas tarefaExistente = tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefaExistente.setTitulo(tarefaAtualizada.titulo());
        tarefaExistente.setDescricao(tarefaAtualizada.descricao());
        tarefaExistente.setMatricula(tarefaAtualizada.matricula());
        tarefaExistente.setSituacao(tarefaAtualizada.situacao());
        if(tarefaAtualizada.situacao().equals( SituacaoTarefa.CONCLUIDA)){
            tarefaExistente.setConclusao(LocalDateTime.now());
        }
        Tarefas tarefaSalva = tarefaRepository.save(tarefaExistente);
        TarefaResponseDTO tarefaResponseDTO = new TarefaResponseDTO(
                tarefaSalva.getId(),
                tarefaSalva.getTitulo(),
                tarefaSalva.getDescricao(),
                tarefaSalva.getMatricula(),
                tarefaSalva.getInicio(),
                tarefaSalva.getConclusao(),
                tarefaSalva.getSituacao()
        );
        return tarefaResponseDTO;
    }

    public void atualizarSituacaoTarefa(Long id, SituacaoTarefa novaSituacao){
        Tarefas tarefaExistente = tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefaExistente.setSituacao(novaSituacao);
        if(novaSituacao.equals(SituacaoTarefa.CONCLUIDA)){
            tarefaExistente.setConclusao(LocalDateTime.now());
        }
        tarefaRepository.save(tarefaExistente);
    }
}
