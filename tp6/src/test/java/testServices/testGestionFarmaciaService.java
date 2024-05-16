package testServices;

import clinica.servicios.GestionFarmaciaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import clinica.entidades.*;
import clinica.dao.implementaciones.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class testGestionFarmaciaService {
    private GestionFarmaciaService gestionFarmaciaService;
    private Farmacia farmacia;
    private Paciente paciente;
    private Receta receta;
    private Medicamento medicamento;
    private Map<Medicamento, Integer> medicamentos;
    private List<Receta> recetas;
    private Map<Medicamento, Integer> pedido;
    private Map<Medicamento, Integer> pedidoRecibido;

    @BeforeEach
    public void setUp() {
        gestionFarmaciaService = GestionFarmaciaService.getInstance();
        farmacia = new Farmacia();
        paciente = new Paciente();
        receta = new Receta();
        medicamento = new Medicamento();
        medicamentos = new HashMap<>();
        recetas = new ArrayList<>();
        pedido = new HashMap<>();
        pedidoRecibido = new HashMap<>();
    }

    @Test
    public void testComprarMedicamentosSegunReceta() {

    }

}


