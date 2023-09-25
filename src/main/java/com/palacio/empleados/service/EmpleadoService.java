package com.palacio.empleados.service;

import com.palacio.empleados.model.Empleado;
import com.palacio.empleados.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAllEmpleados () {
        return empleadoRepository.findAll();
    }

    public Empleado saveEmpleado (Empleado empleado) {
            return empleadoRepository.save(empleado);
    }

    public ResponseEntity<Empleado> deleteEmpleado (Long id) {
        try {
            empleadoRepository.deleteById(id);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public Optional<Empleado> findEmpleadoById (Long id) {
            return empleadoRepository.findById(id);
    }
}
