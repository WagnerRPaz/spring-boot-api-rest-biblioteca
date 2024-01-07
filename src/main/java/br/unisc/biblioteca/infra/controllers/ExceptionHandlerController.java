package br.unisc.biblioteca.infra.controllers;

import br.unisc.biblioteca.dto.ExceptionHandlerDTO;
import br.unisc.biblioteca.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@CrossOrigin(origins = "*")
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(BibliotecaDuplicadaException.class)
    public ResponseEntity<?> bibliotecaDuplicada() {
        ExceptionHandlerDTO dto = new ExceptionHandlerDTO("Biblioteca já cadastrada.", 400);
        return ResponseEntity.badRequest().body(dto);
    }

    @ExceptionHandler(LivroDuplicadoException.class)
    public ResponseEntity<?> livroDuplicado() {
        ExceptionHandlerDTO dto = new ExceptionHandlerDTO("Livro já cadastrado.", 400);
        return ResponseEntity.badRequest().body(dto);
    }

    @ExceptionHandler(LivroNotFoundException.class)
    public ResponseEntity<?> livroNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(BibliotecaNotFoundException.class)
    public ResponseEntity<?> bibliotecaNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AssociationNotFoundException.class)
    public ResponseEntity<?> associationNotFound() {
        ExceptionHandlerDTO dto = new ExceptionHandlerDTO("A associação entre o livro e a biblioteca não existe.", 400);
        return ResponseEntity.badRequest().body(dto);
    }

    @ExceptionHandler(TituloNotFoundException.class)
    public ResponseEntity<?> tituloNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(BibliotecaVaziaException.class)
    public ResponseEntity<?> bibliotecaEmpy() {
        ExceptionHandlerDTO dto = new ExceptionHandlerDTO("Biblioteca vazia ou não encontrada.", 400);
        return ResponseEntity.badRequest().body(dto);
    }

}