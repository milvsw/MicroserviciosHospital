package com.hospital.paciente.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name= "paciente")
@AllArgsConstructor
@NoArgsConstructor
public class PacienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    @Column(unique=true, length=13, nullable=false)
    private String rutPaciente;

    @Column(nullable=false)
    private String nombrePaciente;

    @Column(nullable=false)
    private String apellidoPaciente;

    @Column(nullable=true)
    private LocalDate fechaNacimiento;

    @Column(nullable=false)
    private String sexoPaciente;

    @Column(nullable=false)
    private String correoPaciente;

    @Column(nullable=false)
    private String telefonoPaciente;

    @Column(nullable=true)
    private String direccionPaciente;

}
