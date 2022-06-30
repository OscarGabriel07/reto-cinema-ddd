package org.example.cinema.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sala.entities.Silla;
import org.example.cinema.sala.values.Capacidad;

import java.util.Set;

public class SalaCreada extends DomainEvent {
    private final Capacidad capacidad;
    private final Set<Silla> sillas;

    public SalaCreada(Capacidad capacidad, Set<Silla> sillas) {
        super("org.example.cinema.sala.SalaCreada");
        this.capacidad = capacidad;
        this.sillas = sillas;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }

    public Set<Silla> getSillas() {
        return sillas;
    }
}
