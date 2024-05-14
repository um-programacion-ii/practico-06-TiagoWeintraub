package testDao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import clinica.entidades.*;
import clinica.dao.implementaciones.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class testMedicamentoDao {
    private MedicamentoDaoImpl medicamentoDAO;

    @BeforeEach
    public void setUp() {
        medicamentoDAO = new MedicamentoDaoImpl();
    }

//    private Integer id;
//    private String nombre;
//    private String laboratorio;
//    private String droga;

    @Test
    public void testCrearMedicamento() {
        Medicamento medicamento = new Medicamento();
        medicamento.setNombre("Ibupirac 600");
        medicamento.setDroga("Ibuprofeno 600mg - Clorzoxazona 250mg");
        medicamento.setLaboratorio("Pfizer");
        Medicamento medicamentoCreado = medicamentoDAO.crearMedicamento(medicamento);
        assertEquals(medicamento, medicamentoCreado);
    }

    @Test
    public void testVisualizarMedicamento() {
        Medicamento medicamento = new Medicamento();
        medicamento.setNombre("Ibuprofeno");
        medicamento.setNombre("Ibupirac 600");
        medicamento.setDroga("Ibuprofeno 600mg - Clorzoxazona 250mg");
        medicamento.setLaboratorio("Pfizer");

        Medicamento medicamentoCreado = medicamentoDAO.crearMedicamento(medicamento);
        Medicamento medicamentoVisualizado = medicamentoDAO.visualizarMedicamento(medicamentoCreado.getId());
        assertEquals(medicamentoCreado, medicamentoVisualizado);
    }

    @Test
    public void testActualizarMedicamento() {
        Medicamento medicamento = new Medicamento();
        medicamento.setNombre("Ibupirac 600");
        medicamento.setDroga("Ibuprofeno 600mg - Clorzoxazona 250mg");
        medicamento.setLaboratorio("Pfizer");

        Medicamento medicamentoCreado = medicamentoDAO.crearMedicamento(medicamento);
        medicamentoCreado.setNombre("Ibuprofeno 600 miligramos");
        medicamentoCreado.setLaboratorio("Bayer");

        medicamentoDAO.actualizarMedicamento(medicamentoCreado);

        assertEquals(medicamentoCreado, medicamentoDAO.visualizarMedicamento(medicamentoCreado.getId()) );
    }

    @Test
    public void testEliminarMedicamento() {
        Medicamento medicamento = new Medicamento();
        medicamento.setNombre("Ibuprofeno");
        medicamento.setDroga("Ibuprofeno 600mg - Clorzoxazona 250mg");
        medicamento.setLaboratorio("Pfizer");

        Medicamento medicamentoCreado = medicamentoDAO.crearMedicamento(medicamento);
        medicamentoDAO.eliminarMedicamento(medicamentoCreado.getId());
        Medicamento medicamentoEliminado = medicamentoDAO.visualizarMedicamento(medicamentoCreado.getId());
        assertEquals(null, medicamentoEliminado);
    }


}
