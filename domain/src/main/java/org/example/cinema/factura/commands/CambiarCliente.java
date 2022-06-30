package org.example.cinema.factura.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.factura.entities.Cliente;
import org.example.cinema.factura.values.FacturaId;
import org.example.cinema.sucursal.commands.CambiarNombre;

public class CambiarCliente extends Command {

    private final FacturaId facturaId;
    private final Cliente cliente;

    public CambiarCliente(FacturaId facturaId, Cliente cliente){

        this.facturaId = facturaId;
        this.cliente = cliente;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
