package com.ceiba.biblioteca.aplicacion.consulta;

import com.ceiba.biblioteca.dominio.modelo.dto.DtoRegistroPrestamo;
import com.ceiba.biblioteca.dominio.servicio.ServicioMostrarPrestamo;

public class ManejadorMostrarPrestamo {
    private final ServicioMostrarPrestamo servicioMostrarPrestamo;

    public ManejadorMostrarPrestamo(ServicioMostrarPrestamo servicioMostrarPrestamo) {
        this.servicioMostrarPrestamo = servicioMostrarPrestamo;
    }

    public DtoRegistroPrestamo ejecutar(int id){
        return this.servicioMostrarPrestamo.mostrar(id);
    }

}
