package com.example.SebastianApp.Controladores;

import com.example.SebastianApp.models.Reserva;
import com.example.SebastianApp.servios.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sebastianApp/v1/usuario")
public class ReservaControlador {
    // por cada servicio ofrecido, configuro una funcion controladora
    @Autowired
    ReservaServicio servicio;

    // funcion para coontrolar el guardado
    @PostMapping
    public ResponseEntity<Reserva> controlarGuardado(@RequestBody Reserva datos){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.servicio.guardarReservaEnDB(datos));
    }
    // funcion para controlar las modificaciones
    @PutMapping("/{id}")
    public ResponseEntity<Reserva>controlarmodificado(@RequestBody Reserva datos, @PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.servicio.modificarReservaEnDB(datos,id));
    }
    // funcion para controlar el borrado
    @DeleteMapping("/{id}")
    public ResponseEntity<?>controlarBorrado(UUID id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.servicio.eliminarReservaEnDB(id));
    }
    // funcion para controlar el listar
    @GetMapping
    public ResponseEntity<?>controlarListar(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.servicio.buscarReservaEnDB());
    }

}