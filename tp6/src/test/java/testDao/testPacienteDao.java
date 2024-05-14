package testDao;

import clinica.dao.implementaciones.*;
import clinica.entidades.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class testPacienteDao {
    private PacienteDaoImpl pacienteDao;
    private Paciente paciente;
    private Map<Integer, Paciente> pacientes;

    @BeforeEach
    public void setUp() {
        pacienteDao = new PacienteDaoImpl();
        paciente = new Paciente();
    }

    @Test
    public void testCrearPaciente() {

        List<Receta> recetas = new ArrayList<Receta>();
        List<Turno> turnos = new ArrayList<Turno>();

        ObraSocial obraSocial = new ObraSocial();
        obraSocial.setNombre("OSDE");


        paciente.setDni(1);
        paciente.setNombre("Tiago");
        paciente.setApellido("Weintraub");
        paciente.setObraSocial(obraSocial);
        paciente.setRecetas(recetas);
        paciente.setTurnos(turnos);

        pacienteDao.crearPaciente(paciente);

        assertEquals(paciente, pacienteDao.visualizarPaciente(1));
    }

    @Test
    public void testVisualizarPaciente() {
        List<Receta> recetas = new ArrayList<Receta>();
        List<Turno> turnos = new ArrayList<Turno>();

        ObraSocial obraSocial = new ObraSocial();
        obraSocial.setNombre("OSDE");

        paciente.setDni(1);
        paciente.setNombre("Tiago");
        paciente.setApellido("Weintraub");
        paciente.setObraSocial(obraSocial);
        paciente.setRecetas(recetas);
        paciente.setTurnos(turnos);

        pacienteDao.crearPaciente(paciente);

        assertEquals(paciente, pacienteDao.visualizarPaciente(1));
    }

    @Test
    public void testActualizarPaciente() {
        List<Receta> recetas = new ArrayList<Receta>();
        List<Turno> turnos = new ArrayList<Turno>();

        ObraSocial obraSocial = new ObraSocial();
        obraSocial.setNombre("OSDE");

        paciente.setDni(1);
        paciente.setNombre("Tiago");
        paciente.setApellido("Weintraub");
        paciente.setObraSocial(obraSocial);
        paciente.setRecetas(recetas);
        paciente.setTurnos(turnos);

        pacienteDao.crearPaciente(paciente);

        paciente.setNombre("Tiago Lionel");
        paciente.setApellido("Messi");

        pacienteDao.actualizarPaciente(paciente);

        assertEquals(paciente, pacienteDao.visualizarPaciente(1));
    }

    @Test
    public void testEliminarPaciente() {
        List<Receta> recetas = new ArrayList<Receta>();
        List<Turno> turnos = new ArrayList<Turno>();

        ObraSocial obraSocial = new ObraSocial();
        obraSocial.setNombre("OSDE");

        paciente.setDni(1);
        paciente.setNombre("Tiago");
        paciente.setApellido("Weintraub");
        paciente.setObraSocial(obraSocial);
        paciente.setRecetas(recetas);
        paciente.setTurnos(turnos);

        pacienteDao.crearPaciente(paciente);

        pacienteDao.eliminarPaciente(1);

        assertEquals(null, pacienteDao.visualizarPaciente(1));
    }
}
