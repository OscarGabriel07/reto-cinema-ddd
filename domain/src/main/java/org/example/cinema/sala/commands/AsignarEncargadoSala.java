package org.example.cinema.sala.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.sala.values.*;

public class AsignarEncargadoSala extends Command {

    private final SalaId salaId;
    private final EncargadoSalaId entityId;
    private final Edad edad;
    private final FechaIncorporacion fechaIncorporacion;
    private final Nombre nombre;


    public AsignarEncargadoSala(SalaId salaId, EncargadoSalaId entityId, Edad edad, FechaIncorporacion fechaIncorporacion, Nombre nombre) {
        this.salaId = salaId;
        this.entityId = entityId;
        this.edad = edad;
        this.fechaIncorporacion = fechaIncorporacion;
        this.nombre = nombre;
    }

    public SalaId getSalaId() {
        return salaId;
    }

    public EncargadoSalaId getEntityId() {
        return entityId;
    }

    public Edad getEdad() {
        return edad;
    }

    public FechaIncorporacion getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
