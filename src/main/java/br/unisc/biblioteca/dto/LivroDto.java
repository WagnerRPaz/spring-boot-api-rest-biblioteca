package br.unisc.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDto {
    Long id;
    String titulo;
    Integer anopublicacao;
    String categoria;
    String autor;
    Long codigoisbn;
}