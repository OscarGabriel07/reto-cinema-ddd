package org.example.cinema.sucursal.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.cinema.factura.values.Nombre;
import org.example.cinema.sucursal.values.Edad;
import org.example.cinema.sucursal.values.FechaIncorporacion;
import org.example.cinema.sucursal.values.NombreTaquillero;
import org.example.cinema.sucursal.values.TaquilleroId;

public class Taquillero extends Entity<TaquilleroId> {
    private Edad edad;
    private FechaIncorporacion fechaIncorporacion;
    private NombreTaquillero nombreTaquillero;

    public Taquillero(TaquilleroId entityId, Edad edad, FechaIncorporacion fechaIncorporacion, NombreTaquillero nombreTaquillero) {
        super(entityId);
        this.edad = edad;
        this.fechaIncorporacion = fechaIncorporacion;
        this.nombreTaquillero = nombreTaquillero;
    }

    public Edad getEdad() {
        return edad;
    }

    public FechaIncorporacion getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public NombreTaquillero getNombreTaquillero() {
        return nombreTaquillero;
    }

    public void cambiarEdad(Edad edad){
        this.edad = edad;
    }

    public void cambiarFechaIncorporacion(FechaIncorporacion fechaIncorporacion){
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public void cambiarNombreTquillero(NombreTaquillero nombreTaquillero){
        this.nombreTaquillero = nombreTaquillero;
    }
}
