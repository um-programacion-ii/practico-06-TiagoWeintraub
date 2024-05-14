package clinica.dao.interfaces;

import clinica.entidades.Farmacia;

public interface FarmaciaDao {
    Farmacia crearFarmacia(Farmacia farmacia);
    Farmacia visualizarFarmacia(int id);
    void actualizarFarmacia(Farmacia farmacia);
    void eliminarFarmacia(int id);
}

