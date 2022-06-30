package org.example.cinema.sucursal.values;

import co.com.sofka.domain.generic.Identity;

public class TaquillaId extends Identity {

    public TaquillaId(){

    }

    private TaquillaId(String id){
        super(id);
    }

    public static TaquillaId of(String id){
        return new TaquillaId(id);
    }

}
