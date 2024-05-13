package clinica.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Receta {
    private Integer id;
    private Paciente paciente;
    private Medico medico;
    private Map<String, Integer> medicamentos;
}
