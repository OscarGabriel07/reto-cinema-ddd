package org.example.cinema.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sala.values.Edad;
import org.example.cinema.sala.values.EncargadoSalaId;
import org.example.cinema.sala.values.FechaIncorporacion;
import org.example.cinema.sala.values.Nombre;

public class EncargadoSalaAsignado extends DomainEvent {
    private final EncargadoSalaId entityId;
    private final Edad edad;
    private final FechaIncorporacion fechaIncorporacion;
    private final Nombre nombre;

    public EncargadoSalaAsignado(EncargadoSalaId entityId, Edad edad, FechaIncorporacion fechaIncorporacion, Nombre nombre) {
        super("org.example.cinema.EncargadoSalaAsignado");
        this.entityId = entityId;
        this.edad = edad;
        this.fechaIncorporacion = fechaIncorporacion;
        this.nombre = nombre;
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
