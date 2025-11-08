package com.agibank.gerenciador_tarefas.service;

import com.agibank.gerenciador_tarefas.dto.request.UsuarioRequestDTO;
import com.agibank.gerenciador_tarefas.dto.response.UsuarioResponse;
import com.agibank.gerenciador_tarefas.model.Usuario;
import com.agibank.gerenciador_tarefas.model.enums.Cargo;
import com.agibank.gerenciador_tarefas.model.enums.Setor;
import com.agibank.gerenciador_tarefas.model.enums.Situacao;
import com.agibank.gerenciador_tarefas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioResponse criarColaborador(UsuarioRequestDTO request) {

        Usuario novoColaborador = new Usuario();
        novoColaborador.setNome(request.nome());
        novoColaborador.setEmail(request.email());
        novoColaborador.setSenha(request.senha());
        novoColaborador.setDataAdmissao(LocalDateTime.now());
        novoColaborador.setCargo(request.cargo());
        novoColaborador.setSetor(request.setor());
        novoColaborador.setSituacao(Situacao.ATIVO);

        Usuario usuarioSalvo = usuarioRepository.save(novoColaborador);
        return mapUsuarioToResponse(usuarioSalvo);

    }

    @Transactional
    public UsuarioResponse atualizarCargoColaborador(String matricula, Cargo novoCargo) {
        Usuario usuario = usuarioRepository.findByMatricula(matricula)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com a matricula: " + matricula));

        usuario.setCargo(novoCargo);
        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return mapUsuarioToResponse(usuarioAtualizado);
    }

    @Transactional
    public UsuarioResponse atualizarSetorColaborador(String matricula, Setor novoSetor) {
        Usuario usuario = usuarioRepository.findByMatricula(matricula)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com a matricula: " + matricula));

        usuario.setSetor(novoSetor);
        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return mapUsuarioToResponse(usuarioAtualizado);
    }

    @Transactional
    public UsuarioResponse atualizarSituacaoColaborador(String matricula, Situacao novaSituacao) {
        Usuario usuario = usuarioRepository.findByMatricula(matricula)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com a matricula " + matricula));
        usuario.setSituacao(novaSituacao);
        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return mapUsuarioToResponse(usuarioAtualizado);
    }

    @Transactional(readOnly = true)
    public UsuarioResponse buscarPorMatricula(String matricula) {
        Usuario usuario = usuarioRepository.findByMatricula(matricula)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com a matrícula: " + matricula));
        return mapUsuarioToResponse(usuario);
    }

    private UsuarioResponse mapUsuarioToResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getMatricula()
        );
    }

}
