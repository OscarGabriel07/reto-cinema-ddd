package org.example.cinema.usecase.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.cinema.sala.Sala;
import org.example.cinema.sala.commands.CrearSala;

public class CrearSalaUseCase extends UseCase<RequestCommand<CrearSala>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearSala> crearSalaRequestCommand) {

        var command = crearSalaRequestCommand.getCommand();
        var sala = new Sala(command.getEntityId(), command.getCapacidad(), command.getSillas());

        emit().onResponse(new ResponseEvents(sala.getUncommittedChanges()
        ));
    }
}
