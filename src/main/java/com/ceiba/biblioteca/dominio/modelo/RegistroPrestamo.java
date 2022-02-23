package com.ceiba.biblioteca.dominio.modelo;

import java.time.LocalDate;
import java.util.Date;

public class RegistroPrestamo {
    public static final String IDENTIFICADOR_DE_LIBRO_OBLIGATORIO = "El identificador de libro es obligatorio";
    public static final String IDENTIFICADOR_DE_USUARIO_OBLIGATORIO = "La identificacion de usuario es obligatorio";
    public static final String TIPO_DE_USUARIO_OBLIGATORIO = "El tipo de usuario es obligatorio";

    public static final int TAMANO_MAXIMO_IDENTIFICACION_USUARIO = 10;
    public static final int TAMANO_MAXIMO_IDENTIFICADOR_LIBRO = 10;
    public static final int TAMANO_MAXIMO_TIPO_USUARIO= 1;

    public static final String TAMANO_MAXIMO_IDENTIFICACION_USUARIO_SUPERADO = "ERROR El tamaño maximo de la identificacion de usuario es: "+TAMANO_MAXIMO_IDENTIFICACION_USUARIO;
    public static final String TAMANO_MAXIMO_IDENTIFICADOR_LIBRO_SUPERADO = "ERROR El tamaño maximo del  identificador de libro es: "+TAMANO_MAXIMO_IDENTIFICADOR_LIBRO;
    public static final String TAMANO_MAXIMO_TIPO_USUARIO_SUPERADO = "ERROR El tamaño maximo del  tipo de usuario es: "+TAMANO_MAXIMO_TIPO_USUARIO;


    private int id;
    private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;
    private LocalDate fechaMaximaDevolucion;

    public RegistroPrestamo(int id, String isbn, String identificacionUsuario, int tipoUsuario, LocalDate fechaMaximaDevolucion) {
        ValidarArgumento.validarObligatorio(isbn,IDENTIFICADOR_DE_LIBRO_OBLIGATORIO);
        ValidarArgumento.validarLongitudMaxima(isbn,TAMANO_MAXIMO_IDENTIFICACION_USUARIO,TAMANO_MAXIMO_IDENTIFICACION_USUARIO_SUPERADO);
        ValidarArgumento.validarObligatorio(identificacionUsuario,IDENTIFICADOR_DE_USUARIO_OBLIGATORIO);
        ValidarArgumento.validarLongitudMaxima(identificacionUsuario,TAMANO_MAXIMO_IDENTIFICADOR_LIBRO,TAMANO_MAXIMO_IDENTIFICADOR_LIBRO_SUPERADO);
        ValidarArgumento.validarObligatorio(tipoUsuario,TIPO_DE_USUARIO_OBLIGATORIO);
        ValidarArgumento.validarLongitudMaxima(tipoUsuario+"",TAMANO_MAXIMO_TIPO_USUARIO,TAMANO_MAXIMO_TIPO_USUARIO_SUPERADO);


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
