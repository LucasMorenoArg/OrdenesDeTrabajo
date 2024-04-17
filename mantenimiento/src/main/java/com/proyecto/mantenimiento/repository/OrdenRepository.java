package com.proyecto.mantenimiento.repository;

import com.proyecto.mantenimiento.entities.OrdenDeTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenDeTrabajo,Integer>{

    @Query("SELECT p FROM OrdenDeTrabajo p WHERE p.usuario LIKE %:nombre%")
    List<OrdenDeTrabajo> findByName(@Param("nombre") String nombre);

    @Query("SELECT p FROM OrdenDeTrabajo p WHERE p.estado =:estatus")
    List<OrdenDeTrabajo> findByStatus(@Param("estatus") String estatus);

}
