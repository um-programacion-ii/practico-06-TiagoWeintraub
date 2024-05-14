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

public class testEspecialidadDao {
    private EspecialidadDaoImpl especialidadDAO;

    @BeforeEach
    public void setUp() {
        especialidadDAO = new EspecialidadDaoImpl();
    }

    @Test
    public void testCrearEspecialidad() {
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre("Cardiologia");
        Especialidad especialidadCreada = especialidadDAO.crearEspecialidad(especialidad);
        assertEquals(especialidad, especialidadCreada);
    }

    @Test
    public void testVisualizarEspecialidad() {
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre("Cardiologia");
        Especialidad especialidadCreada = especialidadDAO.crearEspecialidad(especialidad);
        Especialidad especialidadVisualizada = especialidadDAO.visualizarEspecialidad(especialidadCreada.getId());
        assertEquals(especialidadCreada, especialidadVisualizada);
    }

    @Test
    public void testActualizarEspecialidad() {
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre("Cardiologia");
        Especialidad especialidadCreada = especialidadDAO.crearEspecialidad(especialidad);
        especialidadCreada.setNombre("Traumatologia");
        especialidadDAO.actualizarEspecialidad(especialidadCreada);
        Especialidad especialidadActualizada = especialidadDAO.visualizarEspecialidad(especialidadCreada.getId());
        assertEquals(especialidadCreada, especialidadActualizada);
    }

    @Test
    public void testEliminarEspecialidad() {
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre("Cardiologia");
        Especialidad especialidadCreada = especialidadDAO.crearEspecialidad(especialidad);
        especialidadDAO.eliminarEspecialidad(especialidadCreada.getId());
        Especialidad especialidadEliminada = especialidadDAO.visualizarEspecialidad(especialidadCreada.getId());
        assertEquals(null, especialidadEliminada);
    }
}
