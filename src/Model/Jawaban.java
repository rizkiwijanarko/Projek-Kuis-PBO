/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lenovo
 */
public class Jawaban {

    private Integer ID;
    private Integer idPertanyaan;

    /**
     * @return the ID
     */
    public Integer getId() {
        return ID;
    }

    /**
     * @param ID the id to set
     */
    public void setId(Integer ID) {
        this.ID = ID;
    }

    /**
     * @return the IdPertanyaan
     */
    public Integer getIdPertanyaan() {
        return idPertanyaan;
    }

    /**
     * @param idPertanyaan
     */
    public void setIdPertanyaan(Integer idPertanyaan) {
        this.idPertanyaan = idPertanyaan;
    }

    /**
     * @return the TeksJawaban
     */
    public String getTeksJawaban() {
        return TeksJawaban;
    }

    /**
     * @param TeksJawaban
     */
    public void setTeksJawaban(String TeksJawaban) {
        this.TeksJawaban = TeksJawaban;
    }

    /**
     * @return the IsCorrect
     */
    public String getIsCorrect() {
        return IsCorrect;
    }

    /**
     * @param IsCorrect the IsCorrect to set
     */
    public void setIsCorrect(String IsCorrect) {
        this.IsCorrect = IsCorrect;
    }

   
    private Integer Id;
    private Integer IdPertanyaan;
    private String TeksJawaban;
    private String IsCorrect;
}
