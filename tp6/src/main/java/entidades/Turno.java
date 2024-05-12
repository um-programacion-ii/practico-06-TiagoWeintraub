package entidades;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import servicios.ServicioGestionTurno;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turno {
    private Integer id;
    private Paciente paciente;
    private Medico medico;
}
