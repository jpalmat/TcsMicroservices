package com.example.TcsMicroservices.microservice1.service;

import java.util.List;

import com.example.TcsMicroservices.microservice1.data.Cliente;

public interface PersonaService {
    List<Cliente> getClientes();
    void addCliente(Cliente cliente);
    boolean deleteCliente(Long id);
    boolean updateCliente(Long id, Cliente cliente_updated);
}
