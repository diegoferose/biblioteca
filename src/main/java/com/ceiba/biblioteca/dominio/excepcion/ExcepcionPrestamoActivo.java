package com.ceiba.biblioteca.dominio.excepcion;

public class ExcepcionPrestamoActivo extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionPrestamoActivo(String message) {
        super(message);
    }
}
