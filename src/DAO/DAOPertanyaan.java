/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOPertanyaan;
import Helper.Koneksi;
import Model.Pertanyaan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
/**
 *
 * @author rizki
 */
public class DAOPertanyaan implements IDAOPertanyaan{

    public DAOPertanyaan()
    {
        con = Koneksi.getConnection();
    }
    
   
    @Override
    public List<Pertanyaan> getAll() {
        List<Pertanyaan> lstPertanyaan = null;
        
        try {
            lstPertanyaan = new ArrayList<Pertanyaan>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next())
            {
                Pertanyaan ptn = new Pertanyaan();
                ptn.setId(rs.getInt("id"));
                ptn.setTeksPertanyaan(rs.getString("teks_pertanyaan"));
                ptn.setIdJawabanBenar(rs.getInt("id_jawaban_benar"));
                lstPertanyaan.add(ptn);
            }
        
        } catch (SQLException e) {
            System.out.println("Tidak ada entri data");
        }
        return lstPertanyaan;
    }
    
    
    @Override
    public boolean insert(Pertanyaan b)
    {
        boolean hasil = true;
        PreparedStatement statement = null;
        try{
            statement =  (PreparedStatement) con.prepareStatement(insert);
            statement.setInt(1, b.getId());
            statement.setString(2, b.getTeksPertanyaan());
            statement.setInt(3, b.getIdJawabanBenar());
            statement.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("GAGAL MENAMBAHKAN DATA!");
            hasil = false;
        }finally{
            try{
                statement.close();
            }catch(SQLException e){
                System.out.println("GAGAL MENAMBAHKAN DATA!");
                hasil = false;
            }
        }
        return hasil;
    }
    
    @Override
    public void update(Pertanyaan b)
    {
        
        PreparedStatement statement = null;
        try{
            statement =  (PreparedStatement) con.prepareStatement(update);
            
            statement.setString(1, b.getTeksPertanyaan());
            statement.setInt(2, b.getIdJawabanBenar());
            statement.setInt(3, b.getId());
            statement.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("GAGAL UPDATE DATA!");
        }finally{
            try{
                statement.close();
            }catch(SQLException e){
                System.out.println("Data Gagal Ditambahkan!");
            }
        }
    }

    @Override
    public void delete(int id)
    {
        PreparedStatement statement = null;
        
        try {
            statement = (PreparedStatement) con.prepareStatement(delete);
            
            statement.setInt(1, id);
            statement.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Data Gagal Dihapus!");
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Data Gagal Dihapus!");
            }
        }
        
    }
    
    
    @Override
    public List<Pertanyaan> getCariSoal(String soal)
    {
      List<Pertanyaan> lstPertanyaan = null;
        
        try {
            lstPertanyaan = new ArrayList<>();
            PreparedStatement st = (PreparedStatement) con.prepareStatement(cariSoal);
            st.setString(1, "%" + soal + "%");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Pertanyaan b = new Pertanyaan();
                b.setId(rs.getInt("id"));
                b.setTeksPertanyaan(rs.getString("teks_pertanyaan"));
                b.setIdJawabanBenar(rs.getInt("id_jawaban_benar"));
                lstPertanyaan.add(b);
            }
            
        } catch (SQLException e) {
            System.out.println("Tidak ada entri data");
        }
        return lstPertanyaan;
    }
    
    @Override
    public void fillComboBoxJB(JComboBox<Integer> comboBox) {
        try {
            PreparedStatement st = con.prepareStatement(addJB);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int idJB = rs.getInt("id");
                comboBox.addItem(idJB);
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve quiz entries: " + e.getMessage());
            }
    }

    
    
    Connection con;
    
    // SQL Query
    String insert = "INSERT INTO pertanyaan_quiz (id,teks_pertanyaan,id_jawaban_benar) VALUES (?,?,?);";
    String update = "UPDATE pertanyaan_quiz set teks_pertanyaan=?, id_jawaban_benar=? WHERE id=?;";
    String delete = "DELETE FROM pertanyaan_quiz WHERE id=?;";
    String strRead = "SELECT * FROM `pertanyaan_quiz` ORDER BY `id` asc;";
    String cariSoal = "SELECT * FROM pertanyaan_quiz WHERE teks_pertanyaan like ?;";
    String addJB = "SELECT id FROM jawaban_quiz ORDER BY id ASC;";

}
