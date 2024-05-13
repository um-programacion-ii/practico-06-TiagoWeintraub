package clinica.dao.implementaciones;

import clinica.dao.interfaces.MedicoDAO;
import clinica.entidades.Medico;
import clinica.entidades.ObraSocial;
import clinica.entidades.Especialidad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//private Integer id;
//private String nombre;
//private String apellido;
//private String especialidad;
//private List<ObraSocial> obrasSociales;
//private Boolean estaAtendiendo;

import clinica.dao.interfaces.MedicoDAO;
import clinica.entidades.Medico;
import java.util.HashMap;
import java.util.Map;

public class MedicoDAOImpl implements MedicoDAO {
    private static MedicoDAOImpl instancia;
    private final Map<Integer, Medico> medicos = new HashMap<>();
    private int proximoId = 1;

    private MedicoDAOImpl() {}

    public static MedicoDAOImpl getInstance() {
        if (instancia == null) {
            instancia = new MedicoDAOImpl();
        }
        return instancia;
    }

    @Override
    public Medico crearMedico(Medico medico) {
        medico.setId(proximoId++);
        medicos.put(medico.getId(), medico);
        return medico;
    }

    @Override
    public Medico visualizarMedico(int id) {
        return medicos.get(id);
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
