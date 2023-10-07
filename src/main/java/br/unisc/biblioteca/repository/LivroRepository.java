package br.unisc.biblioteca.repository;

import br.unisc.biblioteca.infra.banco.LivroEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntidade, Long> {

    LivroEntidade findByCodigoisbn(Long codigoisbn);
}