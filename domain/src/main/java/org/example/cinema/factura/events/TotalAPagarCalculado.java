package org.example.cinema.factura.events;

import co.com.sofka.domain.generic.DomainEvent;

public class TotalAPagarCalculado extends DomainEvent {
    public TotalAPagarCalculado() {
        super("org.example.cinema.TotalAPagarCalculado");
    }
}
