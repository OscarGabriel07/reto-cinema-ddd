package org.example.cinema.sala.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.sala.values.EncargadoSalaId;
import org.example.cinema.sala.values.Nombre;
import org.example.cinema.sala.values.SalaId;

public class ActualizarNombreDeEncargadoDeSala extends Command {

    private final SalaId salaId;
    private final EncargadoSalaId encargadoSalaId;
    private final Nombre nombre;

    public ActualizarNombreDeEncargadoDeSala(SalaId salaId, EncargadoSalaId encargadoSalaId, Nombre nombre) {
        this.salaId = salaId;
        this.encargadoSalaId = encargadoSalaId;
        this.nombre = nombre;
    }

    public SalaId getSalaId() {
        return salaId;
    }

    public EncargadoSalaId getEncargadoSalaId() {
        return encargadoSalaId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
