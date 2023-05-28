/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Jawaban;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface IDAOJawaban {
    //read data
    public List<Jawaban> getAll();
    //insert data
    public void insert(Jawaban b);
    //update data
    public void update(Jawaban b);
    //delete data
    public void delete(int id);
    //cari data
}
