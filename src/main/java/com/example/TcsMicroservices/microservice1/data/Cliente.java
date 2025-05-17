package com.example.TcsMicroservices.microservice1.data;

import jakarta.persistence.Entity;

@Entity
public class Cliente extends Persona {
    private String email;
    private String password;
    private String state;

    public Cliente() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
}
