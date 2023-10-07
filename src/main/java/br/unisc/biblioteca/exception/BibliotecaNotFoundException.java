package br.unisc.biblioteca.exception;

public class BibliotecaNotFoundException extends RuntimeException{
    public BibliotecaNotFoundException(String msg){
        super (msg);
    }
}
