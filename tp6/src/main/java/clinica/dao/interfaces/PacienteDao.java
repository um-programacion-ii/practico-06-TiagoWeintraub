package clinica.dao.interfaces;

import clinica.entidades.Paciente;

public interface PacienteDao {
    Paciente crearPaciente(Paciente paciente);
    Paciente visualizarPaciente(int id);
    void actualizarPaciente(Paciente paciente);
    void eliminarPaciente(int id);
}



