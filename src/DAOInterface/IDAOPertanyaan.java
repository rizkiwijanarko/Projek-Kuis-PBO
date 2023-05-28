/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;
import Model.Pertanyaan;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author rizki
 */
public interface IDAOPertanyaan {
    public boolean insert(Pertanyaan b);
    public void update(Pertanyaan b);
    public void delete(int id);
    public List<Pertanyaan> getCariSoal(String soal);
    public List<Pertanyaan> getAll();
    public void fillComboBoxJB(JComboBox<Integer> comboBox);
    public void removeAllModelComboBox(JComboBox<Integer> comboBox);
}
