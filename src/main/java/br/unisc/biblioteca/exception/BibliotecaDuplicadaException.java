package br.unisc.biblioteca.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class BibliotecaDuplicadaException extends DataIntegrityViolationException {
    public BibliotecaDuplicadaException(String msg) {
        super(msg);
    }

}