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

//    private Integer id;
//    private String nombre;
//    private String direccion;
//    private Map<Integer, Map<Medicamento,Integer>> pedidoDrogueria;
//    private Map<Medicamento, Integer> medicamentosExistentes;

        @Test
        public void testCrearFarmacia() {
            Farmacia farmacia = new Farmacia();
            farmacia.setNombre("Farmacity");
            farmacia.setDireccion("Av. Rivadavia 1234");
            farmacia.setPedidoDrogueria(new HashMap<Integer, Map<Medicamento,Integer>>());
            farmacia.setMedicamentosExistentes(new HashMap<Medicamento, Integer>());

            farmaciaDao.crearFarmacia(farmacia);

            assertEquals("Farmacity", farmacia.getNombre());
        }



        @Test
        public void testObtenerFarmacia() {
            Farmacia farmacia = new Farmacia();
            farmacia.setNombre("Farmacity");
            farmacia.setDireccion("Av. Rivadavia 1234");
            farmacia.setPedidoDrogueria(new HashMap<Integer, Map<Medicamento,Integer>>());
            farmacia.setMedicamentosExistentes(new HashMap<Medicamento, Integer>());

            farmaciaDao.crearFarmacia(farmacia);

            assertEquals(farmacia, farmaciaDao.visualizarFarmacia(1));

        }

        @Test
        public void testActualizarFarmacia() {
            Farmacia farmacia = new Farmacia();
            farmacia.setNombre("Farmacity");
            farmacia.setDireccion("Av. Rivadavia 1234");
            farmacia.setPedidoDrogueria(new HashMap<Integer, Map<Medicamento,Integer>>());
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
            farmacia.setPedidoDrogueria(new HashMap<Integer, Map<Medicamento,Integer>>());
            farmacia.setMedicamentosExistentes(new HashMap<Medicamento, Integer>());

            farmaciaDao.crearFarmacia(farmacia);
            assertEquals(farmacia, farmaciaDao.visualizarFarmacia(1));

            farmaciaDao.eliminarFarmacia(1);
            assertEquals(null, farmaciaDao.visualizarFarmacia(1));
        }

}
