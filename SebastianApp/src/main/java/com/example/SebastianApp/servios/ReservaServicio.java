package com.example.SebastianApp.servios;

import com.example.SebastianApp.models.Reserva;
import com.example.SebastianApp.repositorios.IRepositorioReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReservaServicio {
    @Autowired
    private IRepositorioReserva iRepositorioReserva;
    public boolean guardarReservaEnDB(Reserva datos){
        // Validar que datos me envian y si estos cummplen las reglas de negocio
        //Guardar los datos en DB con ayuda del repositorio
        return false;
    }
    public boolean modificarReservaEnDB(Reserva datos, UUID id){
        // Validar que datos me envian y si estos cummplen las reglas de negocio
        //Guardar los datos en DB con ayuda del repositorio
        return false;
    }
    public boolean editarReservaEnDB(UUID id){
        // Buscar y validar si el ID que me envian existe
        //Elimino el regitro en DB
        return false;
    }
    public boolean buscarReservaEnDB(){
        //Dependiendo del parametro de busqueda dado implementar validaciones
        // devuelvo los usuarios que encuentre en DB
        return false;
    }
}
