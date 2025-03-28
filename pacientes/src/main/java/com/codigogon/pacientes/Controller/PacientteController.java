package com.codigogon.pacientes.Controller;

import com.codigogon.pacientes.DTO.PacienteDTO;
import com.codigogon.pacientes.Model.Paciente;
import com.codigogon.pacientes.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacientteController {

    @Autowired
    PacienteService pacServ;

    @PostMapping("/create")
    public String createPac(@RequestBody Paciente pac){
         pacServ.PacienteCreate(pac);

         return "paciente created";
     }

    @DeleteMapping("/delete/{id}")
    public String deletePac(@PathVariable("id") Long id) {
         pacServ.PacienteDelete(id);
         return "paciene deleted";
     }

    @GetMapping("/findpaciente/{id}")
    public PacienteDTO findPac(@PathVariable Long id) {
        return pacServ.PacienteFind(id);
    }

    @GetMapping("/getpacientes")
    public List<Paciente> getPac() {
        return pacServ.PacienteGet();
    }


}
