package com.agibank.gerenciador_tarefas.controller.controllerUI;

import com.agibank.gerenciador_tarefas.dto.response.TarefaResponseDTO;
import com.agibank.gerenciador_tarefas.exception.Tarefas.TarefasException;
import com.agibank.gerenciador_tarefas.model.enums.SituacaoTarefa;
import com.agibank.gerenciador_tarefas.service.TarefaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/ui/tarefas")
public class TarefaControllerUI {

    private final TarefaService tarefaService;

    public TarefaControllerUI(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping("/listarTodas")
    public String listarTodasTarefas(Model model) {
        List<TarefaResponseDTO> tarefas = tarefaService.listarTodasTarefas();
        model.addAttribute("tarefas", tarefas);
        return "lista-tarefas";
    }

    @GetMapping("/buscarPorSituacao")
    public String buscarPorSituacao(@RequestParam SituacaoTarefa situacao, Model model) throws TarefasException {
        List<TarefaResponseDTO> tarefas = tarefaService.buscarTarefaPorSituacao(situacao);
        model.addAttribute("tarefas", tarefas);
        model.addAttribute("filtro", "Situação: " + situacao);
        return "lista-tarefas";
    }

    @GetMapping("/buscarPorMatricula")
    public String buscarPorMatricula(@RequestParam String matricula, Model model) throws TarefasException {
        List<TarefaResponseDTO> tarefas = tarefaService.buscarTarefaPorMatricula(matricula);
        model.addAttribute("tarefas", tarefas);
        model.addAttribute("filtro", "Matrícula: " + matricula);
        return "lista-tarefas";
    }
}
