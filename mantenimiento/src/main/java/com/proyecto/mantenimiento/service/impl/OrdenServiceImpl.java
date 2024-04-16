package com.proyecto.mantenimiento.service.impl;

import com.proyecto.mantenimiento.entities.OrdenDeTrabajo;
import com.proyecto.mantenimiento.repository.OrdenRepository;
import com.proyecto.mantenimiento.service.OrdenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class OrdenServiceImpl implements OrdenService {

    private final OrdenRepository ordenRepository;

    @Override
    public List<OrdenDeTrabajo> getAll() throws Exception {

        if (!ordenRepository.findAll().isEmpty()){
            return ordenRepository.findAll();
        } else{

        }

        return null;
    }

    @Override
    public Optional<OrdenDeTrabajo> ById(Integer id) {

        return ordenRepository.findById(id);
    }

    @Override
    public OrdenDeTrabajo save(OrdenDeTrabajo cliente) {

        return ordenRepository.save(cliente);
    }

    @Override
    public Optional<OrdenDeTrabajo> update(OrdenDeTrabajo cliente, Integer id) throws Exception {

        try {
            if (ordenRepository.existsById(id)){
                ordenRepository.save(cliente);
            } else System.out.println("No se pudo completar la operación");

            return ordenRepository.findById(id);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Integer id)  {

        if (ordenRepository.existsById(id)){
            ordenRepository.deleteById(id);
            return true;
        } else{
            System.out.println("No se pudo eliminar el registro");
        }
        return false;
    }
}
