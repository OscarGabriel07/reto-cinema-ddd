package org.example.cinema.factura.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.factura.entities.Cliente;
import org.example.cinema.factura.values.FacturaId;
import org.example.cinema.factura.values.Nombre;

public class CambiarNombreCliente extends Command {

    private final FacturaId facturaId;
    private final Cliente cliente;
    private final Nombre nombre;

    public CambiarNombreCliente(FacturaId facturaId, Cliente cliente, Nombre nombre){

        this.facturaId = facturaId;
        this.cliente = cliente;
        this.nombre = nombre;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
