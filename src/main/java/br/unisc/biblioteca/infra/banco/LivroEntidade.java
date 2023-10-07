package br.unisc.biblioteca.infra.banco;

import br.unisc.biblioteca.dto.LivroDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "livros")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String titulo;

    @Column(nullable = false)
    String categoria;

    @Column(nullable = false)
    Integer anopublicacao;

    @Column(nullable = false)
    String autor;

    @Column(nullable = false, unique = true)
    Long codigoisbn;

    public static LivroDto converterEntidadeParaDto(LivroEntidade entidade) {
        return new LivroDto(entidade.getId(), entidade.getTitulo(), entidade.getCategoria(), entidade.getAnopublicacao(), entidade.getAutor(), entidade.getCodigoisbn());
    }

    public static LivroEntidade criarEntidade(LivroDto dto) {
        return LivroEntidade.builder()
                .titulo(dto.getTitulo())
                .categoria(dto.getCategoria())
                .anopublicacao(dto.getAnopublicacao())
                .autor(dto.getAutor())
                .codigoisbn(dto.getCodigoisbn())
                .build();
    }
}