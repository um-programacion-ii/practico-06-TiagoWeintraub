package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receta {
    private Integer id;
    private String pacienteNombre;
    private String pacienteApellido;
    private Integer dniPaciente;
    private String medicoNombre;
    private String medicoApellido;
    private Integer dniMedico;
    private Map<String, Integer> medicamentos;

    public void agregarMedicamento(String medicamento, Integer cantidad) {
        this.medicamentos.put(medicamento, cantidad);
    }
}
