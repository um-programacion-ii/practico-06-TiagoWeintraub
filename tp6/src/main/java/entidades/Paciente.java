package entidades;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private String dni;
    private String nombre;
    private String apellido;
    private boolean usaObraSocial;
    private ObraSocial obraSocial;
    private List<Receta> recetas;

    public void recibirReceta(Receta receta) {
        this.recetas.add(receta);
    }

    public void solicitarTurno(Medico medico, Especialidad especialidad, boolean usaObraSocial) {
        // Implementa la lógica para solicitar un turno con un médico
    }
}