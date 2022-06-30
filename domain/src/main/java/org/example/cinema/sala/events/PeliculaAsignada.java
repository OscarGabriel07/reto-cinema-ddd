package org.example.cinema.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sala.values.Duracion;
import org.example.cinema.sala.values.Genero;
import org.example.cinema.sala.values.Idioma;
import org.example.cinema.sala.values.PeliculaId;

public class PeliculaAsignada extends DomainEvent {
    private final PeliculaId entityId;
    private final Genero genero;
    private final Idioma idioma;
    private final Duracion duracion;

    public PeliculaAsignada(PeliculaId entityId, Genero genero, Idioma idioma, Duracion duracion) {
        super("org.example.cinema.PeliculaAsignada");
        this.entityId = entityId;
        this.genero = genero;
        this.idioma = idioma;
        this.duracion = duracion;
    }

    public PeliculaId getEntityId() {
        return entityId;
    }

    public Genero getGenero() {
        return genero;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
