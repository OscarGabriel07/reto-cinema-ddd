package org.example.cinema.usecase.sucursal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sucursal.commands.AgregarPantalla;
import org.example.cinema.sucursal.events.PantallaAgregada;
import org.example.cinema.sucursal.events.SucursalCreada;
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
class AgregarPantallaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AgregarPantallaUseCase useCase;

    @Test
    void agregarPantallaSucursal(){

        //arrange
        var sucursalId = new SucursalId();
        var command = new AgregarPantalla(sucursalId, new PantallaId(), new Estado(false));
        when(repository.getEventsBy(sucursalId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (PantallaAgregada) events.get(0);
        Assertions.assertEquals(false, event.getEstado().value());

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