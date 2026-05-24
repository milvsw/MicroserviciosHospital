package com.hospital.reservas.Service;

import com.hospital.reservas.Dto.MedicoDTO;
import com.hospital.reservas.Dto.PacienteDTO;
import com.hospital.reservas.Dto.AgendaDTO;
import com.hospital.reservas.Dto.ReservaDetalleDTO;
import com.hospital.reservas.Model.ReservasModel;
import com.hospital.reservas.Repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
@Service
@Transactional
public class ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

    public List<ReservasModel> listarTodo(){
        return reservasRepository.findAll();
    }

    public ReservasModel buscarId(Long idReservas){
        return reservasRepository.findById(idReservas).get();
    }

    public ReservasModel guardar(ReservasModel reservas){
        return reservasRepository.save(reservas);
    }

    public ReservasModel actualizar(Long id, ReservasModel reservas){
        ReservasModel existente = reservasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        existente.setIdPaciente(reservas.getIdPaciente());
        existente.setIdMedico(reservas.getIdMedico());
        existente.setIdAgenda(reservas.getIdAgenda());
        existente.setFechaAtencion(reservas.getFechaAtencion());
        existente.setMotivoConsulta(reservas.getMotivoConsulta());
        existente.setEstado(reservas.getEstado());
        existente.setObservacion(reservas.getObservacion());

        return reservasRepository.save(existente);

    }
    public void eliminar(Long id){
        reservasRepository.deleteById(id);
    }


    private final WebClient webClient;

    @Value("${servicio.paciente.url}")
    private String pacienteUrl;

    @Value("${servicio.medico.url}")
    private String medicoUrl;

    @Value("${servicio.agenda.url}")
    private String agendaUrl;

    public ReservasService(WebClient webClient, ReservasRepository reservasRepository) {
        this.webClient = webClient;
        this.reservasRepository = reservasRepository;
    }

    public Mono<ReservaDetalleDTO> obtenerReservasConPacienteMedicoAgenda(Long idReservas) {


        Mono<ReservasModel> llamadaReservas =
                Mono.fromCallable(() -> reservasRepository.findById(idReservas)
                        .orElseThrow());


        return llamadaReservas.flatMap(reserva -> {

            Mono<PacienteDTO> llamadaPaciente = webClient.get()
                    .uri(pacienteUrl + "/api/v1/pacientes/{id}",
                            reserva.getIdPaciente())
                    .retrieve()
                    .bodyToMono(PacienteDTO.class);

            Mono<MedicoDTO> llamadaMedico = webClient.get()
                    .uri(medicoUrl + "/api/v1/medicos/{id}",
                            reserva.getIdMedico())
                    .retrieve()
                    .bodyToMono(MedicoDTO.class);

            Mono<AgendaDTO> llamadaAgenda = webClient.get()
                    .uri(agendaUrl + "/api/v1/agendas/{id}",
                            reserva.getIdAgenda())
                    .retrieve()
                    .bodyToMono(AgendaDTO.class);


            return Mono.zip(Mono.just(reserva), llamadaMedico,llamadaPaciente,llamadaAgenda)
                    .map(tupla -> {

                        ReservasModel agendaResult = tupla.getT1();
                        MedicoDTO medico = tupla.getT2();
                        PacienteDTO paciente = tupla.getT3();
                        AgendaDTO agenda = tupla.getT4();

                        return new ReservaDetalleDTO(
                                agendaResult,
                                medico,
                                paciente,
                                agenda
                        );
                    });
        });
    }
}
