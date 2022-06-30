package org.example.cinema.factura.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.factura.values.*;

public class AgregarTicket extends Command {

    private final FacturaId facturaId;
    private final TicketId entityId;
    private final Descripcion descripcion;
    private final Valor valor;
    private final FechaImpresion fechaImpresion;

    public AgregarTicket(FacturaId facturaId, TicketId entityId, Descripcion descripcion, Valor valor, FechaImpresion fechaImpresion){

        this.facturaId = facturaId;
        this.entityId = entityId;
        this.descripcion = descripcion;
        this.valor = valor;
        this.fechaImpresion = fechaImpresion;
    }

    public FacturaId getFacturaId() {
        return facturaId;
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
