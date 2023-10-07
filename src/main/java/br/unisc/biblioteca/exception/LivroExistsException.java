package br.unisc.biblioteca.exception;

public class LivroExistsException extends RuntimeException{
    public LivroExistsException(String msg) {
        super(msg);
    }
}
