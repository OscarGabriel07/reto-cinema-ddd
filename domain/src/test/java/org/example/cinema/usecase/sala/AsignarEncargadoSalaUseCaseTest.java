package org.example.cinema.usecase.sala;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sala.commands.AsignarEncargadoSala;
import org.example.cinema.sala.entities.Silla;
import org.example.cinema.sala.events.EncargadoSalaAsignado;
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
class AsignarEncargadoSalaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AsignarEncargadoSalaUseCase useCase;

    @Test
    void asignarEncargadoDeSala(){

        //arrange
        var salaId = new SalaId();
        var command = new AsignarEncargadoSala(salaId, new EncargadoSalaId(), new Edad(20), new FechaIncorporacion(15, 3, 22), new Nombre("Carlos Gómez"));
        when(repository.getEventsBy(salaId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (EncargadoSalaAsignado) events.get(0);
        Assertions.assertEquals(20, event.getEdad().value());
        Assertions.assertEquals("Carlos Gómez", event.getNombre().value());

    }

    private List<DomainEvent> history() {
        var capacidad = new Capacidad(30);
        Set<Silla> sillas = new HashSet<>();
        return List.of(
                new SalaCreada(capacidad, sillas)
        );
    }

}