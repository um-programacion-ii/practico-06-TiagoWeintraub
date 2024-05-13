package clinica.servicios;

import clinica.dao.interfaces.TurnoDAO;
import clinica.entidades.*;

import java.util.ArrayList;
import java.util.List;


public class GestionTurnoService {
    private static GestionTurnoService instancia;
    private List<Medico> listaMedicos;

// Implementación de singleton
    public static GestionTurnoService getInstance() {
        if (instancia == null) {
            instancia = new GestionTurnoService();
        }
        return instancia;
    }

    // Listar todos los medicos
    public List<Medico> listaMedicos() {
        return listaMedicos;
    }

    // Listar medicos por especialidad y mostrar las obras sociales que atienden
    public List<Medico> listarMedicos(Especialidad especialidad, ObraSocial obraSocial) {
        if (listaMedicos == null) {
            throw new IllegalStateException("La lista de médicos no ha sido inicializada correctamente");
        }

        List<Medico> medicosFiltrados = new ArrayList<>();

        // Filtrar médicos por especialidad y obra social
        for (Medico medico : listaMedicos) {
            if (medico.getEspecialidad().equals(especialidad) &&
                    (obraSocial == null || medico.getObrasSociales().contains(obraSocial))) {
                medicosFiltrados.add(medico);
            }
        }
        return medicosFiltrados;
    }

    public void pacienteSolicitaTurno(Paciente paciente, Medico medico) {
        if (medico.getObrasSociales().isEmpty()) {
            paciente.solicitarTurno(paciente, medico, medico.getEspecialidad(), null);
        }
        else{
            paciente.solicitarTurno(paciente, medico, medico.getEspecialidad(), paciente.getObrasSociales());
        }
    }

    public void finalizarTurno(Paciente paciente, Turno turno, Medico medico, TurnoDAO turnoDAO) {
        paciente.cancelarTurno(turno);
        medico.turnoCanceladoPorPaciente(turno);
        turnoDAO.eliminarTurno(turno.getId());
    }





}

