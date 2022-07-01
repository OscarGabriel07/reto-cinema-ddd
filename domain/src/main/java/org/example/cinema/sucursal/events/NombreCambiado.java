package org.example.cinema.sucursal.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.factura.values.Nombre;
import org.example.cinema.sucursal.values.NombreSucursal;

public class NombreCambiado extends DomainEvent {
    private final NombreSucursal nombreSucursal;

    public NombreCambiado(NombreSucursal nombreSucursal) {
        super("org.example.cinema.NombreCambiado");
        this.nombreSucursal = nombreSucursal;
    }

    public NombreSucursal getNombre() {
        return nombreSucursal;
    }
}
