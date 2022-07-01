package org.example.cinema.usecase.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.cinema.factura.Factura;
import org.example.cinema.factura.commands.AgregarTicket;

public class AgregarTicketUseCase extends UseCase<RequestCommand<AgregarTicket>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarTicket> agregarTicketRequestCommand) {

        var command = agregarTicketRequestCommand.getCommand();
        var factura = Factura.from(
                command.getFacturaId(), repository().getEventsBy(command.getFacturaId().value())
        );

        factura.agregarTicket(command.getEntityId(), command.getDescripcion(), command.getValor(), command.getFechaImpresion());

        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
