package com.hospital.medico.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="medico")
@AllArgsConstructor
@NoArgsConstructor

public class MedicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedico;

    @Column(unique=true, length=13, nullable=false)
    private String rutMedico;

    @Column(nullable=false)
    private String nombreMedico;

    @Column(nullable=false)
    private String apellidoMedico;

    @Column(nullable=false)
    private String telefonoMedico;

    @Column(nullable=false)
    private String correoMedico;

    @Column(nullable=false)
    private Integer idEspecialidad;

    @Column(nullable=false)
    private Integer anniosExperiencia;



}
