package com.codigogon.pacientes.Service;

import com.codigogon.pacientes.DTO.PacienteDTO;
import com.codigogon.pacientes.DTO.TurnosDTO;
import com.codigogon.pacientes.Model.Paciente;
import com.codigogon.pacientes.Repository.IPacienteRepository;
import com.codigogon.pacientes.Repository.TurnoAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService implements IPacienteService{


    @Autowired
    private IPacienteRepository pacRepo;

    @Autowired
    private TurnoAPI turnoAPI;

    @Override
    public void PacienteCreate(Paciente pac) {
        pacRepo.save(pac);
    }

    @Override
    public void PacienteDelete(Long id) {
        pacRepo.deleteById(id);
    }


    @CircuitBreaker(name = "TurnoAPI", fallbackMethod = "inCaseError")
    @Retry(name = "TurnoAPI")
    @Override
    public PacienteDTO PacienteFind(Long id) {
        //la parte complicada
        Paciente pacActual = pacRepo.findById(id).orElse(null);
        assert pacActual != null;
        List<Long> arrayBusca = pacActual.getTurnList();
        List<TurnosDTO> turnosLista = new ArrayList<>();

        for (Long array : arrayBusca) {
            turnosLista.add(turnoAPI.findTurno(array));
        }

        PacienteDTO pacFInal = new PacienteDTO();

        pacFInal.setDNI(pacActual.getDNI());
        pacFInal.setName(pacActual.getName());
        pacFInal.setLastName(pacActual.getLastName());
        pacFInal.setPhone(pacActual.getPhone());
        pacFInal.setTurnList(turnosLista);

        return pacFInal;
    }

    

    @Override
    public List<Paciente> PacienteGet() {
        return pacRepo.findAll();
    }

    @Override
    public void pacienteEdit(Long id, Paciente pac) {
        Paciente pacEditar = pacRepo.findById(id).orElse(null);
        if(pacEditar != null) {
            pacEditar.setDNI(pac.getDNI());
            pacEditar.setName(pac.getName());
            pacEditar.setLastName(pac.getLastName());
            pacEditar.setPhone(pac.getPhone());
            pacEditar.setTurnList(pac.getTurnList());

            PacienteCreate(pacEditar);
        }
    }
    @Override
    public Paciente findByDNIpac(String dni) {

        return pacRepo.findPacienteByDni(dni);
    }

    @Override
    public Paciente PacienteFindConsul(Long id) {
        return pacRepo.findById(id).orElse(null);
    }
}
