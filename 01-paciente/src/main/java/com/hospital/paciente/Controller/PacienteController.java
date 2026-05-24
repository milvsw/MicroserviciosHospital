package com.hospital.paciente.Controller;

import com.hospital.paciente.Model.PacienteModel;
import com.hospital.paciente.Service.PacienteService;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<PacienteModel>> listar(){
        List<PacienteModel> pacientes = pacienteService.listarTodos();
        if(pacientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<PacienteModel> guardar(@Valid @RequestBody PacienteModel paciente){
        PacienteModel pacientes = pacienteService.guardar(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacientes);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PacienteModel> buscar(@PathVariable Long id){
        try{
            PacienteModel paciente =  pacienteService.buscarPorId(id);
            return ResponseEntity.ok(paciente);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteModel> actualizar(@PathVariable Long id, @Valid @RequestBody PacienteModel paciente){
        try{
            PacienteModel pacientes = pacienteService.actualizar(id, paciente);
            return ResponseEntity.ok(pacientes);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            pacienteService.delete(id);
            return  ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }

    }


}
