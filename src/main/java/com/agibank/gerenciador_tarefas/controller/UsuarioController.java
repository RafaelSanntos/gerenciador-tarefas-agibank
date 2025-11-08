package com.agibank.gerenciador_tarefas.controller;

import com.agibank.gerenciador_tarefas.dto.request.LoginRequest;
import com.agibank.gerenciador_tarefas.dto.request.UsuarioRequestDTO;
import com.agibank.gerenciador_tarefas.dto.response.UsuarioResponse;
import com.agibank.gerenciador_tarefas.model.Usuario;
import com.agibank.gerenciador_tarefas.model.enums.Cargo;
import com.agibank.gerenciador_tarefas.model.enums.Setor;
import com.agibank.gerenciador_tarefas.model.enums.Situacao;
import com.agibank.gerenciador_tarefas.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        try {
            String token = usuarioService.login(request.email(), request.senha());
            return ResponseEntity.ok(Map.of("token", token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("erro", "Credenciais inválidas"));
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO){
        UsuarioResponse response = usuarioService.criarColaborador(usuarioRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/listarsetor")
    public ResponseEntity<List<UsuarioResponse>> listaUsuariosSetor(@RequestParam Setor setor) {
        return ResponseEntity.ok(usuarioService.listarTodosSetor(setor));
    }

    @GetMapping("/listarcargo")
    public ResponseEntity<List<UsuarioResponse>> listaUsuariosCargo(@RequestParam Cargo cargo){
        return ResponseEntity.ok(usuarioService.listarTodosCargo(cargo));
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<UsuarioResponse> findByMatricula(@PathVariable Long matricula){
        return ResponseEntity.ok(usuarioService.buscarPorMatricula(matricula));
    }

    @PutMapping("/{matricula}/cargo")
    public ResponseEntity<UsuarioResponse> atualizarCargo(
            @PathVariable Long matricula,
            @RequestParam Cargo novoCargo){
        return ResponseEntity.ok(usuarioService.atualizarCargoColaborador(matricula, novoCargo));
    }

    @PutMapping("/{matricula}/setor")
    public ResponseEntity<UsuarioResponse> atualizarSetor(
            @PathVariable Long matricula,
            @RequestParam Setor novoSetor){
        return ResponseEntity.ok(usuarioService.atualizarSetorColaborador(matricula, novoSetor));
    }

    @PutMapping("/{matricula}/situacao")
    public ResponseEntity<UsuarioResponse> atualizarSituacao(
            @PathVariable Long matricula,
            @RequestParam Situacao novaSituacao){
        return ResponseEntity.ok(usuarioService.atualizarSituacaoColaborador(matricula, novaSituacao));
    }

}
