package org.example.cinema.factura.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.cinema.factura.values.ClienteId;
import org.example.cinema.factura.values.Direccion;
import org.example.cinema.factura.values.Nombre;

import java.util.Objects;

public class Cliente extends Entity<ClienteId> {

    private Nombre nombre;
    private Direccion direccion;

    public Cliente(ClienteId entityId, Nombre nombre, Direccion direccion) {
        super(entityId);
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public void cambiarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void cambiarDireccion(Direccion direccion){
        this.direccion = Objects.requireNonNull(direccion);
    }

    public Nombre nombre() {
        return nombre;
    }

    public Direccion direccion() {
        return direccion;
    }

}
