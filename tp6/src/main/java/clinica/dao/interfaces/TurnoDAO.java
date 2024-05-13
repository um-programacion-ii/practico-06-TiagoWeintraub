package clinica.dao.interfaces;

import clinica.entidades.*;

public interface TurnoDAO {
    Turno crearTurno(Paciente paciente, Medico medico, Especialidad especialidad, ObraSocial obraSocial);
    Turno visualizarTurno(int id);
    void actualizarTurno(Turno turno);
    void eliminarTurno(int id);
}