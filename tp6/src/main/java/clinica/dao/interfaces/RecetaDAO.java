package clinica.dao.interfaces;

import clinica.entidades.Receta;

public interface RecetaDAO {
    Receta crearReceta(Receta receta);
    Receta visualizarReceta(int id);
    void actualizarReceta(Receta receta);
    void eliminarReceta(int id);
}
