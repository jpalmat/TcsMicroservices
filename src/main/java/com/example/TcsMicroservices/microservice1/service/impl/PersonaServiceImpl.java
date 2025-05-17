package com.example.TcsMicroservices.microservice1.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.TcsMicroservices.microservice1.data.Persona;
import com.example.TcsMicroservices.microservice1.data.PersonaRepository;
import com.example.TcsMicroservices.microservice1.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {
    PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }


    int count = 0;
    @Override
    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public void addPersona(Persona personas) {
        personaRepository.save(personas);
    }

    @Override
    public boolean deletePersona(Long id) {
        try {
        personaRepository.deleteById(id);
        return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updatePersona(Long id, Persona persona_updated) {

        Optional<Persona> companiesOptional = personaRepository.findById(id);
        if(companiesOptional.isPresent()) {
            Persona personas = companiesOptional.get();
            personas.setName(persona_updated.getName());
            personaRepository.save(personas);
            return true;
        }
        return false;
    }    
}
