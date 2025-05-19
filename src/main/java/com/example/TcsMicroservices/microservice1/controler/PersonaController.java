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

import com.example.TcsMicroservices.microservice1.dto.ClienteDTO;
import com.example.TcsMicroservices.microservice1.service.PersonaService;

/**
 * F1: Generación de CRUDS (Crear, editar, actualizar y eliminar registros - Entidades: Cliente,
Cuenta y Movimiento).
Los nombres de los endpoints a generar son: /clientes
 */
@RestController
@RequestMapping("/clientes")
public class PersonaController {

    private PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        return new ResponseEntity<>(this.personaService.getClientes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id) {
        return new ResponseEntity<>(this.personaService.getClienteById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCliente(@RequestBody ClienteDTO persona) {
        this.personaService.addCliente(persona);
        return new ResponseEntity<>("Cliente added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        this.personaService.deleteCliente(id);
        return new ResponseEntity<>("Cliente deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO personaUpdated) {
        this.personaService.updateCliente(id, personaUpdated);
        return new ResponseEntity<>("Cliente updated successfully", HttpStatus.OK);
    }
}
