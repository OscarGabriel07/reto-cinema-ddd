package org.example.cinema.sucursal.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.factura.values.Nombre;
import org.example.cinema.sucursal.values.NombreSucursal;
import org.example.cinema.sucursal.values.SucursalId;

public class NombreCambiado extends DomainEvent {
    private final SucursalId sucursalId;
    private final NombreSucursal nombreSucursal;

    public NombreCambiado(SucursalId sucursalId, NombreSucursal nombreSucursal) {
        super("org.example.cinema.NombreCambiado");
        this.sucursalId = sucursalId;
        this.nombreSucursal = nombreSucursal;
    }

    public NombreSucursal getNombre() {
        return nombreSucursal;
    }

    public SucursalId getSucursalId() {
        return sucursalId;
    }
}
