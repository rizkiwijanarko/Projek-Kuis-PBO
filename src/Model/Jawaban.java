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

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the id_pertanyaan
     */
    public Integer getId_pertanyaan() {
        return id_pertanyaan;
    }

    /**
     * @param id_pertanyaan the id_pertanyaan to set
     */
    public void setId_pertanyaan(Integer id_pertanyaan) {
        this.id_pertanyaan = id_pertanyaan;
    }

    /**
     * @return the teks_jawaban
     */
    public String getTeks_jawaban() {
        return teks_jawaban;
    }

    /**
     * @param teks_jawaban the teks_jawaban to set
     */
    public void setTeks_jawaban(String teks_jawaban) {
        this.teks_jawaban = teks_jawaban;
    }

    /**
     * @return the is_correct
     */
    public String getIs_correct() {
        return is_correct;
    }

    /**
     * @param is_correct the is_correct to set
     */
    public void setIs_correct(String is_correct) {
        this.is_correct = is_correct;
    }

    private Integer id;
    private Integer id_pertanyaan;
    private String teks_jawaban;
    private String is_correct;

}