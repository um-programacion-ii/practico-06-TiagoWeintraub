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
}

//public void entregarPedido(Integer id, String receta, Integer cantidad) {
//        Medicamento medicamento = entry.getKey();
//        Integer cantidadNecesaria = entry.getValue();
//}