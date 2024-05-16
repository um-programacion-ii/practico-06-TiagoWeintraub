package testServices;


import clinica.servicios.GestionFarmaciaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import clinica.entidades.*;
import clinica.dao.implementaciones.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class testGestionFarmaciaService {
    private GestionFarmaciaService gestionFarmaciaService;
    private Farmacia farmacia;
    private Paciente paciente;
    private Receta receta;
    private Medicamento medicamento;
    private Map<Medicamento, Integer> medicamentos;
    private List<Receta> recetas;
    private Map<Medicamento, Integer> pedido;
    private Map<Medicamento, Integer> pedidoRecibido;

    @BeforeEach
    public void setUp() {
        gestionFarmaciaService = GestionFarmaciaService.getInstance();
        farmacia = new Farmacia();
    }

    @Test
    public void testComprarMedicamentosSegunReceta() {
        List<ObraSocial> listaObrasSociales = new ArrayList<>();
        ObraSocial obraSocial1 = new ObraSocial(1, "OSDE");
        ObraSocial obraSocial2 = new ObraSocial(2, "Swiss Medical");

        listaObrasSociales.add(obraSocial1);
        listaObrasSociales.add(obraSocial2);

        Especialidad especialidad = new Especialidad(1, "Cardiologia");

        Medico medico = new Medico();
        medico.setId(1);
        medico.setNombre("Emiliano");
        medico.setApellido("Martinez");
        medico.setEspecialidad(especialidad);
        medico.setObrasSociales(listaObrasSociales);
        medico.setAtiendeParticular(true);
        medico.setEstaAtendiendo(true);
        List<Turno> listaTurnosMedico = new ArrayList<>();
        medico.setTurnos(listaTurnosMedico);

        Paciente paciente = new Paciente();
        List<Receta> recetas = new ArrayList<Receta>();
        List<Turno> turnos = new ArrayList<Turno>();

        paciente.setDni(1);
        paciente.setNombre("Tiago");
        paciente.setApellido("Weintraub");
        paciente.setObraSocial(obraSocial1);
        paciente.setRecetas(recetas);
        paciente.setTurnos(turnos);

        Turno turno = new Turno();
        turno.setId(2);
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        turno.setEspecialidad(especialidad);
        turno.setObraSocial(obraSocial1);

        Medicamento ibupirac = new Medicamento();
        ibupirac.setId(1);
        ibupirac.setNombre("Ibupirac");
        ibupirac.setDroga("Ibuprofeno");
        ibupirac.setLaboratorio("Bayer");

//        Medicamento paracetamol = new Medicamento();
//        paracetamol.setId(2);
//        paracetamol.setNombre("Paracetamol");
//        paracetamol.setDroga("Paracetamol");
//        paracetamol.setLaboratorio("Pfizer");

        Map<Medicamento, Integer> medicamentos = new HashMap<>();
        medicamentos.put(ibupirac, 10);
//        medicamentos.put(paracetamol, 5);

        Receta receta = new Receta();
        receta.setId(1);
        receta.setPaciente(paciente);
        receta.setMedico(medico);
        receta.setRecetaUtilizada(false);
        receta.setMedicamentos(medicamentos);

        paciente.recibirReceta(receta);

        assertEquals(receta, paciente.getRecetas().get(0));

        farmacia.setId(1);
        farmacia.setNombre("Farmacity");
        farmacia.setDireccion("Av. Rivadavia 1234");
        farmacia.setMedicamentosExistentes(new HashMap<>());

        farmacia.actualizarStock(medicamentos);

        assertEquals(medicamentos, farmacia.getMedicamentosExistentes());

        gestionFarmaciaService.comprarMedicamentosSegunReceta(paciente, farmacia);


        //Al comprar medicamentos, una vez que se vende se elimina el medicamento de la receta
        assertEquals(0, paciente.getRecetas().get(0).getMedicamentos().size());
        assertEquals(receta.getMedicamentos(), paciente.getRecetas().get(0).getMedicamentos());
        // La receta se marca como utilizada
        assertEquals(true, paciente.getRecetas().get(0).getRecetaUtilizada());

        // La receta que no se ha vendido sigue teniendo los medicamentos
        Receta receta2 = new Receta();
        receta.setId(2);
        receta.setPaciente(paciente);
        receta.setMedico(medico);
        receta.setMedicamentos(medicamentos);

        paciente.recibirReceta(receta2);

        // Se comparan los medicamentos de receta2 con los medicamentos de la receta que no se ha vendido
        assertEquals(receta2.getMedicamentos(), paciente.getRecetas().get(1).getMedicamentos());
        // La receta que no se uso es false
        assertEquals(false, paciente.getRecetas().get(1).getRecetaUtilizada());
    }
}


