package org.example.cinema.sucursal;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.factura.values.Nombre;
import org.example.cinema.sucursal.entities.Fila;
import org.example.cinema.sucursal.entities.Pantalla;
import org.example.cinema.sucursal.entities.Taquilla;
import org.example.cinema.sucursal.entities.Taquillero;
import org.example.cinema.sucursal.events.*;
import org.example.cinema.sucursal.values.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Sucursal extends AggregateEvent<SucursalId> {
    protected NombreSucursal nombreSucursal;
    protected Direccion direccion;
    protected Set<Pantalla> pantallas;
    protected Set<Fila> filas;
    protected Set<Taquilla> taquillas;

    public Sucursal(SucursalId entityId, NombreSucursal nombreSucursal, Direccion direccion) {
        super(entityId);
        appendChange(new SucursalCreada(nombreSucursal, direccion)).apply();
    }

    private Sucursal(SucursalId sucursalId){
        super(sucursalId);
        subscribe(new SucursalChange(this));
    }

    public static Sucursal from(SucursalId sucursalId, List<DomainEvent> events){
        var sucursal = new Sucursal(sucursalId);
        events.forEach(sucursal::applyEvent);
        return sucursal;
    }

    public void agregarPantalla(PantallaId entityId, Estado estado){
        appendChange(new PantallaAgregada(entityId, estado)).apply();
    }

    public void agregarFila(FilaId entityId, TipoDeFila tipoDeFila){
        appendChange(new FilaAgregada(entityId, tipoDeFila)).apply();
    }

    public void cambiarNombre(Nombre nombre){
        appendChange(new NombreCambiado(nombre)).apply();
    }

    public void agregarTaquilla(TaquillaId entityId, Taquillero taquillero){
        appendChange(new TaquillaCreada(entityId, taquillero)).apply();
    }

    private Optional<Pantalla> getPantallaPorId(PantallaId pantallaId){
        return pantallas
                .stream()
                .filter(pantalla -> pantalla.identity().equals(pantallaId))
                .findFirst();
    }

    private Optional<Fila> getFilaPorId(FilaId filaId){
        return filas
                .stream()
                .filter(fila -> fila.identity().equals(filaId))
                .findFirst();
    }

    private Optional<Taquilla> getTaquillaPorId(TaquillaId taquillaId){
        return taquillas
                .stream()
                .filter(taquilla -> taquilla.identity().equals(taquillaId))
                .findFirst();
    }

    public NombreSucursal nombreSucursal() {
        return nombreSucursal;
    }

    public Direccion direccion() {
        return direccion;
    }
}
