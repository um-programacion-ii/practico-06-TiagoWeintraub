package clinica.dao.implementaciones;

import clinica.dao.interfaces.PacienteDAO;
import clinica.entidades.Paciente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PacienteDAOimpl implements PacienteDAO {
    private Map<Integer, Paciente> pacienteMap = new HashMap<>();

    @Override
    public Paciente findById(Integer dni) {
        return pacienteMap.get(dni);
    }

    @Override
    public List<Paciente> findAll() {
        return new ArrayList<>(pacienteMap.values());
    }

    @Override
    public void save(Paciente paciente) {
        pacienteMap.put(paciente.getDni(), paciente);
    }

    @Override
    public void update(Paciente paciente) {
        pacienteMap.put(paciente.getDni(), paciente);
    }

    @Override
    public void delete(Paciente paciente) {
        pacienteMap.remove(paciente.getDni());
    }
}