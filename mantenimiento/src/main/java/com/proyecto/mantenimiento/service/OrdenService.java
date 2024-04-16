package com.proyecto.mantenimiento.service;

import com.proyecto.mantenimiento.entities.OrdenDeTrabajo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface OrdenService {

    List<OrdenDeTrabajo> getAll()throws Exception;
    Optional<OrdenDeTrabajo> ById(Integer id)throws Exception;
    OrdenDeTrabajo save (OrdenDeTrabajo cliente)throws Exception;
    Optional<OrdenDeTrabajo> update(OrdenDeTrabajo cliente,Integer id)throws Exception;
    boolean delete(Integer id)throws Exception;

}
