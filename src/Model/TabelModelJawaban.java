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
    
    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "ID Pertanyaan";
            case 2 -> "Teks Jawaban";
            case 3 -> "Is Correct";
            default -> null;
        };
}


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        return switch (columnIndex) {
            case 0 -> lstJwb.get(rowIndex).getId();
            case 1 -> lstJwb.get(rowIndex).getId_pertanyaan();
            case 2 -> lstJwb.get(rowIndex).getTeks_jawaban();
            case 3 -> lstJwb.get(rowIndex).getIs_correct();
            default -> null;
        };
        
    }
    
    List<Jawaban> lstJwb;

}
