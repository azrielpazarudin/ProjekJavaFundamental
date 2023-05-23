/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import Model.SetTanggal;
import java.util.*;

/**
 *
 * @author Big Nigga Dude
 */
public class Penjualan implements SetTanggal  {
   
    private String idPenjualan, tanggalTransaksi;
    private int totalTransaksi,jumlah;
    public int indexDec=0;
    ArrayList<List<Object>> keranjang = new ArrayList<List<Object>>();

    public void keranjangAddRow(Penjualan p) {
        p.keranjang.add(new ArrayList<>());
    }
    public ArrayList<List<Object>> getKeranjang(Penjualan p){
        return p.keranjang;
    }
    public void setKeranjang(String nama,int subHarga, int jumlah, int totalHarga, int index, Penjualan p) {
        keranjangAddRow(p);
        index-=p.indexDec;
        p.keranjang.get(index).add(0, nama);
        p.keranjang.get(index).add(1, subHarga);
        p.keranjang.get(index).add(2, jumlah);
        p.keranjang.get(index).add(3, totalHarga);
        int res = 0, resTwo = 0;
        for (int x = 0; x < p.keranjang.size() - 1; x++) {
            if (p.keranjang.get(x).get(0).equals(p.keranjang.get(p.keranjang.size() - 1).get(0))) {
                res = (Integer) p.keranjang.get(x).get(2) + (Integer) p.keranjang.get(p.keranjang.size() - 1).get(2);
                resTwo = (Integer) p.keranjang.get(x).get(3) + (Integer) p.keranjang.get(p.keranjang.size() - 1).get(3);
                p.keranjang.get(x).set(2, res);
                p.keranjang.get(x).set(3, resTwo);
                p.keranjang.remove(p.keranjang.size() - 1).clear();
                p.indexDec++;
            }
        }
        getKeranjang(p);
    }

    public String getIdPenjualan() {
        return idPenjualan;
    }


    public void setIdPenjualan(String idPenjualan) {
        this.idPenjualan = idPenjualan;
    }


    public String getTanggalTransaksi() {
        this.tanggalTransaksi=tanggal;
        return tanggalTransaksi;
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

}
