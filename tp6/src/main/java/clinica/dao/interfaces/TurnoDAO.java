package clinica.dao.interfaces;

import clinica.entidades.*;

public interface TurnoDAO {
    Turno crearTurno(Turno turno);
    Turno visualizarTurno(int id);
    void actualizarTurno(Turno turno);
    void eliminarTurno(int id);
}