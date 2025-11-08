package com.agibank.gerenciador_tarefas.model;

import com.agibank.gerenciador_tarefas.model.enums.Cargo;
import com.agibank.gerenciador_tarefas.model.enums.Setor;
import com.agibank.gerenciador_tarefas.model.enums.Situacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Email é obrigatório")
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank(message = "Nome é obrigatório")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @Column(name = "matricula", nullable = false)
    private Long matricula;

    @NotBlank(message = "Senha é obrigatório")
    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "data_admissao", nullable = false)
    private LocalDateTime dataAdmissao;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @Enumerated(EnumType.STRING)
    private Setor setor;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

}
