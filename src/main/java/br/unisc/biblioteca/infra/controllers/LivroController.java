package br.unisc.biblioteca.infra.controllers;

import br.unisc.biblioteca.dto.LivroDto;
import br.unisc.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livrosService;

    @GetMapping
    public ResponseEntity<Page<LivroDto>> buscarTodos(Pageable pageable) {
        return ResponseEntity.ok(livrosService.buscarTodos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> buscarPorId(@PathVariable Long id) {
        var livro = livrosService.buscarPorId(id);
        return ResponseEntity.ok((LivroDto) livro);
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody LivroDto livroDto) {
        livrosService.criar(livroDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody LivroDto livroDto, @PathVariable Long id) {
        livrosService.update(id, livroDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        livrosService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}