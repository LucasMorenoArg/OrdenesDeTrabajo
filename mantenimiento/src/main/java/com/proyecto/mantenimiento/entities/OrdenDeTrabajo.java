package com.proyecto.mantenimiento.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Table(name="ordendetrabajo")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrdenDeTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String usuario;
    private String fallaTipo;
    private String maquina;
    private Date fechaSolicitud;
    private Date fechaCierre;
    private String estado;
}
