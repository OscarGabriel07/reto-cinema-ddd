package org.example.cinema.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.factura.entities.Cliente;

public class ClienteCambiado extends DomainEvent {
    private final Cliente cliente;

    public ClienteCambiado(Cliente cliente) {
        super("org.example.cinema.ClienteCambiado");
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
