package com.igreja.visitas.exceptions;

public class MembroNotFoundException extends RuntimeException{

    public MembroNotFoundException(String mensagem) {
        super(mensagem);
    }
}
