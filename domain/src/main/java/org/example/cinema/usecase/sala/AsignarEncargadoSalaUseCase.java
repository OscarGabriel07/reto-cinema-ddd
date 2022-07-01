package org.example.cinema.usecase.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.cinema.sala.Sala;
import org.example.cinema.sala.commands.AsignarEncargadoSala;

public class AsignarEncargadoSalaUseCase extends UseCase<RequestCommand<AsignarEncargadoSala>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarEncargadoSala> asignarEncargadoSalaRequestCommand) {

        var command = asignarEncargadoSalaRequestCommand.getCommand();
        var sala = Sala.from(
                command.getSalaId(), repository().getEventsBy(command.getSalaId().value())
        );

        sala.asignarEncargadoSala(command.getEntityId(), command.getEdad(), command.getFechaIncorporacion(), command.getNombre());

        emit().onResponse(new ResponseEvents(sala.getUncommittedChanges()));
    }
}
