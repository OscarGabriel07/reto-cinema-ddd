package org.example.cinema.factura;

import co.com.sofka.domain.generic.EventChange;
import org.example.cinema.factura.entities.Ticket;
import org.example.cinema.factura.events.*;
import org.example.cinema.factura.values.Valor;

import java.util.HashSet;

public class FacturaChange extends EventChange {

    public FacturaChange(Factura factura) {

        apply((FacturaCreada event) -> {
            factura.sucursalId = event.getSucursalId();
            factura.cliente = event.getCliente();
            factura.tickets = new HashSet<>();
            factura.valor.value();
        });

        apply((ClienteCambiado event) -> {
            factura.cliente = event.getCliente();
        });

        apply((NombreClienteCambiado event) -> {
            factura.cliente.cambiarNombre(event.getNombre());
        });

        apply((TicketAgregado event) -> {
            factura.tickets.add(new Ticket(
                    event.getEntityId(),
                    event.getDescripcion(),
                    event.getValor(),
                    event.getFechaImpresion()
            ));
            Integer totalFactura = factura.valor.value();
            Integer precioTicket = event.getValor().value();
            totalFactura += precioTicket;
            factura.setValor(new Valor(totalFactura));
        });

        apply((DescripcionDeTicketActualizada event) -> {
            var ticket = factura.getTicketPorId(event.getTicketId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra el ticket de la factura"));
            ticket.actualizarDescripcion(event.getDescripcion());
        });

    }
}
