package clinica.dao.interfaces;

import clinica.entidades.Especialidad;

public interface EspecialidadDAO {
    Especialidad crearEspecialidad(Especialidad especialidad);
    Especialidad visualizarEspecialidad(int id);
    void actualizarEspecialidad(Especialidad especialidad);
    void eliminarEspecialidad(int id);
}