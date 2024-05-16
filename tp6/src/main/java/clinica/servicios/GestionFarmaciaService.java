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

    public void comprarMedicamentosSegunReceta(Paciente paciente, Farmacia farmacia) {
        List<Receta> recetas = paciente.getRecetas();
        // Primero comprobamos que la receta no sea nula
        if (recetas != null) {
            for (Receta receta : recetas) {
                // Por cada medicamento de la receta, utilizando receta.getMedicamento() verificamos si la farmacia tiene stock.
                for (Map.Entry<Medicamento, Integer> entry : receta.getMedicamentos().entrySet()) {
                    //Creo un nuevo map que solo tendra un medicamento y su cantidad
                    Map<Medicamento, Integer> verificarStockMedicamento = new HashMap<>();
                    Medicamento medicamento = entry.getKey();
                    Integer cantidad = entry.getValue();
                    // Le agrego el medicamento y cantidad
                    verificarStockMedicamento.put(medicamento, cantidad);
                    // Si la farmacia tiene stock, se vende el medicamento
                    if (farmacia.comprobarStock(verificarStockMedicamento)) {
                        farmacia.venderMedicamentos(receta);
                    } else {
                        // Si no tiene stock, se pide a la drogueria
                        System.out.println("La farmacia no tiene stock del medicamento"+ medicamento +" y pide a la drogueria");
                        Map<Medicamento, Integer> pedido = new HashMap<>();
                        pedido.put(medicamento, cantidad);
                        Map<Medicamento, Integer> pedidoRecibido = farmacia.pedidoDrogueria(pedido);
                        farmacia.actualizarStock(pedidoRecibido);
                    }
                }
            }
        }
    }
}
