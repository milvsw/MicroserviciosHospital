package com.hospital.medico.Repository;
import com.hospital.medico.Model.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface MedicoRepository extends JpaRepository<MedicoModel,Long> {

    // encontrar medico por el nombre
    List<MedicoModel> findByNombreMedico(String nombreMedico);

    // Encontrar por nombre y apellido
    List<MedicoModel> findByNombreMedicoAndApellidoMedico(String nombreMedico, String apellidoMedico);

    // buscar al medico por correo
    List<MedicoModel> findByCorreoMedico(String correoMedico);



}
