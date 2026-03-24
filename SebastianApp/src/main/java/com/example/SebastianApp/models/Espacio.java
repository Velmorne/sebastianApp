package com.example.SebastianApp.models;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table (name = "espacio")
public class Espacio {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nombre;
    private String description;
    private String foto;
    private Integer aforo;

    public Espacio() {
    }

    public Espacio(UUID id, String nombre, String description, String foto, Integer aforo) {
        this.id = id;
        this.nombre = nombre;
        this.description = description;
        this.foto = foto;
        this.aforo = aforo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }
}
