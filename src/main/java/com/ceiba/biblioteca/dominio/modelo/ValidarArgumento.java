package com.ceiba.biblioteca.dominio.modelo;

import com.ceiba.biblioteca.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.biblioteca.dominio.excepcion.ExcepcionValorObligatorio;

final class ValidarArgumento {
    private ValidarArgumento() {}
    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }
    public static void validarLongitudMaxima(String valor,int longitud,String mensaje){
        if(valor.length() > longitud){
            throw new ExcepcionLongitudValor(mensaje);
        }
    }

}
