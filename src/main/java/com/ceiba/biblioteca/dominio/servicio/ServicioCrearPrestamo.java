package com.ceiba.biblioteca.dominio.servicio;


import com.ceiba.biblioteca.dominio.excepcion.ExcepcionPrestamoActivo;
import com.ceiba.biblioteca.dominio.excepcion.ExcepcionTipoUsario;
import com.ceiba.biblioteca.dominio.modelo.RegistroPrestamo;
import com.ceiba.biblioteca.dominio.modelo.dto.DtoRespuestaCreacionPrestamo;
import com.ceiba.biblioteca.dominio.puerto.RepositorioRegistroPrestamo;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ServicioCrearPrestamo {
    private static final long USUARIO_AFILIADO = 1;
    private static final long USUARIO_EMPLEADO = 2;
    private static final long USUARIO_INVITADO = 3;

    private static final int DIAS_DEVOLUCION_AFILIADO = 10;
    private static final int DIAS_DEVOLUCION_EMPLEADO = 8;
    private static final int DIAS_DEVOLUCION_INVITADO = 7;

    public static final String TIPO_USUARIO_INVALIDO = "Tipo de usuario no permitido en la biblioteca";

    private RepositorioRegistroPrestamo repositorioRegistroPrestamo;

    public ServicioCrearPrestamo(RepositorioRegistroPrestamo repositorioRegistroPrestamo) {
        this.repositorioRegistroPrestamo = repositorioRegistroPrestamo;
    }

    public DtoRespuestaCreacionPrestamo ejecutar(RegistroPrestamo registroPrestamo){
        validarTipoDeUsuario(registroPrestamo);
        validarPrestamosUsuarioInvitado(registroPrestamo);

        LocalDate fechaPrestamo = calcularFechaDevolucion(registroPrestamo);
        registroPrestamo.setFechaMaximaDevolucion(fechaPrestamo);
        return  this.repositorioRegistroPrestamo.crear(registroPrestamo);

    }

    public LocalDate calcularFechaDevolucion(RegistroPrestamo registroPrestamo){
        LocalDate fechaPrestamo = LocalDate.now();

        if(registroPrestamo.getTipoUsuario() == USUARIO_AFILIADO){
            fechaPrestamo = addDaysSkippingWeekends(fechaPrestamo, DIAS_DEVOLUCION_AFILIADO);
        }else if(registroPrestamo.getTipoUsuario() == USUARIO_EMPLEADO){
            fechaPrestamo = addDaysSkippingWeekends(fechaPrestamo, DIAS_DEVOLUCION_EMPLEADO);
        }else if(registroPrestamo.getTipoUsuario() == USUARIO_INVITADO){
            fechaPrestamo = addDaysSkippingWeekends(fechaPrestamo, DIAS_DEVOLUCION_INVITADO);
        }


        return  fechaPrestamo;
    }

    public void validarTipoDeUsuario(RegistroPrestamo registroPrestamo){
        boolean usuarioNoValido = tipoUsuarioPermitido(registroPrestamo.getTipoUsuario());
        if (usuarioNoValido){
            throw new ExcepcionTipoUsario(TIPO_USUARIO_INVALIDO);
        }
    }
    public boolean tipoUsuarioPermitido(int tipoUsuario){
        boolean usuarioNoPermitido = true;
        if (tipoUsuario == USUARIO_AFILIADO || tipoUsuario == USUARIO_EMPLEADO || tipoUsuario == USUARIO_INVITADO){
            usuarioNoPermitido = false;
        }
        return usuarioNoPermitido;
    }
    public void validarPrestamosUsuarioInvitado(RegistroPrestamo registroPrestamo){
        String identificacionUsuario = registroPrestamo.getIdentificacionUsuario();
        if (registroPrestamo.getTipoUsuario() == USUARIO_INVITADO){
            boolean yaTienePrestamo = this.repositorioRegistroPrestamo.existePorIdentificacionUsuario(identificacionUsuario);
            if (yaTienePrestamo){
                String mensajeError = "El usuario con identificación "+identificacionUsuario+" ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo";
                throw new ExcepcionPrestamoActivo(mensajeError);
            }
        }

    }
    public static LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < days) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
    }
}
