package com.ceiba.biblioteca;

import com.ceiba.biblioteca.dominio.modelo.RegistroPrestamo;

import java.time.LocalDate;

public class RegistroPrestamoTestDataBuilder {
    private int id;
    private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;
    private LocalDate fechaMaximaDevolucion;

    public RegistroPrestamoTestDataBuilder() {
        this.isbn = "123";
        this.identificacionUsuario = "abc123";
        this.tipoUsuario = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public LocalDate getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(LocalDate fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

    public RegistroPrestamo build(){
        return new RegistroPrestamo(id,isbn,identificacionUsuario,tipoUsuario,fechaMaximaDevolucion);
    }
}
