package clinica.dao.interfaces;

import clinica.entidades.Turno;

public interface TurnoDAO {
    Turno crearTurno(Turno turno);
    Turno visualizarTurno(int id);
    void actualizarTurno(Turno turno);
    void eliminarTurno(int id);
}