package com.ceiba.biblioteca.dominio.excepcion;

public class ExcepcionIdNoExiste extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ExcepcionIdNoExiste(String message) {
        super(message);
    }
}
