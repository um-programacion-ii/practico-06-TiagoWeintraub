package clinica.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Drogueria {
    private Integer id;
    private String nombre;
    private String direccion;
    private Integer telefono;

    public Map<Medicamento, Integer> entregarPedido(Map<Medicamento, Integer> pedido) {
            return pedido;
    }
}

