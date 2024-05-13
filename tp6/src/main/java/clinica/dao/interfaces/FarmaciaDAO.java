package clinica.dao.interfaces;

import java.util.List;
import clinica.entidades.Farmacia;

public interface FarmaciaDAO {
    Farmacia crearFarmacia(Farmacia farmacia);
    Farmacia visualizarFarmacia(int id);
    void actualizarFarmacia(Farmacia farmacia);
    void eliminarFarmacia(int id);
}

