package org.example.cinema.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sala.values.EncargadoSalaId;
import org.example.cinema.sala.values.Nombre;

public class NombreDeEncargadoDeSalaActualizado extends DomainEvent {
    private final Nombre nombre;

    public NombreDeEncargadoDeSalaActualizado(Nombre nombre) {
        super("org.example.cinema.NombreDeEncargadoDeSalaActualizado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
