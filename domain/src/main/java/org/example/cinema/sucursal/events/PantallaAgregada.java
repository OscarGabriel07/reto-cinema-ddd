package org.example.cinema.sucursal.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sucursal.values.Estado;
import org.example.cinema.sucursal.values.PantallaId;

public class PantallaAgregada extends DomainEvent {
    private final PantallaId entityId;
    private final Estado estado;

    public PantallaAgregada(PantallaId entityId, Estado estado) {
        super("org.example.cinema.PantallaAgregada");
        this.entityId = entityId;
        this.estado = estado;
    }

    public PantallaId getEntityId() {
        return entityId;
    }

    public Estado getEstado() {
        return estado;
    }
}
