package clinica.servicios;

import clinica.entidades.*;
import clinica.dao.implementaciones.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class AtencionMedicoService {
    private static AtencionMedicoService instance;
    private static AtencionMedicoService atencionMedicoService = AtencionMedicoService.getInstance();
    private TurnoDaoImpl turnoDAO;
    private MedicoDaoImpl medicoDAO;
    private PacienteDaoImpl pacienteDAO;
    private RecetaDaoImpl recetaDao;

    public static AtencionMedicoService getInstance() {
        if (instance == null) {
            instance = new AtencionMedicoService();
        }
        return instance;
    }

    public AtencionMedicoService() {
        turnoDAO = new TurnoDaoImpl();
        medicoDAO = new MedicoDaoImpl();
        pacienteDAO = new PacienteDaoImpl();
        recetaDao = new RecetaDaoImpl();
    }

    public void atenderSiguienteTurno(Medico medico) {
        medico.setEstaAtendiendo(false);
        medico.getTurnos().forEach(turno -> {
            if (turno.getMedico().equals(medico)) {
                medico.atenderPaciente();
            }
            else if (medico.getTurnos().isEmpty()) {
                medico.finalizarAtencion();
                throw new IllegalArgumentException("El médico no tiene turnos asignados");
            }
        });
    }
// La cantidad y los medicamentos indicados en la Receta surgirán aleatoriamente siendo una opción no obtener una receta
    public Receta medicoAtendiendendoHaceReceta(Medico medico, Paciente paciente) {
        if (medico.getEstaAtendiendo().equals(true)) {
            // Ahora calculamos la probabilidad de entre 1 y 5 de que el médico haga una receta
            int probabilidad = (int) (Math.random() * 5 + 1);
            // Si cae en 1, el medico no hace receta
            if (probabilidad == 1) {
                Receta receta = null;
                System.out.println("El médico no hace receta");
            }
            else {
                System.out.println("El médico hace receta");

                // Lista de medicamentos para calcular la cantidad de medicamentos que se le asignará al paciente
                List<Medicamento> medicamentos = new ArrayList<>();
                Medicamento paracetamol = new Medicamento(1,"Paracetamol", "Paracetamol", "Pfizer");
                Medicamento ibuprofeno = new Medicamento(2, "Ibupirac", "Ibuprofeno", "Bayer");
                Medicamento losec = new Medicamento(3, "Losec", "Omeprazol", "AstraZeneca");
                Medicamento aspirina = new Medicamento(4, "Aspirina", "Ácido acetilsalicílico", "Bayer");
                Medicamento amoxilina = new Medicamento(5, "Amoxilina", "Amoxilina", "Roche");
                medicamentos.add(paracetamol);
                medicamentos.add(ibuprofeno);
                medicamentos.add(losec);
                medicamentos.add(aspirina);
                medicamentos.add(amoxilina);

                // Ahora calculo aleatoriamente cuantos medicamentos y cantidades se recetarán
                int elegirMedicamentosAleatoriamente = (int) (Math.random() * 5 + 1);

                Map<Medicamento, Integer> medicamentosConCantidades = new HashMap<>();

                for (int i = 0; i < elegirMedicamentosAleatoriamente; i++) {
                    int cantidadDeCadaMedicamento = (int) (Math.random() * 5);
                    medicamentosConCantidades.put(medicamentos.get(i), cantidadDeCadaMedicamento);
                }

                Receta receta = new Receta();
                receta.setMedico(medico);
                receta.setPaciente(paciente);
                receta.setMedicamentos(medicamentosConCantidades);
                return recetaDao.crearReceta(receta);
            }
        }

        return null;
    }

    public void finalizarAtencion(Medico medico) {
        medico.finalizarAtencion();
    }








}