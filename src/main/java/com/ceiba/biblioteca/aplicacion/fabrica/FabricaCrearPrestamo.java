package com.ceiba.biblioteca.aplicacion.fabrica;

import com.ceiba.biblioteca.aplicacion.comando.prestamo.ComandoRegistroPrestamo;
import com.ceiba.biblioteca.dominio.modelo.RegistroPrestamo;
import org.springframework.stereotype.Component;

@Component
public class FabricaCrearPrestamo {
   public RegistroPrestamo crear(ComandoRegistroPrestamo comandoRegistroPrestamo){
        return new RegistroPrestamo(
                comandoRegistroPrestamo.getId(),
                comandoRegistroPrestamo.getIsbn(),
                comandoRegistroPrestamo.getIdentificacionUsuario(),
                comandoRegistroPrestamo.getTipoUsuario(),
                comandoRegistroPrestamo.getFechaMaximaDevolucion()
        );
   }
}
