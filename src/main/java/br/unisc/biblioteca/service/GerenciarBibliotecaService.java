package br.unisc.biblioteca.service;

import br.unisc.biblioteca.dto.BibliotecaLivroDTO;
import br.unisc.biblioteca.persistence.BibliotecaPersistencia;
import br.unisc.biblioteca.dto.LivroEncontradoBibliotecaDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GerenciarBibliotecaService {
    private final BibliotecaPersistencia persistencia;

    public void adicionarLivroNaBiblioteca(BibliotecaLivroDTO dto) {
        persistencia.adicionarLivroNaBiblioteca(dto);
    }

    public void deletarLivroDaBiblioteca(Long bibliotecaId, Long livroId) {
        persistencia.deletarLivroDaBiblioteca(bibliotecaId, livroId);
    }

    public List<LivroEncontradoBibliotecaDTO> buscarLivroPorTitulo(String titulo) {
        return persistencia.buscarLivroPorTitulo(titulo);
    }

    public Page<LivroEncontradoBibliotecaDTO> listarLivrosDaBiblioteca(Long bibliotecaId, Pageable pageable) {
        return persistencia.listarLivrosDaBiblioteca(bibliotecaId, pageable);
    }
}