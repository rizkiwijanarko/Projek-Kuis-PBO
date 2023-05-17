/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOPertanyaan;
import Helper.Koneksi;
import Model.Jawaban;
import Model.Pertanyaan;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**;

/**
 *
 * @author SAFANA SALSABILA
 */
public class DAOJawaban implement DAOJawaban{
    
    public DAOJawaban()
    {
        con = (Connection) Koneksi.getConnection();
    }
    
    public List<Jawaban>getAll(){
        List<Jawaban> lstJawaban = null;
        
        try {
            lstJawaban = new ArrayList<Jawaban>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next())
            {
                Jawaban jwb = new Jawaban();
                jwb.setId(rs.getInt("id"));
                jwb.setTeksJawaban(rs.getString("teks_jawaban"));
                lstJawaban.add(jwb);
            }
            
        }catch (SQLException e) {
            System.out.println("Tidak ada entri data");
        }
        return lstJawaban;
    }
    
    public void insert(Jawaban b)
    {
        PreparedStatement statement = null;
        try{
            statement = (PreparedStatement) con.prepareStatement(insert);
            statement.setString(1, b.getTeksJawaban());
            statement.setString(2, b.getIdPertanyaan());
            statement.setInt(2, b.getIsCorrect());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                b.setId(rs.getInt(1));
            }
            
        }catch(SQLException e){
            System.out.println("Data Berhasil Ditambahkan!");
        }finally{
            try{
                statement.close();
            }catch(SQLException e){
                System.out.println("Data Gagal Ditambahkan!");
            }
        }
    }
    
    public void update(Jawaban b)
    {
        PreparedStatement statement = null;
        try{
            statement = (PreparedStatement) con.prepareStatement(update);
            statement.setString(1, b.getTeksJawaban());
            statement.setString(2, b.getIdPertanyaan());
            statement.setInt(3, b.getIsCorrect());
            statement.setInt(4, b.getId());
            statement.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Data Berhasil Diubah!");
        }finally{
            try{
                statement.close();
            }catch(SQLException e){
                System.out.println("Data Gagal Diubah!");
            }
        }
    }
    
    public void delete(int id)
    {
        PreparedStatement statement = null;
        
        try {
            statement = (PreparedStatement) con.prepareStatement(delete);
            
            statement.setInt(1, id);
            statement.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Data Berhasil Dihapus!");
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Data Gagal Dihapus!");
            }
        }
        
    }
    
    
    public List<Jawaban> getCariJawaban(String Jawaban){
      List<Jawaban> lstJawaban = null;
        
        try {
            lstJawaban = new ArrayList<>();
            PreparedStatement st = (PreparedStatement) con.prepareStatement(cariJawaban);
            st.setString(1, "%" + IsCorrect + "%");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Jawaban b = new Jawaban();
                b.setId(rs.getInt("id"));
                b.setTeksJawaban(rs.getString("teks_Jawaban"));
                b.setIdPertanyaan(rs.getInt("id_pertanyaan"));
                b.setIsCorrect(rs.getInt("jawaban_benar"));
                lstJawaban.add(b);
            }
        } catch (SQLException e) {
            System.out.println("Tidak ada entri data");
        }
        return lstJawaban;
    }
    
    Connection con;
    // SQL Query
    String insert = "INSERT INTO jawaban_quiz (teks_jawaban,id_pertanyaan,jawaban_benar) VALUES (?,?);";
    String update = "UPDATE jawaban_quiz set teks_jawaban=?, id_pertanyaan=?, jawaban_benar=? WHERE id=?;";
    String delete = "DELETE FROM jawaban_quiz WHERE id=?;";
    String strRead = "SELECT * FROM jawaban_quiz;";
    String cariJawaban = "SELECT * FROM jawaban_quiz WHERE teks_jawaban like ?;";
}
