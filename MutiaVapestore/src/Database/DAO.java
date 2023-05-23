/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.util.*;
import Model.Model;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DAO {

    public Connection Conn;
    Database db = new Database();
    Statement stm;
    PreparedStatement ps = null;
    ResultSet rs;
    DefaultTableModel dtm;

    public DAO() {
        Conn = db.callConn();
    }

    public byte[] frameLogo(int i) throws SQLException {
        byte[] path = null;
        stm = Conn.createStatement();
        rs = stm.executeQuery("select gambar from logo where id = '" + i + "'");
        while (rs.next()) {
            path = rs.getBytes("gambar");
        }
        return path;
    }

    //============ LOGIN & AKUN ==========
    public boolean login(Model mod) {
        boolean correct = false;
        String a = "", b = "";
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select *from akun");
            while (rs.next()) {
                a = rs.getString(1);
                b = rs.getString(2);
            }
            if (mod.akun.getUsername().equals(a) && mod.akun.getPassword().equals(b)) {
                correct = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correct;
    }

    public int updateAkun(Model mod) {
        int result = 0;
        try {
            stm = Conn.createStatement();
            result = stm.executeUpdate("update akun set username ='" + mod.akun.getUsername() + "',password='" + mod.akun.getPassword() + "'");
            JOptionPane.showMessageDialog(null, "Update Akun Berhasil", "Mutia Vapestore : Edit Akun", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    // =========== CATALOG =============
    public ArrayList<String> categoryList() {
        ArrayList<String> category = new ArrayList<>();
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select kategori from kategori");
            while (rs.next()) {
                category.add(rs.getString("kategori"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
    }

    public ArrayList<String> productList(String category, String order) {
        ArrayList<String> product = new ArrayList<>();
        try {
            stm = Conn.createStatement();
            if (category.equals("Semua Kategori")) {
                rs = stm.executeQuery("select namaProduk from produk where stok>0  order by hargaJual " + order + "");
            } else {
                rs = stm.executeQuery("select namaProduk from produk where stok>0 and kategori='" + category + "' order by hargaJual " + order + "");
            }
            while (rs.next()) {
                product.add(rs.getString("namaProduk"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    public ArrayList<Object> showProduk(Model mod) {
        ArrayList<Object> product = new ArrayList<>();
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select idProduk from produk where stok>0 and namaProduk = '" + mod.produk.getNamaProduk() + "'");
            while (rs.next()) {
                mod.produk.setIdProduk(rs.getString("idProduk"));
            }
            rs = stm.executeQuery("select *from  produk where idProduk='" + mod.produk.getIdProduk() + "'");
            while (rs.next()) {
                product.add(rs.getString("namaProduk"));
                product.add(rs.getString("kategori"));
                product.add(rs.getBytes("gambar"));
                product.add(rs.getInt("stok"));
                product.add(rs.getInt("hargaJual"));
                product.add(rs.getInt("hargaBeli"));
                product.add(rs.getString("idKategori"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    public DefaultTableModel produkShow() {
        dtm = new DefaultTableModel(new String[]{"Id Produk", "Nama Produk", "Gambar", "Id Kategori", "kategori", "Stok", "Harga Beli", "Harga Jual"}, 0);
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select *from produk");
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("idProduk"), rs.getString("namaProduk"), rs.getBytes("gambar"), rs.getString("idKategori"), rs.getString("kategori"), rs.getInt("stok"), rs.getString("hargaBeli"), rs.getInt("hargaJual")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }

    public int insertProduk(Model mod) {
        int result = 0, count = 1;
        String id = "";
        boolean found = false;
        boolean isNull = false;
        try {
            mod.produk.getIdProduk().equalsIgnoreCase(null);
        } catch (NullPointerException npe) {
            isNull = true;
        }
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select idKategori from kategori where kategori ='" + mod.produk.getKategori() + "'");
            while (rs.next()) {
                mod.produk.setIdKategori(rs.getString("idKategori"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (isNull) {
            System.out.println("Masuk SIni");
            for (int x = 0; x < 1;) {
                if (count < 10) {
                    id = "PR00" + count;
                } else if (count < 100) {
                    id = "PR0" + count;
                } else {
                    id = "PR" + count;
                }
                try {
                    stm = Conn.createStatement();
                    rs = stm.executeQuery("select *from produk where idProduk = '" + id + "'");
                    found = rs.next() ? true : false;
                    if (found) {
                        count++;
                    } else {
                        mod.produk.setIdProduk(id);
                        x++;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        try {
            ps = Conn.prepareCall("insert into produk values('" + mod.produk.getIdProduk() + "','" + mod.produk.getNamaProduk() + "',?,'" + mod.produk.getIdKategori() + "','" + mod.produk.getKategori() + "','" + mod.produk.getStok() + "','" + mod.produk.getHargaBeli() + "','" + mod.produk.getHarga() + "')");
            ps.setBinaryStream(1, mod.produk.getGambarStream());
            result = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public DefaultTableModel searchProduk(String by) {
        dtm = new DefaultTableModel(new String[]{"Id Produk", "Nama Produk", "Gambar", "Id Kategori", "kategori", "Stok", "Harga Beli", "Harga Jual"}, 0);
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select *from produk where namaProduk  like '%" + by + "%' ");
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("idProduk"), rs.getString("namaProduk"), rs.getBytes("gambar"), rs.getString("idKategori"), rs.getString("kategori"), rs.getInt("stok"), rs.getString("hargaBeli"), rs.getInt("hargaJual")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }

    public int updateProduk(Model mod) {
        int result = 0;
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select idKategori from kategori where kategori ='" + mod.produk.getKategori() + "'");
            while (rs.next()) {
                mod.produk.setIdKategori(rs.getString("idKategori"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ps = Conn.prepareCall("update produk set namaProduk ='" + mod.produk.getNamaProduk() + "',gambar=?,idKategori='" + mod.produk.getIdKategori() + "',kategori='" + mod.produk.getKategori() + "',stok='" + mod.produk.getStok() + "',hargaBeli='" + mod.produk.getHargaBeli() + "',hargaJual='" + mod.produk.getHarga() + "' where idProduk='" + mod.produk.getIdProduk() + "'");
            //  ByteArrayInputStream bis = new ByteArrayInputStream(mod.produk.getGambarStream());
            ps.setBinaryStream(1, mod.produk.getGambarStream());
            result = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int deleteProduk(Model mod) {
        int result = 0;
        try {
            stm = Conn.createStatement();
            result = stm.executeUpdate("delete from produk where idProduk ='" + mod.produk.getIdProduk() + "'");
            JOptionPane.showMessageDialog(null, "Berhasil Menghapus Data");
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    // =========== PENJUALAN =======
    public int insertPenjualan(Model mod) {
        int result = 0;
        String id = "";
        int count = 1;
        boolean found = false;
        for (int x = 0; x < 1;) {
            if (count < 10) {
                id = "PJ00" + count;
            } else if (count < 100) {
                id = "PJ0" + count;
            } else {
                id = "PJ" + count;
            }
            try {
                stm = Conn.createStatement();
                rs = stm.executeQuery("select *from penjualan where idPenjualan = '" + id + "'");
                found = rs.next() ? true : false;
                if (found) {
                    count++;
                } else {
                    mod.penjualan.setIdPenjualan(id);
                    x++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            int limit = 0;
            result = stm.executeUpdate("insert into penjualan values ('" + mod.penjualan.getIdPenjualan() + "','" + mod.penjualan.getTanggalTransaksi() + "','" + mod.penjualan.getTotalTransaksi() + "')");
            rs = stm.executeQuery("select count(namaProduk) from keranjangJual");
            while (rs.next()) {
                limit = rs.getInt(1);
            }
            int f = 0;
            String[][] str = new String[limit][5];
            rs = stm.executeQuery("SELECT a.idProduk,a.namaProduk,b.subHarga,b.jumlah,b.totalHarga FROM produk  a INNER JOIN keranjangJual b ON a.namaProduk = b.namaProduk");
            while (rs.next()) {
                str[f][0] = rs.getString(1);
                str[f][1] = rs.getString(2);
                str[f][2] = rs.getString(3);
                str[f][3] = rs.getString(4);
                str[f][4] = rs.getString(5);
                ;
                f++;

            }
            for (int x = 0; x < limit; x++) {
              
          
                    result = stm.executeUpdate("insert into detailPenjualan values ('" + mod.penjualan.getIdPenjualan() + "','" + str[x][0] + "','" + str[x][1] + "','" + str[x][2] + "','" + str[x][3] + "','" + str[x][4] + "')");
                    result = stm.executeUpdate("update produk set stok = stok - "+Integer.parseInt(str[x][3])+" where idProduk='"+str[x][0]+"'");
                
            }

            JOptionPane.showMessageDialog(null, "Pembelian Berhasil", "Mutia Vapestore : Penjualan", JOptionPane.INFORMATION_MESSAGE);
            clearKeranjangJual();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public int stokProduk(Model mod, String by) {
        int result = 0;
        String filter = "";
        if (by.equals("id")) {
            filter = "idProduk='" + mod.produk.getIdProduk() + "'";
        } else {
            filter = "namaProduk='" + mod.produk.getNamaProduk() + "'";
        }
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select stok from produk where " + filter);
            while (rs.next()) {
                result = rs.getInt("stok");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public DefaultTableModel showTroli(Model mod) {
        dtm = new DefaultTableModel(new String[]{"Produk", "Sub Harga", "Jumlah Beli", "Total"}, 0);
        for (int x = 0; x < mod.penjualan.getKeranjang(mod.penjualan).size(); x++) {
            dtm.addRow(new Object[]{mod.penjualan.getKeranjang(mod.penjualan).get(x).get(0), mod.penjualan.getKeranjang(mod.penjualan).get(x).get(1), mod.penjualan.getKeranjang(mod.penjualan).get(x).get(2), mod.penjualan.getKeranjang(mod.penjualan).get(x).get(3)});
            mod.penjualan.getKeranjang(mod.penjualan);
        }
        return dtm;
    }

    public int insertKeranjangJual(String namaProduk, int harga, int jumlah, int total) {
        int result = 0;
        boolean same = false;
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select namaProduk from keranjangJual where namaProduk = '" + namaProduk + "' limit 1");
            while (rs.next()) {
                same = true;
            }
            if (same) {
                result = stm.executeUpdate("update keranjangJual set jumlah =jumlah +'" + jumlah + "', totalHarga = jumlah*subHarga where namaProduk = '" + namaProduk + "' ");
            } else {
                result = stm.executeUpdate("insert into keranjangJual values('" + namaProduk + "','" + harga + "','" + jumlah + "','" + total + "') ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public DefaultTableModel showKeranjangJual() {
        dtm = new DefaultTableModel(new String[]{"Nama Produk", "Sub Harga", "Jumlah", "Total"}, 0);
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select *from keranjangJual");
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("namaProduk"), rs.getInt("subHarga"), rs.getInt("jumlah"), rs.getInt("totalHarga")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }

    public int updateKeranjangJual(String namaProduk, int harga, int jumlah, int total) {
        int result = 0;
        try {
            stm = Conn.createStatement();
            result = stm.executeUpdate("update keranjangJual set subHarga='" + harga + "',jumlah ='" + jumlah + "',totalHarga='" + total + "' where namaProduk ='" + namaProduk + "'");
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public int deleteKeranjangJual(String nama) {
        int result = 0;
        try {
            stm = Conn.createStatement();
            result = stm.executeUpdate("delete from keranjangJual where namaProduk='" + nama + "'");
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int clearKeranjangJual() {
        int result = 0;
        try {
            stm = Conn.createStatement();
            result = stm.executeUpdate("delete from keranjangJual");
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int totalKeranjangJual() {
        int result = 0;
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select sum(totalHarga) from keranjangJual");
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public DefaultTableModel showPenjualan() {
        dtm = new DefaultTableModel(new String[]{"Id Penjualan", "Tanggal Transaksi", "Total Transaksi"}, 0);
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select *from penjualan");
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("idPenjualan"), rs.getString("tanggalTransaksi"), rs.getInt("totalTransaksi")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }

    public DefaultTableModel showDetailPenjualan() {
        dtm = new DefaultTableModel(new String[]{"Id Penjualan", "Id Produk", "Nama Produk", "Sub Harga", "Jumlah", "Total Harga"}, 0);
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select *from detailPenjualan");
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("idPenjualan"), rs.getString("idProduk"), rs.getString("namaProduk"), rs.getInt("subHarga"), rs.getInt("jumlah"), rs.getInt("totalHarga")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;

    }

    //========== PEMBELIAN =======
    public DefaultTableModel showProduk() {
        dtm = new DefaultTableModel(new String[]{"idProduk", "namaProduk", "stok", "harga"}, 0);
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select *from produk");
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("idProduk"), rs.getString("namaProduk"), rs.getInt("stok"), rs.getInt("hargaJual")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }

    public int insertPembelian(Model mod, boolean ubah) {
        int count = 1;
        int result = 0;
        String id = "";
        boolean found = false;
        for (int x = 0; x < 1;) {
            if (count < 10) {
                id = "PB00" + count;
            } else if (count < 100) {
                id = "PB0" + count;
            } else {
                id = "PB" + count;
            }
            try {
                stm = Conn.createStatement();
                rs = stm.executeQuery("select *from pembelian where idPembelian = '" + id + "'");
                found = rs.next() ? true : false;
                if (found) {
                    count++;
                } else {
                    mod.pembelian.setIdPembelian(id);
                    x++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            result = stm.executeUpdate("insert into pembelian values ('" + mod.pembelian.getIdPembelian() + "','" + mod.pembelian.getTanggalTransaksi() + "','" + mod.pembelian.getTotalTransaksi() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ubah) {
            try {
                stm = Conn.createStatement();
                rs = stm.executeQuery("select idProduk from produk where namaProduk = '" + mod.pembelian.getKeranjang(mod.pembelian).get(0) + "' ");
                while (rs.next()) {
                    mod.produk.setIdProduk(rs.getString("idProduk"));
                }
                int updatedStok = mod.produk.getStok() + Integer.parseInt(mod.pembelian.getKeranjang(mod.pembelian).get(2).toString());
                result = stm.executeUpdate("update produk set stok =" + updatedStok + " where idProduk = '" + mod.produk.getIdProduk() + "'");
                mod.pembelian.setTotalTransaksi(Integer.parseInt(showProduk(mod).get(5).toString()) * Integer.parseInt(mod.pembelian.getKeranjang(mod.pembelian).get(2).toString()));

                ps = Conn.prepareCall("insert into detailPembelian values ('" + mod.pembelian.getIdPembelian() + "','" + mod.produk.getIdProduk() + "','" + showProduk(mod).get(0) + "',?,'" + showProduk(mod).get(6) + "','" + showProduk(mod).get(1) + "','" + mod.pembelian.getKeranjang(mod.pembelian).get(2) + "','" + showProduk(mod).get(5) + "','" + showProduk(mod).get(4) + "')");
                ByteArrayInputStream bis = new ByteArrayInputStream((byte[]) showProduk(mod).get(2));
                ps.setBinaryStream(1, bis);

                int res = ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                insertProduk(mod);
                try {
                    stm = Conn.createStatement();
                    rs = stm.executeQuery("select idKategori from kategori where kategori ='" + mod.produk.getKategori() + "'");
                    while (rs.next()) {
                        mod.produk.setIdKategori(rs.getString("idKategori"));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                ps = Conn.prepareCall("insert into detailPembelian values ('" + mod.pembelian.getIdPembelian() + "','" + mod.produk.getIdProduk() + "','" + mod.produk.getNamaProduk() + "',?,'" + mod.produk.getIdKategori() + "','" + mod.produk.getKategori() + "','" + mod.produk.getStok() + "','" + mod.produk.getHargaBeli() + "','" + mod.pembelian.getTotalTransaksi() + "')");
                ps.setBinaryStream(1, mod.pembelian.getGambarStream());
                result = ps.executeUpdate();
                mod.produk.setIdProduk(null);
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return result;
    }

    public DefaultTableModel showPembelian() {
        dtm = new DefaultTableModel(new String[]{"Id Pembelian", "Tanggal Transaksi", "Total Pembelian"}, 0);
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select *from pembelian ");
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("idPembelian"), rs.getString("tanggalTransaksi"), rs.getInt("totalTransaksi")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;

    }

    public DefaultTableModel showDetailPembelian() {
        dtm = new DefaultTableModel(new String[]{"Id Pembelian", "Tanggal Transaksi", "Total Pembelian"}, 0);
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select *from detailPembelian ");
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("idPembelian"), rs.getString("idProduk"), rs.getString("namaProduk"), rs.getBytes("gambarProduk"), rs.getString("idKategori"), rs.getString("kategori"), rs.getInt("jumlah"), rs.getInt("hargaBeli"), rs.getInt("hargaJual")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;

    }

    //=========== SERVIS ===========
    public DefaultTableModel showService() {
        dtm = new DefaultTableModel(new String[]{"Id Servis", "Nama Custormer", "No Telp", "Nama Barang", "Tanggal Mulai", "Tanggal Selesai", "Biaya"}, 0);
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select *from servis");
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("idServis"), rs.getString("namaCustomer"), rs.getString("noTelp"), rs.getString("namaBarang"), rs.getString("tanggalMulai"), rs.getString("tanggalSelesai"), rs.getInt("biaya")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;

    }

    public DefaultTableModel showRiwayatService() {
        dtm = new DefaultTableModel(new String[]{"Id Servis", "Nama Custormer", "No Telp", "Nama Barang", "Tanggal Mulai", "Tanggal Selesai", "Biaya"}, 0);
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("select *from riwayatservis");
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("idServis"), rs.getString("namaCustomer"), rs.getString("noTelp"), rs.getString("namaBarang"), rs.getString("tanggalMulai"), rs.getString("tanggalSelesai"), rs.getInt("biaya")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;

    }

    public int insertService(Model mod) {
        int result = 0, count = 1;
        boolean found = false;
        String id = "";
        for (int x = 0; x < 1;) {
            if (count < 10) {
                id = "SV00" + count;
            } else if (count < 100) {
                id = "SV0" + count;
            } else {
                id = "SV" + count;
            }
            try {
                stm = Conn.createStatement();
                rs = stm.executeQuery("select idServis from servis where idServis = '" + id + "'");
                found = rs.next() ? true : false;
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (found) {
                count++;
            } else {
                x++;
                mod.servis.setIdServis(id);
            }
        }
        try {
            result = stm.executeUpdate("insert into servis values ('" + mod.servis.getIdServis() + "','" + mod.servis.getNamaCustomer() + "','" + mod.servis.getNoTelp() + "','" + mod.servis.getNamaBarang() + "','" + mod.servis.getTanggalMulai() + "','" + mod.servis.getTanggalSelesai() + "','" + mod.servis.getBiaya() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateService(Model mod, String a) {
        int result = 0;
        String tgl = "";
        try {
            stm = Conn.createStatement();
            rs = stm.executeQuery("SELECT DATE_ADD('" + a + "', INTERVAL " + mod.servis.getLamaServis() + " DAY) AS tanggalSelesai");
            while (rs.next()) {
                tgl = rs.getString(1);
            }
            result = stm.executeUpdate("update servis set namaCustomer='" + mod.servis.getNamaCustomer() + "',noTelp='" + mod.servis.getNoTelp() + "',namaBarang='" + mod.servis.getNamaBarang() + "',tanggalSelesai='" + tgl + "',biaya='" + mod.servis.getBiaya() + "' where idServis='" + mod.servis.getIdServis() + "'");
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int jarakWaktu(String a, String b) {
        int result = 0;
        try {
            stm = Conn.createStatement();
            //===== MENGAMBIL JARAK ANTARA DUA TANGGAL DENGAN KUERRY
            rs = stm.executeQuery("SELECT DATEDIFF('" + a + "', '" + b + "') AS days;");
            while (rs.next()) {
                result = rs.getInt("days");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public int deleteService(Model mod) {
        int result = 0;
        try {
            stm = Conn.createStatement();
            result = stm.executeUpdate("delete from servis where idServis ='" + mod.servis.getIdServis() + "'");

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
