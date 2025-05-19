package com.example.TcsMicroservices.microservice1.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.TcsMicroservices.microservice1.controler.PersonaController;
import com.example.TcsMicroservices.microservice1.dto.ClienteDTO;
import com.example.TcsMicroservices.microservice1.service.PersonaService;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {
    @InjectMocks
    private PersonaController clienteController;

    @Mock
    private PersonaService clienteService;

    /**
     F5: Pruebas unitarias: Implementar 1 prueba unitaria para la entidad de dominio Cliente.
     */
    @Test
    void getAllClientes_shouldReturnListOfClientesAndOkStatus() {
        List<ClienteDTO> clientes = new ArrayList<>();
        ClienteDTO cliente1 = new ClienteDTO();
        cliente1.setCedula(1234455678L);
        cliente1.setNombre("Jose Lema");
        cliente1.setGenero("Masculino");
        cliente1.setEdad(30);
        cliente1.setDirection("Otavalo sn y principal");
        cliente1.setTelefono("098254785");
        cliente1.setEmail("test@gmail.com");
        cliente1.setContrasenia("1234");
        cliente1.setEstadoCliente("True");
        clientes.add(cliente1);

        ClienteDTO cliente2 = new ClienteDTO();
        cliente2.setCedula(12344556789L);
        cliente2.setNombre("Marianela Montalvo");
        cliente2.setGenero("Femenino");
        cliente2.setEdad(25);
        cliente2.setDirection("Amazonas y NNUU");
        cliente2.setTelefono("097548965");
        cliente2.setEmail("test1@gmail.com");
        cliente2.setContrasenia("5678");
        cliente2.setEstadoCliente("true");
        clientes.add(cliente2);

        when(clienteService.getClientes()).thenReturn(clientes);

        ResponseEntity<List<ClienteDTO>> response = clienteController.getAllClientes();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
    }

}