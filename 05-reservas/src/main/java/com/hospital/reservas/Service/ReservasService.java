package com.hospital.reservas.Service;

import com.hospital.reservas.Model.ReservasModel;
import com.hospital.reservas.Repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
@Service
@Transactional
public class ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

    public List<ReservasModel> findAll(){
        return reservasRepository.findAll();
    }

    public ReservasModel findById(Long idReservas){
        return reservasRepository.findById(idReservas).get();
    }

    public ReservasModel save(ReservasModel reservas){
        return reservasRepository.save(reservas);
    }

    public void delete(Long id){
        reservasRepository.deleteById(id);
    }


}
