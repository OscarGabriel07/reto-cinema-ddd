package org.example.cinema.sala.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.sala.entities.Silla;
import org.example.cinema.sala.values.Capacidad;
import org.example.cinema.sala.values.SalaId;

import java.util.Set;

public class CrearSala extends Command {

    private final SalaId entityId;
    private final Capacidad capacidad;
    private final Set<Silla> sillas;

    public CrearSala(SalaId entityId, Capacidad capacidad, Set<Silla> sillas){

        this.entityId = entityId;
        this.capacidad = capacidad;
        this.sillas = sillas;
    }

    public SalaId getEntityId() {
        return entityId;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }

    public Set<Silla> getSillas() {
        return sillas;
    }
}
