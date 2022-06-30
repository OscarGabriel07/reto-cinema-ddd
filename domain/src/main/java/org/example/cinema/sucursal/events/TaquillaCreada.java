package org.example.cinema.sucursal.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sucursal.entities.Taquillero;
import org.example.cinema.sucursal.values.TaquillaId;

public class TaquillaCreada extends DomainEvent {
    private final TaquillaId entityId;
    private final Taquillero taquillero;

    public TaquillaCreada(TaquillaId entityId, Taquillero taquillero) {
        super("org.example.cinema.TaquillaCreada");
        this.entityId = entityId;
        this.taquillero = taquillero;
    }

    public TaquillaId getEntityId() {
        return entityId;
    }

    public Taquillero getTaquillero() {
        return taquillero;
    }
}
