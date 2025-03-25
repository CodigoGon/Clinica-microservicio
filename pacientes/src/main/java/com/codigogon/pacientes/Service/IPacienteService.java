package com.codigogon.pacientes.Service;


import com.codigogon.pacientes.Model.Paciente;

import java.util.List;

public interface IPacienteService {
    public void PacienteCreate(Paciente pac);
    public void PacienteDelete(Long id);
    public Paciente PacienteFind(Long id);
    public List<Paciente> PacienteGet();
    public void pacienteEdit(Long id, Paciente pac);
}
