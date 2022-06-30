package org.example.cinema.usecase.sucursal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sala.commands.CrearSala;
import org.example.cinema.sala.entities.Silla;
import org.example.cinema.sala.events.SalaCreada;
import org.example.cinema.sala.values.Anchura;
import org.example.cinema.sala.values.Capacidad;
import org.example.cinema.sala.values.SalaId;
import org.example.cinema.sala.values.SillaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CrearSalaUseCaseTest {

    @Test
    void crearNuevaSala(){

        //arrange
        var id = new SalaId();
        var capacidad = new Capacidad(25);
        Set<Silla> sillas = new HashSet<>();

        var command = new CrearSala(id, capacidad, sillas);

        var useCase = new SalaCreadaUseCase();

        //act
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        SalaCreada event = (SalaCreada) events.get(0);

        Assertions.assertEquals(25, event.getCapacidad().value());
        Assertions.assertEquals(sillas, event.getSillas());
    }

}