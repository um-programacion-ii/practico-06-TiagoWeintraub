package clinica.dao.interfaces;

import clinica.entidades.Medico;

public interface MedicoDAO {
    Medico crearMedico(Medico medico);
    Medico visualizarMedico(int id);
    void actualizarMedico(Medico medico);
    void eliminarMedico(int id);
}

