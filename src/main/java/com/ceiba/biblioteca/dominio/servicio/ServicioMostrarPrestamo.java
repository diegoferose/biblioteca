package com.ceiba.biblioteca.dominio.servicio;

import com.ceiba.biblioteca.dominio.excepcion.ExcepcionIdNoExiste;
import com.ceiba.biblioteca.dominio.modelo.dto.DtoRegistroPrestamo;
import com.ceiba.biblioteca.dominio.puerto.RepositorioRegistroPrestamo;

public class ServicioMostrarPrestamo {
    private final RepositorioRegistroPrestamo repositorioRegistroPrestamo;
    public static final String EL_ID_NO_EXISTE = "El id ingresado no existe en la base de datos";

    public ServicioMostrarPrestamo(RepositorioRegistroPrestamo repositorioRegistroPrestamo) {
        this.repositorioRegistroPrestamo = repositorioRegistroPrestamo;
    }
    public DtoRegistroPrestamo mostrar(int id){
        validarExistenciaId(id);
        return this.repositorioRegistroPrestamo.mostrar(id);
    }
    public void validarExistenciaId(int id){
        boolean existeId = this.repositorioRegistroPrestamo.existePorId(id);
        if (existeId){
            throw new ExcepcionIdNoExiste(EL_ID_NO_EXISTE);
        }
    }
}
