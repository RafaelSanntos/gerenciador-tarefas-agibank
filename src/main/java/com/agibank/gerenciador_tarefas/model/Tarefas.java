package com.agibank.gerenciador_tarefas.model;

import com.agibank.gerenciador_tarefas.model.enums.Situacao;
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

    @NotBlank(message = "Situacao é obrigatorio")
    @Enumerated(EnumType.STRING)
    Situacao situacao;
}
