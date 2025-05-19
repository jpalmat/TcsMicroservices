package com.example.TcsMicroservices.microservice1.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.TcsMicroservices.microservice1.data.Cliente;
import com.example.TcsMicroservices.microservice1.data.PersonaRepository;
import com.example.TcsMicroservices.microservice1.dto.ClienteDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonaRepository clienteRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        clienteRepository.deleteAll();
    }

    /**
     F6: Pruebas de Integración: Implementar 1 prueba de integración.
     */
    @Test
    void createCliente_shouldReturnCreatedClienteAndStatusCreated() throws Exception {
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

        String json = objectMapper.writeValueAsString(cliente1);

        mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(System.out::println);

        Cliente savedCliente = clienteRepository.findAll().get(0);
        assertEquals("Jose Lema", savedCliente.getName());
    }
}