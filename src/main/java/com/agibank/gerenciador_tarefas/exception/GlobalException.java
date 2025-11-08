package com.agibank.gerenciador_tarefas.exception;

import com.agibank.gerenciador_tarefas.exception.Tarefas.TarefasException;
import com.agibank.gerenciador_tarefas.exception.Usuarios.UsuarioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(TarefasException.class)
    public ResponseEntity<String> handlerTarefasException(TarefasException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(UsuarioException.class)
    public ResponseEntity<String> handlerUsuarioException(UsuarioException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
