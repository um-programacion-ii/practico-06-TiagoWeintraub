package clinica.servicios;

import clinica.entidades.*;
import clinica.dao.implementaciones.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GestionFarmaciaService {
    private static GestionFarmaciaService instance;
    private FarmaciaDaoImpl farmaciaDAO;
    private MedicamentoDaoImpl medicamentoDAO;

    public static GestionFarmaciaService getInstance() {
        if (instance == null) {
            instance = new GestionFarmaciaService();
        }
        return instance;
    }

    public GestionFarmaciaService() {
        farmaciaDAO = new FarmaciaDaoImpl();
        medicamentoDAO = new MedicamentoDaoImpl();
    }

}
