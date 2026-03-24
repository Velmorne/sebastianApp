package com.example.SebastianApp.servios;

import com.example.SebastianApp.models.Usuario;
import com.example.SebastianApp.repositorios.IRepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioServicio {

    //Intectando una dependencia al repositorio
    @Autowired
    private IRepositorioUsuario repositorioUsuario;

    public boolean guardarUsuarioEnDB(Usuario datos){
        // Validar que datos me envian y si estos cummplen las reglas de negocio
        //Guardar los datos en DB con ayuda del repositorio
        return false;
    }
    public boolean modificarUsuariioEnDB(Usuario datos, UUID id){
        // Validar que datos me envian y si estos cummplen las reglas de negocio
        //Guardar los datos en DB con ayuda del repositorio
        return false;
    }
    public boolean eliminarUsuarioEnDB(UUID id){
        // Buscar y validar si el ID que me envian existe
        //Elimino el regitro en DB
        return false;
    }
    public boolean buscarUsuarioEnDB(){
        //Dependiendo del parametro de busqueda dado implementar validaciones
        // devuelvo los usuarios que encuentre en DB
        return false;
    }
}
