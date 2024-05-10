package clinica;

import entidades.*;

public class Main {
    public static void main(String[] args) {

        Especialidad especialidad = new Especialidad("1234", "Cardiologia");
        ObraSocial obraSocial = new ObraSocial("1234", "OSDE");
        System.out.println("Hello world!");
        Medico medico = new Medico("1234", "Juan", "Perez", especialidad, true, obraSocial, true);
        Paciente paciente = new Paciente("1234", "Juan", "Perez", true, obraSocial, null);
        Receta receta = new Receta(paciente, null, null);
        System.out.println(receta);

    }

}