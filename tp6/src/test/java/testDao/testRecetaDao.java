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

public class testRecetaDao {
    private RecetaDaoImpl recetaDAO;

    @BeforeEach
    public void setUp() {
        recetaDAO = new RecetaDaoImpl();
    }

    @Test
    public void testCrearReceta() {
        Paciente paciente = new Paciente();
        paciente.setDni(40123432);
        paciente.setNombre("Maria");
        paciente.setApellido("Gomez");
        paciente.setObraSocial(null);
        List<Receta> listaRecetas = new ArrayList<>();
        paciente.setRecetas(listaRecetas);
        List<Turno> listaTurnosPaciente = new ArrayList<>();
        paciente.setTurnos(listaTurnosPaciente);


        Medicamento medicamento = new Medicamento();
        medicamento.setNombre("Ibupirac 600");

        Receta receta = new Receta();

        Map<Medicamento, Integer> medicamentos = new HashMap<Medicamento, Integer>();
        medicamentos.put(medicamento, 2);

        receta.setMedicamentos(medicamentos);
        receta.setPaciente(paciente);
        receta.setMedico(new Medico());
        Receta recetaCreada = recetaDAO.crearReceta(receta);
        assertEquals(receta, recetaCreada);
        assertEquals(paciente.getRecetas().get(0), recetaCreada);
    }

    @Test
    public void testVisualizarReceta() {
        Paciente paciente = new Paciente();
        paciente.setDni(40123432);
        paciente.setNombre("Maria");
        paciente.setApellido("Gomez");
        paciente.setObraSocial(null);
        List<Receta> listaRecetas = new ArrayList<>();
        paciente.setRecetas(listaRecetas);
        List<Turno> listaTurnosPaciente = new ArrayList<>();
        paciente.setTurnos(listaTurnosPaciente);


        Medicamento medicamento = new Medicamento();
        medicamento.setNombre("Ibupirac 600");

        Receta receta = new Receta();

        Map<Medicamento, Integer> medicamentos = new HashMap<Medicamento, Integer>();
        medicamentos.put(medicamento, 2);

        receta.setPaciente(paciente);
        receta.setMedico(new Medico());
        Receta recetaCreada = recetaDAO.crearReceta(receta);
        Receta recetaVisualizada = recetaDAO.visualizarReceta(recetaCreada.getId());
        assertEquals(recetaCreada, recetaVisualizada);
    }

    @Test
    public void testActualizarReceta() {
        Paciente paciente = new Paciente();
        paciente.setDni(40123432);
        paciente.setNombre("Maria");
        paciente.setApellido("Gomez");
        paciente.setObraSocial(null);
        List<Receta> listaRecetas = new ArrayList<>();
        paciente.setRecetas(listaRecetas);
        List<Turno> listaTurnosPaciente = new ArrayList<>();
        paciente.setTurnos(listaTurnosPaciente);

        Medicamento medicamento = new Medicamento();
        medicamento.setNombre("Ibupirac 600");

        Receta receta = new Receta();

        Map<Medicamento, Integer> medicamentos = new HashMap<Medicamento, Integer>();
        medicamentos.put(medicamento, 2);

        receta.setPaciente(paciente);
        receta.setMedico(new Medico());
        Receta recetaCreada = recetaDAO.crearReceta(receta);
        recetaCreada.setMedico(new Medico());
        recetaDAO.actualizarReceta(recetaCreada);
        Receta recetaActualizada = recetaDAO.visualizarReceta(recetaCreada.getId());
        assertEquals(recetaCreada, recetaActualizada);
    }

    @Test
    public void testEliminarReceta() {
        Paciente paciente = new Paciente();
        paciente.setDni(40123432);
        paciente.setNombre("Maria");
        paciente.setApellido("Gomez");
        paciente.setObraSocial(null);
        List<Receta> listaRecetas = new ArrayList<>();
        paciente.setRecetas(listaRecetas);
        List<Turno> listaTurnosPaciente = new ArrayList<>();
        paciente.setTurnos(listaTurnosPaciente);

        Medicamento medicamento = new Medicamento();
        medicamento.setNombre("Ibupirac 600");

        Receta receta = new Receta();

        Map<Medicamento, Integer> medicamentos = new HashMap<Medicamento, Integer>();
        medicamentos.put(medicamento, 2);

        receta.setPaciente(paciente);
        receta.setMedico(new Medico());
        Receta recetaCreada = recetaDAO.crearReceta(receta);
        recetaDAO.eliminarReceta(recetaCreada.getId());
        Receta recetaEliminada = recetaDAO.visualizarReceta(recetaCreada.getId());
        assertEquals(null, recetaEliminada);
    }
}
