package com.ceiba.biblioteca.aplicacion.manejador;

import com.ceiba.biblioteca.aplicacion.comando.prestamo.ComandoRegistroPrestamo;
import com.ceiba.biblioteca.aplicacion.fabrica.FabricaCrearPrestamo;
import com.ceiba.biblioteca.dominio.modelo.RegistroPrestamo;
import com.ceiba.biblioteca.dominio.modelo.dto.DtoRespuestaCreacionPrestamo;
import com.ceiba.biblioteca.dominio.servicio.ServicioCrearPrestamo;

public class ManejadorCrearPrestamo {
    private ServicioCrearPrestamo servicioCrearPrestamo;
    private FabricaCrearPrestamo fabricaCrearPrestamo;

    public ManejadorCrearPrestamo(ServicioCrearPrestamo servicioCrearPrestamo, FabricaCrearPrestamo fabricaCrearPrestamo) {
        this.servicioCrearPrestamo = servicioCrearPrestamo;
        this.fabricaCrearPrestamo = fabricaCrearPrestamo;
    }

    public DtoRespuestaCreacionPrestamo ejecutar(ComandoRegistroPrestamo comandoRegistroPrestamo){
        RegistroPrestamo registroPrestamo = fabricaCrearPrestamo.crear(comandoRegistroPrestamo);
         return  servicioCrearPrestamo.ejecutar(registroPrestamo);
    }
}
