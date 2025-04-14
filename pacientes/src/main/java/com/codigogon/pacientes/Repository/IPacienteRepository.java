package com.codigogon.pacientes.Repository;

import com.codigogon.pacientes.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("SELECT p WHERE Paciente p WHERE p.DNI = DNI")
    public Paciente findPacienteByDni(String DNI);
}
