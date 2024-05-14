package clinica.servicios;

import clinica.dao.implementaciones.TurnoDAOImpl;
import clinica.dao.implementaciones.MedicoDAOImpl;
import clinica.dao.implementaciones.PacienteDAOImpl;
import clinica.entidades.*;

import java.util.ArrayList;
import java.util.List;

public class AtencionMedicoService {
    private static AtencionMedicoService instance = null;
    private static AtencionMedicoService atencionMedicoService = AtencionMedicoService.getInstance();
    private TurnoDAOImpl turnoDAO;
    private MedicoDAOImpl medicoDAO;
    private PacienteDAOImpl pacienteDAO;

    public static AtencionMedicoService getInstance() {
        if (instance == null) {
            instance = new AtencionMedicoService();
        }
        return instance;
    }

    public AtencionMedicoService() {
        turnoDAO = new TurnoDAOImpl();
        medicoDAO = new MedicoDAOImpl();
        pacienteDAO = new PacienteDAOImpl();
    }








}