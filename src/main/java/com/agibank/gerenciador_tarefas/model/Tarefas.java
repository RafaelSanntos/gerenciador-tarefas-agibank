package com.agibank.gerenciador_tarefas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.Message;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tarefas")
@NoArgsConstructor
@AllArgsConstructor
public class Tarefas {

    @Id
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "titulo", nullable = false)
    @NotBlank(message = "Titulo é obrigatório")
    private String Titulo;

    @Column(name = "descricao", nullable = false)
    @NotBlank(message = "Descricao é obrigatorio")
    private String Descricao;

    @Column(name = "matricula", nullable = false)
    @NotBlank(message = "Matricula é obrigatorio")
    private String Matricula;

    @Column(name = "Inicio")
    @NotNull
    private LocalDateTime Inicio;

    @Column(name = "Conclusao")
    @NotNull
    private LocalDateTime Conclusao;
}
