package br.unisc.biblioteca.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class LivroDuplicadoException extends DataIntegrityViolationException {
    public LivroDuplicadoException(String msg) {
        super(msg);
    }
}
