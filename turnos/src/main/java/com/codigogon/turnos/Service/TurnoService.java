package com.codigogon.turnos.Service;

import com.codigogon.turnos.DTO.PacienteDTO;
import com.codigogon.turnos.DTO.TurnoDTO;
import com.codigogon.turnos.Model.Turno;
import com.codigogon.turnos.Repository.ITurnoRepository;
import com.codigogon.turnos.Repository.PacienteAPI;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository turnoRepo;
    @Autowired
    private PacienteAPI pacAPI;

    @Override
    public void CreateTurno(Turno turn) {
        turnoRepo.save(turn);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepo.deleteById(id);
    }

    @Override
    public TurnoDTO findTurno(Long id) {

        //aca toca hacer magia
        Turno turnoActual = turnoRepo.findById(id).orElse(null);
        assert turnoActual != null;
        PacienteDTO pacBuscar = pacAPI.findPaciente(turnoActual.getDNI());


        TurnoDTO turnoFInal= new TurnoDTO();

        turnoFInal.setDate(turnoActual.getDate());
        turnoFInal.setId(turnoActual.getId());
        turnoFInal.setTime(turnoActual.getTime());
        turnoFInal.setStatus(turnoActual.getStatus());
        turnoFInal.setDetails(turnoActual.getDetails());
        turnoFInal.setPaciente(pacBuscar);

        return turnoFInal;
    }

    @Override
    public List<Turno> getTurnos() {

        return turnoRepo.findAll();
    }

    @Override
    public void editTurno(Long id, Turno turn) {

    }
}
