package entidades;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Farmacia {
    private Integer id;
    private String nombre;
    private String direccion;
    private Map<Medicamento, Integer> medicamentosExistentes;

    public void iniciarPedido(Integer id, Medicamento medicamento, Integer cantidad) {
        //gestorDeStock.verificarStock(medicamento, cantidad);
        //gestorDeFarmacia.entregarPedido(medicamento, cantidad);
    }

    public void actualizarStock(Integer id ,Medicamento medicamento, Integer cantidad) {
        //gestorDeStock.actualizarStock(medicamento, cantidad);
    }

    public void venderMedicamento(Integer id ,Medicamento medicamento, Integer cantidad) {
        //gestorDeStock.verificarStock(medicamento, cantidad);
        //gestorDeFarmacia.entregarPedido(medicamento, cantidad);
        //gestorDeStock.actualizarStock(medicamento, cantidad);
    }

}
