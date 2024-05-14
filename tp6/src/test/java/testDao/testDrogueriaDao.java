package testDao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import clinica.entidades.*;
import clinica.dao.implementaciones.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class testDrogueriaDao {
    private DrogueriaDaoImpl drogueriaDao;

    @BeforeEach
    public void setUp() {
        drogueriaDao = new DrogueriaDaoImpl();
    }

    @Test
    public void testCrearDrogueria() {
        Drogueria drogueria = new Drogueria();
        drogueria.setNombre("Drogueria Lionel Andres Messi");
        drogueria.setDireccion("Calle Copa del Mundo #2022");
        drogueria.setTelefono(261456790);

        drogueriaDao.crearDrogueria(drogueria);

        assertEquals(drogueria, drogueriaDao.crearDrogueria(drogueria));
    }

    @Test
    public void testBuscarDrogueria() {
        Drogueria drogueria = new Drogueria();
        drogueria.setNombre("Drogueria Lionel Andres Messi");
        drogueria.setDireccion("Calle Copa del Mundo #2022");
        drogueria.setTelefono(261456790);

        drogueriaDao.crearDrogueria(drogueria);
        assertEquals(drogueria, drogueriaDao.visualizarDrogueria(1));
    }

    @Test
    public void testActualizarDrogueria() {
        Drogueria drogueria = new Drogueria();
        drogueria.setNombre("Drogueria Lionel Andres Messi");
        drogueria.setDireccion("Calle Copa del Mundo #2022");
        drogueria.setTelefono(261456790);

        drogueriaDao.crearDrogueria(drogueria);
        drogueria.setNombre("Drogueria Angel Di Maria");
        drogueria.setDireccion("Calle Jugador de Finales #11");
        drogueria.setTelefono(261456791);
        drogueriaDao.actualizarDrogueria(drogueria);
        assertEquals(drogueria, drogueriaDao.visualizarDrogueria(1));
    }

    @Test
    public void testEliminarDrogueria() {
        Drogueria drogueria = new Drogueria();
        drogueria.setNombre("Drogueria Lionel Andres Messi");
        drogueria.setDireccion("Calle Copa del Mundo #2022");
        drogueria.setTelefono(261456790);

        drogueriaDao.crearDrogueria(drogueria);
        drogueriaDao.eliminarDrogueria(1);
        assertEquals(null, drogueriaDao.visualizarDrogueria(1));
    }
}
