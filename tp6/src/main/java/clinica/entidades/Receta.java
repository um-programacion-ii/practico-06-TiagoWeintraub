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
    private Boolean recetaUtilizada;
    private Map<Medicamento, Integer> medicamentos;


    public void eliminarMedicamento(Medicamento medicamento) {
        this.getMedicamentos().remove(medicamento);
    }

    public boolean recetaUsada() {
        this.setRecetaUtilizada(true);
        return this.getRecetaUtilizada();
    }
}