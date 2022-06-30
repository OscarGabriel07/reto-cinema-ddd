package org.example.cinema.sucursal.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.factura.values.Nombre;

public class NombreCambiado extends DomainEvent {
    private final Nombre nombre;

    public NombreCambiado(Nombre nombre) {
        super("org.example.cinema.NombreCambiado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
