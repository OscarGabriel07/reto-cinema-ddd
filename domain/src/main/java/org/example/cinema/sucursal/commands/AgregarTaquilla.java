package org.example.cinema.sucursal.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.sucursal.entities.Taquillero;
import org.example.cinema.sucursal.values.SucursalId;
import org.example.cinema.sucursal.values.TaquillaId;

public class AgregarTaquilla extends Command {

    private final SucursalId sucursalId;
    private final TaquillaId entityId;
    private final Taquillero taquillero;

    public AgregarTaquilla(SucursalId sucursalId, TaquillaId entityId, Taquillero taquillero){

        this.sucursalId = sucursalId;
        this.entityId = entityId;
        this.taquillero = taquillero;
    }

    public SucursalId getSucursalId() {
        return sucursalId;
    }

    public TaquillaId getEntityId() {
        return entityId;
    }

    public Taquillero getTaquillero() {
        return taquillero;
    }
}
