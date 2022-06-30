package org.example.cinema.sala;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sala.entities.EncargadoSala;
import org.example.cinema.sala.entities.Pelicula;
import org.example.cinema.sala.entities.Silla;
import org.example.cinema.sala.events.*;
import org.example.cinema.sala.values.EncargadoSalaId;
import org.example.cinema.sala.values.*;
import org.example.cinema.sucursal.values.SucursalId;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Sala extends AggregateEvent<SalaId> {
    protected Capacidad capacidad;
    protected EncargadoSala encargadoSala;
    protected Set<Silla> sillas;
    protected Pelicula pelicula;
    protected SucursalId sucursalId;

    public Sala(SalaId entityId, Capacidad capacidad, Set<Silla> sillas) {
        super(entityId);
        appendChange(new SalaCreada(capacidad, sillas)).apply();
    }

    private Sala(SalaId entityId){
        super(entityId);
        subscribe(new SalaChange(this));
    }

    public static Sala from(SalaId salaId, List<DomainEvent> events){
        var persona = new Sala(salaId);
        events.forEach(persona::applyEvent);
        return persona;
    }

    public void asignarEncargadoSala(EncargadoSalaId entityId, Edad edad, FechaIncorporacion fechaIncorporacion, Nombre nombre){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(edad);
        Objects.requireNonNull(fechaIncorporacion);
        Objects.requireNonNull(nombre);
        appendChange(new EncargadoSalaAsignado(entityId, edad, fechaIncorporacion, nombre)).apply();
    }

    public void asignarPelicula(PeliculaId entityId, Genero genero, Idioma idioma, Duracion duracion){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(genero);
        Objects.requireNonNull(idioma);
        Objects.requireNonNull(duracion);
        appendChange(new PeliculaAsignada(entityId, genero, idioma, duracion)).apply();
    }

    public void cambiarAnchuraDeUnaSilla(SillaId sillaId, Anchura anchura){
        Objects.requireNonNull(sillaId);
        Objects.requireNonNull(anchura);
        appendChange(new AnchuraDeSillaCambiada(sillaId, anchura)).apply();
    }

    public void reproducirPelicula(Pelicula pelicula){
        Objects.requireNonNull(pelicula);
        appendChange(new PeliculaReproducida(pelicula)).apply();
    }

    public void actualizarNombreDeEncargadoDeSala(EncargadoSalaId encargadoSalaId, Nombre nombre){
        Objects.requireNonNull(encargadoSalaId);
        Objects.requireNonNull(nombre);
        appendChange(new NombreDeEncargadoDeSalaActualizado(nombre)).apply();
    }

    public Optional<Silla> getSillaPorId(SillaId sillaId){
        return sillas()
                .stream()
                .filter(silla -> silla.identity().equals(sillaId))
                .findFirst();
    }

    public void asociarSucursal(SucursalId sucursalId){
        Objects.requireNonNull(sucursalId);
        appendChange(new SucursalAsociada(sucursalId)).apply();
    }

    public Capacidad capacidad() {
        return capacidad;
    }

    public EncargadoSala encargadoSala() {
        return encargadoSala;
    }

    public Set<Silla> sillas() {
        return sillas;
    }

    public Pelicula peliculaId() {
        return pelicula;
    }
}
