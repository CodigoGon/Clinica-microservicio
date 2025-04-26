package com.codigogon.turnos.DTO;

import com.codigogon.turnos.Util.StatusTurnso;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurnoDTO {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private StatusTurnso status;
    private PacienteDTO Paciente;
    private String details;
}
