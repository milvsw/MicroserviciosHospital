package com.hospital.paciente.Repository;
import com.hospital.paciente.Model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface PacienteRepository extends JpaRepository<PacienteModel,Long> {

    // Encuentra pacientes por nombre
    List<PacienteModel> findByNombrePaciente(String nombrePaciente);

    // Encuentra pacientes por nombre y apellido
    List<PacienteModel> findByNombrePacienteAndApellidoPaciente(String nombrePaciente, String apellidoPaciente);

    // Encuentra pacientes por correo electronico
    PacienteModel findByCorreoPaciente(String correoPaciente);
}
