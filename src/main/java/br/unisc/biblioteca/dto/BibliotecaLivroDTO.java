package br.unisc.biblioteca.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BibliotecaLivroDTO {
    Long bibliotecaId;
    Long livroId;
}