package com.ceiba.biblioteca.infraestructura.adaptador.error;

public class Error {
    private String mensaje;

    public Error(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
