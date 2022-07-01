package org.example.cinema.usecase.sucursal;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.cinema.sucursal.Sucursal;
import org.example.cinema.sucursal.commands.AgregarPantalla;

public class AgregarPantallaUseCase extends UseCase<RequestCommand<AgregarPantalla>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPantalla> agregarPantallaRequestCommand) {

        var command = agregarPantallaRequestCommand.getCommand();
        var sucursal = Sucursal.from(
                command.getSucursalId(), repository().getEventsBy(command.getSucursalId().value())
        );

        sucursal.agregarPantalla(command.getEntityId(), command.getEstado());

        emit().onResponse(new ResponseEvents(sucursal.getUncommittedChanges()));
    }
}
