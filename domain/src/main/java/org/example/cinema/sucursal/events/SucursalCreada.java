package org.example.cinema.sucursal.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sucursal.values.Direccion;
import org.example.cinema.sucursal.values.NombreSucursal;

public class SucursalCreada extends DomainEvent {
    private final NombreSucursal nombreSucursal;
    private final Direccion direccion;

    public SucursalCreada(NombreSucursal nombreSucursal, Direccion direccion) {
        super("org.example.cinema.sucursal.SucursalCreada");
        this.nombreSucursal = nombreSucursal;
        this.direccion = direccion;
    }

    public NombreSucursal getNombreSucursal() {
        return nombreSucursal;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
