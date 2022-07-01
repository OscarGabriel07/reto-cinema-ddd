package org.example.cinema.usecase.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.cinema.sala.Sala;
import org.example.cinema.sala.commands.AsignarPelicula;

public class AsignarPeliculaUseCase extends UseCase<RequestCommand<AsignarPelicula>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarPelicula> asignarPeliculaRequestCommand) {

        var command = asignarPeliculaRequestCommand.getCommand();
        var sala = Sala.from(
                command.getSalaId(), repository().getEventsBy(command.getSalaId().value())
        );

        sala.asignarPelicula(command.getEntityId(), command.getGenero(), command.getIdioma(), command.getDuracion());

        emit().onResponse(new ResponseEvents(sala.getUncommittedChanges()));

    }
}
