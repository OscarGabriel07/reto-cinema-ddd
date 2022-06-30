package org.example.cinema.sucursal.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sucursal.values.FilaId;
import org.example.cinema.sucursal.values.TipoDeFila;

public class FilaAgregada extends DomainEvent {
    private final FilaId entityId;
    private final TipoDeFila tipoDeFila;

    public FilaAgregada(FilaId entityId, TipoDeFila tipoDeFila) {
        super("org.example.cinema.FilaCreada");
        this.entityId = entityId;
        this.tipoDeFila = tipoDeFila;
    }

    public FilaId getEntityId() {
        return entityId;
    }

    public TipoDeFila getTipoDeFila() {
        return tipoDeFila;
    }
}
