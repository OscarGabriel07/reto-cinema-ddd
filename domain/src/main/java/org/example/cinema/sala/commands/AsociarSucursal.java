package org.example.cinema.sala.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.sala.values.SalaId;
import org.example.cinema.sucursal.values.SucursalId;

public class AsociarSucursal extends Command {

    private final SalaId salaId;
    private final SucursalId sucursalId;

    public AsociarSucursal(SalaId salaId, SucursalId sucursalId){

        this.salaId = salaId;
        this.sucursalId = sucursalId;
    }

    public SalaId getSalaId() {
        return salaId;
    }

    public SucursalId getSucursalId() {
        return sucursalId;
    }
}
