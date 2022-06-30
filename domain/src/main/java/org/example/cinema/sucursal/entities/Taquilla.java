package org.example.cinema.sucursal.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.cinema.sucursal.values.TaquillaId;

import java.util.Objects;

public class Taquilla extends Entity<TaquillaId>{
    private Taquillero taquillero;

    public Taquilla(TaquillaId entityId, Taquillero taquillero) {
        super(entityId);
        this.taquillero = taquillero;
    }

    public Taquillero getTaquillero() {
        return taquillero;
    }

    public void cambiarTaquillero(Taquillero taquillero){
        this.taquillero = Objects.requireNonNull(taquillero);
    }
}
