package entidades;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Medico {
    private String nombre;
    private String apellido;
    private String matricula;
    private String especialidad;
    private boolean atiendePorObraSocial;
    private boolean estaAtendiendo;

}
