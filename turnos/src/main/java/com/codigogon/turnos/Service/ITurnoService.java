package com.codigogon.turnos.Service;

import com.codigogon.turnos.DTO.TurnoDTO;
import com.codigogon.turnos.Model.Turno;

import java.util.List;

public interface ITurnoService {
    public void CreateTurno(Turno turn);
    public void deleteTurno(Long id);
    public TurnoDTO findTurno(Long id);
    public List<Turno>getTurnos();
    public void editTurno(Long id, Turno turn);
}
