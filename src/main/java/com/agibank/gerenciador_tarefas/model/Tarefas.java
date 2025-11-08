package com.agibank.gerenciador_tarefas.model;

import com.agibank.gerenciador_tarefas.model.enums.Situacao;
import com.agibank.gerenciador_tarefas.model.enums.SituacaoTarefa;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "tarefas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tarefas {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    @NotBlank(message = "Titulo é obrigatório")
    private String titulo;

    @Column(name = "descricao", nullable = false)
    @NotBlank(message = "Descricao é obrigatorio")
    private String descricao;

    @Column(name = "matricula", nullable = false)
    @NotNull
    private Long matricula;

    @Column(name = "Inicio")
    @NotNull
    private LocalDateTime inicio;

    @Column(name = "Conclusao")
    @NotNull
    private LocalDateTime conclusao;

    @NotNull
    @Enumerated(EnumType.STRING)
    SituacaoTarefa situacao;
}
