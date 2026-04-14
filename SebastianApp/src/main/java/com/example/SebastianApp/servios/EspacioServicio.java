package com.example.SebastianApp.servios;

import com.example.SebastianApp.models.Espacio;
import com.example.SebastianApp.repositorios.IRepositorioEspacio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EspacioServicio {
    @Autowired
    private IRepositorioEspacio repositorioEspacio;

    public Espacio guardarEspacioEnDB(Espacio datos){
        // Validar que datos me envian y si estos cummplen las reglas de negocio
        //Guardar los datos en DB con ayuda del repositorio
        if(datos.getDescription().isEmpty()||datos.getDescription().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Ingrese una descripcion"
            );
        }
        if(datos.getFoto().isEmpty()||datos.getFoto().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Anexe una foto"
            );
        }
        return this.repositorioEspacio.save(datos);
    }

    public Espacio modificarEspacioEnDB(Espacio datos, UUID id){
        // Validar que datos me envian y si estos cummplen las reglas de negocio
        //Guardar los datos en DB con ayuda del repositorio
        Optional<Espacio> espacio_que_estoy_buscando=this.repositorioEspacio.findById(id);
        if (espacio_que_estoy_buscando.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "El espacio que quieres editar, no existe en BD"
            );
        }
        Espacio espacio_que_encontre=espacio_que_estoy_buscando.get();

        //2. validar la informacion nueva que me manda el cliente
        if (datos.getNombre().isEmpty() || datos.getNombre().isBlank()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Revisa el nombre ingresado"
            );
        }
        //3. Ejecutar el nuevo guardado y retornar
        espacio_que_encontre.setNombre(datos.getNombre());
        return this.repositorioEspacio.save(espacio_que_encontre);
    }

    public boolean eliminarEspacioEnDB(UUID id){
        // Buscar y validar si el ID que me envian existe
        //Elimino el regitro en DB
        return false;

    }

    public List<Espacio> buscarEspacioEnDB(){
        //Dependiendo del parametro de busqueda dado implementar validaciones
        // devuelvo los usuarios que encuentre en DB
        List<Espacio>EspacioEncontrado=this.repositorioEspacio.findAll();
        return EspacioEncontrado;
    }
}
