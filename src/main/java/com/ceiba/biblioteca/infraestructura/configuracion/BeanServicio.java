package com.ceiba.biblioteca.infraestructura.configuracion;

import com.ceiba.biblioteca.aplicacion.consulta.ManejadorMostrarPrestamo;
import com.ceiba.biblioteca.aplicacion.fabrica.FabricaCrearPrestamo;
import com.ceiba.biblioteca.aplicacion.manejador.ManejadorCrearPrestamo;
import com.ceiba.biblioteca.dominio.puerto.RepositorioRegistroPrestamo;
import com.ceiba.biblioteca.dominio.servicio.ServicioCrearPrestamo;
import com.ceiba.biblioteca.dominio.servicio.ServicioMostrarPrestamo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearPrestamo servicioCrearPrestamo(RepositorioRegistroPrestamo repositorioRegistroPrestamo){
        return new ServicioCrearPrestamo(repositorioRegistroPrestamo);
    }

    @Bean
    public ManejadorCrearPrestamo manejadorCrearPrestamo(ServicioCrearPrestamo servicioCrearPrestamo, FabricaCrearPrestamo fabricaCrearPrestamo){
        return new ManejadorCrearPrestamo(servicioCrearPrestamo,fabricaCrearPrestamo);
    }
    @Bean
    public ServicioMostrarPrestamo servicioMostrarPrestamo(RepositorioRegistroPrestamo repositorioRegistroPrestamo){
        return new ServicioMostrarPrestamo(repositorioRegistroPrestamo);
    }
    @Bean
    public ManejadorMostrarPrestamo manejadorMostrarPrestamo(ServicioMostrarPrestamo servicioMostrarPrestamo){
        return new ManejadorMostrarPrestamo(servicioMostrarPrestamo);
    }
}
