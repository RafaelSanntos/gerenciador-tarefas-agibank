package com.agibank.gerenciador_tarefas.controller;

import com.agibank.gerenciador_tarefas.dto.request.UsuarioRequestDTO;
import com.agibank.gerenciador_tarefas.dto.response.UsuarioResponse;
import com.agibank.gerenciador_tarefas.model.enums.Cargo;
import com.agibank.gerenciador_tarefas.model.enums.Setor;
import com.agibank.gerenciador_tarefas.model.enums.Situacao;
import com.agibank.gerenciador_tarefas.repository.UsuarioRepository;
import com.agibank.gerenciador_tarefas.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;


    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO){
        UsuarioResponse response = usuarioService.criarColaborador(usuarioRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/listarsetor")
    public ResponseEntity<List<UsuarioResponse>> listaUsuariosSetor(Setor setor) {
        return ResponseEntity.ok(usuarioService.listarTodosSetor(setor));
    }

    @GetMapping("/listarcargo")
    public ResponseEntity<List<UsuarioResponse>> listaUsariosCargo(Cargo cargo){
        return ResponseEntity.ok(usuarioService.listarTodosCargo(cargo));
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<UsuarioResponse> findByMatricula(@PathVariable Long matricula){
        return ResponseEntity.ok(usuarioService.buscarPorMatricula(matricula));
    }

    @PutMapping("/atualizarcargo")
    public ResponseEntity<UsuarioResponse> atualizarCargo(@Valid Long matricula, Cargo novoCargo, @RequestBody UsuarioRequestDTO request){
        return ResponseEntity.ok(usuarioService.atualizarCargoColaborador(matricula, novoCargo));
    }

    @PutMapping("/atualizarsetor")
    public ResponseEntity<UsuarioResponse> atualizarSetor(@Valid Long matricula, Setor novoSetor, @RequestBody UsuarioRequestDTO request){
        return ResponseEntity.ok(usuarioService.atualizarSetorColaborador(matricula, novoSetor));
    }

    @PutMapping("/atualizarstatus")
    public ResponseEntity<UsuarioResponse> atualizarSituacao(@Valid Long matricula, Situacao novaSituacao, @RequestBody UsuarioRequestDTO request){
        return ResponseEntity.ok(usuarioService.atualizarSituacaoColaborador(matricula, novaSituacao));
    }

}
