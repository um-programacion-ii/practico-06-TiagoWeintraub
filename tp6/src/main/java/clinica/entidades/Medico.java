package clinica.entidades;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Medico {
    private Integer id;
    private String nombre;
    private String apellido;
    private Especialidad especialidad;
    private List<ObraSocial> obrasSociales;
    private Boolean atiendeParticular;
    private List<Turno> turnos;
    private Boolean estaAtendiendo;

public void hacerReceta(Integer id, Paciente paciente, Medico medico, Map<String, Integer> medicamentos) {
    Receta receta = new Receta(id, paciente, medico, medicamentos);
    paciente.getRecetas().add(receta);
}
    public void atenderPaciente() {
        this.estaAtendiendo = true;
    }

    public void finalizarAtencion() {
        this.estaAtendiendo = false;
    }

public void agregarTurno(Turno turno) {
        turnos.add(turno);
    }


    public void cancelarTurno(Turno turno) {
        this.turnos.remove(turno);
    }
}
