package entidades;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Medico {
    private Integer id;
    private String nombre;
    private String apellido;
    private String especialidad;
    private List<ObraSocial> obrasSociales;
    private Boolean estaAtendiendo;

public void hacerReceta(Integer id,String pacienteNombre, String pacienteApellido, Integer dniPaciente, String medicoNombre, String medicoApellido, Integer dniMedico, Map<String, Integer> medicamentos) {


//    private Integer id;
//    private String pacienteNombre;
//    private String pacienteApellido;
//    private Integer dniPaciente;
//    private String medicoApellido;
//    private String medicoNombre;
//    private Integer dniMedico;
//    private Map<String, Integer> medicamentos;
}
    public void atenderPaciente(String paciente) {
        this.estaAtendiendo = true;
    }

    public void finalizarAtencion(String paciente) {
        this.estaAtendiendo = false;
    }
}
