package com.hospital.especialidades.Service;

import com.hospital.especialidades.Model.EspecialidadesModel;
import com.hospital.especialidades.Repository.EspecialidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EspecialidadesService {
    @Autowired
    private EspecialidadesRepository especialidadesRepository;

    public  List<EspecialidadesModel> listarTodo(){
        return especialidadesRepository.findAll();
    }

    public EspecialidadesModel buscarId(Long idEspecialidad){
        return especialidadesRepository.findById(idEspecialidad).get();
    }

    public EspecialidadesModel guardar(EspecialidadesModel especialidades){
        return especialidadesRepository.save(especialidades);
    }

    public EspecialidadesModel actualizar(Long id, EspecialidadesModel especialidades){

        EspecialidadesModel existente = especialidadesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));

        existente.setNombreEspecialidad(especialidades.getNombreEspecialidad());
        existente.setDescripcionEspecialidad(especialidades.getDescripcionEspecialidad());
        existente.setAreaMedica(especialidades.getAreaMedica());

        return  especialidadesRepository.save(existente);

    }

    public void delete(Long idEspecialidad){
        especialidadesRepository.deleteById(idEspecialidad);
    }
}
