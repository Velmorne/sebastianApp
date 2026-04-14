package com.example.SebastianApp.repositorios;

import com.example.SebastianApp.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface IRepositorioReserva extends JpaRepository<Reserva, UUID> {
}
