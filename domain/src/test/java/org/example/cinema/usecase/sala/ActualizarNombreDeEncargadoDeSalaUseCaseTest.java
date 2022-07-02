package org.example.cinema.usecase.sala;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sala.commands.ActualizarNombreDeEncargadoDeSala;
import org.example.cinema.sala.entities.Silla;
import org.example.cinema.sala.events.EncargadoSalaAsignado;
import org.example.cinema.sala.events.NombreDeEncargadoDeSalaActualizado;
import org.example.cinema.sala.events.SalaCreada;
import org.example.cinema.sala.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarNombreDeEncargadoDeSalaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    ActualizarNombreDeEncargadoDeSalaUseCase useCase;

    @Test
    void actualizarNombreDelEncargadoDeLaSala(){

        //arrange
        var salaId = SalaId.of("sss");
        var command = new ActualizarNombreDeEncargadoDeSala(salaId, new EncargadoSalaId(), new Nombre("Camilo Sánchez"));
        when(repository.getEventsBy(salaId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (NombreDeEncargadoDeSalaActualizado) events.get(0);
        Assertions.assertEquals("Camilo Sánchez", event.getNombre().value());

    }

    private List<DomainEvent> history() {
        var capacidad = new Capacidad(30);
        Set<Silla> sillas = new HashSet<>();

        var encargadoSalaId = EncargadoSalaId.of("eee");
        var edad = new Edad(25);
        var fechaIncorporacion = new FechaIncorporacion(12, 7, 20);
        var nombre = new Nombre("Pablo Gómez");

        return List.of(
                new SalaCreada(capacidad, sillas),
                new EncargadoSalaAsignado(encargadoSalaId, edad, fechaIncorporacion, nombre)
        );
    }

}