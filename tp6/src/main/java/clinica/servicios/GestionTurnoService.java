package clinica.servicios;

import clinica.dao.interfaces.TurnoDAO;
import clinica.dao.interfaces.MedicoDAO;
import clinica.entidades.*;

import java.util.ArrayList;
import java.util.List;


public class GestionTurnoService {
    private static GestionTurnoService instancia;
    private TurnoDAO turnoDAO;
    private MedicoDAO medicoDAO;

// Implementación de singleton
    public static GestionTurnoService getInstance() {
        if (instancia == null) {
            instancia = new GestionTurnoService();
        }
        return instancia;
    }

    // Listar todos los medicos
    public List<Medico> listaMedicosClinica() {
        return medicoDAO.listaMedicos();
    }

    // Listar medicos por especialidad y mostrar las obras sociales que atienden
    public List<Medico> listarMedicos(Especialidad especialidad, ObraSocial obraSocial) {
        if (medicoDAO.listaMedicos() == null) {
            throw new IllegalStateException("Lista de médicos inicializada incorrectamente");
        }

        List<Medico> medicosFiltrados = new ArrayList<>();

        // Filtrar médicos por especialidad y obra social
        for (Medico medico : medicoDAO.listaMedicos()) {
            if (medico.getEspecialidad().equals(especialidad) && (obraSocial == null || medico.getObrasSociales().contains(obraSocial))) {
                medicosFiltrados.add(medico);
            }
        }
        return medicosFiltrados;
    }


    public Turno pacienteSolicitaTurno(Paciente paciente, Medico medico) throws IllegalArgumentException {
        if (paciente.getObraSocial().equals(null) && medico.getAtiendeParticular()) { //Turno particular
            return turnoDAO.crearTurno(paciente.solicitarTurno(medico, medico.getEspecialidad(), null));
        }

        // Si la obra social del paciente está en la lista de obras sociales del médico se saca el turno
        else if (medico.getObrasSociales().contains(paciente.getObraSocial())){
            return turnoDAO.crearTurno(paciente.solicitarTurno(medico, medico.getEspecialidad(), paciente.getObraSocial()));
        }
      else {
            throw new IllegalArgumentException("El médico no atiende a la obra social del paciente");
        }
    }

    public void finalizarTurno(Paciente paciente, Turno turno, Medico medico) {
        paciente.cancelarTurno(turno);
        medico.turnoCanceladoPorPaciente(turno);
        turnoDAO.eliminarTurno(turno.getId());
    }





}

