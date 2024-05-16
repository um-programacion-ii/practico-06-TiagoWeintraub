package testServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import clinica.servicios.*;
import clinica.entidades.*;
import clinica.dao.implementaciones.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class testAtencionMedicoService {
    private AtencionMedicoService atencionMedicoService;
    private GestionTurnoService gestionTurnoService;
    private PacienteDaoImpl pacienteDao;
    private MedicoDaoImpl medicoDao;
    private RecetaDaoImpl recetaDao;
    private TurnoDaoImpl turnoDao;
    private MedicamentoDaoImpl medicamentoDao;

    @BeforeEach
    public void setUp() {
        atencionMedicoService = AtencionMedicoService.getInstance();
        pacienteDao = new PacienteDaoImpl();
        medicoDao = new MedicoDaoImpl();
        recetaDao = new RecetaDaoImpl();
        turnoDao = new TurnoDaoImpl();
        medicamentoDao = new MedicamentoDaoImpl();
        gestionTurnoService = GestionTurnoService.getInstance();
    }

    @Test
    public void testAtenderSiguienteTurno() {
        List<ObraSocial> listaObrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");

        listaObrasSociales.add(obraSocial1);
        listaObrasSociales.add(obraSocial2);

        Especialidad especialidad = new Especialidad(1, "Cardiologia");

        Medico medico = new Medico();
        medico.setId(1);
        medico.setNombre("Emiliano");
        medico.setApellido("Martinez");
        medico.setEspecialidad(especialidad);
        medico.setObrasSociales(listaObrasSociales);
        medico.setAtiendeParticular(true);
        medico.setEstaAtendiendo(false);
        List<Turno> listaTurnosMedico = new ArrayList<>();
        medico.setTurnos(listaTurnosMedico);

        Paciente paciente = new Paciente();
        List<Receta> recetas = new ArrayList<Receta>();
        List<Turno> turnos = new ArrayList<Turno>();

        paciente.setDni(1);
        paciente.setNombre("Tiago");
        paciente.setApellido("Weintraub");
        paciente.setObraSocial(obraSocial1);
        paciente.setRecetas(recetas);
        paciente.setTurnos(turnos);

        Turno turno = new Turno();
        turno.setId(2);
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        turno.setEspecialidad(especialidad);
        turno.setObraSocial(null);
        Turno turnoCreado = gestionTurnoService.pacienteSolicitaTurno(paciente, medico, especialidad);


        atencionMedicoService.atenderSiguienteTurno(medico);
        assertEquals(true, medico.getEstaAtendiendo());
    }

    @Test
    public void testMedicoAtendiendendoHaceReceta() {
        List<ObraSocial> listaObrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");

        listaObrasSociales.add(obraSocial1);
        listaObrasSociales.add(obraSocial2);

        Especialidad especialidad = new Especialidad(1, "Cardiologia");

        Medico medico = new Medico();
        medico.setId(1);
        medico.setNombre("Emiliano");
        medico.setApellido("Martinez");
        medico.setEspecialidad(especialidad);
        medico.setObrasSociales(listaObrasSociales);
        medico.setAtiendeParticular(true);
        medico.setEstaAtendiendo(true);
        List<Turno> listaTurnosMedico = new ArrayList<>();
        medico.setTurnos(listaTurnosMedico);

        Paciente paciente = new Paciente();
        List<Receta> recetas = new ArrayList<Receta>();
        List<Turno> turnos = new ArrayList<Turno>();

        paciente.setDni(1);
        paciente.setNombre("Tiago");
        paciente.setApellido("Weintraub");
        paciente.setObraSocial(obraSocial1);
        paciente.setRecetas(recetas);
        paciente.setTurnos(turnos);

        Turno turno = new Turno();
        turno.setId(2);
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        turno.setEspecialidad(especialidad);
        turno.setObraSocial(null);
        Turno turnoCreado = gestionTurnoService.pacienteSolicitaTurno(paciente, medico, especialidad);

        Receta receta = atencionMedicoService.medicoAtendiendendoHaceReceta(medico, paciente);
//        System.out.println("Receta: " + receta);
        assertEquals(true, receta != null);

        Receta receta2 = atencionMedicoService.medicoAtendiendendoHaceReceta(medico, paciente);
        assertEquals(2, paciente.getRecetas().size());
    }

    @Test
    public void testFinalizarAtencion() {
        List<ObraSocial> listaObrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");

        listaObrasSociales.add(obraSocial1);
        listaObrasSociales.add(obraSocial2);

        Especialidad especialidad = new Especialidad(1, "Cardiologia");

        Medico medico = new Medico();
        medico.setId(1);
        medico.setNombre("Emiliano");
        medico.setApellido("Martinez");
        medico.setEspecialidad(especialidad);
        medico.setObrasSociales(listaObrasSociales);
        medico.setAtiendeParticular(true);
        medico.setEstaAtendiendo(true);
        List<Turno> listaTurnosMedico = new ArrayList<>();
        medico.setTurnos(listaTurnosMedico);

        atencionMedicoService.finalizarAtencion(medico);
        assertEquals(false, medico.getEstaAtendiendo());
    }
}
