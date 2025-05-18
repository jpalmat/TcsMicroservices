package com.example.TcsMicroservices.microservice1.service;

import java.util.List;

import com.example.TcsMicroservices.microservice1.dto.ClienteDTO;

public interface PersonaService {
    List<ClienteDTO> getClientes();
    ClienteDTO getClienteById(Long id);
    void addCliente(ClienteDTO cliente);
    void deleteCliente(Long id);
    void updateCliente(Long id, ClienteDTO cliente_updated);
}
