package org.example.cinema.usecase.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.cinema.factura.Factura;
import org.example.cinema.factura.commands.ActualizarDescripcionDeUnTicket;

public class ActualizarDescripcionTicketUseCase extends UseCase<RequestCommand<ActualizarDescripcionDeUnTicket>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDescripcionDeUnTicket> actualizarDescripcionDeUnTicketRequestCommand) {

        var command = actualizarDescripcionDeUnTicketRequestCommand.getCommand();
        var factura = Factura.from(
                command.getFacturaId(), repository().getEventsBy(command.getFacturaId().value())
        );

        factura.actualizarDescripcionDeUnTicket(command.getTicketId(), command.getDescripcion());

        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
