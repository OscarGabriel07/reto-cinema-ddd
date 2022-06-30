package org.example.cinema.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sala.values.Anchura;
import org.example.cinema.sala.values.SillaId;

public class AnchuraDeSillaCambiada extends DomainEvent {
    private final SillaId sillaId;
    private final Anchura anchura;

    public AnchuraDeSillaCambiada(SillaId sillaId, Anchura anchura) {
        super("org.example.cinema.AnchuraDeSillaCambiada");
        this.sillaId = sillaId;
        this.anchura = anchura;
    }

    public SillaId getSillaId() {
        return sillaId;
    }

    public Anchura getAnchura() {
        return anchura;
    }
}
