package org.example.cinema.factura.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.factura.values.Descripcion;
import org.example.cinema.factura.values.FacturaId;
import org.example.cinema.factura.values.TicketId;

public class ActualizarDescripcionDeUnTicket extends Command {

    private final FacturaId facturaId;
    private final TicketId ticketId;
    private final Descripcion descripcion;

    public ActualizarDescripcionDeUnTicket(FacturaId facturaId, TicketId ticketId, Descripcion descripcion){

        this.facturaId = facturaId;
        this.ticketId = ticketId;
        this.descripcion = descripcion;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public TicketId getTicketId() {
        return ticketId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
