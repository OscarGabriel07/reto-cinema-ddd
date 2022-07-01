package org.example.cinema.sucursal.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.sucursal.values.NombreSucursal;
import org.example.cinema.sucursal.values.SucursalId;

public class CambiarNombre extends Command {

    private final SucursalId sucursalId;
    private final NombreSucursal nombreSucursal;

    public CambiarNombre(SucursalId sucursalId, NombreSucursal nombreSucursal){

        this.sucursalId = sucursalId;
        this.nombreSucursal = nombreSucursal;
    }

    public SucursalId getSucursalId() {
        return sucursalId;
    }

    public NombreSucursal getNombre() {
        return nombreSucursal;
    }
}
