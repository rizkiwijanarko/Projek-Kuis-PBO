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
    
    //Constructor
    public TabelModelJawaban(List<Jawaban> lstJawabans){
        this.lstJawaban = lstJawabans;
    }

    @Override
    public int getRowCount(){
        return this.lstJawaban.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column)
    {
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
            case 0 -> lstJawaban.get(rowIndex).getId();
            case 1 -> lstJawaban.get(rowIndex).getIdPertanyaan();
            case 2 -> lstJawaban.get(rowIndex).getTeksJawaban();
            case 3 -> lstJawaban.get(rowindex).getIsCorrect();
            default -> null;
        };
    }
    
}
