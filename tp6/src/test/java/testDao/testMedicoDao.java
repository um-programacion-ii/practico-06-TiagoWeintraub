package testDao;

import clinica.dao.implementaciones.*;
import clinica.entidades.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import clinica.dao.implementaciones.MedicoDaoImpl;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class testMedicoDao {
    private MedicoDaoImpl medicoDAO;


    @BeforeEach
    public void setUp() {
        ObraSocialDaoImpl obraSocialDAO = new ObraSocialDaoImpl();
        medicoDAO = new MedicoDaoImpl();
    }

    @Test
    public void testCrearMedico() {
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

        Medico medicoCreado = medicoDAO.crearMedico(medico);
        assertEquals(medico, medicoCreado);
    }

    @Test
public void testVisualizarMedico() {
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

        Medico medicoCreado = medicoDAO.crearMedico(medico);
        Medico medicoVisualizado = medicoDAO.visualizarMedico(1);
        assertEquals(medico, medicoVisualizado);
    }

    @Test
    public void testActualizarMedico() {
        List<ObraSocial> listaObrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");

        listaObrasSociales.add(obraSocial1);
        listaObrasSociales.add(obraSocial2);

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

        Medico medicoCreado = medicoDAO.crearMedico(medico);

        Medico medicoActualizado = new Medico();
        medicoActualizado.setId(1);
        medicoActualizado.setNombre("Juan");
        medicoActualizado.setApellido("Perez Alias El Actualizado");
        medicoActualizado.setEspecialidad(especialidad);
        medicoActualizado.setObrasSociales(listaObrasSociales);
        medicoActualizado.setAtiendeParticular(true);
        medicoActualizado.setEstaAtendiendo(false);
        List<Turno> listaTurnosMedicoActualizado = new ArrayList<>();
        medicoActualizado.setTurnos(listaTurnosMedicoActualizado);

        medicoDAO.actualizarMedico(medicoActualizado);

        Medico medicoVisualizado = medicoDAO.visualizarMedico(1);
        assertEquals(medicoActualizado, medicoVisualizado);
    }

    @Test
    public void testEliminarMedico() {
        List<ObraSocial> listaObrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");

        listaObrasSociales.add(obraSocial1);
        listaObrasSociales.add(obraSocial2);

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

        Medico medicoCreado = medicoDAO.crearMedico(medico);
        medicoDAO.eliminarMedico(1);
        Medico medicoVisualizado = medicoDAO.visualizarMedico(1);
        assertEquals(null, medicoVisualizado);
    }



}
