package clinica.dao.interfaces;

import java.util.List;

import clinica.entidades.Paciente;


public interface PacienteDAO {
    Paciente findById(Integer dni);
    List<Paciente> findAll();
    void save(Paciente paciente);
    void update(Paciente paciente);
    void delete(Paciente paciente);
}


