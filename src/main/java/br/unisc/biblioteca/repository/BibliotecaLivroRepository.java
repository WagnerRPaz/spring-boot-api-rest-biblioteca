package br.unisc.biblioteca.repository;

import br.unisc.biblioteca.infra.banco.BibliotecaLivroEntidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BibliotecaLivroRepository extends JpaRepository<BibliotecaLivroEntidade, Long> {
    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM BibliotecaLivroEntidade b WHERE b.livro.id = :livroId AND b.biblioteca.id = :bibliotecaId")
    boolean existsByBibliotecaIdAndLivroId(@Param("bibliotecaId") Long bibliotecaId, @Param("livroId") Long livroId);


    void deleteByBibliotecaIdAndLivroId(Long bibliotecaId, Long livroId);

    List<BibliotecaLivroEntidade> findAllByLivroTituloContaining(String titulo);

    Page<BibliotecaLivroEntidade> findByBibliotecaId(Long bibliotecaId, Pageable pageable);
}