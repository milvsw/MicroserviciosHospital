package com.hospital.especialidades.Repository;

import com.hospital.especialidades.Model.EspecialidadesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface EspecialidadesRepository extends JpaRepository<EspecialidadesModel,Integer> {

    // Encontrar la especiliadad por el nombreEspecialidad

    List<EspecialidadesModel> findByNombreEspecialidad(String nombreEspecialidad);

    // buscar por area medica
    List<EspecialidadesModel> findByAreaMedica(String areaMedica);

}
