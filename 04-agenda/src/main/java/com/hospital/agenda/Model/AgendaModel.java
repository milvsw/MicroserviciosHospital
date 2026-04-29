package com.hospital.agenda.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Data
@Table(name="agenda")
@AllArgsConstructor
@NoArgsConstructor
public class AgendaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAgenda;

    @Column(nullable=false)
    private Integer idMedico;

    @Column(nullable=false)
    private LocalDate fecha;

    @Column(nullable=false)
    private LocalTime horaInicio;

    @Column(nullable=false)
    private LocalTime horaFin;

    @Column(nullable=false)
    private Integer duracionMinutos;

    @Column(nullable=false)
    private Integer cuposDisponibles;

    @Column(nullable=false)
    private String estado;

    @Column(nullable=false)
    private boolean activo;
}
