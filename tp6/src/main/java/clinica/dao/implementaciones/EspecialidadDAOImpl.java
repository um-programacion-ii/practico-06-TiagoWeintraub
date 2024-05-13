package clinica.dao.implementaciones;

import clinica.dao.interfaces.EspecialidadDAO;
import clinica.entidades.Especialidad;
import java.util.HashMap;
import java.util.Map;


public class EspecialidadDAOImpl implements EspecialidadDAO {
    private final Map<Integer, Especialidad> especialidades = new HashMap<>();
    private int proximoId = 1;

    private EspecialidadDAOImpl() {}

    @Override
    public Especialidad crearEspecialidad(Especialidad especialidad) {
        especialidad.setId(proximoId++);
        especialidades.put(especialidad.getId(), especialidad);
        return especialidad;
    }

    @Override
    public Especialidad visualizarEspecialidad(int id) {
        return especialidades.get(id);
    }

    @Override
    public void actualizarEspecialidad(Especialidad especialidad) {
        especialidades.put(especialidad.getId(), especialidad);
    }

    @Override
    public void eliminarEspecialidad(int id) {
        especialidades.remove(id);
    }
}
