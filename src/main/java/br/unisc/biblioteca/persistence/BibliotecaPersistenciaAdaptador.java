package br.unisc.biblioteca.persistence;

import br.unisc.biblioteca.dto.BibliotecaDTO;
import br.unisc.biblioteca.dto.BibliotecaLivroDTO;
import br.unisc.biblioteca.exception.*;
import br.unisc.biblioteca.dto.LivroEncontradoBibliotecaDTO;
import br.unisc.biblioteca.infra.banco.BibliotecaEntidade;
import br.unisc.biblioteca.infra.banco.BibliotecaLivroEntidade;
import br.unisc.biblioteca.infra.banco.LivroEntidade;
import br.unisc.biblioteca.repository.BibliotecaLivroRepository;
import br.unisc.biblioteca.repository.BibliotecaRepository;
import br.unisc.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BibliotecaPersistenciaAdaptador implements BibliotecaPersistencia {

    private final BibliotecaRepository repository;
    private final LivroRepository livroRepository;
    private final BibliotecaLivroRepository gerenciaRepository;

    @Override
    public void criar(BibliotecaDTO bibliotecaDTO) {
        BibliotecaEntidade bibliotecaExiste = repository.findByNome(bibliotecaDTO.getNome());
        if (bibliotecaExiste != null) {
            throw new BibliotecaDuplicadaException("Biblioteca já cadastrada.");
        }
        var bibliotecaEntidade = BibliotecaEntidade.criarEntidade(bibliotecaDTO);
        repository.save(bibliotecaEntidade);
    }

    @Override
    public Page<BibliotecaDTO> buscarBiblioteca(Pageable pageable) {
        return repository.findAll(pageable)
                .map(BibliotecaEntidade::converterEntidadeParaDto);
    }

    @Override
    public void deleteBiblioteca(Long id) {
        var entidadeOptional = repository.findById(id);
        if (entidadeOptional.isEmpty()) {
            throw new BibliotecaNotFoundException("Biblioteca não encontrada.");
        }
        repository.deleteById(id);
    }

    @Override
    public void updateBiblioteca(Long id, BibliotecaDTO bibliotecaDTO) {
        var entidadeOptional = repository.findById(id);
        if (entidadeOptional.isEmpty()) {
            throw new BibliotecaNotFoundException("Biblioteca não encontrada.");
        }
        var entidade = entidadeOptional.get();
        entidade.setNome(StringUtils.isBlank(bibliotecaDTO.getNome()) ? entidade.getNome() : bibliotecaDTO.getNome());
        repository.save(entidade);
    }

    @Override
    public void adicionarLivroNaBiblioteca(BibliotecaLivroDTO dto) {
        Long bibliotecaId = dto.getBibliotecaId();
        Long livroId = dto.getLivroId();

        if (gerenciaRepository.existsByBibliotecaIdAndLivroId(bibliotecaId, livroId)) {
            throw new LivroExistsException("O livro já existe nesta biblioteca.");
        }
        BibliotecaEntidade biblioteca = repository.findById(dto.getBibliotecaId())
                .orElseThrow(() -> new BibliotecaNotFoundException("Biblioteca não encontrada."));

        LivroEntidade livro = livroRepository.findById(dto.getLivroId())
                .orElseThrow(() -> new LivroNotFoundException("Livro não encontrado."));

        BibliotecaLivroEntidade bibliotecaLivro = new BibliotecaLivroEntidade();
        bibliotecaLivro.setBiblioteca(biblioteca);
        bibliotecaLivro.setLivro(livro);
        gerenciaRepository.save(bibliotecaLivro);
    }

    @Override
    @Transactional
    public void deletarLivroDaBiblioteca(Long bibliotecaId, Long livroId) {
        if (!gerenciaRepository.existsByBibliotecaIdAndLivroId(bibliotecaId, livroId)) {
            throw new AssociationNotFoundException("A associação entre o livro e a biblioteca não existe.");
        }
        gerenciaRepository.deleteByBibliotecaIdAndLivroId(bibliotecaId, livroId);
    }

    @Override
    public List<LivroEncontradoBibliotecaDTO> buscarLivroPorTitulo(String titulo) {
        List<BibliotecaLivroEntidade> livrosEncontrados = gerenciaRepository.findAllByLivroTituloContaining(titulo);
        if (livrosEncontrados.isEmpty()) {
            throw new TituloNotFoundException("Nenhum livro com o título fornecido foi encontrado.");
        }
        return gerenciaRepository.findAllByLivroTituloContaining(titulo)
                .stream()
                .map(BibliotecaLivroEntidade::convertEntityToDTO)
                .toList();
    }

    @Override
    public Page<LivroEncontradoBibliotecaDTO> listarLivrosDaBiblioteca(Long bibliotecaId, Pageable pageable) {
        var entidadeOptional = gerenciaRepository.findByBibliotecaId(bibliotecaId, pageable);
        if (entidadeOptional.isEmpty()) {
            throw new BibliotecaVaziaException("Biblioteca vazia ou não encontrada.");
        }
        Page<BibliotecaLivroEntidade> bibliotecaLivros = gerenciaRepository.findByBibliotecaId(bibliotecaId, pageable);
        return bibliotecaLivros.map(BibliotecaLivroEntidade::convertEntityToDTO);
    }
}