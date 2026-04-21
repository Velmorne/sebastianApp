package com.example.SebastianApp.Controladores;

import com.example.SebastianApp.models.Usuario;
import com.example.SebastianApp.servios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sebastianApp/v1/usuario")
public class UsuarioControlador {
    // por cada servicio ofrecido, configuro una funcion controladora
    @Autowired
    UsuarioServicio servicio;

    // funcion para coontrolar el guardado
    @PostMapping
    public ResponseEntity<Usuario>controlarGuardado(@RequestBody Usuario datos){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.servicio.guardarUsuarioEnDB(datos));
    }
    // funcion para controlar las modificaciones
    @PutMapping("/{id}")
    public ResponseEntity<Usuario>controlarmodificado(@RequestBody Usuario datos, @PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.servicio.modificarUsuariioEnDB(datos,id));
    }
    // funcion para controlar el borrado
    @DeleteMapping("/{id}")
    public ResponseEntity<?>controlarBorrado(UUID id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.servicio.eliminarUsuarioEnDB(id));
    }
    // funcion para controlar el listar
    @GetMapping
    public ResponseEntity<?>controlarListar(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.servicio.buscarUsuarioEnDB());
    }

}
