package testDao;

import clinica.dao.implementaciones.*;
import clinica.entidades.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testObraSocialDao { //Tests de la clase ObraSocialDAO
    private ObraSocialDaoImpl obraSocialDAO;
    private ObraSocial obraSocial;
    private Paciente paciente;

    @BeforeEach
    public void setUp() {
        obraSocialDAO = new ObraSocialDaoImpl();
    }

    @Test
    public void testCrearObraSocial() {
        obraSocial = new ObraSocial(1, "OSDE");
        ObraSocial obraSocialCreada = obraSocialDAO.crearObraSocial(obraSocial);
        assertEquals(obraSocial, obraSocialCreada);
    }

    @Test
    public void testVisualizarObraSocial() {
        obraSocial = new ObraSocial(1, "OSDE");
        obraSocialDAO.crearObraSocial(obraSocial);
        ObraSocial obraSocialVisualizada = obraSocialDAO.visualizarObraSocial(1);
        assertEquals(obraSocial, obraSocialVisualizada);
    }

    @Test
    public void testActualizarObraSocial() {
        obraSocial = new ObraSocial(1, "OSDE");
        obraSocialDAO.crearObraSocial(obraSocial);
        ObraSocial obraSocialActualizada = new ObraSocial(1, "osdeActualizado");
        obraSocialDAO.actualizarObraSocial(obraSocialActualizada);
        ObraSocial obraSocialVisualizada = obraSocialDAO.visualizarObraSocial(1);
        assertEquals(obraSocialActualizada, obraSocialVisualizada);
    }

    @Test
    public void testEliminarObraSocial() {
        obraSocial = new ObraSocial(1, "OSDE 210");
        obraSocialDAO.crearObraSocial(obraSocial);
        obraSocialDAO.eliminarObraSocial(1);
        ObraSocial obraSocialVisualizada = obraSocialDAO.visualizarObraSocial(1);
        assertEquals(null, obraSocialVisualizada);
    }
}

