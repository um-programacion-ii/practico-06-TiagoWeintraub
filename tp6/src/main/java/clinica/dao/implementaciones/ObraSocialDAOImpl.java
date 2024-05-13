package clinica.dao.implementaciones;

import clinica.dao.interfaces.ObraSocialDAO;
import clinica.entidades.ObraSocial;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class ObraSocialDAOImpl implements ObraSocialDAO {
    private final Map<Integer, ObraSocial> obrasSociales = new HashMap<>();
    private int proximoId = 1;

    private ObraSocialDAOImpl() {}

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
