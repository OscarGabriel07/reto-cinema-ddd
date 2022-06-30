package org.example.cinema.usecase.factura;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.factura.Factura;
import org.example.cinema.factura.commands.CrearFactura;
import org.example.cinema.factura.entities.Cliente;
import org.example.cinema.factura.events.FacturaCreada;
import org.example.cinema.factura.values.ClienteId;
import org.example.cinema.factura.values.Direccion;
import org.example.cinema.factura.values.FacturaId;
import org.example.cinema.factura.values.Nombre;
import org.example.cinema.sucursal.values.SucursalId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CrearFacturaUseCaseTest {

    @Test
    void crearNuevaFactura(){

        //arrange
        var id = new FacturaId();
        var sucursalId = SucursalId.of("Sucursal1");
        var cliente = new Cliente(ClienteId.of("Cliente1"), new Nombre("Pepito Pérez"), new Direccion("Calle 5 22 - 32"));

        var command = new CrearFactura(id, sucursalId, cliente);

        var useCase = new CrearFacturaUseCase();

        //act
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        FacturaCreada event = (FacturaCreada) events.get(0);

        Assertions.assertEquals(SucursalId.of("Sucursal1"), event.getSucursalId());
        Assertions.assertEquals(new Cliente(ClienteId.of("Cliente1"), new Nombre("Pepito Pérez"), new Direccion("Calle 5 22 - 32")), event.getCliente());
    }

}