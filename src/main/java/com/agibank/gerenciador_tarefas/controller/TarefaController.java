package com.agibank.gerenciador_tarefas.controller;

import com.agibank.gerenciador_tarefas.dto.request.TarefaRequestDTO;
import com.agibank.gerenciador_tarefas.dto.response.TarefaResponseDTO;
import com.agibank.gerenciador_tarefas.exception.Tarefas.TarefasException;
import com.agibank.gerenciador_tarefas.model.enums.SituacaoTarefa;
import com.agibank.gerenciador_tarefas.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<TarefaResponseDTO> criarTarefa(@RequestBody TarefaRequestDTO tarefaRequestDTO) throws TarefasException {
        TarefaResponseDTO tarefaCriada = tarefaService.criarTarefa(tarefaRequestDTO);
        return ResponseEntity.ok(tarefaCriada);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<TarefaResponseDTO> atualizarTarefa(@PathVariable Long id,@RequestBody TarefaRequestDTO tarefaRequestDTO) throws TarefasException {
        TarefaResponseDTO tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefaRequestDTO);
        return ResponseEntity.ok(tarefaAtualizada);
    }

    @PutMapping("/atualizarSituacao/{id}")
    public ResponseEntity<Void> atualizarSituacaoTarefa(@PathVariable Long id,@RequestParam SituacaoTarefa novaSituacao) throws TarefasException {
        tarefaService.atualizarSituacaoTarefa(id, novaSituacao);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscarPorMatricula")
    public ResponseEntity<List<TarefaResponseDTO>> buscarTarefaPorMatricula(@RequestParam Long matricula) throws TarefasException {
        List<TarefaResponseDTO> tarefas = tarefaService.buscarTarefaPorMatricula(matricula);
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/buscarPorSituacao")
    public ResponseEntity<List<TarefaResponseDTO>> buscarTarefaPorSituacao(@RequestParam SituacaoTarefa situacao) throws TarefasException {
        List<TarefaResponseDTO> tarefas = tarefaService.buscarTarefaPorSituacao(situacao);
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/listarTodas")
    public ResponseEntity<List<TarefaResponseDTO>> listarTodasTarefas() {
        List<TarefaResponseDTO> tarefas = tarefaService.listarTodasTarefas();
        return ResponseEntity.ok(tarefas);
    }


}
