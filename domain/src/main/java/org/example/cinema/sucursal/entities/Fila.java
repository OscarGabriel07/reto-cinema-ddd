package org.example.cinema.sucursal.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.cinema.sucursal.values.FilaId;
import org.example.cinema.sucursal.values.TipoDeFila;

import java.util.Objects;

public class Fila extends Entity<FilaId> {
    private TipoDeFila tipoDeFila;

    public Fila(FilaId entityId, TipoDeFila tipoDeFila) {
        super(entityId);
        this.tipoDeFila = tipoDeFila;
    }

    public TipoDeFila tipoDeFila() {
        return tipoDeFila;
    }

    public void cambiarTipoDeFila(TipoDeFila tipoDeFila){
        this.tipoDeFila = Objects.requireNonNull(tipoDeFila);
    }
}
