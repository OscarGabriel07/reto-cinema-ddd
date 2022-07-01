package org.example.cinema.usecase.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.cinema.sala.Sala;
import org.example.cinema.sala.commands.ActualizarNombreDeEncargadoDeSala;

public class ActualizarNombreDeEncargadoDeSalaUseCase extends UseCase<RequestCommand<ActualizarNombreDeEncargadoDeSala>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreDeEncargadoDeSala> actualizarNombreDeEncargadoDeSalaRequestCommand) {

        var command = actualizarNombreDeEncargadoDeSalaRequestCommand.getCommand();
        var sala = Sala.from(
                command.getSalaId(), repository().getEventsBy(command.getSalaId().value())
        );

        sala.actualizarNombreDeEncargadoDeSala(command.getEncargadoSalaId(), command.getNombre());

        emit().onResponse(new ResponseEvents(sala.getUncommittedChanges()));
    }
}
