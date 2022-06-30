package org.example.cinema.sucursal.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.factura.values.Nombre;
import org.example.cinema.sucursal.values.SucursalId;

public class CambiarNombre extends Command {

    private final SucursalId sucursalId;
    private final Nombre nombre;

    public CambiarNombre(SucursalId sucursalId, Nombre nombre){

        this.sucursalId = sucursalId;
        this.nombre = nombre;
    }

    public SucursalId getSucursalId() {
        return sucursalId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
