package br.unisc.biblioteca.exception;

public class BibliotecaVaziaException extends RuntimeException{
    public BibliotecaVaziaException(String msg){
        super (msg);
    }
}
