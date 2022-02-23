package com.ceiba.biblioteca.infraestructura.controlador;


import com.ceiba.biblioteca.aplicacion.comando.prestamo.ComandoRegistroPrestamo;
import com.ceiba.biblioteca.aplicacion.consulta.ManejadorMostrarPrestamo;
import com.ceiba.biblioteca.aplicacion.manejador.ManejadorCrearPrestamo;
import com.ceiba.biblioteca.dominio.modelo.RegistroPrestamo;
import com.ceiba.biblioteca.dominio.modelo.dto.DtoRegistroPrestamo;
import com.ceiba.biblioteca.dominio.modelo.dto.DtoRespuestaCreacionPrestamo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("prestamo")
public class RegistroPrestamoControlador {
    private final ManejadorCrearPrestamo manejadorCrearPrestamo;
    private final ManejadorMostrarPrestamo manejadorMostrarPrestamo;

    @Autowired
    public RegistroPrestamoControlador(ManejadorCrearPrestamo manejadorCrearPrestamo, ManejadorMostrarPrestamo manejadorMostrarPrestamo) {
        this.manejadorCrearPrestamo = manejadorCrearPrestamo;
        this.manejadorMostrarPrestamo = manejadorMostrarPrestamo;
    }

    @PostMapping
    @ApiOperation("crear")
    public DtoRespuestaCreacionPrestamo crear(@RequestBody ComandoRegistroPrestamo comandoRegistroPrestamo) {
        return this.manejadorCrearPrestamo.ejecutar(comandoRegistroPrestamo);

    }

    @GetMapping("/{id}")
    @ApiOperation("mostrar")
    public DtoRegistroPrestamo mostrar(@PathVariable("id") int id) {
        return this.manejadorMostrarPrestamo.ejecutar(id);
    }

}

