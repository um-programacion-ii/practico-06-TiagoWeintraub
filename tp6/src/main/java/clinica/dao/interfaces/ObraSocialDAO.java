package clinica.dao.interfaces;

import clinica.entidades.ObraSocial;
import java.util.List;

public interface ObraSocialDAO {
    ObraSocial crearObraSocial(ObraSocial obraSocial);
    ObraSocial visualizarObraSocial(int id);
    void actualizarObraSocial(ObraSocial obraSocial);
    void eliminarObraSocial(int id);
}