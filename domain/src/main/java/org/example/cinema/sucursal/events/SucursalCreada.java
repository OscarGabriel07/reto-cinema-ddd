package org.example.cinema.sucursal.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sucursal.values.Direccion;
import org.example.cinema.sucursal.values.NombreSucursal;
import org.example.cinema.sucursal.values.SucursalId;

public class SucursalCreada extends DomainEvent {
    private final SucursalId sucursalId;
    private final NombreSucursal nombreSucursal;
    private final Direccion direccion;

    public SucursalCreada(SucursalId sucursalId, NombreSucursal nombreSucursal, Direccion direccion) {
        super("org.example.cinema.sucursal.SucursalCreada");
        this.sucursalId = sucursalId;
        this.nombreSucursal = nombreSucursal;
        this.direccion = direccion;
    }

    public NombreSucursal getNombreSucursal() {
        return nombreSucursal;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public SucursalId getSucursalId() {
        return sucursalId;
    }
}
