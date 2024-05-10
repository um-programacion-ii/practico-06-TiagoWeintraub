package entidades;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private String nombre;
    private String apellido;
    private String dni;
    private boolean usaObraSocial;
    private String obraSocial;
    private List<Receta> recetas;
    private String especialidad;

    public void agregarReceta(Receta receta) {
        this.recetas.add(receta);
    }
}