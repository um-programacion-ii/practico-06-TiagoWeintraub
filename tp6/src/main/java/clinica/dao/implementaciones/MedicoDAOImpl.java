package clinica.dao.implementaciones;

import clinica.dao.interfaces.MedicoDAO;
import clinica.entidades.Medico;
import clinica.entidades.ObraSocial;
import clinica.entidades.Especialidad;
import clinica.servicios.GestionTurnoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import clinica.servicios.GestionTurnoService;


public class MedicoDAOImpl implements MedicoDAO {
    private final Map<Integer, Medico> medicos = new HashMap<>();

    private int proximoId = 1;

    @Override
    public Medico crearMedico(Medico medico) {
        medico.setId(proximoId++);
        medicos.put(medico.getId(), medico);
        GestionTurnoService.getInstance().listaMedicos().add(medico);
        return medico;
    }

    @Override
    public Medico visualizarMedico(int id) {
        return medicos.get(id);
    }

    //Listar todos los medicos
    public List<Medico> listaMedicos() {
        return new ArrayList<>(medicos.values());
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
