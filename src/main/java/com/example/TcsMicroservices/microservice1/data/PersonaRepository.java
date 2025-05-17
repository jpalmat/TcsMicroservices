package com.example.TcsMicroservices.microservice1.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
}
