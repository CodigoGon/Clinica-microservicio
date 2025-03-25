package com.codigogon.pacientes.Service;

import com.codigogon.pacientes.Model.Paciente;
import com.codigogon.pacientes.Repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository pacRepo;

    @Override
    public void PacienteCreate(Paciente pac) {
        pacRepo.save(pac);
    }

    @Override
    public void PacienteDelete(Long id) {
        pacRepo.deleteById(id);
    }

    @Override
    public Paciente PacienteFind(Long id) {
        //la parte complicada

    }

    @Override
    public List<Paciente> PacienteGet() {
        return pacRepo.findAll();
    }

    @Override
    public void pacienteEdit(Long id, Paciente pac) {
        Paciente pacEditar = PacienteFind(id);
        if(pacEditar != null) {
            pacEditar.setDNI(pac.getDNI());
            pacEditar.setName(pac.getName());
            pacEditar.setLastName(pac.getLastName());
            pacEditar.setPhone(pac.getPhone());
            pacEditar.setTurnList(pac.getTurnList());

            PacienteCreate(pacEditar);
        }
    }
}
