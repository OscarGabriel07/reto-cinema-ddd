package org.example.cinema.usecase.sucursal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sucursal.commands.CambiarNombre;
import org.example.cinema.sucursal.events.NombreCambiado;
import org.example.cinema.sucursal.events.SucursalCreada;
import org.example.cinema.sucursal.values.Direccion;
import org.example.cinema.sucursal.values.NombreSucursal;
import org.example.cinema.sucursal.values.SucursalId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarNombreUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarNombreUseCase useCase;

    @Test
    void cambiarNombreSucursal(){

        SucursalId sucursalId = SucursalId.of("1");
        NombreSucursal nombreSucursal = new NombreSucursal("Plaza Central");
        var command = new CambiarNombre(sucursalId, nombreSucursal);
        when(repository.getEventsBy(sucursalId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (NombreCambiado) events.get(0);
        Assertions.assertEquals("Plaza Central", event.getNombre().value());
    }

    private List<DomainEvent> history() {
        SucursalId sucursalId = SucursalId.of("1");
        NombreSucursal nombreSucursal = new NombreSucursal("Plaza de las Américas");
        Direccion direccion = new Direccion("Avenida Primero de Mayo 78 - 34");

        return List.of(
                new SucursalCreada(sucursalId, nombreSucursal, direccion)
        );
    }

}