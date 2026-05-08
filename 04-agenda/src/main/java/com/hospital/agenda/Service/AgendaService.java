package com.hospital.agenda.Service;

import com.hospital.agenda.Model.AgendaModel;
import com.hospital.agenda.Repository.AgendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;

    public List<AgendaModel> findAll(){
        return agendaRepository.findAll();
    }

    public AgendaModel findById(Long idAgenda){
        return agendaRepository.findById(idAgenda).get();
    }

    public AgendaModel save(AgendaModel agenda){
        return agendaRepository.save(agenda);
    }

    public void delete(Long idAgenda){
        agendaRepository.deleteById(idAgenda);
    }
}
