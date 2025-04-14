package com.codigogon.turnos.Service;

import com.codigogon.turnos.Model.Turno;
import com.codigogon.turnos.Repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository turnoRepo;

    @Override
    public void CreateTurno(Turno turn) {
        turnoRepo.save(turn);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepo.deleteById(id);
    }

    @Override
    public Turno findTurno(Long id) {

        //aca toca hacer magia
        return null;
    }

    @Override
    public List<Turno> getTurnos() {

        return turnoRepo.findAll();
    }

    @Override
    public void editTurno(Long id, Turno turn) {

    }
}
