package com.codigogon.turnos.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {

    private Long id;
    private String name;
    private String lastName;
    private String DNI;
    private String Phone;
    private List<Long> TurnList;
}
