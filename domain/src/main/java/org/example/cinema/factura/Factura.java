package org.example.cinema.factura;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.factura.entities.Cliente;
import org.example.cinema.factura.entities.Ticket;
import org.example.cinema.factura.events.*;
import org.example.cinema.factura.values.*;
import org.example.cinema.sucursal.values.SucursalId;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Factura extends AggregateEvent<FacturaId> {

    protected SucursalId sucursalId;
    protected Cliente cliente;
    protected Set<Ticket> tickets;
    protected Valor valor;

    public Factura(FacturaId entityId, SucursalId sucursalId, Cliente cliente) {
        super(entityId);
        appendChange(new FacturaCreada(sucursalId, cliente)).apply();
    }

    private Factura(FacturaId facturaId){
        super(facturaId);
        subscribe(new FacturaChange(this));
    }

    public static Factura from(FacturaId facturaId, List<DomainEvent> events){
        var factura = new Factura(facturaId);
        events.forEach(factura::applyEvent);
        return factura;
    }

    public void agregarTicket(TicketId entityId, Descripcion descripcion, Valor valor, FechaImpresion fechaImpresion){
        appendChange(new TicketAgregado(entityId, descripcion, valor, fechaImpresion)).apply();
    }

    public void calcularTotalAPagar(){
        appendChange(new TotalAPagarCalculado()).apply();
    }

    public void cambiarCliente(Cliente cliente){
        appendChange(new ClienteCambiado(cliente)).apply();
    }

    public void actualizarDescripcionDeUnTicket(TicketId ticketId, Descripcion descripcion){
        appendChange(new DescripcionDeTicketActualizada(ticketId, descripcion)).apply();
    }

    public void cambiarNombreCliente(Cliente cliente, Nombre nombre){
        appendChange(new NombreClienteCambiado(cliente, nombre)).apply();
    }

    protected Optional<Ticket> getTicketPorId(TicketId ticketId){
        return tickets()
                .stream()
                .filter(ticket -> ticket.identity().equals(ticketId))
                .findFirst();
    }

    public SucursalId sucursalId() {
        return sucursalId;
    }

    public Cliente cliente() {
        return cliente;
    }

    public Set<Ticket> tickets() {
        return tickets;
    }

    public Valor valor() {
        return valor;
    }
}
