package br.unisc.biblioteca.repository;

import br.unisc.biblioteca.infra.banco.BibliotecaLivroEntidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BibliotecaLivroRepository extends JpaRepository<BibliotecaLivroEntidade, Long> {

    List<BibliotecaLivroEntidade> findAllByLivroTituloContaining(String titulo);

    Page<BibliotecaLivroEntidade> findByBibliotecaId(Long bibliotecaId, Pageable pageable);
}