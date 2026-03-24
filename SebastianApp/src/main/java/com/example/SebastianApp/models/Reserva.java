package com.example.SebastianApp.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table (name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime fechas;
    private String tiempos;

    public Reserva() {
    }

    public Reserva(UUID id, LocalDateTime fechas, String tiempos) {
        this.id = id;
        this.fechas = fechas;
        this.tiempos = tiempos;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getFechas() {
        return fechas;
    }

    public void setFechas(LocalDateTime fechas) {
        this.fechas = fechas;
    }

    public String getTiempos() {
        return tiempos;
    }

    public void setTiempos(String tiempos) {
        this.tiempos = tiempos;
    }
}