package org.example.cinema.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.factura.values.Descripcion;
import org.example.cinema.factura.values.FechaImpresion;
import org.example.cinema.factura.values.TicketId;
import org.example.cinema.factura.values.Valor;

public class TicketAgregado extends DomainEvent {
    private final TicketId entityId;
    private final Descripcion descripcion;
    private final Valor valor;
    private final FechaImpresion fechaImpresion;

    public TicketAgregado(TicketId entityId, Descripcion descripcion, Valor valor, FechaImpresion fechaImpresion) {
        super("org.example.cinema.TicketAgregado");
        this.entityId = entityId;
        this.descripcion = descripcion;
        this.valor = valor;
        this.fechaImpresion = fechaImpresion;
    }

    public TicketId getEntityId() {
        return entityId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Valor getValor() {
        return valor;
    }

    public FechaImpresion getFechaImpresion() {
        return fechaImpresion;
    }
}
