package entidades;

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
    private List<String> obrasSociales; // Si no tiene obra social, la lista estará vacía (Visita particular)
    private List<String> recetas;
    public void recibirReceta(String receta) {
        this.recetas.add(receta);
    }

    public void solicitarTurno(String medico, String especialidad, String obraSocial) {
        // Implementa la lógica para solicitar un turno con un médico
    }

    public void comprarMedicamentos(String farmacia, String receta) {
        // Implementa la lógica para comprar los medicamentos de una receta en una droguería
    }
}