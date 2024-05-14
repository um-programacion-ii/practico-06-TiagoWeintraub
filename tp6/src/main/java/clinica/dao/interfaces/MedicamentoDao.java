package clinica.dao.interfaces;

import clinica.entidades.Medicamento;

public interface MedicamentoDao {
    Medicamento crearMedicamento(Medicamento medicamento);
    Medicamento visualizarMedicamento(int id);
    void actualizarMedicamento(Medicamento medicamento);
    void eliminarMedicamento(int id);
}