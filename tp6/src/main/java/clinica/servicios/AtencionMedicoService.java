package clinica.servicios;

import clinica.dao.implementaciones.TurnoDaoImpl;
import clinica.dao.implementaciones.MedicoDaoImpl;
import clinica.dao.implementaciones.PacienteDaoImpl;

public class AtencionMedicoService {
    private static AtencionMedicoService instance = null;
    private static AtencionMedicoService atencionMedicoService = AtencionMedicoService.getInstance();
    private TurnoDaoImpl turnoDAO;
    private MedicoDaoImpl medicoDAO;
    private PacienteDaoImpl pacienteDAO;

    public static AtencionMedicoService getInstance() {
        if (instance == null) {
            instance = new AtencionMedicoService();
        }
        return instance;
    }

    public AtencionMedicoService() {
        turnoDAO = new TurnoDaoImpl();
        medicoDAO = new MedicoDaoImpl();
        pacienteDAO = new PacienteDaoImpl();
    }








}