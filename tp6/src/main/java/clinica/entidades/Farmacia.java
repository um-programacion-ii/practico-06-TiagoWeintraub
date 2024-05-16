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
    private Map<Medicamento, Integer> medicamentosExistentes;

    public Map<Medicamento,Integer> pedidoDrogueria(Map<Medicamento,Integer> pedido) {
        return pedido;
    }

    public void actualizarStock(Map<Medicamento,Integer> pedidoRecibido) {
        pedidoRecibido.forEach((medicamento, cantidad) -> {
            if (medicamentosExistentes.containsKey(medicamento)) {
                medicamentosExistentes.put(medicamento, medicamentosExistentes.get(medicamento) + cantidad);
            } else {
                medicamentosExistentes.put(medicamento, cantidad);
            }
        });
    }

    public boolean comprobarStock(Map<Medicamento, Integer> verificarMedicamento) {
        return verificarMedicamento.entrySet().stream().allMatch(entry -> medicamentosExistentes.containsKey(entry.getKey()) && medicamentosExistentes.get(entry.getKey()) >= entry.getValue());
    }

    public void venderMedicamentos(Receta receta) {
        receta.getMedicamentos().forEach((medicamento, cantidad) -> {
            if (medicamentosExistentes.containsKey(medicamento)) {
                medicamentosExistentes.put(medicamento, medicamentosExistentes.get(medicamento) - cantidad);
            }
        });
    }

}
