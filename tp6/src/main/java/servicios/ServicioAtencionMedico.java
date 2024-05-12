package servicios;

import entidades.Medico;
import entidades.Paciente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;



public class ServicioAtencionMedico {
    private static ServicioAtencionMedico instance;
    private final Map<String, Queue<Medico>> medicosPorEspecialidad;
    private final Map<String, Queue<Paciente>> personasPorEspecialidad;

    private ServicioAtencionMedico() {
        this.medicosPorEspecialidad = new ConcurrentHashMap<>();
        this.personasPorEspecialidad = new ConcurrentHashMap<>();
    }

    public static ServicioAtencionMedico getInstance() {
        if (instance == null) {
            instance = new ServicioAtencionMedico();
        }
        return instance;
    }

    public void agregarMedico(Medico medico) {
        Queue<Medico> colaMedicos = medicosPorEspecialidad.computeIfAbsent(medico.getEspecialidad(), k -> new ConcurrentLinkedQueue<>());
        colaMedicos.add(medico);
    }

    public Medico obtenerMedico(String especialidad) {
        Queue<Medico> colaMedicos = medicosPorEspecialidad.get(especialidad);
        if (colaMedicos != null && !colaMedicos.isEmpty()) {
            return colaMedicos.poll();
        }
        return null;
    }

    public void agregarPersona(Paciente paciente) {
        //Queue<Paciente> colaPersonas = personasPorEspecialidad.computeIfAbsent(paciente.getEspecialidad(), k -> new ConcurrentLinkedQueue<>());
        //colaPersonas.add(paciente);
    }

    public Persona obtenerPersona(String especialidad) {
        Queue<Persona> colaPersonas = personasPorEspecialidad.get(especialidad);
        if (colaPersonas != null && !colaPersonas.isEmpty()) {
            return colaPersonas.poll();
        }
        return null;
    }

    public void devolverMedico(Medico medico) {
        medico.setEstaAtendiendo(false);
    }
}