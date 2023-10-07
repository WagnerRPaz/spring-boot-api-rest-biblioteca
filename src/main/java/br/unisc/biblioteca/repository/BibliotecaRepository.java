package br.unisc.biblioteca.repository;

import br.unisc.biblioteca.infra.banco.BibliotecaEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends JpaRepository<BibliotecaEntidade, Long> {
    BibliotecaEntidade findByNome(String nome);
}