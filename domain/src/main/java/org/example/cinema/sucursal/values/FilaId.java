package org.example.cinema.sucursal.values;

import co.com.sofka.domain.generic.Identity;

public class FilaId extends Identity {

    public FilaId(){

    }

    private FilaId(String id){
        super(id);
    }

    public static FilaId of(String id){
        return new FilaId(id);
    }

}
