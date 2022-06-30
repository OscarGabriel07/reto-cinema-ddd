package org.example.cinema.sala.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.cinema.sala.values.Anchura;
import org.example.cinema.sala.values.SillaId;

public class Silla extends Entity<SillaId> {
    private Anchura anchura;

    public Silla(SillaId entityId, Anchura anchura) {
        super(entityId);
        this.anchura = anchura;
    }

    public void cambiarAnchura(Anchura anchura){
        this.anchura = anchura;
    }

    public Anchura anchura() {
        return anchura;
    }
}
