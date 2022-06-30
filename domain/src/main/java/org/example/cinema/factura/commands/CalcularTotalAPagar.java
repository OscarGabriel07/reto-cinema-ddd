package org.example.cinema.factura.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.factura.values.FacturaId;

public class CalcularTotalAPagar extends Command {

    private final FacturaId facturaId;

    public CalcularTotalAPagar(FacturaId facturaId){

        this.facturaId = facturaId;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }
}
