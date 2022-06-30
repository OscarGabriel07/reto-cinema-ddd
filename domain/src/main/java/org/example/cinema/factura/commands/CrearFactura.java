package org.example.cinema.factura.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.factura.entities.Cliente;
import org.example.cinema.factura.values.FacturaId;
import org.example.cinema.sucursal.values.SucursalId;

public class CrearFactura extends Command {

    private final FacturaId entityId;
    private final SucursalId sucursalId;
    private final Cliente cliente;

    public CrearFactura(FacturaId entityId, SucursalId sucursalId, Cliente cliente){

        this.entityId = entityId;
        this.sucursalId = sucursalId;
        this.cliente = cliente;
    }

    public FacturaId getEntityId() {
        return entityId;
    }

    public SucursalId getSucursalId() {
        return sucursalId;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
