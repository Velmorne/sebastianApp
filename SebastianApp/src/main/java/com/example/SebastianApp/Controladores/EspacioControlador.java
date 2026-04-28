package com.example.SebastianApp.Controladores;

import com.example.SebastianApp.models.Espacio;
import com.example.SebastianApp.servios.EspacioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//  EN LA CAPA DE CONTROLADORES RESIDEN LAS DEPENDENCIAS (RESIVE  LAS PETICIONES HTTP)

@RestController
@RequestMapping("/sebastianApp/v1/espacio")
public class EspacioControlador {
    // por cada servicio ofrecido, configuro una funcion controladora
    @Autowired
    EspacioServicio servicio;

    // funcion para coontrolar el guardado
    @PostMapping
    public ResponseEntity<Espacio> controlarGuardado(@RequestBody Espacio datos){
        return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarEspacioEnDB(datos));
        }
        // funcion para controlar las modificaciones
        @PutMapping("/{id}")
        public ResponseEntity<Espacio>controlarmodificado(@RequestBody Espacio datos, @PathVariable UUID id){
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.modificarEspacioEnDB(datos,id));
        }
        // funcion para controlar el borrado
        @DeleteMapping("/{id}")
        public ResponseEntity<?>controlarBorrado(UUID id){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.eliminarEspacioEnDB(id));
        }
        // funcion para controlar el listar
        @GetMapping
        public ResponseEntity<?>controlarListar(){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarEspacioEnDB());
        }
    }
