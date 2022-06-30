package org.example.cinema.sala.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.sala.values.*;

public class AsignarPelicula extends Command {

    private final SalaId salaId;
    private final PeliculaId entityId;
    private final Idioma idioma;
    private final Duracion duracion;

    public AsignarPelicula(SalaId salaId, PeliculaId entityId, Genero genero, Idioma idioma, Duracion duracion){

        this.salaId = salaId;
        this.entityId = entityId;
        this.idioma = idioma;
        this.duracion = duracion;
    }

    public SalaId getSalaId() {
        return salaId;
    }

    public PeliculaId getEntityId() {
        return entityId;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
