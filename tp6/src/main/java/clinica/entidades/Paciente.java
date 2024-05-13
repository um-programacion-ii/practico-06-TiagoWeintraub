package clinica.entidades;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;
import clinica.dao.interfaces.TurnoDAO;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private Integer dni;
    private String nombre;
    private String apellido;
    private ObraSocial obrasSociales; // Si no tiene obra social, la lista estará vacía (Visita particular)
    private List<Receta> recetas;
    private List<Turno> turnos;

    public void recibirReceta(Receta receta) {
        this.recetas.add(receta);
    }

    private TurnoDAO turnoDAO;

    public void solicitarTurno(Paciente paciente,Medico medico, Especialidad especialidad, ObraSocial obraSocial) {
        // Sacar turno y agregar a la lista
        this.turnos.add(turnoDAO.crearTurno(paciente, medico, especialidad, obraSocial));

    }

    public void comprarMedicamentos(Farmacia farmacia, Receta receta) {
        // Implementa la lógica para comprar los medicamentos de una receta en una droguería
    }

    public void cancelarTurno(Turno turno) {
        this.turnos.remove(turno);
    }
}