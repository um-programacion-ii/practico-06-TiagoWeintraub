package clinica.servicios;


public class AtencionMedicoService {
    private static AtencionMedicoService instance = null;
    private static AtencionMedicoService atencionMedicoService = AtencionMedicoService.getInstance();


    private AtencionMedicoService() {

    }

    public static AtencionMedicoService getInstance() {
        if (instance == null) {
            instance = new AtencionMedicoService();
        }
        return instance;
    }






}