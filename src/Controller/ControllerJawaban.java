/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOJawaban;
import DAOInterface.IDAOJawaban;
import View.CRUDJawaban;
import java.util.List;
import Model.Jawaban;
import Model.TabelModelJawaban;
/**
 *
 * @author rizki
 */
public class ControllerJawaban {
    
    public ControllerJawaban(CRUDJawaban frame)
    {
        this.frame = frame;
        implJawaban = new DAOJawaban();
        
    }
    
    public void isiTabel()
    {
        lstJawaban = implJawaban.getAll();
        TabelModelJawaban tmp = new TabelModelJawaban(lstJawaban);
        frame.getTabelData().setModel(tmp);
    }
    
    
    
    CRUDJawaban frame;
    IDAOJawaban implJawaban;
    List<Jawaban> lstJawaban;
}
