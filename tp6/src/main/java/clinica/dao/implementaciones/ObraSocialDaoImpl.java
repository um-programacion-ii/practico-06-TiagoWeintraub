package clinica.dao.implementaciones;

import clinica.dao.interfaces.ObraSocialDao;
import clinica.entidades.ObraSocial;

import java.util.HashMap;
import java.util.Map;

public class ObraSocialDaoImpl implements ObraSocialDao {
    private final Map<Integer, ObraSocial> obrasSociales = new HashMap<>();
    private int proximoId = 1;

    @Override
    public ObraSocial crearObraSocial(ObraSocial obraSocial) {
        obraSocial.setId(proximoId++);
        obrasSociales.put(obraSocial.getId(), obraSocial);
        return obraSocial;
    }

    @Override
    public ObraSocial visualizarObraSocial(int id) {
        return obrasSociales.get(id);
    }

    @Override
    public void actualizarObraSocial(ObraSocial obraSocial) {
        obrasSociales.put(obraSocial.getId(), obraSocial);
    }

    @Override
    public void eliminarObraSocial(int id) {
        obrasSociales.remove(id);
    }
}
