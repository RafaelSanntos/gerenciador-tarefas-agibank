package com.agibank.gerenciador_tarefas.service;

import com.agibank.gerenciador_tarefas.Config.SpringSecurity.TokenService;
import com.agibank.gerenciador_tarefas.dto.request.LoginRequest;
import com.agibank.gerenciador_tarefas.dto.request.UsuarioRequestDTO;
import com.agibank.gerenciador_tarefas.dto.response.UsuarioResponse;
import com.agibank.gerenciador_tarefas.model.Usuario;
import com.agibank.gerenciador_tarefas.model.enums.Cargo;
import com.agibank.gerenciador_tarefas.model.enums.Setor;
import com.agibank.gerenciador_tarefas.model.enums.Situacao;
import com.agibank.gerenciador_tarefas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Transactional
    public String login(String email, String senha) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(email, senha);
        var auth = authenticationManager.authenticate(usernamePassword);

        Usuario usuario = (Usuario) auth.getPrincipal();
        return tokenService.generateToken(usuario);
    }

    @Transactional
    public UsuarioResponse criarColaborador(UsuarioRequestDTO request) {
        long matriculaRandom = ThreadLocalRandom.current().nextLong(100L, 10000L);

        Usuario novoColaborador = new Usuario();
        novoColaborador.setNome(request.nome());
        novoColaborador.setMatricula(matriculaRandom);
        novoColaborador.setEmail(request.email());
        String senhaCriptografada = passwordEncoder.encode(request.senha());
        novoColaborador.setSenha(senhaCriptografada);
        novoColaborador.setDataAdmissao(LocalDateTime.now());
        novoColaborador.setCargo(request.cargo());
        novoColaborador.setSetor(request.setor());
        novoColaborador.setSituacao(Situacao.ATIVO);

        Usuario usuarioSalvo = usuarioRepository.save(novoColaborador);
        return mapUsuarioToResponse(usuarioSalvo);
    }

    @Transactional
    public UsuarioResponse atualizarCargoColaborador(Long matricula, Cargo novoCargo) {
        Usuario usuario = usuarioRepository.findByMatricula(matricula)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com a matricula: " + matricula));

        usuario.setCargo(novoCargo);
        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return mapUsuarioToResponse(usuarioAtualizado);
    }

    @Transactional
    public UsuarioResponse atualizarSetorColaborador(Long matricula, Setor novoSetor) {
        Usuario usuario = usuarioRepository.findByMatricula(matricula)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com a matricula: " + matricula));

        usuario.setSetor(novoSetor);
        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return mapUsuarioToResponse(usuarioAtualizado);
    }

    @Transactional
    public UsuarioResponse atualizarSituacaoColaborador(Long matricula, Situacao novaSituacao) {
        Usuario usuario = usuarioRepository.findByMatricula(matricula)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com a matricula " + matricula));
        usuario.setSituacao(novaSituacao);
        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return mapUsuarioToResponse(usuarioAtualizado);
    }

    @Transactional(readOnly = true)
    public UsuarioResponse buscarPorMatricula(Long matricula) {
        Usuario usuario = usuarioRepository.findByMatricula(matricula)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com a matrícula: " + matricula));
        return mapUsuarioToResponse(usuario);
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponse> listarTodosSetor(Setor setor){
        List<Usuario> usuarios = usuarioRepository.findAllBySetor(setor);
        return usuarios.stream()
                .map(this::mapUsuarioToResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponse> listarTodosCargo(Cargo cargo){
        List<Usuario> usuarios = usuarioRepository.findAllByCargo(cargo);
        return usuarios.stream()
                .map(this::mapUsuarioToResponse)
                .toList();
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
