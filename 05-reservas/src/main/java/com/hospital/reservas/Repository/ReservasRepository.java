package com.hospital.reservas.Repository;

import com.hospital.reservas.Model.ReservasModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservasRepository extends JpaRepository<ReservasModel,Long> {


}
