/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Design;

import Model.*;
import Database.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Big Nigga Dude
 */
public class PembelianFrame extends javax.swing.JFrame {

    DAO myDao = new DAO();
    Model myMod;
    InputStream is = null;
    Image img = null;
    ImageIcon imgIcn = null;

    public PembelianFrame(Model mod) {
        myMod = mod;
        initComponents();
        run();
        setTable();
        setLogo();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Ingin Keluar", "Mutia Vapestore : Login", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    //======= METHODE =====
    public void setTable() {
        produkTbl.setModel(myDao.showProduk());
    }

    public boolean checkInputAngka(String str) {
        boolean check = false;
        for (int x = 0; x < str.length(); x++) {
            if (!(str.charAt(x) >= '0' && str.charAt(x) <= '9')) {
                check = false;
                System.out.println("salah");
            } else {
                check = true;
            }
        }
        return check;
    }

    public void setKategoriList() {
        kategoriCb.removeAllItems();
        for (String x : myDao.categoryList()) {
            kategoriCb.addItem(x);
        }
    }

    public void clearPembelian() {
        pembelianNamaTF.setText("");
        is = null;
        kategoriCb.setSelectedIndex(0);
        hargaBeliTF.setText("");
        hargaJualTF.setText("");
        jumlahTF.setText("");
        uploadGambarCek.setSelected(false);
    }

    public void setLogo() {
        try {
            img = Toolkit.getDefaultToolkit().createImage(myDao.frameLogo(1));
        } catch (SQLException ex) {
            Logger.getLogger(PembelianFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        imgIcn = new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        logoContainer.setIcon(imgIcn);
        logoContainer.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TambahStokFrame = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        produkTbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tambahStokTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tambahStokOkBtn = new javax.swing.JButton();
        tambahStokStokLbl = new javax.swing.JLabel();
        tambahStokNamaLbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        BeliProdukFrame = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        kategoriCb = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tambahGambarBtn = new javax.swing.JButton();
        pembelianNamaTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jumlahTF = new javax.swing.JTextField();
        hargaBeliTF = new javax.swing.JTextField();
        hargaJualTF = new javax.swing.JTextField();
        catatBTn = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        uploadGambarCek = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        logoContainer = new javax.swing.JLabel();
        katalogBtn = new javax.swing.JButton();
        pembelianBtn = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();
        serviceBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(153, 0, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        produkTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        produkTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                produkTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(produkTbl);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, 104));

        jLabel2.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("stok awal");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 208, -1, -1));

        jLabel3.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Produk");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 167, -1, -1));

        tambahStokTF.setBackground(new java.awt.Color(255, 255, 255));
        tambahStokTF.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        tambahStokTF.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(tambahStokTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 249, 103, -1));

