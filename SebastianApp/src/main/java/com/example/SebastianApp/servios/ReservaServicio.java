package com.example.SebastianApp.servios;

import com.example.SebastianApp.models.Reserva;
import com.example.SebastianApp.repositorios.IRepositorioReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservaServicio {
    @Autowired
    private IRepositorioReserva iRepositorioReserva;
    public Reserva guardarReservaEnDB(Reserva datos) {
        // Validar que datos me envian y si estos cummplen las reglas de negocio
        //Guardar los datos en DB con ayuda del repositorio
        if(datos.getTiempos().isEmpty()||datos.getTiempos().isBlank()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Ingrese un tiempo valido"
            );
        }
        if (datos.getFechas() == null){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Ingresa una contraseña valida"
            );
        }
        return this.iRepositorioReserva.save(datos);
    }

    public Reserva modificarReservaEnDB(Reserva datos, UUID id){
        // Validar que datos me envian y si estos cummplen las reglas de negocio
        //Guardar los datos en DB con ayuda del repositorio
        Optional<Reserva> reserva_que_estoy_buscando=this.iRepositorioReserva.findById(id);
        if (reserva_que_estoy_buscando.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "La reserva que quieres editar, no existe en BD"
            );
        }
        Reserva reserva_que_encontre=reserva_que_estoy_buscando.get();

        //2. validar la informacion nueva que me manda el cliente
        if (datos.getTiempos().isEmpty() || datos.getTiempos().isBlank()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Revisa el tiempo ingresado"
            );
        }
        //3. Ejecutar el nuevo guardado y retornar
        reserva_que_encontre.setTiempos(datos.getTiempos());
        return this.iRepositorioReserva.save(reserva_que_encontre);
    }

    public boolean eliminarReservaEnDB(UUID id){
        // Buscar y validar si el ID que me envian existe
        //Elimino el regitro en DB
        Optional<Reserva>reserva_que_estoy_buscando=this.iRepositorioReserva.findById(id);
        if (reserva_que_estoy_buscando.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "La reserva que quieres eliminar, no existe en BD");
        }
        Reserva reserva_que_encontre=reserva_que_estoy_buscando.get();
        this.iRepositorioReserva.deleteById(id);

        return true;
    }

    public List<Reserva>  buscarReservaEnDB(){
        //Dependiendo del parametro de busqueda dado implementar validaciones
        // devuelvo los usuarios que encuentre en DB
        List<Reserva>horarioEncontrado=this.iRepositorioReserva.findAll();
     return horarioEncontrado;
    }
}