package br.unisc.biblioteca.repository;

import br.unisc.biblioteca.infra.banco.LivroEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntidade, Long> {

    Optional<LivroEntidade> findByCodigoisbn(Long codigoisbn);
}