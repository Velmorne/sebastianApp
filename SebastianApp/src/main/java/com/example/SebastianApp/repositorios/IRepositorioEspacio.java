package com.example.SebastianApp.repositorios;

import com.example.SebastianApp.models.Espacio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IRepositorioEspacio extends JpaRepository<Espacio, UUID>{
}
