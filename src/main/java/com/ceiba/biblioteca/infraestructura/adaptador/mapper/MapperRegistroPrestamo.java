package com.ceiba.biblioteca.infraestructura.adaptador.mapper;

import com.ceiba.biblioteca.dominio.modelo.RegistroPrestamo;
import com.ceiba.biblioteca.dominio.modelo.dto.DtoRegistroPrestamo;
import com.ceiba.biblioteca.dominio.modelo.dto.DtoRespuestaCreacionPrestamo;
import com.ceiba.biblioteca.infraestructura.adaptador.entidad.RegistroPrestamoEntity;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class MapperRegistroPrestamo {

    public RegistroPrestamoEntity mapperDominioToEntity(RegistroPrestamo registroPrestamo){
        RegistroPrestamoEntity registroPrestamoEntity = null;
        registroPrestamoEntity = new RegistroPrestamoEntity(
                registroPrestamo.getId(),
                registroPrestamo.getIsbn(),
                registroPrestamo.getIdentificacionUsuario(),
                registroPrestamo.getTipoUsuario(),
                registroPrestamo.getFechaMaximaDevolucion()
        );
        return registroPrestamoEntity;
    }
    public DtoRegistroPrestamo mapperEntityToDtoRegistroPrestamo(RegistroPrestamoEntity registroPrestamoEntity){
        DtoRegistroPrestamo registroPrestamo = null;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        registroPrestamo = new DtoRegistroPrestamo(
                registroPrestamoEntity.getId(),
                registroPrestamoEntity.getIsbn(),
                registroPrestamoEntity.getIdentificacionUsuario(),
                registroPrestamoEntity.getTipoUsuario(),
                registroPrestamoEntity.getFechaMaximaDevolucion().format(formato)
        );
        return registroPrestamo;
    }
    public DtoRespuestaCreacionPrestamo mapperEntityToDtoRespuestaCreacionPrestamo(RegistroPrestamoEntity registroPrestamoEntity){
        DtoRespuestaCreacionPrestamo dtoRespuestaCreacionPrestamo = null;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dtoRespuestaCreacionPrestamo = new DtoRespuestaCreacionPrestamo(
                registroPrestamoEntity.getId(),
                registroPrestamoEntity.getFechaMaximaDevolucion().format(formato)
        );
        return dtoRespuestaCreacionPrestamo;
    }
}
