package org.example.cinema.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sala.entities.Pelicula;
import org.example.cinema.sala.values.PeliculaId;

public class PeliculaReproducida extends DomainEvent {
    private final Pelicula pelicula;

    public PeliculaReproducida(Pelicula pelicula) {
        super("org.example.cinema.PeliculaReproducida");
        this.pelicula = pelicula;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }
}
