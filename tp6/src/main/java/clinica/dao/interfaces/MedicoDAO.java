package clinica.dao.interfaces;

import clinica.entidades.Medico;
import java.util.List;

public interface MedicoDAO {
    Medico crearMedico(Medico medico);
    Medico visualizarMedico(int id);
    List<Medico> listaMedicos();
    void actualizarMedico(Medico medico);
    void eliminarMedico(int id);
}

