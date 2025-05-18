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

import com.example.TcsMicroservices.microservice1.data.Cliente;
import com.example.TcsMicroservices.microservice1.service.PersonaService;

@RestController
@RequestMapping("/clientes")
public class PersonaController {

    private PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getCliente() {
        return new ResponseEntity<>(this.personaService.getClientes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCliente(@RequestBody Cliente persona) {
        this.personaService.addCliente(persona);
        return new ResponseEntity<>("Cliente added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        boolean deleted = this.personaService.deleteCliente(id);
        if (!deleted) {
            return new ResponseEntity<>("Cliente not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Cliente deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCliente(@PathVariable Long id, @RequestBody Cliente personaUpdated) {
        boolean updated = this.personaService.updateCliente(id, personaUpdated);
        if (!updated) {
            return new ResponseEntity<>("Cliente not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Cliente updated successfully", HttpStatus.OK);
    }
}
