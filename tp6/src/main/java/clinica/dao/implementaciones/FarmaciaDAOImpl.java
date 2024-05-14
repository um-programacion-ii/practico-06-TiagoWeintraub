package clinica.dao.implementaciones;

import clinica.dao.interfaces.FarmaciaDAO;
import clinica.entidades.Farmacia;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FarmaciaDAOImpl implements FarmaciaDAO {
    private final Map<Integer, Farmacia> farmacias = new HashMap<>();
    private int proximoId = 1;

    @Override
    public Farmacia crearFarmacia(Farmacia farmacia) {
        farmacia.setId(proximoId++);
        farmacias.put(farmacia.getId(), farmacia);
        return farmacia;
    }

    @Override
    public Farmacia visualizarFarmacia(int id) {
        return farmacias.get(id);
    }

    @Override
    public void actualizarFarmacia(Farmacia farmacia) {
        farmacias.put(farmacia.getId(), farmacia);
    }

    @Override
    public void eliminarFarmacia(int id) {
        farmacias.remove(id);
    }
}