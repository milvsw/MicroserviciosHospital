package com.hospital.agenda.Service;

import com.hospital.agenda.Dto.AgendaDetalleDTO;
import com.hospital.agenda.Dto.MedicoDTO;
import com.hospital.agenda.Model.AgendaModel;
import com.hospital.agenda.Repository.AgendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Transactional
public class AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;

    public List<AgendaModel> listarTodo(){
        return agendaRepository.findAll();
    }

    public AgendaModel buscarId(Long idAgenda){
        return agendaRepository.findById(idAgenda).get();
    }

    public AgendaModel guardar(AgendaModel agenda){
        return agendaRepository.save(agenda);
    }

    public AgendaModel actualizar(Long id, AgendaModel agenda){
        AgendaModel existente = agendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agenda no encontrada"));

        existente.setIdMedico(agenda.getIdMedico());
        existente.setFecha(agenda.getFecha());
        existente.setHoraInicio(agenda.getHoraInicio());
        existente.setHoraFin(agenda.getHoraFin());
        existente.setDuracionMinutos(agenda.getDuracionMinutos());
        existente.setCuposDisponibles(agenda.getCuposDisponibles());
        existente.setEstado(agenda.getEstado());
        existente.setActivo(agenda.isActivo());

        return  agendaRepository.save(existente);
    }
    public void delete(Long idAgenda){
        agendaRepository.deleteById(idAgenda);
    }

    private final WebClient webClient;

    @Value("${servicio.medico.url}")
    private String medicoUrl;

    public AgendaService(WebClient webClient, AgendaRepository agendaRepository) {
        this.webClient = webClient;
        this.agendaRepository = agendaRepository;
    }

    public Mono<AgendaDetalleDTO> obtenerAgendaConMedico(Long idAgenda) {


        Mono<AgendaModel> llamadaAgenda =
                Mono.fromCallable(() -> agendaRepository.findById(idAgenda)
                        .orElseThrow());


        return llamadaAgenda.flatMap(agenda -> {

            Mono<MedicoDTO> llamadaMedico = webClient.get()
                    .uri(medicoUrl + "/api/v1/medicos/{id}",
                            agenda.getIdMedico())
                    .retrieve()
                    .bodyToMono(MedicoDTO.class);


            return Mono.zip(Mono.just(agenda), llamadaMedico)
                    .map(tupla -> {

                        AgendaModel agendaResult = tupla.getT1();
                        MedicoDTO medico = tupla.getT2();

                        return new AgendaDetalleDTO(
                                agendaResult,
                                medico
                        );
                    });
        });
    }

}
