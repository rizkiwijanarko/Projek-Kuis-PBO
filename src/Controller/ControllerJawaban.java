/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOJawaban;
import DAOInterface.IDAOJawaban;
import Model.Jawaban;
import Model.TabelModelJawaban;
import View.CRUDKuis;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;

/**
 *
 * @author lenovo
 */
public class ControllerJawaban {
    
    public ControllerJawaban(CRUDKuis crudKuis){
        this.crudKuis = crudKuis;
        iJawaban = new DAOJawaban();
        lstJwb = iJawaban.getAll();
        iJawaban.fillComboBoxPtn(crudKuis.getComboBoxPtn());
    }
    
    public void isiTable()
    {
        lstJwb = iJawaban.getAll();
        TabelModelJawaban tabelJwb = new TabelModelJawaban(lstJwb);
        crudKuis.getTabelDataJawaban().setModel(tabelJwb);
    }
    
    public void insert()
    {
        Jawaban b = new Jawaban();
        b.setId(Integer.parseInt(crudKuis.gettxtId().getText()));
        b.setId_pertanyaan(Integer.parseInt(crudKuis.getComboBoxPtn().getSelectedItem().toString()));
        b.setTeks_jawaban(crudKuis.gettxtJawaban().getText());
        b.setIs_correct(crudKuis.getJawabanBenar().getSelectedItem().toString());
        iJawaban.insert(b);
        JOptionPane.showMessageDialog(null, "input berhasil");
    }
    
    public void reset()
    {
        if(crudKuis.gettxtId().isEnabled())
            crudKuis.gettxtId().setEnabled(true);
            crudKuis.gettxtId().setText("");
            crudKuis.getComboBoxPtn().setSelectedItem("");
            crudKuis.gettxtJawaban().setText("");
            crudKuis.getJawabanBenar().setSelectedItem("");
    }
    
    public void isiField(int row)
    {
        crudKuis.gettxtId().setEnabled(false);
        crudKuis.gettxtId().setText(lstJwb.get(row).getId().toString());
        crudKuis.getComboBoxPtn().setSelectedItem(Integer.toString(lstJwb.get(row).getId_pertanyaan()));
        crudKuis.gettxtJawaban().setText(lstJwb.get(row).getTeks_jawaban());
        crudKuis.getJawabanBenar().setSelectedItem(lstJwb);
    }
    
    public void update()
    {        
        Jawaban b = new Jawaban();
        b.setId(Integer.parseInt(crudKuis.gettxtId().getText()));
        b.setTeks_jawaban(crudKuis.gettxtJawaban().getText());
        b.setId_pertanyaan(Integer.parseInt(crudKuis.getComboBoxPtn().getSelectedItem().toString()));
        b.setIs_correct(crudKuis.getJawabanBenar().getSelectedItem().toString());
        iJawaban.update(b);
        JOptionPane.showMessageDialog(null, "update berhasil");
    }
    
    public void delete()
    {
        iJawaban.delete(Integer.parseInt(crudKuis.gettxtId().getText()));
        JOptionPane.showMessageDialog(null,"Berhasil Menghapus Data!");
    }
    
    CRUDKuis crudKuis;
    IDAOJawaban iJawaban;
    List<Jawaban> lstJwb;
}
