package com.codigogon.pacientes.DTO;


import com.codigogon.pacientes.util.StatusTurnos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurnosDTO {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private StatusTurnos status;
    private String DNI;
    private String details;

}
