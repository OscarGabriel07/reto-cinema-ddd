package org.example.cinema.factura.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.cinema.factura.values.Descripcion;
import org.example.cinema.factura.values.FechaImpresion;
import org.example.cinema.factura.values.TicketId;
import org.example.cinema.factura.values.Valor;

import java.util.Objects;

public class Ticket extends Entity<TicketId>{

    private Descripcion descripcion;
    private Valor valor;
    private FechaImpresion fechaImpresion;

    public Ticket(TicketId entityId, Descripcion descripcion, Valor valor, FechaImpresion fechaImpresion) {
        super(entityId);
        this.descripcion = descripcion;
        this.valor = valor;
        this.fechaImpresion = fechaImpresion;
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public void modificarValor(Valor valor){
        this.valor = Objects.requireNonNull(valor);
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Valor valor() {
        return valor;
    }

    public FechaImpresion fechaImpresion() {
        return fechaImpresion;
    }

}
