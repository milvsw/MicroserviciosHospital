package com.hospital.paciente.DTO;

import com.hospital.paciente.Service.PacienteService;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ErrorResponse {

    public String mensaje;
    public String detalle;
    public int status;
    public LocalDateTime timeStamp;

}
