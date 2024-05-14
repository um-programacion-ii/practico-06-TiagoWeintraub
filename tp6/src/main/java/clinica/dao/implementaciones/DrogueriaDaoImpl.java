package clinica.dao.implementaciones;

import clinica.dao.interfaces.DrogueriaDao;
import clinica.entidades.Drogueria;
import java.util.HashMap;
import java.util.Map;

public class DrogueriaDaoImpl implements DrogueriaDao {
    private final Map<Integer, Drogueria> droguerias = new HashMap<>();
    private int proximoId = 1;

    @Override
    public Drogueria crearDrogueria(Drogueria drogueria) {
        drogueria.setId(proximoId++);
        droguerias.put(drogueria.getId(), drogueria);
        return drogueria;
    }

    @Override
    public Drogueria visualizarDrogueria(int id) {
        return droguerias.get(id);
    }

    @Override
    public void actualizarDrogueria(Drogueria drogueria) {
        droguerias.put(drogueria.getId(), drogueria);
    }

    @Override
    public void eliminarDrogueria(int id) {
        droguerias.remove(id);
    }
}
