package com.hospital.historialclinico.repository;

import com.hospital.historialclinico.model.HCModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HCRepository extends JpaRepository<HCModel, Long> {
}
