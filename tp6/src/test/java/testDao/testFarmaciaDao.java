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

public class testFarmaciaDao {

        private FarmaciaDaoImpl farmaciaDao;

        @BeforeEach
        public void setUp() {
            farmaciaDao = new FarmaciaDaoImpl();
        }


        @Test
        public void testCrearFarmacia() {
            Farmacia farmacia = new Farmacia();
            farmacia.setNombre("Farmacity");
            farmacia.setDireccion("Av. Rivadavia 1234");
            farmacia.setMedicamentosExistentes(new HashMap<Medicamento, Integer>());

            farmaciaDao.crearFarmacia(farmacia);

            assertEquals("Farmacity", farmacia.getNombre());
        }



        @Test
        public void testObtenerFarmacia() {
            Farmacia farmacia = new Farmacia();
            farmacia.setNombre("Farmacity");
            farmacia.setDireccion("Av. Rivadavia 1234");
            farmacia.setMedicamentosExistentes(new HashMap<Medicamento, Integer>());

            farmaciaDao.crearFarmacia(farmacia);

            assertEquals(farmacia, farmaciaDao.visualizarFarmacia(1));

        }

        @Test
        public void testActualizarFarmacia() {
            Farmacia farmacia = new Farmacia();
            farmacia.setNombre("Farmacity");
            farmacia.setDireccion("Av. Rivadavia 1234");
            farmacia.setMedicamentosExistentes(new HashMap<Medicamento, Integer>());

            farmaciaDao.crearFarmacia(farmacia);

            farmacia.setNombre("Farmacity 2.0");
            farmaciaDao.actualizarFarmacia(farmacia);

            assertEquals("Farmacity 2.0", farmaciaDao.visualizarFarmacia(1).getNombre());
        }

        @Test
        public void testEliminarFarmacia() {
            Farmacia farmacia = new Farmacia();
            farmacia.setId(1);
            farmacia.setNombre("Farmacity");
            farmacia.setDireccion("Av. Rivadavia 1234");
            farmacia.setMedicamentosExistentes(new HashMap<Medicamento, Integer>());

            farmaciaDao.crearFarmacia(farmacia);
            assertEquals(farmacia, farmaciaDao.visualizarFarmacia(1));

            farmaciaDao.eliminarFarmacia(1);
            assertEquals(null, farmaciaDao.visualizarFarmacia(1));
        }

    @Test
    public void testActualizarStock() {
        Farmacia farmacia = new Farmacia();
        farmacia.setId(1);
        farmacia.setNombre("Farmacity");
        farmacia.setDireccion("Av. Rivadavia 1234");
        farmacia.setMedicamentosExistentes(new HashMap<Medicamento, Integer>());

        Medicamento medicamento = new Medicamento();
        medicamento.setId(1);
        medicamento.setNombre("Ibupirac");
        medicamento.setDroga("Ibuprofeno");
        medicamento.setLaboratorio("Bayer");

        Map<Medicamento, Integer> medicamentos = new HashMap<>();
        medicamentos.put(medicamento, 10);

        farmacia.actualizarStock(medicamentos);

        Map<Medicamento, Integer> testStockMedicamentos = new HashMap<>();
        testStockMedicamentos.put(medicamento, 10);

        assertEquals(testStockMedicamentos, farmacia.getMedicamentosExistentes());
    }

    @Test
    public void testComprobarStock() {
        Farmacia farmacia = new Farmacia();
        farmacia.setId(1);
        farmacia.setNombre("Farmacity");
        farmacia.setDireccion("Av. Rivadavia 1234");
        farmacia.setMedicamentosExistentes(new HashMap<Medicamento, Integer>());

        Medicamento medicamento = new Medicamento();
        medicamento.setId(1);
        medicamento.setNombre("Ibupirac");
        medicamento.setDroga("Ibuprofeno");

        medicamento.setLaboratorio("Bayer");

        Map<Medicamento, Integer> medicamentos = new HashMap<>();
        medicamentos.put(medicamento, 10);

        assertEquals(false, farmacia.comprobarStock(medicamentos));

        farmacia.actualizarStock(medicamentos);

        Map<Medicamento, Integer> testStockMedicamentos = new HashMap<>();
        testStockMedicamentos.put(medicamento, 10);

        assertEquals(testStockMedicamentos, farmacia.getMedicamentosExistentes());
        assertEquals(true, farmacia.comprobarStock(medicamentos));
    }

    @Test
    public void testEliminarMedicamentoDeLaReceta() {
        Receta receta = new Receta();
        receta.setId(1);
        receta.setPaciente(new Paciente());
        receta.setMedico(new Medico());
        receta.setMedicamentos(new HashMap<Medicamento, Integer>());

        Medicamento medicamento = new Medicamento();
        medicamento.setId(1);
        medicamento.setNombre("Ibupirac");
        medicamento.setDroga("Ibuprofeno");
        medicamento.setLaboratorio("Bayer");

        Medicamento medicamento2 = new Medicamento();
        medicamento.setId(2);
        medicamento.setNombre("Paracetamol");
        medicamento.setDroga("Paracetamol");
        medicamento.setLaboratorio("Aspen");

        receta.getMedicamentos().put(medicamento, 10);
        receta.getMedicamentos().put(medicamento2, 5);

        assertEquals(2, receta.getMedicamentos().size());

        receta.eliminarMedicamento(medicamento);

        assertEquals(1, receta.getMedicamentos().size());

    }

}
