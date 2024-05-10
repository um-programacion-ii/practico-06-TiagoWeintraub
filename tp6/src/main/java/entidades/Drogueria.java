package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashMap;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drogueria {
    private String nombre;
    private String direccion;
    private String telefono;
    private HashMap<String, Medicamento> stockMedicamentosDrogueria;
}
