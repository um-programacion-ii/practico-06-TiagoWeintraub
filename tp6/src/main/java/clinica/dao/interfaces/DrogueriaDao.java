package clinica.dao.interfaces;

import clinica.entidades.Drogueria;

public interface DrogueriaDao {
    Drogueria crearDrogueria(Drogueria drogueria);
    Drogueria visualizarDrogueria(int id);
    void actualizarDrogueria(Drogueria drogueria);
    void eliminarDrogueria(int id);
}