package clinica.dao.implementaciones;

import clinica.dao.interfaces.MedicamentoDao;
import clinica.entidades.Medicamento;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicamentoDaoImpl implements MedicamentoDao {
    private final Map<Integer, Medicamento> medicamentos = new HashMap<>();
    private int proximoId = 1;

    @Override
    public Medicamento crearMedicamento(Medicamento medicamento) {
        medicamento.setId(proximoId++);
        medicamentos.put(medicamento.getId(), medicamento);
        return medicamento;
    }

    @Override
    public Medicamento visualizarMedicamento(int id) {
        return medicamentos.get(id);
    }

    @Override
    public void actualizarMedicamento(Medicamento medicamento) {
        medicamentos.put(medicamento.getId(), medicamento);
    }

    @Override
    public void eliminarMedicamento(int id) {
        medicamentos.remove(id);
    }
}