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
        private Farmacia farmacia;

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
        public void testAgregarFarmacia() {
            farmacia.setNombre("Farmacity");
            farmacia.setDireccion("Av. Rivadavia 1234");
//            farmacia.setTelefono("1234-5678");
//            farmaciaDao.agregarFarmacia(farmacia);
//            assertEquals(farmaciaDao.obtenerFarmacias().size(), 1);
        }



        @Test
        public void testObtenerFarmacia() {
            farmacia.setNombre("Farmacity");
//            farmacia.setDireccion("Av. Rivadavia 1234");
//            farmacia.setTelefono("1234-5678");
//            farmaciaDao.agregarFarmacia(farmacia);
//            assertEquals(farmaciaDao.obtenerFarmacia(1).getNombre(), "Farmacity");
        }

        @Test
        public void testActualizarFarmacia() {
            farmacia.setNombre("Farmacity");
//            farmacia.setDireccion("Av. Rivadavia 1234");
//            farmacia.setTelefono("1234-5678");
//            farmaciaDao.agregarFarmacia(farmacia);
//            farmacia.setNombre("Farmacity 2");
//            farmaciaDao.actualizarFarmacia(farmacia);
//            assertEquals(farmaciaDao.obtenerFarmacia(1).getNombre(), "Farmacity 2");
        }

        @Test
        public void testEliminarFarmacia() {
            farmacia.setNombre("Farmacity");
//            farmacia.setDireccion("Av. Rivadavia 1234");
//            farmacia.setTelefono("1234-5678");
//            farmaciaDao.agregarFarmacia(farmacia);
//            farmaciaDao.eliminarFarmacia(1);
//            assertEquals(farmaciaDao.obtenerFarmacias().size(), 0);
        }

}
