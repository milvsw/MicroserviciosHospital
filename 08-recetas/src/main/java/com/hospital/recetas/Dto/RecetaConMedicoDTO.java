package com.hospital.recetas.Dto;

import java.time.LocalDate;

public class RecetaConMedicoDTO {

    private Long id;
    private Long idPaciente;
    private Long idMedico;
    private String nombreMedico;
    private String apellidoMedico;
    private Long idReserva;
    private LocalDate fechaEmision;
    private String diagnostico;
    private String medicamentos;
    private String indicaciones;
    private Integer vigenciaDias;

    public RecetaConMedicoDTO() {
    }

    public RecetaConMedicoDTO(Long id, Long idPaciente, Long idMedico, String nombreMedico, String apellidoMedico,
                              Long idReserva, LocalDate fechaEmision, String diagnostico, String medicamentos,
                              String indicaciones, Integer vigenciaDias) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.nombreMedico = nombreMedico;
        this.apellidoMedico = apellidoMedico;
        this.idReserva = idReserva;
        this.fechaEmision = fechaEmision;
        this.diagnostico = diagnostico;
        this.medicamentos = medicamentos;
        this.indicaciones = indicaciones;
        this.vigenciaDias = vigenciaDias;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getApellidoMedico() {
        return apellidoMedico;
    }

    public void setApellidoMedico(String apellidoMedico) {
        this.apellidoMedico = apellidoMedico;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public Integer getVigenciaDias() {
        return vigenciaDias;
    }

    public void setVigenciaDias(Integer vigenciaDias) {
        this.vigenciaDias = vigenciaDias;
    }
}
