package org.example.cinema.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sucursal.values.SucursalId;

public class SucursalAsociada extends DomainEvent {
    private final SucursalId sucursalId;

    public SucursalAsociada(SucursalId sucursalId) {
        super("org.example.cinema.SucursalAsociada");
        this.sucursalId = sucursalId;
    }

    public SucursalId getSucursalId() {
        return sucursalId;
    }
}
