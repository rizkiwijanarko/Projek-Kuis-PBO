///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package DAO;
//
//import DAOInterface.IDAOJawaban;
//import Helper.Koneksi;
//import Model.Jawaban;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author lenovo
// */
//public class DAOJawaban implements IDAOJawaban{
//
//    public DAOJawaban()
//    {
//        con = (Connection) Koneksi.getConnection();
//    }
//    
//    @Override
//    public List<Jawaban> getAll() {
//        List<Jawaban> lstJwb = null;
//        try
//        {
//            lstJwb = new ArrayList<Jawaban>();
//            Statement st = (Statement) con.createStatement();
//            ResultSet rs = st.executeQuery(strRead);
//            while(rs.next())
//            {
//                Jawaban jwb = new Jawaban();
//                jwb.setId(rs.getInt("id"));
//                jwb.setIdPertanyaan(rs.getInt("id_pertanyaan"));
//                jwb.setTeksJawaban(rs.getString("teks_jawaban"));
//                jwb.setIsCorrect(rs.getString("is_correct"));
//            }
//        }
//        catch(SQLException e)
//        {
//            System.out.println("Tidak ada entri data");
//        }
//        return lstJwb;
//    }
//    
//
//    @Override
//    public void insert(Jawaban b) {
//        PreparedStatement statement = null;
//        try
//        {
//            statement = (PreparedStatement) con.prepareStatement(strInsert);
//            statement.setInt(1, b.getId());
//            statement.setInt(2, b.getId_pertanyaan());
//            statement.setString(3, b.getTeks_jawaban());
//            statement.setString(4, b.getIsCorrect());
//            statement.execute();
//            
//        } catch(SQLException e)
//        {
//           System.out.println("gagal input");
//        }
//        finally
//        {
//                try {
//                    statement.close();
//                } catch (SQLException ex) {
//                    System.out.println("gagal input");
//                }
//        }
//    }
//    
//     Connection con;
//    // SQL Query
//    String strRead = "select * from jawaban_quiz;";
//    String strInsert = "insert into tblJawaban (id, id_pertanyaan, teks_jawaban, is_correct) values (?,?,?,?);";
//    
//}
