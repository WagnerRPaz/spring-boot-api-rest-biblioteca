package br.unisc.biblioteca.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BibliotecaLivroDTO {
    Long id;
    Long bibliotecaId;
    Long codigoisbn;
}