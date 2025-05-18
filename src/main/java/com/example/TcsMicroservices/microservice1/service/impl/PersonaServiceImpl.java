package com.example.TcsMicroservices.microservice1.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.TcsMicroservices.microservice1.data.Cliente;
import com.example.TcsMicroservices.microservice1.data.PersonaRepository;
import com.example.TcsMicroservices.microservice1.dto.ClienteDTO;
import com.example.TcsMicroservices.microservice1.exceptions.NoClienteException;
import com.example.TcsMicroservices.microservice1.service.PersonaService;
import com.example.TcsMicroservices.microservice1.util.ClienteMapperUtil;

@Service
public class PersonaServiceImpl implements PersonaService {
    PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }


    int count = 0;
    @Override
    public List<ClienteDTO> getClientes() {
        return personaRepository.findAll().stream()
        .map(cliente -> ClienteMapperUtil.toDTO(cliente))
        .collect(Collectors.toList());
    }

    @Override
    public void addCliente(ClienteDTO cliente) {
        personaRepository.save(ClienteMapperUtil.toEntity(cliente));
    }

    @Override
    public void deleteCliente(Long id) {
        Optional<Cliente> clienteOptional = personaRepository.findById(id);
        if(clienteOptional.isEmpty()) {
            throw new NoClienteException("Cliente with id " + id + " not found");
        }

        try {
            personaRepository.deleteById(id);
        } catch (Exception e) {
            throw new NoClienteException("Unable to delete Cliente with id " + id);
        }
    }

    @Override
    public void updateCliente(Long id, ClienteDTO cliente_updated) {

        Optional<Cliente> clienteOptional = personaRepository.findById(id);
        if(clienteOptional.isEmpty()) {
            throw new NoClienteException("Cliente with id " + id + " not found");
        }
        personaRepository.save(ClienteMapperUtil.toEntity(cliente_updated));
    }

    @Override
    public ClienteDTO getClienteById(Long id) {
        Optional<Cliente> clienteOptional = personaRepository.findById(id);
        if(clienteOptional.isEmpty()) {
            throw new NoClienteException("Cliente with id " + id + " not found");
        }
        return ClienteMapperUtil.toDTO(clienteOptional.get());
    }
}
