package com.ceiba.biblioteca.infraestructura.adaptador.servicio;

import com.ceiba.biblioteca.dominio.modelo.RegistroPrestamo;
import com.ceiba.biblioteca.dominio.modelo.dto.DtoRegistroPrestamo;
import com.ceiba.biblioteca.dominio.modelo.dto.DtoRespuestaCreacionPrestamo;
import com.ceiba.biblioteca.dominio.puerto.RepositorioRegistroPrestamo;
import com.ceiba.biblioteca.infraestructura.adaptador.entidad.RegistroPrestamoEntity;
import com.ceiba.biblioteca.infraestructura.adaptador.mapper.MapperRegistroPrestamo;
import com.ceiba.biblioteca.infraestructura.adaptador.repositorio.RepositorioRegistroPrestamoJPA;
import org.springframework.stereotype.Repository;

@Repository
public class AdaptadorRegistroPrestamo implements RepositorioRegistroPrestamo {
    private RepositorioRegistroPrestamoJPA repositorioRegistroPrestamoJPA;
    private MapperRegistroPrestamo mapperRegistroPrestamo;

    public AdaptadorRegistroPrestamo(RepositorioRegistroPrestamoJPA repositorioRegistroPrestamoJPA, MapperRegistroPrestamo mapperRegistroPrestamo) {
        this.repositorioRegistroPrestamoJPA = repositorioRegistroPrestamoJPA;
        this.mapperRegistroPrestamo = mapperRegistroPrestamo;
    }

    @Override
    public DtoRespuestaCreacionPrestamo crear(RegistroPrestamo prestamo) {
        RegistroPrestamoEntity registroPrestamoEntity = mapperRegistroPrestamo.mapperDominioToEntity(prestamo);
        repositorioRegistroPrestamoJPA.save(registroPrestamoEntity);
        return mapperRegistroPrestamo.mapperEntityToDtoRespuestaCreacionPrestamo(registroPrestamoEntity);
    }

    @Override
    public boolean existePorIdentificacionUsuario(String identificacionUsuario) {
        RegistroPrestamoEntity prestamo = repositorioRegistroPrestamoJPA.findByIdentificacionUsuario(identificacionUsuario);
        if (prestamo == null){
            return false;
        }
        return true;
    }

    @Override
    public boolean existePorId(int id) {
        RegistroPrestamoEntity prestamo = repositorioRegistroPrestamoJPA.findById(id);
        if (prestamo == null){
            return true;
        }
        return false;
    }

    @Override
    public DtoRegistroPrestamo mostrar(int id) {
        return mapperRegistroPrestamo.mapperEntityToDtoRegistroPrestamo(repositorioRegistroPrestamoJPA.findById(id));
    }
}
