package clinica.dao.implementaciones;

import clinica.dao.interfaces.RecetaDAO;
import clinica.entidades.Receta;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecetaDAOImpl implements RecetaDAO {
    private static RecetaDAOImpl instancia;
    private final Map<Integer, Receta> recetas = new HashMap<>();
    private int proximoId = 1;

    private RecetaDAOImpl() {}

    public static RecetaDAOImpl getInstance() {
        if (instancia == null) {
            instancia = new RecetaDAOImpl();
        }
        return instancia;
    }

    @Override
    public Receta crearReceta(Receta receta) {
        receta.setId(proximoId++);
        recetas.put(receta.getId(), receta);
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
