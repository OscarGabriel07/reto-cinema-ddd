package org.example.cinema.sala.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.sala.entities.Pelicula;
import org.example.cinema.sala.values.SalaId;

public class ReproducirPelicula extends Command {

    private final SalaId salaId;
    private final Pelicula pelicula;

    public ReproducirPelicula(SalaId salaId, Pelicula pelicula){

        this.salaId = salaId;
        this.pelicula = pelicula;
    }

    public SalaId getSalaId() {
        return salaId;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }
}
