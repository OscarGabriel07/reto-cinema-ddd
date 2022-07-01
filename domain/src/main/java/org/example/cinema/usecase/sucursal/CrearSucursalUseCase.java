package org.example.cinema.usecase.sucursal;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.cinema.sucursal.Sucursal;
import org.example.cinema.sucursal.commands.CrearSucursal;

public class CrearSucursalUseCase extends UseCase<RequestCommand<CrearSucursal>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearSucursal> crearSucursalRequestCommand) {

        var command = crearSucursalRequestCommand.getCommand();
        var sucursal = new Sucursal(command.getEntityId(), command.getNombreSucursal(), command.getDireccion());

        emit().onResponse(new ResponseEvents(sucursal.getUncommittedChanges()));
    }
}
