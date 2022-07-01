package org.example.cinema.usecase.sala;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.factura.commands.AgregarTicket;
import org.example.cinema.sala.commands.AsociarSucursal;
import org.example.cinema.sala.entities.Silla;
import org.example.cinema.sala.events.SalaCreada;
import org.example.cinema.sala.events.SucursalAsociada;
import org.example.cinema.sala.values.Capacidad;
import org.example.cinema.sala.values.SalaId;
import org.example.cinema.sucursal.events.SucursalCreada;
import org.example.cinema.sucursal.values.SucursalId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AsociarSucursalUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AsociarSucursalUseCase useCase;

    @Test
    void asociarSucursalASala(){

        //arrange
        var salaId = SalaId.of("sss");
        var command = new AsociarSucursal(salaId, SucursalId.of("sususu"));
        when(repository.getEventsBy(salaId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (SucursalAsociada) events.get(0);
        Assertions.assertEquals("sususu", event.getSucursalId().value());

    }

    private List<DomainEvent> history() {
        var capacidad = new Capacidad(30);
        Set<Silla> sillas = new HashSet<>();
        return List.of(
                new SalaCreada(capacidad, sillas)
        );
    }

}