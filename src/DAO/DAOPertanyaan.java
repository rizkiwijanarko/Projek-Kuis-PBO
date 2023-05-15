/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOPertanyaan;
import Helper.Koneksi;
import Model.Pertanyaan;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author rizki
 */
public class DAOPertanyaan implements IDAOPertanyaan{

    public DAOPertanyaan()
    {
        con = (Connection) Koneksi.getConnection();
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
    
    public List<Pertanyaan> getCariSoal(String soal)
    {
      List<Pertanyaan> lstPertanyaan = null;
        
        try {
            lstPertanyaan = new ArrayList<Pertanyaan>();
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
    
    Connection con;
    // SQL Query
    String insert = "INSERT INTO pertanyaan_quiz (teks_pertanyaan,id_jawaban_benar) VALUES (?,?);";
    String update = "UPDATE pertanyaan_quiz set teks_pertanyaan=?, id_jawaban_benar=? WHERE id=?;";
    String delete = "DELETE FROM pertanyaan_quiz WHERE id=?;";
    String strRead = "SELECT * FROM pertanyaan_quiz;";
    

    String cariSoal = "SELECT * FROM pertanyaan_quiz WHERE teks_pertanyaan like ?;";
}
