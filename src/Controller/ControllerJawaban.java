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
import javax.swing.JRootPane;
import javax.swing.JTextField;

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
        b.setId(Integer.parseInt(crudJawaban.gettxtId().getText()));
        b.setId_pertanyaan(Integer.parseInt(crudJawaban.gettxtIdPertanyaan().getText()));
        b.setTeks_jawaban(crudJawaban.gettxtJawaban().getText());
        b.setIs_correct(crudJawaban.getsetJawabanBenar().getSelectedItem().toString());
        iJawaban.insert(b);
        JOptionPane.showMessageDialog(null, "input berhasil");
    }
    
    public void reset()
    {
        if(crudJawaban.gettxtId().isEnabled())
        crudJawaban.gettxtId().setEnabled(true);
        crudJawaban.gettxtId().setText("");
        crudJawaban.gettxtIdPertanyaan().setText("");
        crudJawaban.gettxtJawaban().setText("");
        crudJawaban.getsetJawabanBenar().setSelectedItem("");
    }
    
    public void isiField(int row)
    {
        crudJawaban.gettxtId().setEnabled(false);
        crudJawaban.gettxtId().setText(lstJwb.get(row).getId().toString());
        crudJawaban.gettxtIdPertanyaan().setText(Integer.toString(lstJwb.get(row).getId_pertanyaan()));
        crudJawaban.gettxtJawaban().setText(lstJwb.get(row).getTeks_jawaban());
        crudJawaban.getsetJawabanBenar().setSelectedItem(lstJwb);
    }
    
    public void update()
    {        
        Jawaban b = new Jawaban();
        b.setId(Integer.parseInt(crudJawaban.gettxtId().getText()));
        b.setTeks_jawaban(crudJawaban.gettxtJawaban().getText());
        b.setIs_correct(crudJawaban.getsetJawabanBenar().getSelectedItem().toString());
        b.setId_pertanyaan(Integer.parseInt(crudJawaban.gettxtIdPertanyaan().getText()));
        iJawaban.update(b);
        JOptionPane.showMessageDialog(null, "update berhasil");
    }
    
    public void delete()
    {
        iJawaban.delete(Integer.parseInt(crudJawaban.gettxtId().getText()));
        JOptionPane.showMessageDialog(null,"Berhasil Menghapus Data!");
    }
    
    CRUDJawaban crudJawaban;
    IDAOJawaban iJawaban;
    List<Jawaban> lstJwb;
}
