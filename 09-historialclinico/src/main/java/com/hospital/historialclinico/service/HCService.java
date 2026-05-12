package com.hospital.historialclinico.service;

import com.hospital.historialclinico.model.HCModel;
import com.hospital.historialclinico.repository.HCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class HCService {
    @Autowired
    private HCRepository repo;

    public List<HCModel> listarTodos() {
        return repo.findAll();
    }

    public HCModel guardar(HCModel historial) {
        return repo.save(historial);
    }

    public HCModel buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
