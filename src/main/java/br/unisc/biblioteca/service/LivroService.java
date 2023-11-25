package br.unisc.biblioteca.service;

import br.unisc.biblioteca.dto.LivroDto;
import br.unisc.biblioteca.persistence.LivroPersistencia;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroPersistencia persistencia;

    public Page<LivroDto> buscarTodos(Pageable pageable) {
        return persistencia.buscarTodos(pageable);
    }

    public void criar(LivroDto livroDto) {
        persistencia.criar(livroDto);
    }

    public void update(Long id, LivroDto livroDto) {
        persistencia.update(id, livroDto);
    }

    public void delete(Long id) {
        persistencia.delete(id);
    }

    public Object buscarPorId(Long id) {return persistencia.buscarPorId(id);}
}