package com.hospital.especialidades.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="especialidades")
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEspecialidad")
    private Long idEspecialidad;

    @Column(name="nombreEspecialidad",nullable = false)
    private String nombreEspecialidad;

    @Column(name="descripcionEspecialidad",nullable = false)
    private String descripcionEspecialidad;

    @Column(name="areaMedica",nullable = false)
    private String areaMedica;
}
