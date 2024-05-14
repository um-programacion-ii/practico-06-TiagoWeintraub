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

public class testTurnoDao {
    private TurnoDaoImpl turnoDao;


    @BeforeEach
    public void setUp() {
        turnoDao = new TurnoDaoImpl();
    }

    @Test
    public void testCrearTurno() {
        List<ObraSocial> listaObrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");

        Especialidad especialidad = new Especialidad(1, "Cardiologia");

        Medico medico = new Medico();
        medico.setId(1);
        medico.setNombre("Juan");
        medico.setApellido("Perez");
        medico.setEspecialidad(especialidad);
        medico.setObrasSociales(listaObrasSociales);
        medico.setAtiendeParticular(true);
        medico.setEstaAtendiendo(false);
        List<Turno> listaTurnosMedico = new ArrayList<>();
        medico.setTurnos(listaTurnosMedico);

        Paciente paciente = new Paciente();
        paciente.setDni(40123432);
        paciente.setNombre("Maria");
        paciente.setApellido("Gomez");
        paciente.setObraSocial(obraSocial2);
        List<Receta> listaRecetas = new ArrayList<>();
        paciente.setRecetas(listaRecetas);
        List<Turno> listaTurnosPaciente = new ArrayList<>();
        paciente.setTurnos(listaTurnosPaciente);

        Turno turno = new Turno();
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        turno.setEspecialidad(especialidad);
        turno.setObraSocial(obraSocial2);

        Turno turnoCreado = turnoDao.crearTurno(turno);
        assertEquals(turno, turnoCreado);
    }

    @Test
    public void testVisualizarTurno() {
        List<ObraSocial> listaObrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");

        Especialidad especialidad = new Especialidad(1, "Cardiologia");

        Medico medico = new Medico();
        medico.setId(1);
        medico.setNombre("Juan");
        medico.setApellido("Perez");
        medico.setEspecialidad(especialidad);
        medico.setObrasSociales(listaObrasSociales);
        medico.setAtiendeParticular(true);
        medico.setEstaAtendiendo(false);
        List<Turno> listaTurnosMedico = new ArrayList<>();
        medico.setTurnos(listaTurnosMedico);

        Paciente paciente = new Paciente();
        paciente.setDni(40123432);
        paciente.setNombre("Maria");
        paciente.setApellido("Gomez");
        paciente.setObraSocial(obraSocial2);
        List<Receta> listaRecetas = new ArrayList<>();
        paciente.setRecetas(listaRecetas);
        List<Turno> listaTurnosPaciente = new ArrayList<>();
        paciente.setTurnos(listaTurnosPaciente);

        Turno turno = new Turno();
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        turno.setEspecialidad(especialidad);
        turno.setObraSocial(obraSocial2);

        turnoDao.crearTurno(turno);
        Turno turnoVisualizado = turnoDao.visualizarTurno(1);
        assertEquals(turno, turnoVisualizado);
    }

    @Test
    public void testActualizarTurno() {
        List<ObraSocial> listaObrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");

        Especialidad especialidad = new Especialidad(1, "Cardiologia");

        Medico medico = new Medico();
        medico.setId(1);
        medico.setNombre("Juan");
        medico.setApellido("Perez");
        medico.setEspecialidad(especialidad);
        medico.setObrasSociales(listaObrasSociales);
        medico.setAtiendeParticular(true);
        medico.setEstaAtendiendo(false);
        List<Turno> listaTurnosMedico = new ArrayList<>();
        medico.setTurnos(listaTurnosMedico);

        Paciente paciente = new Paciente();
        paciente.setDni(40123432);
        paciente.setNombre("Maria");
        paciente.setApellido("Gomez");
        paciente.setObraSocial(obraSocial2);
        List<Receta> listaRecetas = new ArrayList<>();
        paciente.setRecetas(listaRecetas);
        List<Turno> listaTurnosPaciente = new ArrayList<>();
        paciente.setTurnos(listaTurnosPaciente);

        Turno turno = new Turno();
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        turno.setEspecialidad(especialidad);
        turno.setObraSocial(obraSocial2);

        turnoDao.crearTurno(turno);

        Turno turnoActualizado = new Turno();
        turnoActualizado.setId(1);
        turnoActualizado.setPaciente(paciente);
        turnoActualizado.setMedico(medico);
        turnoActualizado.setEspecialidad(especialidad);
        turnoActualizado.setObraSocial(obraSocial1);

        turnoDao.actualizarTurno(turnoActualizado);
        Turno turnoVisualizado = turnoDao.visualizarTurno(1);
        assertEquals(turnoActualizado, turnoVisualizado);
    }

    @Test
    public void testEliminarTurno() {
        List<ObraSocial> listaObrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");

        Especialidad especialidad = new Especialidad(1, "Cardiologia");

        Medico medico = new Medico();
        medico.setId(1);
        medico.setNombre("Juan");
        medico.setApellido("Perez");
        medico.setEspecialidad(especialidad);
        medico.setObrasSociales(listaObrasSociales);
        medico.setAtiendeParticular(true);
        medico.setEstaAtendiendo(false);
        List<Turno> listaTurnosMedico = new ArrayList<>();
        medico.setTurnos(listaTurnosMedico);

        Paciente paciente = new Paciente();
        paciente.setDni(40123432);
        paciente.setNombre("Maria");
        paciente.setApellido("Gomez");
        paciente.setObraSocial(obraSocial2);
        List<Receta> listaRecetas = new ArrayList<>();
        paciente.setRecetas(listaRecetas);
        List<Turno> listaTurnosPaciente = new ArrayList<>();
        paciente.setTurnos(listaTurnosPaciente);

        Turno turno = new Turno();
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        turno.setEspecialidad(especialidad);
        turno.setObraSocial(obraSocial2);

        turnoDao.crearTurno(turno);
        turnoDao.eliminarTurno(1);
        Turno turnoVisualizado = turnoDao.visualizarTurno(1);
        assertEquals(null, turnoVisualizado);
    }


}
