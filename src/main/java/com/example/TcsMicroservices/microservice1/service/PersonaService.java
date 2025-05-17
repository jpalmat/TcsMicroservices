package com.example.TcsMicroservices.microservice1.service;

import java.util.List;


import com.example.TcsMicroservices.microservice1.data.Persona;

public interface PersonaService {
    List<Persona> getPersonas();
    void addPersona(Persona persona);
    boolean deletePersona(Long id);
    boolean updatePersona(Long id, Persona companies_updated);
}
