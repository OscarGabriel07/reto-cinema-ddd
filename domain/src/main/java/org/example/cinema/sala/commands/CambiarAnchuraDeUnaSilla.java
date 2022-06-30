package org.example.cinema.sala.commands;

import co.com.sofka.domain.generic.Command;
import org.example.cinema.sala.values.Anchura;
import org.example.cinema.sala.values.SalaId;
import org.example.cinema.sala.values.SillaId;

public class CambiarAnchuraDeUnaSilla extends Command{

    private final SalaId salaId;
    private final SillaId sillaId;
    private final Anchura anchura;

    public CambiarAnchuraDeUnaSilla(SalaId salaId, SillaId sillaId, Anchura anchura){

        this.salaId = salaId;
        this.sillaId = sillaId;
        this.anchura = anchura;
    }

    public SalaId getSalaId() {
        return salaId;
    }

    public SillaId getSillaId() {
        return sillaId;
    }

    public Anchura getAnchura() {
        return anchura;
    }
}
