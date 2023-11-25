package br.unisc.biblioteca.persistence;

import br.unisc.biblioteca.dto.LivroDto;
import br.unisc.biblioteca.exception.LivroDuplicadoException;
import br.unisc.biblioteca.exception.LivroNotFoundException;
import br.unisc.biblioteca.infra.banco.LivroEntidade;
import br.unisc.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class LivroPersistenciaAdaptador implements LivroPersistencia {

    private final LivroRepository repository;

    @Override
    public void criar(LivroDto livroDto) {
        Optional<LivroEntidade> liverExistence = repository.findByCodigoisbn(livroDto.getCodigoisbn());
        if (liverExistence.isPresent()) {
            throw new LivroDuplicadoException("Livro já cadastrado.");
        }
        var livroEntidade = LivroEntidade.criarEntidade(livroDto);
        repository.save(livroEntidade);
    }

    @Override
    public Page<LivroDto> buscarTodos(Pageable pageable) {
        return repository.findAll(pageable)
                .map(LivroEntidade::converterEntidadeParaDto);
    }

    @Override
    public void update(Long id, LivroDto livroDto) {
        var entidadeOptional = repository.findById(id);
        if (entidadeOptional.isEmpty()) {
            throw new LivroNotFoundException("Este livro não existe!");
        }
        var entidade = entidadeOptional.get();
        entidade.setTitulo(StringUtils.isBlank(livroDto.getTitulo()) ? entidade.getTitulo() : livroDto.getTitulo());
        entidade.setCategoria(StringUtils.isBlank(livroDto.getCategoria()) ? entidade.getCategoria() : livroDto.getCategoria());
        entidade.setAutor(StringUtils.isBlank(livroDto.getAutor()) ? entidade.getAutor() : livroDto.getAutor());
        entidade.setAnopublicacao(livroDto.getAnopublicacao());
        entidade.setCodigoisbn(livroDto.getCodigoisbn());

        repository.save(entidade);
    }

    @Override
    public void delete(Long id) {
        var entidadeOptional = repository.findById(id);
        if (entidadeOptional.isEmpty()) {
            throw new LivroNotFoundException("Este livro não existe!");
        }
        repository.deleteById(id);
    }

    @Override
    public Object buscarPorId(Long id) {
        Optional<LivroEntidade> livroOptional = repository.findById(id);

        if (livroOptional.isPresent()) {
            LivroEntidade livro = livroOptional.get();
            return LivroEntidade.converterEntidadeParaDto(livro);
        } else {
            throw new LivroNotFoundException("Livro não encontrado para o ID: " + id);
        }
    }
}