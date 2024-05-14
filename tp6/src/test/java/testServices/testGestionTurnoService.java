package testServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import clinica.entidades.Turno;
import clinica.servicios.GestionTurnoService;
import clinica.dao.interfaces.TurnoDAO;
import clinica.dao.implementaciones.TurnoDAOImpl;
import clinica.entidades.Medico;
import clinica.entidades.Paciente;
import clinica.entidades.ObraSocial;
import clinica.entidades.Especialidad;
import clinica.dao.interfaces.MedicoDAO;
import clinica.dao.implementaciones.MedicoDAOImpl;
import clinica.dao.interfaces.PacienteDAO;
import clinica.dao.implementaciones.PacienteDAOImpl;
import clinica.dao.interfaces.ObraSocialDAO;
import clinica.dao.implementaciones.ObraSocialDAOImpl;
import java.util.ArrayList;
import java.util.List;

public class testGestionTurnoService {
    private GestionTurnoService gestionTurnoService;
    private TurnoDAO turnoDAO;
    private MedicoDAO medicoDAO;
    private PacienteDAO pacienteDAO;
    private ObraSocialDAO obraSocialDAO;


    @BeforeEach
    public void setUp() {
        gestionTurnoService = GestionTurnoService.getInstance();
        turnoDAO = new TurnoDAOImpl();
        medicoDAO = new MedicoDAOImpl();
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
        medico.setTurnos(null);

        Paciente paciente = new Paciente();
        paciente.setDni(40123432);
        paciente.setNombre("Maria");
        paciente.setApellido("Gomez");
        paciente.setObraSocial(obraSocial1);
        paciente.setRecetas(null);
        paciente.setTurnos(null);

        Turno turno = new Turno();
        turno.setId(1);
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        turno.setEspecialidad(especialidad);
        turno.setObraSocial(obraSocial1);
        Turno turnoCreado = gestionTurnoService.pacienteSolicitaTurno(paciente, medico, especialidad);
        assertEquals(turno, turnoCreado);
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
        medico.setTurnos(null);

        Paciente paciente = new Paciente();
        paciente.setDni(40123432);
        paciente.setNombre("Maria");
        paciente.setApellido("Gomez");
        paciente.setObraSocial(null);
        paciente.setRecetas(null);
        paciente.setTurnos(null);

        Turno turno = new Turno();
        turno.setId(2);
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        turno.setEspecialidad(especialidad);
        turno.setObraSocial(null);
        Turno turnoCreado = gestionTurnoService.pacienteSolicitaTurno(paciente, medico, especialidad);
        assertEquals(turno, turnoCreado);
    }
}
