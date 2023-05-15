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
/**
 *
 * @author rizki
 */
public class ControllerPertanyaan {
    
    public ControllerPertanyaan(CRUDPertanyaan frame)
    {
        this.frame = frame;
        implPertanyaan = new DAOPertanyaan();
        
    }
    
    public void isiTabel()
    {
        lstPertanyaan = implPertanyaan.getAll();
        TabelModelPertanyaan tmp = new TabelModelPertanyaan(lstPertanyaan);
        frame.getTabelData().setModel(tmp);
    }
    
    
    
    CRUDPertanyaan frame;
    IDAOPertanyaan implPertanyaan;
    List<Pertanyaan> lstPertanyaan;
}
