package org.example.cinema.sucursal.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.sucursal.values.FilaId;
import org.example.cinema.sucursal.values.SucursalId;
import org.example.cinema.sucursal.values.TipoDeFila;

public class AgregarFila extends Command {

    private final SucursalId sucursalId;
    private final FilaId entityId;
    private final TipoDeFila tipoDeFila;

    public AgregarFila(SucursalId sucursalId, FilaId entityId, TipoDeFila tipoDeFila){

        this.sucursalId = sucursalId;
        this.entityId = entityId;
        this.tipoDeFila = tipoDeFila;
    }

    public SucursalId getSucursalId() {
        return sucursalId;
    }

    public FilaId getEntityId() {
        return entityId;
    }

    public TipoDeFila getTipoDeFila() {
        return tipoDeFila;
    }
}
