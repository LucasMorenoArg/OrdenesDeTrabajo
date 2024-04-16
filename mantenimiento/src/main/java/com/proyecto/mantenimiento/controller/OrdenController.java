package com.proyecto.mantenimiento.controller;

import com.proyecto.mantenimiento.entities.OrdenDeTrabajo;
import com.proyecto.mantenimiento.repository.OrdenRepository;
import com.proyecto.mantenimiento.service.impl.OrdenServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class OrdenController {

    private final OrdenServiceImpl ordenService;
    private final OrdenRepository ordenRepository;
    @GetMapping("getAll")
    public List<OrdenDeTrabajo> getAll() throws Exception {

        return ordenService.getAll();
    }

    @GetMapping("byId/{id}")
    public Optional<OrdenDeTrabajo> byId(@PathVariable int id) {

        return ordenService.ById(id);
    }

    @GetMapping("byNombre")
    public List<OrdenDeTrabajo> byNombre(@RequestParam String nombre){

        return ordenRepository.findByNombre(nombre);
    }

    @PostMapping("create")
    public OrdenDeTrabajo create(@RequestBody OrdenDeTrabajo ordenDeTrabajo){

       return ordenService.save(ordenDeTrabajo);
    }

    @PostMapping("update")
    public Optional<OrdenDeTrabajo> update(@RequestBody OrdenDeTrabajo ordenDeTrabajo, int id ) throws Exception {

        return ordenService.update(ordenDeTrabajo, id);
    }

    @DeleteMapping("deleteId/{id}")
    public boolean deleteId(int id){
        return ordenService.delete(id);
    }
}
