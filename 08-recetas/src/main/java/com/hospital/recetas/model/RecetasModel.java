package com.hospital.recetas.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "recetas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecetasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // IDs de los otros microservicios
    @Column(name = "paciente_id", nullable = false)
    private Long pacienteId;

    @Column(name = "medico_id", nullable = false)
    private Long medicoId;

    @Column(name = "reserva_id", nullable = false)
    private Long reservaId;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @Column(name = "diagnostico", columnDefinition = "TEXT")
    private String diagnostico;

    @Column(name = "medicamentos", columnDefinition = "TEXT", nullable = false)
    private String medicamentos;

    @Column(name = "indicaciones", columnDefinition = "TEXT")
    private String indicaciones;

    @Column(name = "vigencia_dias")
    private Integer vigenciaDias;
}
