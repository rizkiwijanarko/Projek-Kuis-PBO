/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rizki
 */
public class Pertanyaan {

    /**
     * @return the ID
     */
    public int getId() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setId(int ID) {
        this.ID = ID;
    }

    /**
     * @return the teksPertanyaan
     */
    public String getTeksPertanyaan() {
        return teksPertanyaan;
    }

    /**
     * @param teksPertanyaan the teksPertanyaan to set
     */
    public void setTeksPertanyaan(String teksPertanyaan) {
        this.teksPertanyaan = teksPertanyaan;
    }

    /**
     * @return the IdJawabanBenar
     */
    public int getIdJawabanBenar() {
        return IdJawabanBenar;
    }

    /**
     * @param IdJawabanBenar the IdJawabanBenar to set
     */
    public void setIdJawabanBenar(int IdJawabanBenar) {
        this.IdJawabanBenar = IdJawabanBenar;
    }
    private int ID;
    private String teksPertanyaan;
    private int IdJawabanBenar;
    
    
}
