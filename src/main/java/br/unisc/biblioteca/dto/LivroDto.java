package br.unisc.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LivroDto {
    Long id;
    String titulo;
    String categoria;
    Integer anopublicacao;
    String autor;
    Long codigoisbn;
}
