package clinica.dao.interfaces;

import clinica.entidades.Drogueria;

public interface DrogueriaDAO {
    Drogueria crearDrogueria(Drogueria drogueria);
    Drogueria visualizarDrogueria(int id);
    void actualizarDrogueria(Drogueria drogueria);
    void eliminarDrogueria(int id);
}