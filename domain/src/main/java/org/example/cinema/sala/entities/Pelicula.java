package org.example.cinema.sala.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.cinema.sala.values.*;

import java.util.Objects;

public class Pelicula extends Entity<PeliculaId> {
    private TiempoTranscurrido tiempoTranscurrido;
    private Genero genero;
    private Idioma idioma;
    private Duracion duracion;

    public Pelicula(PeliculaId entityId, Genero genero, Idioma idioma, Duracion duracion) {
        super(entityId);
        this.genero = genero;
        this.idioma = idioma;
        this.duracion = duracion;
        this.tiempoTranscurrido.value();
    }

    public void cambiarGenero(Genero genero){
        this.genero = Objects.requireNonNull(genero);
    }

    public void cambiarIdioma(Idioma idioma){
        this.idioma = Objects.requireNonNull(idioma);
    }

    public void cambiarDuracion(Duracion duracion){
        this.duracion = duracion;
    }

    public void reproducir(){
        this.tiempoTranscurrido.value();
    }

    public Genero genero() {
        return genero;
    }

    public Idioma idioma() {
        return idioma;
    }

    public Duracion duracion() {
        return duracion;
    }
}
