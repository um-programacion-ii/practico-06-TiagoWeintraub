package clinica.dao.implementaciones;

import clinica.dao.interfaces.MedicoDao;
import clinica.entidades.Medico;
import clinica.entidades.ObraSocial;
import clinica.entidades.Especialidad;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MedicoDaoImpl implements MedicoDao {
    private final Map<Integer, Medico> medicos = new HashMap<>();

    private int proximoId = 1;

    @Override
    public Medico crearMedico(Medico medico) {
        medico.setId(proximoId++);
        medicos.put(medico.getId(), medico);
        this.listaMedicos().add(medico);
        return medico;
    }

    @Override
    public Medico visualizarMedico(int id) {
        return medicos.get(id);
    }

    // Lista de todos los medicos
    @Override
    public List<Medico> listaMedicos() {
        return new ArrayList<>(medicos.values());
    }

    //Lista de todos los medicos que atienden particular
    @Override
    public List<Medico> listaMedicosParticular() {
        List<Medico> medicosFiltrados = new ArrayList<>();
        for (Medico medico : medicos.values()) {
            if (medico.getAtiendeParticular()) {
                medicosFiltrados.add(medico);
            }
        }
        return medicosFiltrados;
    }


    // Devuelve un map entre cada medico de la lista medico y las obras sociales que atiende
    @Override
    public Map<Medico, List<ObraSocial>> listaMedicosPorEspecialidad(Especialidad especialidad) {
        Map<Medico, List<ObraSocial>> medicosPorEspecialidad = new HashMap<>();
        for (Medico medico : medicos.values()) {
            if (medico.getEspecialidad().equals(especialidad)) {
                medicosPorEspecialidad.put(medico, medico.getObrasSociales());
            }
        }
        return medicosPorEspecialidad;
    }

    @Override
    public void actualizarMedico(Medico medico) {
        medicos.put(medico.getId(), medico);
    }

    @Override
    public void eliminarMedico(int id) {
        medicos.remove(id);
    }
}
