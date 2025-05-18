package com.example.TcsMicroservices.microservice1.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.TcsMicroservices.microservice1.controler.PersonaController;
import com.example.TcsMicroservices.microservice1.data.Cliente;
import com.example.TcsMicroservices.microservice1.service.PersonaService;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {
    @InjectMocks
    private PersonaController clienteController;

    @Mock
    private PersonaService clienteService;

    @Test
    void getAllClientes_shouldReturnListOfClientesAndOkStatus() {
        // Arrange
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente1 = new Cliente();
        cliente1.setId(1234455678L);
        cliente1.setName("Jose Lema");
        cliente1.setGender("Masculino");
        cliente1.setAge(30);
        cliente1.setDirection("Otavalo sn y principal");
        cliente1.setPhone("098254785");
        cliente1.setEmail("test@gmail.com");
        cliente1.setPassword("1234");
        cliente1.setState("True");
        clientes.add(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setId(12344556789L);
        cliente2.setName("Marianela Montalvo");
        cliente2.setGender("Femenino");
        cliente2.setAge(25);
        cliente2.setDirection("Amazonas y NNUU");
        cliente2.setPhone("097548965");
        cliente2.setEmail("test1@gmail.com");
        cliente2.setPassword("5678");
        cliente2.setState("true");
        clientes.add(cliente2);

        when(clienteService.getClientes()).thenReturn(clientes);

        // Act
        ResponseEntity<List<Cliente>> response = clienteController.getAllClientes();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
    }

}