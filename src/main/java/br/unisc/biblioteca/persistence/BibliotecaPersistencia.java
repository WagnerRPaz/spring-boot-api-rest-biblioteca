package br.unisc.biblioteca.persistence;

import br.unisc.biblioteca.dto.BibliotecaDTO;
import br.unisc.biblioteca.dto.BibliotecaLivroDTO;
import br.unisc.biblioteca.dto.LivroEncontradoBibliotecaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BibliotecaPersistencia {

    void criar(BibliotecaDTO bibliotecaDTO);

    Page<BibliotecaDTO> buscarBiblioteca(Pageable pageable);

    void deleteBiblioteca(Long id);

    void updateBiblioteca(Long id, BibliotecaDTO bibliotecaDTO);

    void adicionarLivroNaBiblioteca(BibliotecaLivroDTO dto);

    void deletarLivroDaBiblioteca(Long id);

    List<LivroEncontradoBibliotecaDTO> buscarLivroPorTitulo(String titulo);

    Page<LivroEncontradoBibliotecaDTO> listarLivrosDaBiblioteca(Long bibliotecaId, Pageable pageable);

    Object buscarPorId(Long id);
}