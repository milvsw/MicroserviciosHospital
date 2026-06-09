package com.hospital.paciente.Exception;
import com.hospital.paciente.Service.PacienteService;
import com.hospital.paciente.DTO.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GloblaExceptionHandler {

    private static final Logger log =
            LoggerFactory.getLogger(PacienteService.class);
    // ... handlers

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoResourceFound(NoResourceFoundException ex,
                                                               HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND; // Código HTTP 404

        // Registramos la advertencia estructurada para Grafana Loki
        log.warn("Ruta o recurso estático no encontrado");

        // Construimos la respuesta homogénea para el cliente
        ErrorResponse error = new ErrorResponse();
        error.setMensaje("Ruta no encontrada");
        error.setDetalle("El endpoint '" + request.getRequestURI() + "' no existe en este servidor o el recurso estático no fue encontrado.");
        error.setStatus(status.value()); // 404
        error.setTimeStamp(LocalDateTime.now());
        return ResponseEntity.status(status).body(error);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
            MethodArgumentNotValidException ex) {
        String detalle = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ":" + err.getDefaultMessage())
                .collect(Collectors.joining(","));
        // Registramos la advertencia de validación en logs
        log.warn("Fallo de validación en tiempo de persistencia");
        ErrorResponse error = new ErrorResponse();
        error.setMensaje("Errores de validacion");
        error.setDetalle(detalle);
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimeStamp(LocalDateTime.now());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);


    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(
            Exception ex, HttpServletRequest request) {
        log.warn("Fallo Generico en la aplicacion");
        ErrorResponse error = new ErrorResponse();
        error.setMensaje("Errores interno del servidor");
        error.setDetalle(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setTimeStamp(LocalDateTime.now());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);

    }



}
