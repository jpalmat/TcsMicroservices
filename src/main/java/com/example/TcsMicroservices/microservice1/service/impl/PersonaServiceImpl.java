package com.example.TcsMicroservices.microservice1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.TcsMicroservices.microservice1.data.Cliente;
import com.example.TcsMicroservices.microservice1.data.PersonaRepository;
import com.example.TcsMicroservices.microservice1.exceptions.NoClienteException;
import com.example.TcsMicroservices.microservice1.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {
    PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }


    int count = 0;
    @Override
    public List<Cliente> getClientes() {
        return personaRepository.findAll();
    }

    @Override
    public void addCliente(Cliente cliente) {
        personaRepository.save(cliente);
    }

    @Override
    public boolean deleteCliente(Long id) {
        try {
        personaRepository.deleteById(id);
        return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateCliente(Long id, Cliente cliente_updated) {

        Optional<Cliente> clienteOptional = personaRepository.findById(id);
        if(clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setName(cliente_updated.getName());
            cliente.setGender(cliente_updated.getGender());
            cliente.setAge(cliente_updated.getAge());
            cliente.setDirection(cliente_updated.getDirection());
            cliente.setPhone(cliente_updated.getPhone());
            cliente.setEmail(cliente_updated.getEmail());
            cliente.setPassword(cliente_updated.getPassword());
            cliente.setState(cliente_updated.getState());

            personaRepository.save(cliente);
            return true;
        }
        return false;
    }

    @Override
    public Cliente getClienteById(Long id) {
        Optional<Cliente> clienteOptional = personaRepository.findById(id);
        if(clienteOptional.isEmpty()) {
            throw new NoClienteException("Cliente with id " + id + "not found");
        }
        return clienteOptional.get();
    }
}
