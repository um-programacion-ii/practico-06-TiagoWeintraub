package clinica.entidades;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Farmacia {
    private Integer id;
    private String nombre;
    private String direccion;
    private Map<Integer, Map<Medicamento,Integer>> pedidoDrogueria;
    private Map<Medicamento, Integer> medicamentosExistentes;

    public void iniciarPedido(Integer id, Medicamento medicamento, Integer cantidad) {

    }

    public void actualizarStock(Integer id ,Medicamento medicamento, Integer cantidad) {
        //gestorDeStock.actualizarStock(medicamento, cantidad);
    }

    public void venderMedicamentos(Receta receta) {
        receta.getMedicamentos().forEach((medicamento, cantidad) -> {
            if (medicamentosExistentes.containsKey(medicamento)) {
                medicamentosExistentes.put(medicamento, medicamentosExistentes.get(medicamento) - cantidad);
            }
        });
    }

}
