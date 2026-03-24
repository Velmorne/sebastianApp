package com.example.SebastianApp.repositorios;

import com.example.SebastianApp.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IRepositorioReserva extends JpaRepository<Reserva, UUID> {
}
