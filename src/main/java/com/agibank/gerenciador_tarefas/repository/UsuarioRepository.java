package com.agibank.gerenciador_tarefas.repository;

import com.agibank.gerenciador_tarefas.model.Usuario;
import com.agibank.gerenciador_tarefas.model.enums.Cargo;
import com.agibank.gerenciador_tarefas.model.enums.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByMatricula(Long matricula);
    Optional<Usuario> findByEmail(String email);
    List<Usuario> findAllBySetor(Setor setor);
    List<Usuario> findAllByCargo(Cargo cargo);
}
