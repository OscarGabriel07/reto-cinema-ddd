package org.example.cinema.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.factura.values.Descripcion;
import org.example.cinema.factura.values.TicketId;

public class DescripcionDeTicketActualizada extends DomainEvent {
    private final TicketId ticketId;
    private final Descripcion descripcion;

    public DescripcionDeTicketActualizada(TicketId ticketId, Descripcion descripcion) {
        super("org.example.cinema.DescripcionDeTicketActualizada");
        this.ticketId = ticketId;
        this.descripcion = descripcion;
    }

    public TicketId getTicketId() {
        return ticketId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
