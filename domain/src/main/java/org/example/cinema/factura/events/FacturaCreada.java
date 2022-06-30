package org.example.cinema.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.factura.Factura;
import org.example.cinema.factura.entities.Cliente;
import org.example.cinema.sucursal.Sucursal;
import org.example.cinema.sucursal.values.SucursalId;

public class FacturaCreada extends DomainEvent{
    private final SucursalId sucursalId;
    private final Cliente cliente;

    public FacturaCreada(SucursalId sucursalId, Cliente cliente) {
        super("org.example.cinema.factura.FacturaCreada");
        this.sucursalId = sucursalId;
        this.cliente = cliente;
    }

    public SucursalId getSucursalId() {
        return sucursalId;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
