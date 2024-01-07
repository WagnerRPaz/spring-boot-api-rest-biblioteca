package br.unisc.biblioteca.infra.banco;

import br.unisc.biblioteca.dto.LivroEncontradoBibliotecaDTO;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "livro_biblioteca")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BibliotecaLivroEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "biblioteca_FK", nullable = false)
    private BibliotecaEntidade biblioteca;

    @ManyToOne
    @JoinColumn(name = "livro_FK", nullable = false)
    private LivroEntidade livro;


    public static LivroEncontradoBibliotecaDTO convertEntityToDTO(BibliotecaLivroEntidade entidade) {
        var dto = new LivroEncontradoBibliotecaDTO();
        dto.setId(entidade.getId());
        dto.setNomeBiblioteca(entidade.getBiblioteca().getNome());
        dto.setTituloLivro(entidade.getLivro().getTitulo());
        dto.setCodigoisbn(entidade.getLivro().getCodigoisbn());
        return dto;
    }

}
