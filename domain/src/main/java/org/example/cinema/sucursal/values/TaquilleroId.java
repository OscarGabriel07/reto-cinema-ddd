package org.example.cinema.sucursal.values;

import co.com.sofka.domain.generic.Identity;

public class TaquilleroId extends Identity {

    public TaquilleroId(){

    }

    private TaquilleroId(String id){
        super(id);
    }

    public static TaquilleroId of(String id){
        return new TaquilleroId(id);
    }

}
