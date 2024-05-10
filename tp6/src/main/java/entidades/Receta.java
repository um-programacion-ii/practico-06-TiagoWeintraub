package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receta {
    private Paciente paciente;
    private Medico medico;
    private Map<Medicamento, Integer> medicamentos;

    public void agregarMedicamento(Medicamento medicamento, Integer cantidad) {
        this.medicamentos.put(medicamento, cantidad);
    }
}
