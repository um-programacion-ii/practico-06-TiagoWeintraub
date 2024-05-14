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
    private ObraSocial obraSocial; // Si no tiene obra social, la lista estará vacía (Visita particular)
    private List<Receta> recetas;
    private List<Turno> turnos;

    public void recibirReceta(Receta receta) {
        this.recetas.add(receta);
    }


    public Turno solicitarTurno(Medico medico, Especialidad especialidad, ObraSocial obraSocial) {
        // Sacar turno y agregar a la lista de turnos
        Turno turno = new Turno();
        turno.setPaciente(this);
        turno.setMedico(medico);
        turno.setEspecialidad(especialidad);
        turno.setObraSocial(obraSocial);
        return turno;
    }

    public void comprarMedicamentos(Farmacia farmacia, Receta receta) {
        // Implementa la lógica para comprar los medicamentos de una receta en una droguería
    }

    public void agregarTurno(Turno turno) {
        turnos.add(turno);
    }

    public void cancelarTurno(Turno turno) {
        this.turnos.remove(turno);
    }
}