package org.example.cinema.sala;

import co.com.sofka.domain.generic.EventChange;
import org.example.cinema.sala.entities.EncargadoSala;
import org.example.cinema.sala.entities.Pelicula;
import org.example.cinema.sala.events.*;

public class SalaChange extends EventChange{
    public SalaChange(Sala sala) {

        apply((SalaCreada event) -> {
            sala.capacidad = event.getCapacidad();
            sala.encargadoSala = null;
            sala.sillas = event.getSillas();
            sala.pelicula = null;
        });

        apply((PeliculaAsignada event) -> {
            if(sala.pelicula != null){
                throw new IllegalArgumentException("No puedes asignar más de una película a la sala");
            }
            sala.pelicula = new Pelicula(
                    event.getEntityId(),
                    event.getGenero(),
                    event.getIdioma(),
                    event.getDuracion());
        });

        apply((PeliculaReproducida event) -> {
            if(sala.pelicula == null){
                throw new IllegalArgumentException("Debes asignar primero una película a la sala");
            }
            sala.reproducirPelicula(event.getPelicula());
        });

        apply((EncargadoSalaAsignado event) -> {
            if(sala.encargadoSala != null){
                throw new IllegalArgumentException("No puedes asignar a la sala más de un encargado");
            }
            sala.encargadoSala = new EncargadoSala(
                    event.getEntityId(),
                    event.getEdad(),
                    event.getFechaIncorporacion(),
                    event.getNombre());
        });

        apply((NombreDeEncargadoDeSalaActualizado event) -> {
            sala.encargadoSala.modificarNombre(event.getNombre());
        });

        apply((AnchuraDeSillaCambiada event) -> {
            var silla = sala.getSillaPorId(event.getSillaId()).
                    orElseThrow(() -> new IllegalArgumentException("No se encuentra la silla de la sala"));
            silla.cambiarAnchura(event.getAnchura());
        });

        apply((SucursalAsociada event) -> {
            sala.sucursalId = event.getSucursalId();
        });

    }
}
