package org.example.cinema.usecase.sala;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.cinema.sala.commands.AsignarPelicula;
import org.example.cinema.sala.entities.Silla;
import org.example.cinema.sala.events.PeliculaAsignada;
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
class AsignarPeliculaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AsignarPeliculaUseCase useCase;

    @Test
    void AsignarPeliculaASala(){

        //arrange
        var salaId = new SalaId();
        var command = new AsignarPelicula(salaId, new PeliculaId(), new Genero("Terror"), new Idioma("Inglés"), new Duracion(98));
        when(repository.getEventsBy(salaId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (PeliculaAsignada)events.get(0);
        Assertions.assertEquals("Terror", event.getGenero().value());
    }

    private List<DomainEvent> history() {
        var capacidad = new Capacidad(40);
        Set<Silla> sillas = new HashSet<>();
        return List.of(
                new SalaCreada(capacidad, sillas)
        );
    }

}