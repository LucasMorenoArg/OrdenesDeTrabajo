package com.proyecto.mantenimiento.controller;

import com.proyecto.mantenimiento.entities.OrdenDeTrabajo;
import com.proyecto.mantenimiento.repository.OrdenRepository;
import com.proyecto.mantenimiento.service.impl.OrdenServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class OrdenController {

    private final OrdenServiceImpl ordenService;
    private final OrdenRepository ordenRepository;

    @SneakyThrows(Exception.class)
    @GetMapping("getAll")
    public List<OrdenDeTrabajo> getAll()  {

        return ordenService.getAll();
    }

    @GetMapping("byId/{id}")
    public Optional<OrdenDeTrabajo> byId(@PathVariable int id) {

        return ordenService.ById(id);
    }

    @GetMapping("byNombre")
    public List<OrdenDeTrabajo> byNombre(@RequestParam String nombre){

        return ordenRepository.findByName(nombre);
    }

    @GetMapping("")
    public List<OrdenDeTrabajo> byStatus(@RequestParam String estatus){

        return ordenRepository.findByStatus(estatus);
    }

    @PostMapping("create")
    public OrdenDeTrabajo create(@RequestBody OrdenDeTrabajo ordenDeTrabajo){

       return ordenService.save(ordenDeTrabajo);
    }

    @SneakyThrows
    @PutMapping("update/{id}")
    public Optional<OrdenDeTrabajo> update(@RequestBody OrdenDeTrabajo ordenDeTrabajo,
                                           @PathVariable int id)  {

        return ordenService.update(ordenDeTrabajo,id);
    }

    @DeleteMapping("deleteId/{id}")
    public boolean deleteId(int id){
        return ordenService.delete(id);
    }
}
