package com.example.SebastianApp.servios;

import com.example.SebastianApp.models.Usuario;
import com.example.SebastianApp.repositorios.IRepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioServicio {

    //Intectando una dependencia al repositorio
    @Autowired
    private IRepositorioUsuario repositorioUsuario;

    public Usuario guardarUsuarioEnDB(Usuario datos){
        // Validar que datos me envian y si estos cummplen las reglas de negocio
        //Guardar los datos en DB con ayuda del repositorio
        if( repositorioUsuario.findByCorreo(datos.getCorreo()).isPresent()){
           throw new ResponseStatusException(
                   HttpStatus.CONFLICT, "Ya se encuentra registrado este correo"
           );
        }
        if(datos.getNombre().isEmpty()||datos.getNombre().isBlank()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"El nombre digitado no puede estar vacio"
            );
        }
        if (datos.getContraseña().length()<6){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"La contraseña debe tener al menos 6 caracteres"
            );
        }
        //Si paso la zona de validaciones procedo a preparar la
        // receta(Ejecuto la query que se necesite)
        return this.repositorioUsuario.save(datos);
    }

    public Usuario modificarUsuariioEnDB(Usuario datos, UUID id){
        // Validar que datos me envian y si estos cummplen las reglas de negocio
        //Guardar los datos en DB con ayuda del repositorio

        // 1. si el usuario existe en DB
        Optional<Usuario>usuario_que_estoy_buscando=this.repositorioUsuario.findById(id);
        if (usuario_que_estoy_buscando.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "El usuario que quieres editar, no existe en BD"
            );
        }
        Usuario usuario_que_encontre=usuario_que_estoy_buscando.get();

        //2. validar la informacion nueva que me manda el cliente
        if (datos.getNombre().isEmpty() || datos.getNombre().isBlank()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Revisa el nombre ingresado"
            );
        }
        //3. Ejecutar el nuevo guardado y retornar
        usuario_que_encontre.setNombre(datos.getNombre());
        return this.repositorioUsuario.save(usuario_que_encontre);
    }

    public boolean eliminarUsuarioEnDB(UUID id){
        // Buscar y validar si el ID que me envian existe
        //Elimino el regitro en DB
        Optional<Usuario>usuario_que_estoy_buscando=this.repositorioUsuario.findById(id);
        if (usuario_que_estoy_buscando.isEmpty()){
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "El usuario que quieres eliminar, no existe en BD");
        }
        Usuario usuario_que_encontre=usuario_que_estoy_buscando.get();
        this.repositorioUsuario.deleteById(id);

        return true;
    }

    public List<Usuario> buscarUsuarioEnDB(){
        //Dependiendo del parametro de busqueda dado implementar validaciones
        // devuelvo los usuarios que encuentre en DB
        List<Usuario>usuariosEncontrados=this.repositorioUsuario.findAll();
        return usuariosEncontrados;
    }
}
