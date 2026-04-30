package com.hospital.recetas.controller;
import com.hospital.recetas.model.RecetasModel;
import com.hospital.recetas.service.RecetasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recetas")
public class RecetasController {

    @Autowired
    private RecetasService service;

    @GetMapping
    public List<RecetasModel> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public RecetasModel crear(@RequestBody RecetasModel receta) {
        return service.guardar(receta);
    }

    @GetMapping("/{id}")
    public RecetasModel obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
