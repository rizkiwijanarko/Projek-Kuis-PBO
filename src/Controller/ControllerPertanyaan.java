/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOPertanyaan;
import DAOInterface.IDAOJawaban;
import DAOInterface.IDAOPertanyaan;
import View.CRUDKuis;
import java.util.List;
import Model.Pertanyaan;
import Model.TabelModelPertanyaan;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/**
 *
 * @author rizki
 */
public class ControllerPertanyaan {
    
    public ControllerPertanyaan(CRUDKuis frame)
    {
        this.frmPertanyaan = frame;
        implPertanyaan = new DAOPertanyaan();
        implPertanyaan.fillComboBoxJB(frmPertanyaan.getComboJB());
    }
    
    public void isiTabel()
    {
        lstPertanyaan = implPertanyaan.getAll();
        TabelModelPertanyaan tmp = new TabelModelPertanyaan(lstPertanyaan);
        frmPertanyaan.getTabelDataSoal().setModel(tmp);
    }
    
    public void Reset()
    {
        if(!frmPertanyaan.getID().isEnabled())
            frmPertanyaan.getID().setEnabled(true);
        
        frmPertanyaan.getID().setText("");
        frmPertanyaan.getTxtPertanyaan().setText("");
        frmPertanyaan.getJawabanBenar().setSelectedItem("");
    }
    
    public void insert()
    {
        if (!frmPertanyaan.getTxtPertanyaan().getText().trim().isEmpty() &&
            !frmPertanyaan.getID().getText().trim().isEmpty() &&
            frmPertanyaan.getComboJB().getSelectedItem() != null){
             Pertanyaan b = new Pertanyaan();
             b.setId(Integer.parseInt(frmPertanyaan.getID().getText()));
             b.setTeksPertanyaan(frmPertanyaan.getTxtPertanyaan().getText());
             b.setIdJawabanBenar(Integer.parseInt(frmPertanyaan.getComboJB().getSelectedItem().toString()));
             
             boolean res = implPertanyaan.insert(b);
             
             if(res)
                 JOptionPane.showMessageDialog(null,"Berhasil menyimpan Data!");
             else
                 JOptionPane.showMessageDialog(frmPertanyaan,"Gagal menyimpan Data, Dikarenakan Terdapat Data Duplikat!");
        }else{
             JOptionPane.showMessageDialog(frmPertanyaan,"Data Tidak Boleh Kosong!");
        }
    }
    
    public void isiField(int row)
    {
        frmPertanyaan.getID().setEnabled(false);
        frmPertanyaan.getID().setText(Integer.toString(lstPertanyaan.get(row).getId()));
        frmPertanyaan.getTxtPertanyaan().setText(lstPertanyaan.get(row).getTeksPertanyaan());   
        frmPertanyaan.getComboJB().setSelectedItem(Integer.toString(lstPertanyaan.get(row).getIdJawabanBenar()));
    }
    
    public void update()
    {
        Pertanyaan b = new Pertanyaan();
        b.setId(Integer.parseInt(frmPertanyaan.getID().getText()));
        b.setTeksPertanyaan(frmPertanyaan.getTxtPertanyaan().getText());
        b.setIdJawabanBenar(Integer.parseInt(frmPertanyaan.getComboJB().getSelectedItem().toString()));
        implPertanyaan.update(b);

        JOptionPane.showMessageDialog(null,"Berhasil Mengubah Data!");
    }
    
    public void delete()
    {
        if (!frmPertanyaan.getTxtPertanyaan().getText().trim().isEmpty() && !frmPertanyaan.getID().getText().trim().isEmpty() && frmPertanyaan.getComboJB().getSelectedItem() != null){
             implPertanyaan.delete(Integer.parseInt(frmPertanyaan.getID().getText()));
            JOptionPane.showMessageDialog(null,"Berhasil Menghapus Data!");
        }else{
             JOptionPane.showMessageDialog(frmPertanyaan,"Tidak Ada Data yang Dipilih!");
        }
    }
    
    public void cariSoal()
    {
        lstPertanyaan = implPertanyaan.getCariSoal(frmPertanyaan.getTxtCariSoal().getText());
        TabelModelPertanyaan tblPertanyaan = new TabelModelPertanyaan(lstPertanyaan);
        frmPertanyaan.getTabelDataSoal().setModel(tblPertanyaan);
    }
    
    public void fillComboBoxJB()
    {
        implPertanyaan.fillComboBoxJB(frmPertanyaan.getComboJB());
    }

    public void removeComboBoxJB()
    {
        implPertanyaan.removeAllModelComboBox(frmPertanyaan.getComboBoxPtn());
    }
        
    CRUDKuis frmPertanyaan;
    IDAOPertanyaan implPertanyaan;
    List<Pertanyaan> lstPertanyaan;
}
