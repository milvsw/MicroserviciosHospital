package com.hospital.medico.Service;

import com.hospital.medico.Repository.MedicoRepository;
import com.hospital.medico.Model.MedicoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<MedicoModel> findAll(){
        return medicoRepository.findAll();
    }

    public MedicoModel findById(Long idMedico){
        return medicoRepository.findById(idMedico).get();
    }

    public MedicoModel save(MedicoModel medico){
        return medicoRepository.save(medico);
    }

    public void delete(Long id){
        medicoRepository.deleteById(id);
    }


}
