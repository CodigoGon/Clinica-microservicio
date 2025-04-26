package com.codigogon.turnos.Repository;


import com.codigogon.turnos.DTO.PacienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pacienteapi",url = "http://localhost/8081")
public interface PacienteAPI {
    @GetMapping("/turno/findbydni/{dni}")
    public PacienteDTO findPaciente (@PathVariable("dni") String dni);
}
