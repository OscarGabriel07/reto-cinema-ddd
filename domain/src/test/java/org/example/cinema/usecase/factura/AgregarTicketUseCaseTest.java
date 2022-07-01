package org.example.cinema.usecase.factura;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.factura.commands.AgregarTicket;
import org.example.cinema.factura.entities.Cliente;
import org.example.cinema.factura.entities.Ticket;
import org.example.cinema.factura.events.FacturaCreada;
import org.example.cinema.factura.events.TicketAgregado;
import org.example.cinema.factura.values.*;
import org.example.cinema.sucursal.values.SucursalId;
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
class AgregarTicketUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AgregarTicketUseCase useCase;

    @Test
    void agregarTicketFactura(){

        //arrange
        var facturaId = FacturaId.of("fff");
        var command = new AgregarTicket(facturaId, TicketId.of("ttt"), new Descripcion("Boletos Rapido y Furioso"), new Valor(29000), new FechaImpresion("01/07/2022"));
        when(repository.getEventsBy(facturaId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (TicketAgregado) events.get(0);
        Assertions.assertEquals(29000, event.getValor().value());

    }

    private List<DomainEvent> history() {
        var sucursalId = SucursalId.of("sss");
        var cliente = new Cliente(ClienteId.of("ccc"), new Nombre("Paco López"), new Direccion("Calle 1 23-45"));
        return List.of(
                new FacturaCreada(sucursalId, cliente)
        );
    }

}