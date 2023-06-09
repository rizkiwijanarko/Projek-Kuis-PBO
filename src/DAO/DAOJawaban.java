/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOJawaban;
import Helper.Koneksi;
import Model.Jawaban;
import Model.Pertanyaan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author lenovo
 */
public class DAOJawaban implements IDAOJawaban{

    public DAOJawaban()
    {
        con = Koneksi.getConnection();
    }
    
    @Override
    public List<Jawaban> getAll() {
        List<Jawaban> lstJwb = null;
        try
        {
            lstJwb = new ArrayList<Jawaban>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next())
            {
                Jawaban jwb = new Jawaban();
                jwb.setId(rs.getInt("id"));
                jwb.setId_pertanyaan(rs.getInt("id_pertanyaan"));
                jwb.setTeks_jawaban(rs.getString("teks_jawaban"));
                jwb.setIs_correct(rs.getString("is_correct"));
                lstJwb.add(jwb);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Tidak ada entri data");
        }
        return lstJwb;
    }
    

    @Override
    public void insert(Jawaban b) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strInsert);
            statement.setInt(1, b.getId());
            statement.setInt(2, b.getId_pertanyaan());
            statement.setString(3, b.getTeks_jawaban());
            statement.setString(4, b.getIs_correct());
            statement.execute();
            
        } catch(SQLException e)
        {
           System.out.println("gagal input");
        }
        finally
        {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println("gagal input");
                }
        }
    }
    
    @Override
    public void update(Jawaban b) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strUpdate);
            statement.setInt(1, b.getId_pertanyaan());
            statement.setString(2, b.getTeks_jawaban());
            statement.setString(3, b.getIs_correct());
            statement.setInt(4, b.getId());
            statement.execute();
            
        } catch(SQLException e)
        {
           System.out.println("gagal update");
        }
        finally
        {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println("gagal update");
                }
        }
        
    }
    
    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strDelete);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch(SQLException e)
        {
           System.out.println("gagal delete");
        }
        finally
        {
            try {
            statement.close();
            } catch (SQLException ex) {
            System.out.println("gagal delete");
            }
        }
    }
    
    @Override
    public void fillComboBoxPtn(JComboBox<Integer> comboBox) {
        try {
            PreparedStatement st = con.prepareStatement(strComboPtn);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int idPtn = rs.getInt("id");
                comboBox.addItem(idPtn);
            }
        } catch (SQLException e) {
            System.out.println("Gagal Mengambil entri quiz: " + e.getMessage());
            }    
    }
    
    @Override
    public List<Jawaban> getCariJawaban(String jawaban) {
        List<Jawaban> lstJawaban = null;
        
        try {
            lstJawaban = new ArrayList<>();
            PreparedStatement st = (PreparedStatement) con.prepareStatement(strCariJawaban);
            st.setString(1, "%" + jawaban + "%");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Jawaban b = new Jawaban();
                b.setId(rs.getInt("id"));
                b.setTeks_jawaban(rs.getString("teks_jawaban"));
                b.setIs_correct(rs.getString("is_correct"));
                b.setId_pertanyaan(rs.getInt("id_pertanyaan"));
                lstJawaban.add(b);
            }
            
        } catch (SQLException e) {
            System.out.println("Tidak ada entri data");
        }
        return lstJawaban;
    }
    
    @Override
    public void removeAllModelComboBox(JComboBox<Integer> comboBox)
    {
        comboBox.removeAllItems();
    }
    
    Connection con;
    // SQL Query
    String strRead = "select * from jawaban_quiz ORDER BY id ASC ;";
    String strInsert = "insert into jawaban_quiz (id, id_pertanyaan, teks_jawaban, is_correct) values (?,?,?,?);";
    String strUpdate = "update jawaban_quiz set id_pertanyaan=?, teks_jawaban=?, is_correct=? where id=?;";
    String strDelete = "delete from jawaban_quiz where id=?;";
    String strCariJawaban = "SELECT * FROM jawaban_quiz WHERE teks_jawaban like ?;";
    String strComboPtn = "SELECT id FROM pertanyaan_quiz ORDER BY id ASC;";

}
