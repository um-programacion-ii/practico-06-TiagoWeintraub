package clinica.dao.implementaciones;

import clinica.dao.interfaces.TurnoDao;
import clinica.entidades.Turno;
import java.util.HashMap;
import java.util.Map;

public class TurnoDaoImpl implements TurnoDao {
    private final Map<Integer, Turno> turnos = new HashMap<>();
    private int proximoId = 1;

    @Override
    public Turno crearTurno(Turno turno) {
        turno.setId(proximoId++);
        turnos.put(turno.getId(), turno);
        turno.getMedico().agregarTurno(turno);
        turno.getPaciente().agregarTurno(turno);
        return turno;
    }

    @Override
    public Turno visualizarTurno(int id) {
        return turnos.get(id);
    }

    @Override
    public void actualizarTurno(Turno turno) {
        turnos.put(turno.getId(), turno);
    }

    @Override
    public void eliminarTurno(int id) {
        turnos.remove(id);
    }

}