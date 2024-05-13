package clinica.servicios;

import clinica.dao.implementaciones.MedicoDAOImpl;
import clinica.dao.interfaces.MedicoDAO;
import clinica.dao.interfaces.TurnoDAO;
import clinica.entidades.Paciente;
import clinica.entidades.Turno;
import clinica.entidades.Especialidad;
import clinica.entidades.Medico;
import clinica.entidades.ObraSocial;
import java.util.ArrayList;
import java.util.List;


public class GestionTurnoService {
    private static GestionTurnoService instancia;
    private List<Medico> listMedicos;
    private TurnoDAO turnoDAO;


// Con singleton
    public static GestionTurnoService getInstance() {
        if (instancia == null) {
            instancia = new GestionTurnoService();
        }
        return instancia;
    }

    // Listar todos los medicos
    public List<Medico> listaMedicos() {
        return listMedicos;
    }

    // Listar medicos por especialidad y mostrar las obras sociales que atienden
    public List<Medico> listarMedicos(Especialidad especialidad, ObraSocial obraSocial) {
        if (listMedicos == null) {
            throw new IllegalStateException("La lista de médicos no ha sido inicializada correctamente");
        }

        List<Medico> medicosFiltrados = new ArrayList<>();

        // Filtrar médicos por especialidad y obra social
        for (Medico medico : listMedicos) {
            if (medico.getEspecialidad().equals(especialidad) &&
                    (obraSocial == null || medico.getObrasSociales().contains(obraSocial))) {
                medicosFiltrados.add(medico);
            }
        }
        return medicosFiltrados;
    }

    public Turno solicitarTurno(Paciente paciente, Medico medico) {
        Turno turno = new Turno();
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        return turnoDAO.crearTurno(turno);
    }

    public void finalizarTurno(Turno turno) {
        turnoDAO.eliminarTurno(turno.getId());
    }



}

