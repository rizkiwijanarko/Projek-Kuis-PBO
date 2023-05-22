/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lenovo
 */
public class TabelModelJawaban extends AbstractTableModel{

    public TabelModelJawaban(List<Jawaban> lstJwb)
    {
        this.lstJwb = lstJwb;
    }
    
    @Override
    public int getRowCount() {
       return this.lstJwb.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    public String getColumName(int column)
    {
        switch(column)
        {
            case 0:
                return "ID";
            case 1:
                return "ID Pertanyaan";
            case 2 :
                return "Teks Jawaban";
            case 3:
                return "Is Correct";
            default:
                return null;
        }
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex)
        {
            case 0:
                return lstJwb.get(rowIndex).getId();
            case 1:
                return lstJwb.get(rowIndex).getId_pertanyaan();
            case 2 :
                return lstJwb.get(rowIndex).getTeks_jawaban();
            case 3:
                return lstJwb.get(rowIndex).getIs_correct();
            default:
                return null;
        }
        
    }
    
    List<Jawaban> lstJwb;

}
