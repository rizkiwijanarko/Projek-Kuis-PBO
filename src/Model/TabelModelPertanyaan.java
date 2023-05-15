/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rizki
 */
public class TabelModelPertanyaan extends AbstractTableModel{

    //Constructor
    public TabelModelPertanyaan(List<Pertanyaan> lstPertanyaans)
    {
        this.lstPertanyaan = lstPertanyaans;
    }
    
    
    @Override
    public int getRowCount() {
        return this.lstPertanyaan.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column)
    {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Pertanyaan";
            case 2 -> "ID Jawaban Benar";
            default -> null;
        };
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> lstPertanyaan.get(rowIndex).getId();
            case 1 -> lstPertanyaan.get(rowIndex).getTeksPertanyaan();
            case 2 -> lstPertanyaan.get(rowIndex).getIdJawabanBenar();
            default -> null;
        };
    }
    
    List<Pertanyaan> lstPertanyaan;
}
