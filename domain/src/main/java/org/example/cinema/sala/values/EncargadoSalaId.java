package org.example.cinema.sala.values;

import co.com.sofka.domain.generic.Identity;

public class EncargadoSalaId extends Identity {

    public EncargadoSalaId(){

    }

    private EncargadoSalaId(String id){
        super(id);
    }

    public static EncargadoSalaId of(String id){
        return new EncargadoSalaId(id);
    }

}
