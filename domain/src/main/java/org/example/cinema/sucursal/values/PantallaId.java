package org.example.cinema.sucursal.values;

import co.com.sofka.domain.generic.Identity;

public class PantallaId extends Identity {

    public PantallaId(){

    }

    private PantallaId(String id){
        super(id);
    }

    public static PantallaId of(String id){
        return new PantallaId(id);
    }

}
