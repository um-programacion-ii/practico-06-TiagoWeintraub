package entidades;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import servicios.ServicioGestionTurno;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turno {
    private Paciente paciente;
    private String nombrePaciente;
    private String apellidoPaciente;
    private String dniPaciente;
    private Medico medico;
    private String nombreMedico;
    private String apellidoMedico;
    private String especialidadMedico;
    private String obraSocial;
    private boolean terminado;
    private boolean recetaGenerada;
    private ServicioGestionTurno gestor;


    public Turno(Paciente paciente, Medico medico, String obraSocial, ServicioGestionTurno gestor) {
        this.paciente = paciente;
        this.nombrePaciente = paciente.getNombre();
        this.apellidoPaciente = paciente.getApellido();
        this.dniPaciente = paciente.getDni();
        this.medico = medico;
        this.nombreMedico = medico.getNombre();
        this.apellidoMedico = medico.getApellido();
        this.especialidadMedico = medico.getEspecialidad();
        this.obraSocial = obraSocial;
        this.terminado = false;
        this.recetaGenerada = false;
        this.gestor = gestor;
    }}
