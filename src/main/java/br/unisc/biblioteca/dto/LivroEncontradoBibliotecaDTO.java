package br.unisc.biblioteca.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LivroEncontradoBibliotecaDTO {
    String nomeBiblioteca;
    String tituloLivro;
    Long codigoisbn;
}
