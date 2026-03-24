package com.example.SebastianApp.servios;

import com.example.SebastianApp.models.Espacio;
import com.example.SebastianApp.repositorios.IRepositorioEspacio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EspacioServicio {
    @Autowired
    private IRepositorioEspacio repositorioEspacio;

    private boolean guardarEspacioEnDB(Espacio datos){
        // Validar que datos me envian y si estos cummplen las reglas de negocio
        //Guardar los datos en DB con ayuda del repositorio
        return false;
    }
    private boolean modificarEspacioEnDB(Espacio datos, UUID id){
        // Validar que datos me envian y si estos cummplen las reglas de negocio
        //Guardar los datos en DB con ayuda del repositorio
        return false;
    }
    private boolean eliminarEspacioEnDB(UUID id){
        // Buscar y validar si el ID que me envian existe
        //Elimino el regitro en DB
        return false;
    }
    private boolean buscarEspacioEnDB(){
        //Dependiendo del parametro de busqueda dado implementar validaciones
        // devuelvo los usuarios que encuentre en DB
        return false;}

}
