package org.example.cinema.sucursal.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.sucursal.values.Direccion;
import org.example.cinema.sucursal.values.NombreSucursal;
import org.example.cinema.sucursal.values.SucursalId;

public class CrearSucursal extends Command {

    private final SucursalId entityId;
    private final NombreSucursal nombreSucursal;
    private final Direccion direccion;

    public CrearSucursal(SucursalId entityId, NombreSucursal nombreSucursal, Direccion direccion){

        this.entityId = entityId;
        this.nombreSucursal = nombreSucursal;
        this.direccion = direccion;
    }

    public SucursalId getEntityId() {
        return entityId;
    }

    public NombreSucursal getNombreSucursal() {
        return nombreSucursal;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
