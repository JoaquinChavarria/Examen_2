package hn.examen2.examen2.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import hn.examen2.examen2.Modelos.Prestamo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private List<Prestamo> prestamos;
}
