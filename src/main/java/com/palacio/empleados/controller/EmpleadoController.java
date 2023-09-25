package com.palacio.empleados.controller;

import com.palacio.empleados.model.Empleado;
import com.palacio.empleados.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<Empleado>> getEmpleados () {
        return ResponseEntity.ok(empleadoService.getAllEmpleados());
    }

    @GetMapping("/{id}")
    public Optional<Empleado> findEmpleadoById (@PathVariable Long id) {
        return empleadoService.findEmpleadoById(id);
    }

    @PostMapping("/insert")
    public ResponseEntity<Empleado> insertEmpleado(@RequestBody Empleado empleado){
        Empleado empleadoTemporal = empleadoService.saveEmpleado(empleado);
        try {
            return ResponseEntity.created(new URI("/api/empleado" + empleadoTemporal.getId())).body(empleadoTemporal);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        Empleado empleadoTemporal = empleadoService.saveEmpleado(empleado);
        try {
            return ResponseEntity.created(new URI("/api/empleado" + empleadoTemporal.getId())).body(empleadoTemporal);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Empleado> deleteEmpleado(@PathVariable Long id) {
        return empleadoService.deleteEmpleado(id);
    }
}
