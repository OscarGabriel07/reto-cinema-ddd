package org.example.cinema.sala.values;

import co.com.sofka.domain.generic.Identity;

public class SillaId extends Identity {

    public SillaId(){

    }

    private SillaId(String id){
        super(id);
    }

    public static SillaId of(String id){
        return new SillaId(id);
    }
}
