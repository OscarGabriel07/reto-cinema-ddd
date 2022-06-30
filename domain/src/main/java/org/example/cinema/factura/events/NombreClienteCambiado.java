package org.example.cinema.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.factura.entities.Cliente;
import org.example.cinema.factura.values.Nombre;

public class NombreClienteCambiado extends DomainEvent {
    private final Cliente cliente;
    private final Nombre nombre;

    public NombreClienteCambiado(Cliente cliente, Nombre nombre) {
        super("org.example.cinema.NombreClienteCambiado");
        this.cliente = cliente;
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
