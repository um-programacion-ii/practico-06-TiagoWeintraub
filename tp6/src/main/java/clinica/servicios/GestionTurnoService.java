package clinica.servicios;

import clinica.dao.implementaciones.TurnoDAOImpl;
import clinica.dao.implementaciones.MedicoDAOImpl;
import clinica.dao.implementaciones.PacienteDAOImpl;
import clinica.entidades.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class GestionTurnoService {
    private static GestionTurnoService instancia;
    private TurnoDAOImpl turnoDAO;
    private MedicoDAOImpl medicoDAO;

// Implementación de singleton
    public static GestionTurnoService getInstance() {
        if (instancia == null) {
            instancia = new GestionTurnoService();
        }
        return instancia;
    }

    public GestionTurnoService() {
        turnoDAO = new TurnoDAOImpl();
        medicoDAO = new MedicoDAOImpl();
    }

    // Listar todos los medicos
    public List<Medico> listaMedicosClinica() {
        return medicoDAO.listaMedicos();
    }

    // Listar todos los medicos que atienden particular
    public List<Medico> listaMedicosParticular() {
        return medicoDAO.listaMedicosParticular();
    }

    // Listar todos los medicos que atienden una especialidad
    public Map<Medico, List<ObraSocial>> listaMedicosPorEspecialidad(Especialidad especialidad) {
        return medicoDAO.listaMedicosPorEspecialidad(especialidad);
    }

    public Turno pacienteSolicitaTurno(Paciente paciente, Medico medico, Especialidad especialidad) {
        if (paciente.getObraSocial() == null && medico.getAtiendeParticular() && especialidad == medico.getEspecialidad()) { // Turno particular
            return turnoDAO.crearTurno(paciente.solicitarTurno(medico, medico.getEspecialidad(), null))
                    ;
        }
        // Si la obra social del paciente está en la lista de obras sociales del médico se saca el turno
        else if (paciente.getObraSocial() != null && medico.getObrasSociales().contains(paciente.getObraSocial()) && especialidad == medico.getEspecialidad()) {
            return turnoDAO.crearTurno(paciente.solicitarTurno(medico, medico.getEspecialidad(), paciente.getObraSocial()));
        }
        else {
            throw new IllegalArgumentException("El médico no atiende a la obra social del paciente");
        }
    }

    public void finalizarTurno(Paciente paciente, Turno turno, Medico medico) {
        paciente.cancelarTurno(turno);
        medico.cancelarTurno(turno);
        turnoDAO.eliminarTurno(turno.getId());
    }
}

