package com.ceiba.biblioteca.dominio.puerto;

import com.ceiba.biblioteca.dominio.modelo.RegistroPrestamo;
import com.ceiba.biblioteca.dominio.modelo.dto.DtoRegistroPrestamo;
import com.ceiba.biblioteca.dominio.modelo.dto.DtoRespuestaCreacionPrestamo;

public interface RepositorioRegistroPrestamo {
    /**
     * Permite crear los registros de un prestamo
     * @param prestamo
     */
     DtoRespuestaCreacionPrestamo crear(RegistroPrestamo prestamo);
    /**
     * Permite determinar si previamente se tiene un libro prestado
     * @param identificacionUsuario
     * @return si existe o no
     */
    boolean existePorIdentificacionUsuario(String identificacionUsuario);
    /**
     * Permite determinar si previamente se tiene un libro prestado
     * @param id
     * @return si existe o no
     */
    boolean existePorId(int id);


    /**
     * Permite crear los registros de un prestamo
     * @param id
     */
    DtoRegistroPrestamo mostrar(int id);
}