        jLabel4.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("tambah stok");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 253, -1, -1));

        jLabel5.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("pcs");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 253, -1, -1));

        tambahStokOkBtn.setBackground(new java.awt.Color(0, 0, 0));
        tambahStokOkBtn.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        tambahStokOkBtn.setForeground(new java.awt.Color(255, 255, 255));
        tambahStokOkBtn.setText("OK");
        tambahStokOkBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahStokOkBtnMouseClicked(evt);
            }
        });
        tambahStokOkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahStokOkBtnActionPerformed(evt);
            }
        });
        jPanel2.add(tambahStokOkBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 301, 145, -1));

        tambahStokStokLbl.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        tambahStokStokLbl.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(tambahStokStokLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 208, -1, -1));

        tambahStokNamaLbl.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        tambahStokNamaLbl.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(tambahStokNamaLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 167, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel14.setFont(new java.awt.Font("Electroharmonix", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("tambah stok produk");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        javax.swing.GroupLayout TambahStokFrameLayout = new javax.swing.GroupLayout(TambahStokFrame.getContentPane());
        TambahStokFrame.getContentPane().setLayout(TambahStokFrameLayout);
        TambahStokFrameLayout.setHorizontalGroup(
            TambahStokFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TambahStokFrameLayout.setVerticalGroup(
            TambahStokFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(153, 0, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.add(kategoriCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 301, 158, -1));

        jLabel6.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("harga beli");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 392, -1, -1));

        jLabel7.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("gambar");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 251, -1, -1));

        jLabel9.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("harga jual");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 439, -1, -1));

        jLabel10.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("kategori");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 298, -1, -1));

        jLabel11.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("NAMA PRODUK");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 216, -1, -1));

        tambahGambarBtn.setBackground(new java.awt.Color(0, 0, 0));
        tambahGambarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Attach-Image-36.png"))); // NOI18N
        tambahGambarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahGambarBtnMouseClicked(evt);
            }
        });
        jPanel6.add(tambahGambarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 251, -1, -1));

        pembelianNamaTF.setBackground(new java.awt.Color(255, 255, 255));
        pembelianNamaTF.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        pembelianNamaTF.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.add(pembelianNamaTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 216, 230, -1));

        jLabel12.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("jumlah");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 345, -1, -1));

        jumlahTF.setBackground(new java.awt.Color(255, 255, 255));
        jumlahTF.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        jumlahTF.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.add(jumlahTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 240, -1));

        hargaBeliTF.setBackground(new java.awt.Color(255, 255, 255));
        hargaBeliTF.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        hargaBeliTF.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.add(hargaBeliTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 240, -1));

        hargaJualTF.setBackground(new java.awt.Color(255, 255, 255));
        hargaJualTF.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        hargaJualTF.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.add(hargaJualTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 240, -1));

        catatBTn.setBackground(new java.awt.Color(0, 0, 0));
        catatBTn.setFont(new java.awt.Font("Electroharmonix", 1, 42)); // NOI18N
        catatBTn.setForeground(new java.awt.Color(255, 255, 255));
        catatBTn.setText("CATAT");
        catatBTn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catatBTnMouseClicked(evt);
            }
        });
        jPanel6.add(catatBTn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 488, -1, -1));

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("back");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jPanel6.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 27, -1, -1));

        jLabel13.setFont(new java.awt.Font("Electroharmonix", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("PEMBELIAN PRODUK BARU");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        uploadGambarCek.setBackground(new java.awt.Color(0, 0, 0));
        uploadGambarCek.setForeground(new java.awt.Color(51, 255, 51));
        uploadGambarCek.setEnabled(false);
        jPanel6.add(uploadGambarCek, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, -1, -1));

        javax.swing.GroupLayout BeliProdukFrameLayout = new javax.swing.GroupLayout(BeliProdukFrame.getContentPane());
        BeliProdukFrame.getContentPane().setLayout(BeliProdukFrameLayout);
        BeliProdukFrameLayout.setHorizontalGroup(
            BeliProdukFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BeliProdukFrameLayout.setVerticalGroup(
            BeliProdukFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 691, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 0, 51));

        logoContainer.setText("jLabel3");

        katalogBtn.setBackground(new java.awt.Color(153, 0, 51));
        katalogBtn.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        katalogBtn.setForeground(new java.awt.Color(255, 255, 255));
        katalogBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/E-Service-WF-52.png"))); // NOI18N
        katalogBtn.setText(" KATALOG    ");
        katalogBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        katalogBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                katalogBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                katalogBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                katalogBtnMouseExited(evt);
            }
        });

        pembelianBtn.setBackground(new java.awt.Color(0, 0, 0));
        pembelianBtn.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        pembelianBtn.setForeground(new java.awt.Color(255, 255, 255));
        pembelianBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Shopping-Cart-01-52.png"))); // NOI18N
        pembelianBtn.setText(" Pembelian");
        pembelianBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pembelianBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pembelianBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pembelianBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pembelianBtnMouseExited(evt);
            }
        });

        homeBtn.setBackground(new java.awt.Color(153, 0, 51));
        homeBtn.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        homeBtn.setForeground(new java.awt.Color(255, 255, 255));
        homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Home-52.png"))); // NOI18N
        homeBtn.setText(" HOME            ");
        homeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeBtnMouseExited(evt);
            }
        });

        serviceBtn.setBackground(new java.awt.Color(153, 0, 51));
        serviceBtn.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        serviceBtn.setForeground(new java.awt.Color(255, 255, 255));
        serviceBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Tools-02-52.png"))); // NOI18N
        serviceBtn.setText(" SErvice    ");
        serviceBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        serviceBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serviceBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                serviceBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                serviceBtnMouseExited(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(153, 0, 51));
        exitBtn.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Exit-03-48.png"))); // NOI18N
        exitBtn.setText(" EXIT          ");
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.setPreferredSize(new java.awt.Dimension(135, 60));
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(katalogBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(homeBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(logoContainer))
                    .addComponent(pembelianBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serviceBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(logoContainer)
                .addGap(44, 44, 44)
                .addComponent(homeBtn)
                .addGap(18, 18, 18)
                .addComponent(katalogBtn)
                .addGap(18, 18, 18)
                .addComponent(pembelianBtn)
                .addGap(18, 18, 18)
                .addComponent(serviceBtn)
                .addGap(99, 99, 99)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 691));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 10));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 590, 30));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 10));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 660, 590, 30));

        jLabel8.setFont(new java.awt.Font("Electroharmonix", 1, 52)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 51));
        jLabel8.setText("~ pembelian ~");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("BELI PRODUK BARU");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 330, 70));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("TAMBAH STOK PRODUK");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 330, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //========= ACTION ===========
    private void katalogBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_katalogBtnMouseClicked
        CatalogFrame cat = new CatalogFrame(myMod);
        this.dispose();
    }//GEN-LAST:event_katalogBtnMouseClicked

    private void katalogBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_katalogBtnMouseEntered
        katalogBtn.setBackground(Color.black);
    }//GEN-LAST:event_katalogBtnMouseEntered

    private void katalogBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_katalogBtnMouseExited
        katalogBtn.setBackground(new Color(153, 0, 51));
    }//GEN-LAST:event_katalogBtnMouseExited

    private void pembelianBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembelianBtnMouseEntered
        pembelianBtn.setBackground(new Color(153, 0, 51));
    }//GEN-LAST:event_pembelianBtnMouseEntered

    private void pembelianBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembelianBtnMouseExited
        pembelianBtn.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_pembelianBtnMouseExited

    private void homeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseClicked
        this.dispose();;
        MainFrame mf = new MainFrame(myMod);
    }//GEN-LAST:event_homeBtnMouseClicked

    private void homeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseEntered
        homeBtn.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_homeBtnMouseEntered

    private void homeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseExited
        homeBtn.setBackground(new Color(153, 0, 51));
    }//GEN-LAST:event_homeBtnMouseExited

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        TambahStokFrame.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton3MouseClicked

    private void produkTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_produkTblMouseClicked
        int rows = produkTbl.getSelectedRow();
        tambahStokNamaLbl.setText(produkTbl.getValueAt(rows, 1).toString());
        tambahStokStokLbl.setText(produkTbl.getValueAt(rows, 2).toString());
    }//GEN-LAST:event_produkTblMouseClicked

    private void tambahStokOkBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahStokOkBtnMouseClicked

        if (tambahStokNamaLbl.getText().equals("") && tambahStokStokLbl.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak Ada Produk Yang Dipilih", "Mutia Vapestore : Tambah Stok", JOptionPane.WARNING_MESSAGE);
        } else {
            if (tambahStokTF.getText().equals("") || tambahStokTF.getText().equals("0") || !checkInputAngka(tambahStokTF.getText()) || tambahStokTF.getText().charAt(0) == '0' || Integer.parseInt(tambahStokTF.getText()) < 1) {
                JOptionPane.showMessageDialog(null, "Inputan Tidak Valid", "Mutia Vapestore : Tambah Stok", JOptionPane.WARNING_MESSAGE);
            } else {
                int rows = produkTbl.getSelectedRow();
                myMod.produk.setIdProduk(produkTbl.getValueAt(rows, 0).toString());
                System.out.println("Ini id yang dipilih : " + produkTbl.getValueAt(rows, 0).toString());
                myMod.pembelian.setKeranjang(myMod.pembelian, produkTbl.getValueAt(rows, 1).toString(), Integer.parseInt(produkTbl.getValueAt(rows, 3).toString()), Integer.parseInt(tambahStokTF.getText().toString()), Integer.parseInt(produkTbl.getValueAt(rows, 3).toString()) * Integer.parseInt(tambahStokTF.getText().toString()));
                myMod.pembelian.setTotalTransaksi(Integer.parseInt(produkTbl.getValueAt(rows, 3).toString()) * Integer.parseInt(tambahStokTF.getText()));
                myMod.produk.setStok(Integer.parseInt(produkTbl.getValueAt(rows, 2).toString()));
                myDao.insertPembelian(myMod, true);

                JOptionPane.showMessageDialog(null, "Berhasil Menambah Stok", "Mutia Vapestore : Tambah Stok", JOptionPane.INFORMATION_MESSAGE);
                TambahStokFrame.setVisible(false);
                this.setVisible(true);
                tambahStokNamaLbl.setText("");
                tambahStokStokLbl.setText("");
                setTable();
            }
        }
        tambahStokTF.setText("");
    }//GEN-LAST:event_tambahStokOkBtnMouseClicked

    private void tambahStokOkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahStokOkBtnActionPerformed

    }//GEN-LAST:event_tambahStokOkBtnActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        TambahStokFrame.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        BeliProdukFrame.setVisible(true);
        this.setVisible(false);
        setKategoriList();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        BeliProdukFrame.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_jButton6MouseClicked

    private void tambahGambarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahGambarBtnMouseClicked
        JFileChooser openFile = new JFileChooser("E:/Java/ProjekJavaFundamental/Database/Resource");
        File pf = new File("");
        int res = openFile.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            pf = openFile.getSelectedFile();
            try {
                is = new FileInputStream(new File(pf.getAbsoluteFile().toString()));
                myMod.produk.setGambarStream(is);
                uploadGambarCek.setSelected(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PembelianFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tambahGambarBtnMouseClicked

    private void catatBTnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catatBTnMouseClicked
        if (pembelianNamaTF.getText().equals("") || jumlahTF.getText().equals("") || hargaBeliTF.getText().equals("") || hargaJualTF.getText().equals("") || is == null || !checkInputAngka(jumlahTF.getText().toString()) || !checkInputAngka(hargaBeliTF.getText().toString()) || !checkInputAngka(hargaJualTF.getText().toString())) {
            JOptionPane.showMessageDialog(null, "Inputan Data Tidak Valid", "Mutia Vapestore : Beli Produk Baru", JOptionPane.WARNING_MESSAGE);
        } else {
            if (Integer.parseInt(hargaBeliTF.getText().toString()) >= Integer.parseInt(hargaJualTF.getText().toString())) {
                JOptionPane.showMessageDialog(null, "Harga Jual Harus Lebih Besar ari Harga Beli", "Mutia Vapestore : Beli Produk Baru", JOptionPane.WARNING_MESSAGE);
            } else {
                myMod.produk.setNamaProduk(pembelianNamaTF.getText());
                myMod.produk.setKategori(kategoriCb.getItemAt(kategoriCb.getSelectedIndex()));
                myMod.produk.setStok(Integer.parseInt(jumlahTF.getText().toString()));
                myMod.produk.setHargaBeli(Integer.parseInt(hargaBeliTF.getText().toString()));
                myMod.produk.setHarga(Integer.parseInt(hargaJualTF.getText().toString()));
                myMod.pembelian.setTotalTransaksi(Integer.parseInt(jumlahTF.getText().toString()) * Integer.parseInt(hargaBeliTF.getText().toString()));
                myDao.insertPembelian(myMod, false);
                clearPembelian();
                JOptionPane.showMessageDialog(null, "Berhasil Membeli Produk", "Mutia Vapestore : Beli Produk Baru", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }//GEN-LAST:event_catatBTnMouseClicked

    private void pembelianBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembelianBtnMouseClicked
        JOptionPane.showMessageDialog(null, "Anda Sedang Berada Di Menu Pembelian", "Mutia Vapestore : Pembelian", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_pembelianBtnMouseClicked

    private void serviceBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceBtnMouseEntered
        serviceBtn.setBackground(Color.black);
    }//GEN-LAST:event_serviceBtnMouseEntered

    private void serviceBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceBtnMouseExited
        serviceBtn.setBackground(new Color(153, 0, 51));
    }//GEN-LAST:event_serviceBtnMouseExited

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        int res = JOptionPane.showConfirmDialog(null, "Ingin Keluar", "Mutia Vapestore : Home", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitBtnMouseClicked

    private void serviceBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceBtnMouseClicked
        ServiceFrame sf = new ServiceFrame(myMod);
        this.dispose();

    }//GEN-LAST:event_serviceBtnMouseClicked

    private void exitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseEntered
        exitBtn.setBackground(Color.black);
    }//GEN-LAST:event_exitBtnMouseEntered

    private void exitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseExited
        exitBtn.setBackground(new Color(153, 0, 51));
    }//GEN-LAST:event_exitBtnMouseExited

    public void run() {

        this.setTitle("MUTIA VAPESTORE");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(0);

        TambahStokFrame.setTitle("Mutia Vapestore : Pembelian");
        TambahStokFrame.setSize(600, 500);
        TambahStokFrame.setLocationRelativeTo(null);
        TambahStokFrame.setUndecorated(true);
        TambahStokFrame.setResizable(false);

        BeliProdukFrame.setTitle("Mutia Vapestore : Pembelian");
        BeliProdukFrame.setSize(600, 600);
        BeliProdukFrame.setLocationRelativeTo(null);
        BeliProdukFrame.setUndecorated(true);
        BeliProdukFrame.setResizable(false);

        try {
            img = Toolkit.getDefaultToolkit().createImage(myDao.frameLogo(1));
            imgIcn = new ImageIcon(img);
            this.setIconImage(img);
            TambahStokFrame.setIconImage(img);
            BeliProdukFrame.setIconImage(img);
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame BeliProdukFrame;
    private javax.swing.JFrame TambahStokFrame;
    private javax.swing.JButton catatBTn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JTextField hargaBeliTF;
    private javax.swing.JTextField hargaJualTF;
    private javax.swing.JButton homeBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlahTF;
    private javax.swing.JButton katalogBtn;
    private javax.swing.JComboBox<String> kategoriCb;
    private javax.swing.JLabel logoContainer;
    private javax.swing.JButton pembelianBtn;
    private javax.swing.JTextField pembelianNamaTF;
    private javax.swing.JTable produkTbl;
    private javax.swing.JButton serviceBtn;
    private javax.swing.JButton tambahGambarBtn;
    private javax.swing.JLabel tambahStokNamaLbl;
    private javax.swing.JButton tambahStokOkBtn;
    private javax.swing.JLabel tambahStokStokLbl;
    private javax.swing.JTextField tambahStokTF;
    private javax.swing.JCheckBox uploadGambarCek;
    // End of variables declaration//GEN-END:variables
}
