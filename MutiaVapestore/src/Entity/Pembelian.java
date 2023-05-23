/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Model.SetTanggal;
import java.io.InputStream;
import java.util.ArrayList;

public class Pembelian implements SetTanggal {

    private String idPembelian, tanggalTransaksi;
    private int totalTransaksi, jumlah;
    private InputStream gambarStream;
    ArrayList<Object> keranjang;

    public void keranjangAddRow(Pembelian b) {
        b.keranjang= new ArrayList<>();
    }

    public ArrayList<Object> getKeranjang(Pembelian b) {
        return b.keranjang;
    }

    public void setKeranjang(Pembelian b,String namaProduk, int subHarga, int jumlah, int totalHarga) {
        keranjangAddRow(b);
        b.keranjang.add(0, namaProduk);
        b.keranjang.add(1, subHarga);
        b.keranjang.add(2, jumlah);
        b.keranjang.add(3, totalHarga);
        getKeranjang(b);
    }


    public String getIdPembelian() {
        return idPembelian;
    }

    public void setIdPembelian(String idPembelian) {
        this.idPembelian = idPembelian;
    }

    public String getTanggalTransaksi() {
        setTanggalTransaksi();
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi() {
        
        this.tanggalTransaksi = tanggal;
    }

    public int getTotalTransaksi() {
        return totalTransaksi;
    }

    public void setTotalTransaksi(int totalTransaksi) {
        this.totalTransaksi = totalTransaksi;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    /**
     * @return the gambarStream
     */
    public InputStream getGambarStream() {
        return gambarStream;
    }

    /**
     * @param gambarStream the gambarStream to set
     */
    public void setGambarStream(InputStream gambarStream) {
        this.gambarStream = gambarStream;
    }

}
