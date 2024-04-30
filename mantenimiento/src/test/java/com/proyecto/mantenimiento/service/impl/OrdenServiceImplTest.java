package com.proyecto.mantenimiento.service.impl;

import com.proyecto.mantenimiento.entities.OrdenDeTrabajo;
import com.proyecto.mantenimiento.repository.OrdenRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrdenServiceImplTest {
    @Mock
    private OrdenRepository ordenRepository;

    @InjectMocks
    private OrdenServiceImpl ordenService;

    @Test
    void testGetAllMethod() {

        OrdenDeTrabajo ordenDeTrabajo = new OrdenDeTrabajo();
        List<OrdenDeTrabajo> lista= new ArrayList<>();
        lista.add(ordenDeTrabajo);
        when(ordenRepository.findAll()).thenReturn(lista);
        List<OrdenDeTrabajo> ordenDeTrabajoResult=null;
        try {
           ordenDeTrabajoResult = ordenService.getAll();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        assertNotNull(ordenDeTrabajoResult);
    }

    @Test
    void byId() {

        Integer id = 1;
        OrdenDeTrabajo ordenDeTrabajoMock = new OrdenDeTrabajo();
        when(ordenRepository.findById(id)).thenReturn(Optional.of(ordenDeTrabajoMock));

        Optional<OrdenDeTrabajo> result = ordenService.ById(id);
        assertEquals(Optional.of(ordenDeTrabajoMock), result);

      }
    }
