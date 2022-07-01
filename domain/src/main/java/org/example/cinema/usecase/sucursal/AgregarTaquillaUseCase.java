package org.example.cinema.usecase.sucursal;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.cinema.sucursal.Sucursal;
import org.example.cinema.sucursal.commands.AgregarTaquilla;

public class AgregarTaquillaUseCase extends UseCase<RequestCommand<AgregarTaquilla>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarTaquilla> agregarTaquillaRequestCommand) {

        var command = agregarTaquillaRequestCommand.getCommand();
        var sucursal = Sucursal.from(
                command.getSucursalId(), repository().getEventsBy(command.getSucursalId().value())
        );

        sucursal.agregarTaquilla(command.getEntityId(), command.getTaquillero());

        emit().onResponse(new ResponseEvents(sucursal.getUncommittedChanges()));
    }
}
