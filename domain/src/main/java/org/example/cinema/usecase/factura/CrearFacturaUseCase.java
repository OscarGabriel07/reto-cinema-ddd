package org.example.cinema.usecase.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.cinema.factura.Factura;
import org.example.cinema.factura.commands.CrearFactura;

public class CrearFacturaUseCase extends UseCase<RequestCommand<CrearFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearFactura> crearFacturaRequestCommand) {

        var command = crearFacturaRequestCommand.getCommand();
        var factura = new Factura(command.getEntityId(), command.getSucursalId(), command.getCliente());

        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
