package Entity;

import java.io.InputStream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Big Nigga Dude
 */
public class Produk {
    private String idProduk,namaProduk,idKategori,kategori;
    private int stok,harga,hargaBeli;
    private InputStream gambarStream;
    private byte[] gambar;

    /**
     * @return the idProduk
     */
    public String getIdProduk() {
        return idProduk;
    }

    /**
     * @param idProduk the idProduk to set
     */
    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    /**
     * @return the namaProduk
     */
    public String getNamaProduk() {
        return namaProduk;
    }

    /**
     * @param namaProduk the namaProduk to set
     */
    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    /**
     * @return the idKategori
     */
    public String getIdKategori() {
        return idKategori;
    }

    /**
     * @param idKategori the idKategori to set
     */
    public void setIdKategori(String idKategori) {
        this.idKategori = idKategori;
    }

    /**
     * @return the kategori
     */
    public String getKategori() {
        return kategori;
    }

    /**
     * @param kategori the kategori to set
     */
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    /**
     * @return the stok
     */
    public int getStok() {
        return stok;
    }

    /**
     * @param stok the stok to set
     */
    public void setStok(int stok) {
        this.stok = stok;
    }

    /**
     * @return the harga
     */
    public int getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(int harga) {
        this.harga = harga;
    }

    /**
     * @return the gambar
     */
    public byte[] getGambar() {
        return gambar;
    }

    /**
     * @param gambar the gambar to set
     */
    public void setGambar(byte[] gambar) {
        this.gambar = gambar;
    }

    /**
     * @return the hargaBeli
     */
    public int getHargaBeli() {
        return hargaBeli;
    }

    /**
     * @param hargaBeli the hargaBeli to set
     */
    public void setHargaBeli(int hargaBeli) {
        this.hargaBeli = hargaBeli;
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
