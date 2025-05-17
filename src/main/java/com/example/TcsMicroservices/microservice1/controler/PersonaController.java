package com.example.TcsMicroservices.microservice1.controler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TcsMicroservices.microservice1.data.Persona;
import com.example.TcsMicroservices.microservice1.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    private PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public ResponseEntity<List<Persona>> getPersonas() {
        return new ResponseEntity<>(this.personaService.getPersonas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addPersona(@RequestBody Persona persona) {
        this.personaService.addPersona(persona);
        return new ResponseEntity<>("Persona added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersona(@PathVariable Long id) {
        boolean deleted = this.personaService.deletePersona(id);
        if (!deleted) {
            return new ResponseEntity<>("Persona not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Persona deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePersona(@PathVariable Long id, @RequestBody Persona companiesUpdated) {
        boolean updated = this.personaService.updatePersona(id, companiesUpdated);
        if (!updated) {
            return new ResponseEntity<>("Persona not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Persona updated successfully", HttpStatus.OK);
    }
}
