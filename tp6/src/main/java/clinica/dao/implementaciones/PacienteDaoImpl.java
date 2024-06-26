package clinica.dao.implementaciones;

import clinica.dao.interfaces.PacienteDao;
import clinica.entidades.Paciente;
import java.util.HashMap;
import java.util.Map;

public class PacienteDaoImpl implements PacienteDao {
    private final Map<Integer, Paciente> pacientes = new HashMap<>();
    private int proximoId = 1;

    @Override
    public Paciente crearPaciente(Paciente paciente) {
        paciente.setDni(proximoId++);
        pacientes.put(paciente.getDni(), paciente);
        return paciente;
    }

    @Override
    public Paciente visualizarPaciente(int dni) {
        return pacientes.get(dni);
    }

    @Override
    public void actualizarPaciente(Paciente paciente) {
        pacientes.put(paciente.getDni(), paciente);
    }

    @Override
    public void eliminarPaciente(int dni) {
        pacientes.remove(dni);
    }
}
