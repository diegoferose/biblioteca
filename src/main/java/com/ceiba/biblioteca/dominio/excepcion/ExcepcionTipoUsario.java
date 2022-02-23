package com.ceiba.biblioteca.dominio.excepcion;

public class ExcepcionTipoUsario extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ExcepcionTipoUsario(String message) {
        super(message);
    }
}
