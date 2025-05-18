package com.example.TcsMicroservices.microservice1.util;

import com.example.TcsMicroservices.microservice1.data.Cliente;
import com.example.TcsMicroservices.microservice1.dto.ClienteDTO;

public class ClienteMapperUtil {
    
    public static ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setCedula(cliente.getId());
        clienteDTO.setNombre(cliente.getName());
        clienteDTO.setGenero(cliente.getGender());
        clienteDTO.setEdad(cliente.getAge());
        clienteDTO.setDirection(cliente.getAddress());
        clienteDTO.setTelefono(cliente.getPhone());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setContrasenia(cliente.getPassword());
        clienteDTO.setEstadoCliente(cliente.getState());
        return clienteDTO;
    }

    public static Cliente toEntity(ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getCedula());
        cliente.setName(clienteDTO.getNombre());
        cliente.setGender(clienteDTO.getGenero());
        cliente.setAge(clienteDTO.getEdad());
        cliente.setAddress(clienteDTO.getDirection());
        cliente.setPhone(clienteDTO.getTelefono());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setPassword(clienteDTO.getContrasenia());
        cliente.setState(clienteDTO.getEstadoCliente());
        return cliente;
    }
}
