package clinica.dao.interfaces;

import clinica.entidades.Especialidad;
import clinica.entidades.Medico;
import clinica.entidades.ObraSocial;

import java.util.List;
import java.util.Map;

public interface MedicoDao {
    Medico crearMedico(Medico medico);
    Medico visualizarMedico(int id);
    List<Medico> listaMedicos();
    List<Medico> listaMedicosParticular();
    Map<Medico, List<ObraSocial>> listaMedicosPorEspecialidad(Especialidad especialidad);
    void actualizarMedico(Medico medico);
    void eliminarMedico(int id);
}

