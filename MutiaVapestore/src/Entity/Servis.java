/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Model.*;
import static Model.SetTanggal.myDateObj;
import static Model.SetTanggal.myFormatObj;
import java.time.LocalDateTime;

public class Servis implements SetTanggal {

    private String namaCustomer, namaBarang, noTelp, tanggalMulai, tanggalSelesai,idServis;
    private int lamaServis, biaya;

    /**
     * @return the namaCustomer
     */
    public String getNamaCustomer() {
        return namaCustomer;
    }

    /**
     * @param namaCustomer the namaCustomer to set
     */
    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    /**
     * @return the namaBarang
     */
    public String getNamaBarang() {
        return namaBarang;
    }

    /**
     * @param namaBarang the namaBarang to set
     */
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    /**
     * @return the noTelp
     */
    public String getNoTelp() {
        return noTelp;
    }

    /**
     * @param noTelp the noTelp to set
     */
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    /**
     * @return the tanggalMulai
     */
    public String getTanggalMulai() {
        setTanggalMulai();
        return tanggalMulai;
    }

    /**
     * @param tanggalMulai the tanggalMulai to set
     */
    public void setTanggalMulai() {
        this.tanggalMulai = tanggal;
    }

    /**
     * @return the tanggalSelesai
     */
    public String getTanggalSelesai() {
        setTanggalSelesai();
        return tanggalSelesai;
    }

    /**
     * @param tanggalSelesai the tanggalSelesai to set
     */
    public void setTanggalSelesai() {
        LocalDateTime x = myDateObj.plusDays(getLamaServis());        
        this.tanggalSelesai =  x.format(myFormatObj);
    }

    /**
     * @return the lamaServis
     */
    public int getLamaServis() {
        return lamaServis;
    }

    /**
     * @param lamaServis the lamaServis to set
     */
    public void setLamaServis(int lamaServis) {
        this.lamaServis = lamaServis;
    }

    /**
     * @return the biaya
     */
    public int getBiaya() {
        return biaya;
    }

    /**
     * @param biaya the biaya to set
     */
    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    /**
     * @return the idServis
     */
    public String getIdServis() {
        return idServis;
    }

    /**
     * @param idServis the idServis to set
     */
    public void setIdServis(String idServis) {
        this.idServis = idServis;
    }

}
