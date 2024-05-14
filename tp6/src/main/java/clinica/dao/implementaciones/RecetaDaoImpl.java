package clinica.dao.implementaciones;

import clinica.dao.interfaces.RecetaDao;
import clinica.entidades.Receta;
import java.util.HashMap;
import java.util.Map;

public class RecetaDaoImpl implements RecetaDao {
    private final Map<Integer, Receta> recetas = new HashMap<>();
    private int proximoId = 1;

    @Override
    public Receta crearReceta(Receta receta) {
        receta.setId(proximoId++);
        recetas.put(receta.getId(), receta);
        receta.getPaciente().recibirReceta(receta);
        return receta;
    }

    @Override
    public Receta visualizarReceta(int id) {
        return recetas.get(id);
    }

    @Override
    public void actualizarReceta(Receta receta) {
        recetas.put(receta.getId(), receta);
    }

    @Override
    public void eliminarReceta(int id) {


        recetas.remove(id);

    }
}
