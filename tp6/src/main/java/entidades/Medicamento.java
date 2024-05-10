package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento {
    private String nombre;
    private String laboratorio;
    private String droga;
    private Integer cantidad;
}