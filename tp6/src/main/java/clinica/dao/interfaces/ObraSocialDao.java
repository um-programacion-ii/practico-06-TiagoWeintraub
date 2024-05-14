package clinica.dao.interfaces;

import clinica.entidades.ObraSocial;

public interface ObraSocialDao {
    ObraSocial crearObraSocial(ObraSocial obraSocial);
    ObraSocial visualizarObraSocial(int id);
    void actualizarObraSocial(ObraSocial obraSocial);
    void eliminarObraSocial(int id);
}