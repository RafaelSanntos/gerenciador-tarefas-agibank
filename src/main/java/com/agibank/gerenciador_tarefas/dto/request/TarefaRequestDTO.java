package com.agibank.gerenciador_tarefas.dto.request;

import jakarta.validation.constraints.NotBlank;

public record TarefaRequestDTO(@NotBlank(message = "Titulo é obrigatório")
                               String titulo,
                               @NotBlank(message = "Descricao é obrigatorio")
                               String descricao,
                               @NotBlank(message = "Matricula é obrigatorio")
                               Long matricula)
                               {



}
