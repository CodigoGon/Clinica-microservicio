package com.codigogon.pacientes.Repository;


import com.codigogon.pacientes.DTO.TurnosDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Turnoapi",url = "http://localhost/8082")
public interface TurnoAPI {

    @GetMapping("/turno/findturno/{id}")
    public TurnosDTO findTurno (@PathVariable("id") Long id);
}


