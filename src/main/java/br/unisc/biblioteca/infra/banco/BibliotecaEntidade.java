package br.unisc.biblioteca.infra.banco;

import br.unisc.biblioteca.dto.BibliotecaDTO;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "bibliotecas")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BibliotecaEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String nome;

    public static BibliotecaDTO converterEntidadeParaDto(BibliotecaEntidade entidade) {
        return new BibliotecaDTO(entidade.getId(), entidade.getNome());
    }

    public static BibliotecaEntidade criarEntidade(BibliotecaDTO dto) {
        return BibliotecaEntidade.builder()
                .nome(dto.getNome())
                .build();
    }
}