package clinica.dao.interfaces;

import java.util.List;
import clinica.entidades.Paciente;

public interface PacienteDAO {
    Paciente crearPaciente(Paciente paciente);
    Paciente visualizarPaciente(int id);
    void actualizarPaciente(Paciente paciente);
    void eliminarPaciente(int id);
}



