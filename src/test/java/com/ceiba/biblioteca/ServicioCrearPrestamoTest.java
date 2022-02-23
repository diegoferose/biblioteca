package com.ceiba.biblioteca;

import com.ceiba.biblioteca.dominio.modelo.RegistroPrestamo;
import com.ceiba.biblioteca.dominio.puerto.RepositorioRegistroPrestamo;
import com.ceiba.biblioteca.dominio.servicio.ServicioCrearPrestamo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class ServicioCrearPrestamoTest {
    @Spy
    @InjectMocks
    private ServicioCrearPrestamo servicioCrearPrestamo;

    @Mock
    private RepositorioRegistroPrestamo repositorioRegistroPrestamo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void crearRegistroPrestamoTest() {
        RegistroPrestamoTestDataBuilder registroPrestamoTestDataBuilder = new RegistroPrestamoTestDataBuilder();
        RegistroPrestamo registroPrestamo = registroPrestamoTestDataBuilder.build();
        this.servicioCrearPrestamo.ejecutar(registroPrestamo);
    }

}
