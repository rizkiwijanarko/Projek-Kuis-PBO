/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOPertanyaan;
import DAOInterface.IDAOPertanyaan;
import View.CRUDPertanyaan;
import java.util.List;
import Model.Pertanyaan;
import Model.TabelModelPertanyaan;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
/**
 *
 * @author rizki
 */
public class ControllerPertanyaan {
    
    public ControllerPertanyaan(CRUDPertanyaan frame)
    {
        this.frmPertanyaan = frame;
        implPertanyaan = new DAOPertanyaan();
        
    }
    
    public void isiTabel()
    {
        lstPertanyaan = implPertanyaan.getAll();
        TabelModelPertanyaan tmp = new TabelModelPertanyaan(lstPertanyaan);
        frmPertanyaan.getTabelData().setModel(tmp);
    }
    
    public void Reset()
    {
        if(!frmPertanyaan.getID().isEnabled())
            frmPertanyaan.getID().setEnabled(true);
        
        frmPertanyaan.getID().setText("");
        frmPertanyaan.getTxtPertanyaan().setText("");
        frmPertanyaan.getIDJawabanBenar().setText("");
    }
    
    public void insert()
    {
        if (!frmPertanyaan.getTxtPertanyaan().getText().trim().isEmpty() && !frmPertanyaan.getID().getText().trim().isEmpty() && !frmPertanyaan.getIDJawabanBenar().getText().trim().isEmpty()){
             Pertanyaan b = new Pertanyaan();
             b.setId(Integer.parseInt(frmPertanyaan.getID().getText()));
             b.setTeksPertanyaan(frmPertanyaan.getTxtPertanyaan().getText());
             b.setIdJawabanBenar(Integer.parseInt(frmPertanyaan.getIDJawabanBenar().getText()));
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
        frmPertanyaan.getIDJawabanBenar().setText(Integer.toString(lstPertanyaan.get(row).getIdJawabanBenar()));
    }
    
    public void update()
    {
        Pertanyaan b = new Pertanyaan();
        b.setId(Integer.parseInt(frmPertanyaan.getID().getText()));
        b.setTeksPertanyaan(frmPertanyaan.getTxtPertanyaan().getText());
        b.setIdJawabanBenar(Integer.parseInt(frmPertanyaan.getIDJawabanBenar().getText()));
        implPertanyaan.update(b);

        JOptionPane.showMessageDialog(null,"Berhasil Mengubah Data!");
    }
    
    public void delete()
    {
        implPertanyaan.delete(Integer.parseInt(frmPertanyaan.getID().getText()));
        JOptionPane.showMessageDialog(null,"Berhasil Menghapus Data!");
    }
    
    public void cariSoal()
    {
        lstPertanyaan = implPertanyaan.getCariSoal(frmPertanyaan.getTxtCariSoal().getText());
        TabelModelPertanyaan tblPertanyaan = new TabelModelPertanyaan(lstPertanyaan);
        frmPertanyaan.getTabelData().setModel(tblPertanyaan);
    }
        
        
    CRUDPertanyaan frmPertanyaan;
    IDAOPertanyaan implPertanyaan;
    List<Pertanyaan> lstPertanyaan;
}
