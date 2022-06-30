package org.example.cinema.sucursal.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.sucursal.values.Estado;
import org.example.cinema.sucursal.values.PantallaId;
import org.example.cinema.sucursal.values.SucursalId;

public class AgregarPantalla extends Command {

    private final SucursalId sucursalId;
    private final PantallaId entityId;
    private final Estado estado;

    public AgregarPantalla(SucursalId sucursalId, PantallaId entityId, Estado estado){

        this.sucursalId = sucursalId;
        this.entityId = entityId;
        this.estado = estado;
    }

    public SucursalId getSucursalId() {
        return sucursalId;
    }

    public PantallaId getEntityId() {
        return entityId;
    }

    public Estado getEstado() {
        return estado;
    }
}
