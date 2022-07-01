package org.example.cinema.usecase.sucursal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sucursal.Sucursal;
import org.example.cinema.sucursal.commands.CrearSucursal;
import org.example.cinema.sucursal.events.SucursalCreada;
import org.example.cinema.sucursal.values.Direccion;
import org.example.cinema.sucursal.values.NombreSucursal;
import org.example.cinema.sucursal.values.SucursalId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CrearSucursalUseCaseTest {

    @Test
    void crearNuevaSucursal(){

        //arrange
        var id = new SucursalId();
        var nombre = new NombreSucursal("Plaza de las Américas");
        var direccion = new Direccion("Avenida Primero de Mayo 78 - 34");

        var command = new CrearSucursal(id, nombre, direccion);

        var useCase = new CrearSucursalUseCase();

        //act
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        SucursalCreada event = (SucursalCreada) events.get(0);
        Assertions.assertEquals("Plaza de las Américas", event.getNombreSucursal().value());
        Assertions.assertEquals("Avenida Primero de Mayo 78 - 34", event.getDireccion().value());
    }

}