package org.example.cinema.sucursal.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.cinema.sucursal.values.Estado;
import org.example.cinema.sucursal.values.PantallaId;

public class Pantalla extends Entity<PantallaId> {
    private Estado estado;

    public Pantalla(PantallaId entityId, Estado estado) {
        super(entityId);
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void cambiarEstado(Estado estado){
        this.estado = estado;
    }
}
