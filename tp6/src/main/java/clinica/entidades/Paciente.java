package clinica.entidades;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private Integer dni;
    private String nombre;
    private String apellido;
    private ObraSocial obrasSociales; // Si no tiene obra social, la lista estará vacía (Visita particular)
    private List<Receta> recetas;

    public void recibirReceta(Receta receta) {
        this.recetas.add(receta);
    }

    public void solicitarTurno(Medico medico, Especialidad especialidad, ObraSocial obraSocial) {
        // Implementa la lógica para solicitar un turno con un médico
    }

    public void comprarMedicamentos(Farmacia farmacia, Receta receta) {
        // Implementa la lógica para comprar los medicamentos de una receta en una droguería
    }
}