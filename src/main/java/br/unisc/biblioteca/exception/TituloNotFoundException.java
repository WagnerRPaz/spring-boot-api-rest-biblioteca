package br.unisc.biblioteca.exception;

public class TituloNotFoundException extends RuntimeException{
    public TituloNotFoundException(String msg) {
        super(msg);
    }
}
