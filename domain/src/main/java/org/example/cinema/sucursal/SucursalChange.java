package org.example.cinema.sucursal;

import co.com.sofka.domain.generic.EventChange;
import org.example.cinema.sucursal.entities.Fila;
import org.example.cinema.sucursal.entities.Pantalla;
import org.example.cinema.sucursal.entities.Taquilla;
import org.example.cinema.sucursal.events.*;

import java.util.HashSet;

public class SucursalChange extends EventChange {
    public SucursalChange(Sucursal sucursal) {

        apply((SucursalCreada event) -> {
            sucursal.nombreSucursal = event.getNombreSucursal();
            sucursal.direccion = event.getDireccion();
            sucursal.pantallas = new HashSet<>();
            sucursal.filas = new HashSet<>();
            sucursal.taquillas = new HashSet<>();
        });

        apply((NombreCambiado event) -> {
            sucursal.cambiarNombre(event.getNombre());
        });

        apply((PantallaAgregada event) -> {
            sucursal.pantallas.add(new Pantalla(
                    event.getEntityId(),
                    event.getEstado()
            ));
        });

        apply((FilaAgregada event) -> {
            sucursal.filas.add(new Fila(
                    event.getEntityId(),
                    event.getTipoDeFila()
            ));
        });

        apply((TaquillaAgregada event) -> {
            sucursal.taquillas.add(new Taquilla(
                    event.getEntityId(),
                    event.getTaquillero()
            ));
        });
    }
}
