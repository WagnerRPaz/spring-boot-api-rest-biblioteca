package br.unisc.biblioteca.infra.controllers;

import br.unisc.biblioteca.dto.BibliotecaDTO;
import br.unisc.biblioteca.dto.BibliotecaLivroDTO;
import br.unisc.biblioteca.service.BibliotecaService;
import br.unisc.biblioteca.dto.LivroEncontradoBibliotecaDTO;
import br.unisc.biblioteca.service.GerenciarBibliotecaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bibliotecas")
@RequiredArgsConstructor
public class BibliotecaController {
    private final BibliotecaService bibliotecaService;
    private final GerenciarBibliotecaService gerenciarService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BibliotecaDTO bibliotecaDTO) {
        bibliotecaService.create(bibliotecaDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping
    public ResponseEntity<Page<BibliotecaDTO>> buscarBiblioteca(Pageable pageable) {
        return ResponseEntity
                .ok(bibliotecaService.buscarBiblioteca(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBiblioteca(@PathVariable Long id) {
        bibliotecaService.deleteBiblioteca(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBiblioteca(@RequestBody BibliotecaDTO bibliotecaDTO, @PathVariable Long id) {
        bibliotecaService.updateBiblioteca(id, bibliotecaDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PostMapping("/adicionarLivroNaBiblioteca")
    public ResponseEntity<?> adicionarLivroNaBiblioteca(@RequestBody BibliotecaLivroDTO dto) {
        gerenciarService.adicionarLivroNaBiblioteca(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/deletarLivroDaBiblioteca/{id}")
    public ResponseEntity<?> deletarLivroDaBiblioteca(@PathVariable Long id) {
        gerenciarService.deletarLivroDaBiblioteca(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("/buscarLivroPorTitulo")
    public ResponseEntity<List<LivroEncontradoBibliotecaDTO>> buscarLivroPorTitulo(@RequestParam("titulo") String titulo) {
        return ResponseEntity
                .ok(gerenciarService.buscarLivroPorTitulo(titulo));
    }

    @GetMapping("/listarLivrosDaBiblioteca/{bibliotecaId}")
    public ResponseEntity<Page<LivroEncontradoBibliotecaDTO>> listarLivrosDaBiblioteca(@PathVariable Long bibliotecaId, Pageable pageable) {
        return ResponseEntity
                .ok(gerenciarService.listarLivrosDaBiblioteca(bibliotecaId, pageable));
    }
}