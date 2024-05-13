package clinica.dao.interfaces;

import clinica.entidades.Medicamento;

public interface MedicamentoDAO {
    Medicamento crearMedicamento(Medicamento medicamento);
    Medicamento visualizarMedicamento(int id);
    void actualizarMedicamento(Medicamento medicamento);
    void eliminarMedicamento(int id);
}