package com.hospital.agenda.Repository;

import com.hospital.agenda.Model.AgendaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AgendaRepository extends JpaRepository<AgendaModel,Integer> {

    // buscar por fecha
    List<AgendaModel> findByFecha(LocalDate fecha);

    // buscar por estado
    List<AgendaModel> findByEstado(String estado);


}
