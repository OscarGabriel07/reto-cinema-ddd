package org.example.cinema.sucursal.values;

import co.com.sofka.domain.generic.Identity;

public class SucursalId extends Identity {

    public SucursalId(){

    }

    private SucursalId(String id){
        super(id);
    }

    public static SucursalId of(String id){
        return new SucursalId(id);
    }

}
