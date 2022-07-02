package org.example.cinema.usecase.sucursal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sucursal.Sucursal;
import org.example.cinema.sucursal.commands.AgregarTaquilla;
import org.example.cinema.sucursal.entities.Taquillero;
import org.example.cinema.sucursal.events.SucursalCreada;
import org.example.cinema.sucursal.events.TaquillaAgregada;
import org.example.cinema.sucursal.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarTaquillaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AgregarTaquillaUseCase useCase;

    @Test
    void agregarTaquillaASucursal(){

        //arrange
        var sucursalId = new SucursalId();
        var command = new AgregarTaquilla(sucursalId, TaquillaId.of("Taq1234"), new Taquillero(new TaquilleroId(), new Edad(23), new FechaIncorporacion(3, 5, 20), new NombreTaquillero("Brayan Pérez")));
        when(repository.getEventsBy(sucursalId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (TaquillaAgregada) events.get(0);
        Assertions.assertEquals(TaquillaId.of("Taq1234"), event.getEntityId());


    }

    private List<DomainEvent> history() {
        var sucuralId = new SucursalId();
        var nombreSucursal = new NombreSucursal("Sucursal del norte");
        var direccion = new Direccion("Calle 5 14 - 34");
        return List.of(
                new SucursalCreada(sucuralId, nombreSucursal, direccion)
        );
    }

}