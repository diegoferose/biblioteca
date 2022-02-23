package com.ceiba.biblioteca.infraestructura.adaptador.repositorio;

import com.ceiba.biblioteca.infraestructura.adaptador.entidad.RegistroPrestamoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioRegistroPrestamoJPA extends JpaRepository<RegistroPrestamoEntity,Integer> {
    RegistroPrestamoEntity findByIdentificacionUsuario(String findByIdentificacionUsuario);
    RegistroPrestamoEntity findById(int id);
}
