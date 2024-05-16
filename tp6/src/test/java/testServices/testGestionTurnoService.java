package testServices;

import clinica.entidades.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import clinica.servicios.GestionTurnoService;
import clinica.dao.interfaces.TurnoDao;
import clinica.dao.implementaciones.TurnoDaoImpl;
import clinica.dao.interfaces.MedicoDao;
import clinica.dao.implementaciones.MedicoDaoImpl;
import clinica.dao.interfaces.PacienteDao;
import clinica.dao.interfaces.ObraSocialDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class testGestionTurnoService {
    private GestionTurnoService gestionTurnoService;
    private TurnoDao turnoDAO;
    private MedicoDao medicoDAO;
    private PacienteDao pacienteDAO;
    private ObraSocialDao obraSocialDAO;



    @BeforeEach
    public void setUp() {
        gestionTurnoService = GestionTurnoService.getInstance();
        turnoDAO = new TurnoDaoImpl();
        medicoDAO = new MedicoDaoImpl();
    }

    @Test
    public void testListaMedicosClinica() {
        List<ObraSocial> listaObrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");

        List<Medico> listaMedicosTest = new ArrayList<>();

        Especialidad especialidad = new Especialidad(1, "Cardiologia");

        Medico medico1 = new Medico();
        medico1.setId(1);
        medico1.setNombre("Juan");
        medico1.setApellido("Perez");
        medico1.setEspecialidad(especialidad);
        medico1.setObrasSociales(listaObrasSociales);
        medico1.setAtiendeParticular(true);
        medico1.setEstaAtendiendo(false);
        List<Turno> listaTurnosMedico1 = new ArrayList<>();
        medico1.setTurnos(listaTurnosMedico1);
        medicoDAO.crearMedico(medico1);

        listaMedicosTest.add(medico1);

        Medico medico2 = new Medico();
        medico2.setId(2);
        medico2.setNombre("Juan");
        medico2.setApellido("Perez");
        medico2.setEspecialidad(especialidad);
        medico2.setObrasSociales(listaObrasSociales);
        medico2.setAtiendeParticular(true);
        medico2.setEstaAtendiendo(false);
        List<Turno> listaTurnosMedico2 = new ArrayList<>();
        medico2.setTurnos(listaTurnosMedico2);
        medicoDAO.crearMedico(medico2);

        listaMedicosTest.add(medico2);

        //medico3
        Medico medico3 = new Medico();
        medico3.setId(3);
        medico3.setNombre("Juan");
        medico3.setApellido("Perez");
        medico3.setEspecialidad(especialidad);
        medico3.setObrasSociales(listaObrasSociales);
        medico3.setAtiendeParticular(true);
        medico3.setEstaAtendiendo(false);
        List<Turno> listaTurnosMedico3 = new ArrayList<>();
        medico3.setTurnos(listaTurnosMedico3);
        medicoDAO.crearMedico(medico3);

        listaMedicosTest.add(medico3);



        assertEquals(listaMedicosTest, medicoDAO.listaMedicos());
    }

    // test lista de medicos
    @Test
    public void testListaMedicosParticular() {
        List<ObraSocial> listaObrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");

        List<Medico> listaMedicosTest = new ArrayList<>();

        Especialidad especialidad = new Especialidad(1, "Cardiologia");

        Medico medico1 = new Medico();
        medico1.setId(1);
        medico1.setNombre("Juan");
        medico1.setApellido("Perez");
        medico1.setEspecialidad(especialidad);
        medico1.setObrasSociales(listaObrasSociales);
        medico1.setAtiendeParticular(true);
        medico1.setEstaAtendiendo(false);
        List<Turno> listaTurnosMedico1 = new ArrayList<>();
        medico1.setTurnos(listaTurnosMedico1);
        medicoDAO.crearMedico(medico1);

        listaMedicosTest.add(medico1);

        Medico medico2 = new Medico();
        medico2.setId(2);
        medico2.setNombre("Juan");
        medico2.setApellido("Perez");
        medico2.setEspecialidad(especialidad);
        medico2.setObrasSociales(listaObrasSociales);
        medico2.setAtiendeParticular(true);
        medico2.setEstaAtendiendo(false);
        List<Turno> listaTurnosMedico2 = new ArrayList<>();
        medico2.setTurnos(listaTurnosMedico2);
        medicoDAO.crearMedico(medico2);

        listaMedicosTest.add(medico2);

        assertEquals(listaMedicosTest, medicoDAO.listaMedicosParticular());
    }

    // test lista de medicos por especialidad
    @Test
    public void testListaMedicosPorEspecialidad() {
        List<ObraSocial> listaObrasSociales1 = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");
        ObraSocial obraSocial3 = new ObraSocial(3, "OSEP");
        ObraSocial obraSocial4 = new ObraSocial(4, "PAMI");

        List<Medico> listaMedicosTest = new ArrayList<>();

        Especialidad especialidad = new Especialidad(1, "Cardiologia");

        Medico medico1 = new Medico();
        medico1.setId(1);
        medico1.setNombre("Juan");
        medico1.setApellido("Perez");
        medico1.setEspecialidad(especialidad);
        medico1.setObrasSociales(listaObrasSociales1);
        medico1.setAtiendeParticular(true);
        medico1.setEstaAtendiendo(false);
        List<Turno> listaTurnosMedico1 = new ArrayList<>();
        medico1.setTurnos(listaTurnosMedico1);
        medicoDAO.crearMedico(medico1);
        listaMedicosTest.add(medico1);


        List<ObraSocial> listaObrasSociales2 = new ArrayList<>();
        listaObrasSociales2.add(obraSocial1);
        listaObrasSociales2.add(obraSocial2);
        listaObrasSociales2.add(obraSocial3);
        listaObrasSociales2.add(obraSocial4);

        Medico medico2 = new Medico();
        medico2.setId(2);
        medico2.setNombre("Juan");
        medico2.setApellido("Perez");
        medico2.setEspecialidad(especialidad);
        medico2.setObrasSociales(listaObrasSociales2);
        medico2.setAtiendeParticular(true);
        medico2.setEstaAtendiendo(false);
        List<Turno> listaTurnosMedico2 = new ArrayList<>();
        medico2.setTurnos(listaTurnosMedico2);
        medicoDAO.crearMedico(medico2);
        listaMedicosTest.add(medico2);

        Map<Medico, List<ObraSocial>> medicosMap = new HashMap<>();
        medicosMap.put(medico1, listaObrasSociales1);
        medicosMap.put(medico2, listaObrasSociales2);

        assertEquals(medicosMap, medicoDAO.listaMedicosPorEspecialidad(especialidad));
    }

    @Test
    public void testPacienteSolicitaTurnoParticular() {
        List<ObraSocial> listaObrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");

        listaObrasSociales.add(obraSocial1);
        listaObrasSociales.add(obraSocial2);

        Especialidad especialidad = new Especialidad(1, "Cardiologia");

        Medico medico = new Medico();
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
        paciente.setObraSocial(null);
        List<Receta> listaRecetas = new ArrayList<>();
        paciente.setRecetas(listaRecetas);
        List<Turno> listaTurnosPaciente = new ArrayList<>();
        paciente.setTurnos(listaTurnosPaciente);

        Turno turno = new Turno();
        turno.setId(2);
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        turno.setEspecialidad(especialidad);
        turno.setObraSocial(null);
        Turno turnoCreado = gestionTurnoService.pacienteSolicitaTurno(paciente, medico, especialidad);
        assertEquals(turno, turnoCreado);
        assertEquals(1, medico.getTurnos().size());
        assertEquals(medico.getTurnos(), paciente.getTurnos());
    }

    @Test
    public void testPacienteSolicitaTurnoConObraSocial() {
        List<ObraSocial> listaObrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");
        listaObrasSociales.add(obraSocial1);
        listaObrasSociales.add(obraSocial2);

        Especialidad especialidad = new Especialidad(1, "Cardiologia");

        Medico medico = new Medico();
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
        paciente.setObraSocial(obraSocial1);
        paciente.setRecetas(new ArrayList<>());
        List<Turno> listaTurnosPaciente = new ArrayList<>();
        paciente.setTurnos(listaTurnosPaciente);

        Turno turno = new Turno();
        turno.setId(1);
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        turno.setEspecialidad(especialidad);
        turno.setObraSocial(obraSocial1);
        assertEquals(turno, gestionTurnoService.pacienteSolicitaTurno(paciente, medico, especialidad));
    }

    @Test
    public void testFinalizarTurno() {
        List<ObraSocial> listaObrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");

        listaObrasSociales.add(obraSocial1);
        listaObrasSociales.add(obraSocial2);

        Especialidad especialidad = new Especialidad(1, "Cardiologia");

        Medico medico = new Medico();
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
        paciente.setObraSocial(null);
        List<Receta> listaRecetas = new ArrayList<>();
        paciente.setRecetas(listaRecetas);
        List<Turno> listaTurnosPaciente = new ArrayList<>();
        paciente.setTurnos(listaTurnosPaciente);

        Turno turno = new Turno();
        turno.setId(2);
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        turno.setEspecialidad(especialidad);
        turno.setObraSocial(null);
        Turno turnoCreado = gestionTurnoService.pacienteSolicitaTurno(paciente, medico, especialidad);
        gestionTurnoService.finalizarTurno(paciente, turnoCreado, medico);
        assertEquals(0, medico.getTurnos().size());
        assertEquals(0, paciente.getTurnos().size());
    }
}
