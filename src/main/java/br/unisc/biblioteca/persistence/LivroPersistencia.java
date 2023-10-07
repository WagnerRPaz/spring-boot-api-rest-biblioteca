package br.unisc.biblioteca.persistence;

import br.unisc.biblioteca.dto.LivroDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LivroPersistencia {

    void criar(LivroDto livroDto);

    Page<LivroDto> buscarTodos(Pageable pageable);

    void update(Long id, LivroDto livroDto);

    void delete(Long id);
}