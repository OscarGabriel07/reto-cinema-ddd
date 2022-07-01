package org.example.cinema.usecase.sucursal;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.cinema.sucursal.Sucursal;
import org.example.cinema.sucursal.commands.CambiarNombre;

public class CambiarNombreUseCase extends UseCase<RequestCommand<CambiarNombre>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarNombre> cambiarNombreRequestCommand) {

        var command = cambiarNombreRequestCommand.getCommand();
        var sucursal = Sucursal.from(
                command.getSucursalId(), repository().getEventsBy(command.getSucursalId().value())
        );

        sucursal.cambiarNombreSucursal(command.getSucursalId(), command.getNombre());

        emit().onResponse(new ResponseEvents(sucursal.getUncommittedChanges()));

    }
}
