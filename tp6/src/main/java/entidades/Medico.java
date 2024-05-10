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
    private String dni;
    private String nombre;
    private String apellido;
    private Especialidad especialidad;
    private boolean admiteObraSocial;
    private ObraSocial obraSocial;
    private boolean estaAtendiendo;

//    public Medico hacerReceta(Paciente paciente, List<Medicamento> medicamentos) {
//        Random random = new Random();
//        Receta receta = new Medico(paciente, this);
//        for (Medicamento medicamento : medicamentos) {
//            if (random.nextBoolean()) {
//                // Decide aleatoriamente la cantidad de este medicamento
//                int cantidad = random.nextInt(10) + 1; // Genera un número entre 1 y 10
//                receta.agregarMedicamento(medicamento, cantidad);
//            }
//        }
//        // Si la receta no tiene medicamentos, devuelve null
//        return receta.getMedicamentos().isEmpty() ? null : receta;
//    }

    public Receta atenderPaciente(Paciente paciente) {
        // Implementa la lógica para atender a un paciente y generar una receta
        return null; // Reemplaza con la receta generada
    }
}