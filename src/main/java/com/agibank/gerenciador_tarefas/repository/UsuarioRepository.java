package com.agibank.gerenciador_tarefas.repository;

import com.agibank.gerenciador_tarefas.model.Usuario;
import com.agibank.gerenciador_tarefas.model.enums.Cargo;
import com.agibank.gerenciador_tarefas.model.enums.Setor;
import com.agibank.gerenciador_tarefas.model.enums.Situacao;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByMatricula(Long matricula);
    List<Usuario> findAllBySetor(Setor setor);
    List<Usuario> findAllByCargo(Cargo cargo);
    Optional<Usuario> findByEmailAndSenha(String email, String senha);
    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findFirstBySituacaoAndSetorAndMatriculaNot(Situacao situacao, Setor setor, @NotNull Long matricula);
}
