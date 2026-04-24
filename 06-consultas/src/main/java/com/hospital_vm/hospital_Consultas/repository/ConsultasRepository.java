package com.hospital_vm.hospital_Consultas.repository;

import com.hospital_vm.hospital_Consultas.model.ConsultasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultasRepository extends JpaRepository<ConsultasModel, Long> {

}
