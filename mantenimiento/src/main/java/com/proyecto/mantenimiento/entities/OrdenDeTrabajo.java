package com.proyecto.mantenimiento.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name="ordendetrabajo")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class OrdenDeTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String usuario;
    private String fallaTipo;
    private String maquina;
    private LocalDate fechaSolicitud;
    private LocalDate fechaCierre;
    private String estado;
}
