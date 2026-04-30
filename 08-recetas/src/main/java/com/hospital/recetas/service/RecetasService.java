package com.hospital.recetas.service;
import com.hospital.recetas.model.RecetasModel;
import com.hospital.recetas.repository.RecetasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecetasService {

    @Autowired
    private RecetasRepository repo;

    public List<RecetasModel> listarTodas() {
        return repo.findAll();
    }

    public RecetasModel guardar(RecetasModel receta) {
        return repo.save(receta);
    }

    public RecetasModel buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}