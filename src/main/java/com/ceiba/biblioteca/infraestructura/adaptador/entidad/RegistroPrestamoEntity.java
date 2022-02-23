package com.ceiba.biblioteca.infraestructura.adaptador.entidad;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "prestamo")
public class RegistroPrestamoEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(name = "isbn")
    String isbn;

    @Column(name = "identificacionUsuario")
    String identificacionUsuario;

    @Column(name = "tipoUsuario")
    int tipoUsuario;

    @Column(name = "fechaMaximaDevolucion")
    LocalDate fechaMaximaDevolucion;

    public RegistroPrestamoEntity() {
    }

    public RegistroPrestamoEntity(int id, String isbn, String identificacionUsuario, int tipoUsuario, LocalDate fechaMaximaDevolucion) {
        this.id = id;
        this.isbn = isbn;
        this.identificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
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
}
