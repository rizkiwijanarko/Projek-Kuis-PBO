/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;
import Model.Pertanyaan;
import java.util.List;

/**
 *
 * @author rizki
 */
public interface IDAOPertanyaan {
    public void insert(Pertanyaan b);
    public void update(Pertanyaan b);
    public void delete(int id);
    public List<Pertanyaan> getAll();
    public List<Pertanyaan> getCariSoal(String soal);
}