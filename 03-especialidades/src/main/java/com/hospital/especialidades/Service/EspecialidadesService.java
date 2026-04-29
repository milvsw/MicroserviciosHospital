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

    public  List<EspecialidadesModel> findAll(){
        return especialidadesRepository.findAll();
    }

    public EspecialidadesModel findById(Integer idEspecialidad){
        return especialidadesRepository.findById(idEspecialidad).get();
    }

    public EspecialidadesModel save(EspecialidadesModel especialidades){
        return especialidadesRepository.save(especialidades);
    }

    public void delete(Integer idEspecialidad){
        especialidadesRepository.deleteById(idEspecialidad);
    }
}
