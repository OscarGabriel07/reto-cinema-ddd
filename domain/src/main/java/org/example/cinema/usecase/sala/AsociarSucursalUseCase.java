package org.example.cinema.usecase.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.cinema.sala.Sala;
import org.example.cinema.sala.commands.AsociarSucursal;

public class AsociarSucursalUseCase extends UseCase<RequestCommand<AsociarSucursal>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsociarSucursal> asociarSucursalRequestCommand) {

        var command = asociarSucursalRequestCommand.getCommand();

        var sala = Sala.from(
                command.getSalaId(), repository().getEventsBy(command.getSalaId().value())
        );

        sala.asociarSucursal(command.getSucursalId());

        emit().onResponse(new ResponseEvents(sala.getUncommittedChanges()));

    }
}
