/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOJawaban;
import DAOInterface.IDAOJawaban;
import Model.Jawaban;
import Model.TabelModelJawaban;
import View.CRUDJawaban;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class ControllerJawaban {
    
    public ControllerJawaban(CRUDJawaban crudJawaban){
        this.crudJawaban = crudJawaban;
        iJawaban = new DAOJawaban();
        lstJwb = iJawaban.getAll();
    }
    
    public void isiTable()
    {
        lstJwb = iJawaban.getAll();
        TabelModelJawaban tabelJwb = new TabelModelJawaban(lstJwb);
        crudJawaban.getTabelData().setModel(tabelJwb);
    }
    
    public void insert()
    {
        Jawaban b = new Jawaban();
        b.setId_pertanyaan(Integer.parseInt(crudJawaban.gettxtIdPertanyaan().getText()));
        b.setTeks_jawaban(crudJawaban.gettxtJawaban().getText());
        b.setIs_correct(crudJawaban.getsetJawabanBenar().getSelectedItem().toString());
        iJawaban.insert(b);
        JOptionPane.showMessageDialog(null, "input berhasil");
    }
    
    public void reset()
    {
        crudJawaban.gettxtIdPertanyaan().setText("");
        crudJawaban.gettxtJawaban().setText("");
        crudJawaban.getsetJawabanBenar().setSelectedItem("");
    }
    
    CRUDJawaban crudJawaban;
    IDAOJawaban iJawaban;
    List<Jawaban> lstJwb;
}
