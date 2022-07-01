package org.example.cinema.usecase.factura;

import co.com.sofka.business.repository.DomainEventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ActualizarDescripcionTicketUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    ActualizarDescripcionTicketUseCase useCase;

    @Test
    void actualizarDescripcionTicket(){

    }

}