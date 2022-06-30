package org.example.cinema.sala.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.cinema.sala.values.Edad;
import org.example.cinema.sala.values.EncargadoSalaId;
import org.example.cinema.sala.values.FechaIncorporacion;
import org.example.cinema.sala.values.Nombre;

import java.util.Objects;

public class EncargadoSala extends Entity<EncargadoSalaId> {
    private Edad edad;
    private FechaIncorporacion fechaIncorporacion;
    private Nombre nombre;

    public EncargadoSala(EncargadoSalaId entityId, Edad edad, FechaIncorporacion fechaIncorporacion, Nombre nombre) {
        super(entityId);
        this.edad = edad;
        this.fechaIncorporacion = fechaIncorporacion;
        this.nombre = nombre;
    }

    public void modificarEdad(Edad edad){
        this.edad = Objects.requireNonNull(edad);
    }

    public void cambiarFechaIncorporacion(FechaIncorporacion fechaIncorporacion){
        this.fechaIncorporacion = Objects.requireNonNull(fechaIncorporacion);
    }

    public void modificarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    public Nombre nombre() {
        return nombre;
    }

    public FechaIncorporacion fechaIncorporacion() {
        return fechaIncorporacion;
    }

    public Edad edad() {
        return edad;
    }
}
