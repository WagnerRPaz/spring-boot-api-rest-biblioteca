package br.unisc.biblioteca.exception;

public class LivroNotFoundException extends RuntimeException{
    public LivroNotFoundException(String msg) {
        super(msg);
    }
}
