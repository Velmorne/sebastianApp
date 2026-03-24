package com.example.SebastianApp.repositorios;

import com.example.SebastianApp.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IRepositorioUsuario extends JpaRepository<Usuario, UUID> {
}
