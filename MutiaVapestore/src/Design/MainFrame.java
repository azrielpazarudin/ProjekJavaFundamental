/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Design;

import Model.*;
import Database.*;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {

    DAO myDao = new DAO();
    Model myMod;
    Image img = null;
    ImageIcon imgIcn = null;
    InputStream is;
    boolean crudProdukDelete = false;
    boolean crudProdukAdd = false;
    boolean crudProdukEdit = false;

    public MainFrame(Model mod) {
        initComponents();
        this.myMod = mod;
        run();
        setLogo();
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Ingin Keluar", "Mutia Vapestore : Login", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        dataProdukSetInput();
        editAkunSetInput();
        dataSeviceSetInput();
    }
//========== METHODE =======

    //===== VALIDASI INPUT ======
    public void dataProdukSetInput() {
        crudProdukNamaProdukTF.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (crudProdukNamaProdukTF.getText().length() >= 20) {
                    e.consume();
                }
            }
        });
        crudProdukStokTF.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {

                if ((crudProdukStokTF.getText().length() >= 3) || !(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
                    e.consume();
                }
            }
        });
        crudProdukHargaBeliTF.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {

                if ((crudProdukHargaBeliTF.getText().length() >= 8) || !(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
                    e.consume();
                }
            }
        });
        crudProdukHargaJualTF.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {

                if ((crudProdukHargaJualTF.getText().length() >= 8) || !(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
                    e.consume();
                }
            }
        });

    }

    public void editAkunSetInput() {
        editAkunUsernameTF.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (editAkunUsernameTF.getText().length() >= 20 || e.getKeyChar() == ' ') {
                    e.consume();
                }
            }
        });
        editAkunPasswordTF.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (editAkunPasswordTF.getText().length() >= 20 || e.getKeyChar() == ' ') // limit to 3 characters
                {
                    e.consume();
                }
            }
        });
    }

    public void dataSeviceSetInput() {
        namaCustomerTF.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (namaCustomerTF.getText().length() >= 25 || !(e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z' || e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z' || e.getKeyChar() == ' ')) {
                    e.consume();
                }
            }
        });
        noTelpTF.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (noTelpTF.getText().length() >= 13 || e.getKeyChar() == ' ' || !(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
                    e.consume();
                }
            }
        });
        namaBarangTF.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (namaBarangTF.getText().length() >= 25 || !(e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z' || e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z' || e.getKeyChar() == ' ')) {
                    e.consume();
                }
            }
        });
        lamaServiceTF.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (lamaServiceTF.getText().length() >= 2 || e.getKeyChar() == ' ' || !(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
                    e.consume();
                }
            }
        });
        biayaTF.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (biayaTF.getText().length() >= 8 || e.getKeyChar() == ' ' || !(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
                    e.consume();
                }
            }
        });

    }

    // === MEHOD LAIN
    public void openLink(String urlString) {
        try {
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            desktop.browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLogo() {
        try {
            img = Toolkit.getDefaultToolkit().createImage(myDao.frameLogo(1));
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        imgIcn = new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        logoContainer.setIcon(imgIcn);
        logoContainer.setText("");
    }

    public boolean cekAngka(String str) {
        boolean isNull = false;
        boolean cek = true;
        try {
            str.equalsIgnoreCase(null);
        } catch (NullPointerException npe) {
            isNull = true;
        }
        if (!isNull) {
            for (int x = 0; x < str.length(); x++) {
                if (!(str.charAt(x) >= '0' || str.charAt(x) <= '9')) {
                    cek = false;
                }
            }
        }
        return cek;
    }

    //======= CRUD PRODUK =======
    public void setTableProduk() {
        crudProdukTbl.setModel(myDao.produkShow());
        setKategoriCB();
    }

    public void setFullSizeImg() {
        myMod.produk.setNamaProduk(crudProdukNamaProdukTF.getText());
        byte[] path = (byte[]) myDao.showProduk(myMod).get(2);
        img = Toolkit.getDefaultToolkit().createImage(path);
        imgIcn = new ImageIcon(img.getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        imageCont.setIcon(imgIcn);
        imageCont.setText("");
    }

    public void setKategoriCB() {
        crudProdukKategoriCB.removeAllItems();
        for (String string : myDao.categoryList()) {
            crudProdukKategoriCB.addItem(string);
        }
    }

    public void clearCrudProdukData() {
        if (!crudProdukAdd) {
            crudProdukIdProdukTF.setText("");
        }
        crudProdukNamaProdukTF.setText("");
        crudProdukStokTF.setText("");
        crudProdukKategoriCB.setSelectedIndex(0);
        crudProdukHargaBeliTF.setText("");
        crudProdukHargaJualTF.setText("");
    }

    public void setCrudProdukOn() {
        crudProdukAddBtn.setEnabled(false);
        crudProdukEditBtn.setEnabled(false);
        crudProdukDeleteBtn.setEnabled(false);
        crudProdukSaveBtn.setEnabled(true);
        crudProdukCancelBtn.setEnabled(true);
        crudProdukIdProdukTF.setEnabled(true);
        crudProdukNamaProdukTF.setEnabled(true);
        crudProdukStokTF.setEnabled(true);
        crudProdukKategoriCB.setEnabled(true);
        crudProdukHargaBeliTF.setEnabled(true);
        crudProdukHargaJualTF.setEnabled(true);
        crudProdukAddImgBtn.setVisible(true);
        setTableProduk();
        clearCrudProdukData();
        crudProdukKembaliBtn.setEnabled(false);

    }

    public void setCrudProdukOff() {
        crudProdukAddBtn.setEnabled(true);
        crudProdukEditBtn.setEnabled(true);
        crudProdukDeleteBtn.setEnabled(true);
        crudProdukSaveBtn.setEnabled(false);
        crudProdukCancelBtn.setEnabled(false);
        crudProdukIdProdukTF.setEnabled(false);
        crudProdukNamaProdukTF.setEnabled(false);
        crudProdukStokTF.setEnabled(false);
        crudProdukKategoriCB.setEnabled(false);
        crudProdukHargaBeliTF.setEnabled(false);
        crudProdukHargaJualTF.setEnabled(false);
        crudProdukAddImgBtn.setVisible(false);
        crudProdukUploadImgCB.setVisible(false);
        crudProdukKembaliBtn.setEnabled(true);
        setTableProduk();
        clearCrudProdukData();

    }

    // ======= DATA PEMBELIAN ==========
    public void setTableDataPembelian() {
        pembelianTbl.setModel(myDao.showPembelian());
        detailPembelianTbl.setModel(myDao.showDetailPembelian());
        pembelianTotpemLbl.setText(String.valueOf(pembelianTbl.getRowCount()));
    }

    //====== DATA PENJUALAN ===========
    public void setTableDataPenjualan() {
        penjualanTbl.setModel(myDao.showPenjualan());
        detailPenjualanTbl.setModel(myDao.showDetailPenjualan());
        penjualanTotpenLbl.setText((String.valueOf(penjualanTbl.getRowCount())));
    }

    // ======= DATA SERVICE ==============
    public void setTableDataService() {
        dataServiceTbl.setModel(myDao.showService());
    }

    public void setTableDataRimayatService() {
        dataServiceTbl.setModel(myDao.showRiwayatService());
    }

    public void setServiceClear() {
        namaCustomerTF.setText("");
        noTelpTF.setText("");
        lamaServiceTF.setText("");
        namaBarangTF.setText("");
        biayaTF.setText("");
    }

    public void serviceCrudOn() {
        namaCustomerTF.setEnabled(true);
        noTelpTF.setEnabled(true);
        namaBarangTF.setEnabled(true);
        lamaServiceTF.setEnabled(true);
        biayaTF.setEnabled(false);
        serviceEditBtn.setEnabled(false);
        serviceDeleteBtn.setEnabled(false);
        serviceSaveBtn.setEnabled(true);
        serviceCancelBtn.setEnabled(true);
    }

    public void serviceCrudOff() {
        namaCustomerTF.setEnabled(false);
        noTelpTF.setEnabled(false);
        namaBarangTF.setEnabled(false);
        lamaServiceTF.setEnabled(false);
        biayaTF.setEnabled(false);
        serviceEditBtn.setEnabled(true);
        serviceDeleteBtn.setEnabled(true);
        serviceSaveBtn.setEnabled(false);
        serviceCancelBtn.setEnabled(false);
        setServiceClear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        KoleksiDataFrame = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        crudPenjualanBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        crudProdukBtn = new javax.swing.JButton();
        crudPembelianBtn = new javax.swing.JButton();
        crudAkunBtn = new javax.swing.JButton();
        crudServiceBtn = new javax.swing.JButton();
        selectedMenu1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        crudHomeBtn = new javax.swing.JButton();
        selectedMenuLbl = new javax.swing.JLabel();
        DataProduk = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        crudProdukTbl = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        crudProdukKategoriCB = new javax.swing.JComboBox<>();
        crudProdukIdProdukTF = new javax.swing.JTextField();
        crudProdukNamaProdukTF = new javax.swing.JTextField();
        crudProdukStokTF = new javax.swing.JTextField();
        crudProdukHargaBeliTF = new javax.swing.JTextField();
        crudProdukHargaJualTF = new javax.swing.JTextField();
        crudProdukAddBtn = new javax.swing.JButton();
        crudProdukSaveBtn = new javax.swing.JButton();
        crudProdukEditBtn = new javax.swing.JButton();
        crudProdukDeleteBtn = new javax.swing.JButton();
        crudProdukCancelBtn = new javax.swing.JButton();
        crudProdukResetBtn = new javax.swing.JButton();
        crudProdukSearchBtn = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        crudProdukAddImgBtn = new javax.swing.JButton();
        crudProdukShowImgBtn = new javax.swing.JButton();
        crudProdukKembaliBtn = new javax.swing.JButton();
        crudProdukUploadImgCB = new javax.swing.JCheckBox();
        DataProdukShowImg = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        imageCont = new javax.swing.JLabel();
        DataPenjualan = new javax.swing.JFrame();
        DataPembelianFrame = new javax.swing.JFrame();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pembelianTbl = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        detailPembelianTbl = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        pembelianTotpemLbl = new javax.swing.JLabel();
        DataPenjualanFrame = new javax.swing.JFrame();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        penjualanTbl = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        detailPenjualanTbl = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        penjualanTotpenLbl = new javax.swing.JLabel();
        EditAkunFrame = new javax.swing.JFrame();
        jPanel10 = new javax.swing.JPanel();
        editAkunUsernameTF = new javax.swing.JTextField();
        editAkunPasswordTF = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        editAkunSaveBtn = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        DataServiceFrame = new javax.swing.JFrame();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        dataServiceTbl = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        namaCustomerTF = new javax.swing.JTextField();
        noTelpTF = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        namaBarangTF = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        lamaServiceTF = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        biayaTF = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        serviceDeleteBtn = new javax.swing.JButton();
        serviceEditBtn = new javax.swing.JButton();
        serviceSaveBtn = new javax.swing.JButton();
        serviceResetbtn = new javax.swing.JButton();
        serviceCancelBtn = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        logoContainer = new javax.swing.JLabel();
        katalogBtn = new javax.swing.JButton();
        pembelianBtn = new javax.swing.JButton();
        serviceBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();
        emailBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        instagramBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        koleksiDataBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(153, 0, 51));

        crudPenjualanBtn.setBackground(new java.awt.Color(153, 0, 51));
        crudPenjualanBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Dollar-Tag-52.png"))); // NOI18N
        crudPenjualanBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudPenjualanBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crudPenjualanBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crudPenjualanBtnMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Electroharmonix", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("koleksi data");

        crudProdukBtn.setBackground(new java.awt.Color(153, 0, 51));
        crudProdukBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/E-Service-WF-52.png"))); // NOI18N
        crudProdukBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudProdukBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crudProdukBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crudProdukBtnMouseExited(evt);
            }
        });

        crudPembelianBtn.setBackground(new java.awt.Color(153, 0, 51));
        crudPembelianBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Shopping-Cart-01-52.png"))); // NOI18N
        crudPembelianBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudPembelianBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crudPembelianBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crudPembelianBtnMouseExited(evt);
            }
        });

        crudAkunBtn.setBackground(new java.awt.Color(153, 0, 51));
        crudAkunBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/User-Profile-48.png"))); // NOI18N
        crudAkunBtn.setMaximumSize(new java.awt.Dimension(64, 60));
        crudAkunBtn.setMinimumSize(new java.awt.Dimension(64, 60));
        crudAkunBtn.setPreferredSize(new java.awt.Dimension(64, 60));
        crudAkunBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudAkunBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crudAkunBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crudAkunBtnMouseExited(evt);
            }
        });

        crudServiceBtn.setBackground(new java.awt.Color(153, 0, 51));
        crudServiceBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Tools-02-52.png"))); // NOI18N
        crudServiceBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudServiceBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crudServiceBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crudServiceBtnMouseExited(evt);
            }
        });

        selectedMenu1.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        selectedMenu1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Menu : ");

        crudHomeBtn.setBackground(new java.awt.Color(153, 0, 51));
        crudHomeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Home-52.png"))); // NOI18N
        crudHomeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudHomeBtnMouseClicked(evt);
            }
        });

        selectedMenuLbl.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        selectedMenuLbl.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(crudHomeBtn))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(selectedMenu1))
                            .addComponent(jLabel12)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel4))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(selectedMenuLbl))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(crudProdukBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(crudPenjualanBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(crudPembelianBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(crudAkunBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(crudServiceBtn)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(crudHomeBtn)
                .addGap(44, 44, 44)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(selectedMenu1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel12))
                    .addComponent(jLabel4)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(selectedMenuLbl)))
                .addGap(56, 56, 56)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(crudProdukBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crudPenjualanBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crudPembelianBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crudServiceBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crudAkunBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout KoleksiDataFrameLayout = new javax.swing.GroupLayout(KoleksiDataFrame.getContentPane());
        KoleksiDataFrame.getContentPane().setLayout(KoleksiDataFrameLayout);
        KoleksiDataFrameLayout.setHorizontalGroup(
            KoleksiDataFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        KoleksiDataFrameLayout.setVerticalGroup(
            KoleksiDataFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(153, 0, 51));

        crudProdukTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        crudProdukTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudProdukTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(crudProdukTbl);

        jLabel3.setFont(new java.awt.Font("Electroharmonix", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CRUD PRODUK");

        jLabel6.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID PRODUK");

        jLabel13.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("NAMA PRODUK");

        jLabel15.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("KATEGORI");

        jLabel16.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("STOK");

        jLabel14.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("HARGA BELI");

        jLabel17.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("HARGA JUAL");

        crudProdukKategoriCB.setBackground(new java.awt.Color(255, 255, 255));
        crudProdukKategoriCB.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        crudProdukKategoriCB.setForeground(new java.awt.Color(0, 0, 0));
        crudProdukKategoriCB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                crudProdukKategoriCBKeyPressed(evt);
            }
        });

        crudProdukIdProdukTF.setBackground(new java.awt.Color(255, 255, 255));
        crudProdukIdProdukTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N
        crudProdukIdProdukTF.setForeground(new java.awt.Color(0, 0, 0));
        crudProdukIdProdukTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                crudProdukIdProdukTFKeyPressed(evt);
            }
        });

        crudProdukNamaProdukTF.setBackground(new java.awt.Color(255, 255, 255));
        crudProdukNamaProdukTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N
        crudProdukNamaProdukTF.setForeground(new java.awt.Color(0, 0, 0));
        crudProdukNamaProdukTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                crudProdukNamaProdukTFKeyPressed(evt);
            }
        });

        crudProdukStokTF.setBackground(new java.awt.Color(255, 255, 255));
        crudProdukStokTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N
        crudProdukStokTF.setForeground(new java.awt.Color(0, 0, 0));

        crudProdukHargaBeliTF.setBackground(new java.awt.Color(255, 255, 255));
        crudProdukHargaBeliTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N
        crudProdukHargaBeliTF.setForeground(new java.awt.Color(0, 0, 0));

        crudProdukHargaJualTF.setBackground(new java.awt.Color(255, 255, 255));
        crudProdukHargaJualTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N
        crudProdukHargaJualTF.setForeground(new java.awt.Color(0, 0, 0));

        crudProdukAddBtn.setBackground(new java.awt.Color(0, 0, 0));
        crudProdukAddBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Add-New-48.png"))); // NOI18N
        crudProdukAddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudProdukAddBtnMouseClicked(evt);
            }
        });
        crudProdukAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudProdukAddBtnActionPerformed(evt);
            }
        });

        crudProdukSaveBtn.setBackground(new java.awt.Color(0, 0, 0));
        crudProdukSaveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Save-48.png"))); // NOI18N
        crudProdukSaveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudProdukSaveBtnMouseClicked(evt);
            }
        });

        crudProdukEditBtn.setBackground(new java.awt.Color(0, 0, 0));
        crudProdukEditBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Data-Edit-48.png"))); // NOI18N
        crudProdukEditBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudProdukEditBtnMouseClicked(evt);
            }
        });

        crudProdukDeleteBtn.setBackground(new java.awt.Color(0, 0, 0));
        crudProdukDeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Garbage-Closed-48.png"))); // NOI18N
        crudProdukDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudProdukDeleteBtnMouseClicked(evt);
            }
        });

        crudProdukCancelBtn.setBackground(new java.awt.Color(0, 0, 0));
        crudProdukCancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Delete-48.png"))); // NOI18N
        crudProdukCancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudProdukCancelBtnMouseClicked(evt);
            }
        });

        crudProdukResetBtn.setBackground(new java.awt.Color(0, 0, 0));
        crudProdukResetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Command-Reset-48.png"))); // NOI18N
        crudProdukResetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudProdukResetBtnMouseClicked(evt);
            }
        });

        crudProdukSearchBtn.setBackground(new java.awt.Color(0, 0, 0));
        crudProdukSearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Search-48.png"))); // NOI18N
        crudProdukSearchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudProdukSearchBtnMouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("GAMBAR");

        crudProdukAddImgBtn.setBackground(new java.awt.Color(0, 0, 0));
        crudProdukAddImgBtn.setFont(new java.awt.Font("Swis721 BT", 1, 12)); // NOI18N
        crudProdukAddImgBtn.setForeground(new java.awt.Color(255, 255, 255));
        crudProdukAddImgBtn.setText("TAMBAH / GANTI");
        crudProdukAddImgBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudProdukAddImgBtnMouseClicked(evt);
            }
        });

        crudProdukShowImgBtn.setBackground(new java.awt.Color(0, 0, 0));
        crudProdukShowImgBtn.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        crudProdukShowImgBtn.setForeground(new java.awt.Color(255, 255, 255));
        crudProdukShowImgBtn.setText("LIHAT");
        crudProdukShowImgBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudProdukShowImgBtnMouseClicked(evt);
            }
        });

        crudProdukKembaliBtn.setBackground(new java.awt.Color(0, 0, 0));
        crudProdukKembaliBtn.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        crudProdukKembaliBtn.setForeground(new java.awt.Color(255, 255, 255));
        crudProdukKembaliBtn.setText("Kembali");
        crudProdukKembaliBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudProdukKembaliBtnMouseClicked(evt);
            }
        });

        crudProdukUploadImgCB.setBackground(new java.awt.Color(255, 255, 255));
        crudProdukUploadImgCB.setForeground(new java.awt.Color(0, 0, 0));
        crudProdukUploadImgCB.setText("Upload Gambar");
        crudProdukUploadImgCB.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel18)
                .addGap(90, 90, 90)
                .addComponent(crudProdukShowImgBtn)
                .addGap(18, 18, 18)
                .addComponent(crudProdukAddImgBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crudProdukUploadImgCB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(crudProdukKembaliBtn)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel6)
                        .addGap(62, 62, 62)
                        .addComponent(crudProdukIdProdukTF, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel13)
                        .addGap(35, 35, 35)
                        .addComponent(crudProdukNamaProdukTF, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel15)
                        .addGap(67, 67, 67)
                        .addComponent(crudProdukKategoriCB, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel16)
                        .addGap(117, 117, 117)
                        .addComponent(crudProdukStokTF, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(crudProdukHargaBeliTF, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(crudProdukHargaJualTF, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(crudProdukSearchBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(crudProdukAddBtn)
                        .addGap(20, 20, 20)
                        .addComponent(crudProdukDeleteBtn)
                        .addGap(20, 20, 20)
                        .addComponent(crudProdukCancelBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(crudProdukEditBtn)
                        .addGap(20, 20, 20)
                        .addComponent(crudProdukSaveBtn)
                        .addGap(20, 20, 20)
                        .addComponent(crudProdukResetBtn)))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(crudProdukKembaliBtn)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6))
                    .addComponent(crudProdukIdProdukTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel13))
                    .addComponent(crudProdukNamaProdukTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel15))
                    .addComponent(crudProdukKategoriCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(crudProdukShowImgBtn)
                    .addComponent(crudProdukAddImgBtn)
                    .addComponent(crudProdukUploadImgCB))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel16))
                    .addComponent(crudProdukStokTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel14)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(crudProdukHargaBeliTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(crudProdukHargaJualTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(crudProdukSearchBtn)))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(crudProdukAddBtn)
                    .addComponent(crudProdukDeleteBtn)
                    .addComponent(crudProdukCancelBtn))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(crudProdukEditBtn)
                    .addComponent(crudProdukSaveBtn)
                    .addComponent(crudProdukResetBtn)))
        );

        javax.swing.GroupLayout DataProdukLayout = new javax.swing.GroupLayout(DataProduk.getContentPane());
        DataProduk.getContentPane().setLayout(DataProdukLayout);
        DataProdukLayout.setHorizontalGroup(
            DataProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DataProdukLayout.setVerticalGroup(
            DataProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(153, 0, 51));

        imageCont.setText("jLabel2");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(imageCont)
                .addContainerGap(506, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(imageCont)
                .addContainerGap(542, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DataProdukShowImgLayout = new javax.swing.GroupLayout(DataProdukShowImg.getContentPane());
        DataProdukShowImg.getContentPane().setLayout(DataProdukShowImgLayout);
        DataProdukShowImgLayout.setHorizontalGroup(
            DataProdukShowImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DataProdukShowImgLayout.setVerticalGroup(
            DataProdukShowImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DataPenjualanLayout = new javax.swing.GroupLayout(DataPenjualan.getContentPane());
        DataPenjualan.getContentPane().setLayout(DataPenjualanLayout);
        DataPenjualanLayout.setHorizontalGroup(
            DataPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        DataPenjualanLayout.setVerticalGroup(
            DataPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(153, 0, 51));

        pembelianTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(pembelianTbl);

        detailPembelianTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(detailPembelianTbl);

        jLabel19.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("detail pembelian");

        jLabel20.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("pembelian");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("kembali");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Total PEmbelian  :");

        pembelianTotpemLbl.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        pembelianTotpemLbl.setForeground(new java.awt.Color(255, 255, 255));
        pembelianTotpemLbl.setText("Total PEmbelian ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel19))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel20))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pembelianTotpemLbl)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(15, 15, 15)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(pembelianTotpemLbl))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DataPembelianFrameLayout = new javax.swing.GroupLayout(DataPembelianFrame.getContentPane());
        DataPembelianFrame.getContentPane().setLayout(DataPembelianFrameLayout);
        DataPembelianFrameLayout.setHorizontalGroup(
            DataPembelianFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DataPembelianFrameLayout.setVerticalGroup(
            DataPembelianFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(153, 0, 51));

        penjualanTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(penjualanTbl);

        detailPenjualanTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(detailPenjualanTbl);

        jLabel22.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("detail penjualan");

        jLabel23.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("penjualan");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("kembali");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Total PEnjualan  :");

        penjualanTotpenLbl.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        penjualanTotpenLbl.setForeground(new java.awt.Color(255, 255, 255));
        penjualanTotpenLbl.setText("Total PEnjualan ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel23))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(penjualanTotpenLbl)))
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(69, 69, 69)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(168, 168, 168))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(15, 15, 15)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(penjualanTotpenLbl))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DataPenjualanFrameLayout = new javax.swing.GroupLayout(DataPenjualanFrame.getContentPane());
        DataPenjualanFrame.getContentPane().setLayout(DataPenjualanFrameLayout);
        DataPenjualanFrameLayout.setHorizontalGroup(
            DataPenjualanFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DataPenjualanFrameLayout.setVerticalGroup(
            DataPenjualanFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(153, 0, 51));

        editAkunUsernameTF.setBackground(new java.awt.Color(255, 255, 255));
        editAkunUsernameTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N
        editAkunUsernameTF.setForeground(new java.awt.Color(0, 0, 0));
        editAkunUsernameTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editAkunUsernameTFKeyPressed(evt);
            }
        });

        editAkunPasswordTF.setBackground(new java.awt.Color(255, 255, 255));
        editAkunPasswordTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N
        editAkunPasswordTF.setForeground(new java.awt.Color(0, 0, 0));
        editAkunPasswordTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editAkunPasswordTFKeyPressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Electroharmonix", 1, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("EDIT AKUN");

        editAkunSaveBtn.setBackground(new java.awt.Color(0, 0, 0));
        editAkunSaveBtn.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        editAkunSaveBtn.setForeground(new java.awt.Color(255, 255, 255));
        editAkunSaveBtn.setText("SAVE");
        editAkunSaveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editAkunSaveBtnMouseClicked(evt);
            }
        });
        editAkunSaveBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editAkunSaveBtnKeyPressed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Electroharmonix", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("MASUKAN DATA BARU ANDA");

        jLabel27.setFont(new java.awt.Font("Electroharmonix", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("PASSWORD");

        jLabel28.setFont(new java.awt.Font("Electroharmonix", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("USERNAME");

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("kembali");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(0, 77, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(198, 198, 198))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel28))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(editAkunPasswordTF, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                            .addComponent(editAkunUsernameTF)))
                                    .addComponent(jLabel26))
                                .addGap(133, 133, 133))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addComponent(editAkunSaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(167, 167, 167))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton3)
                .addGap(53, 53, 53)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addGap(38, 38, 38)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editAkunUsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editAkunPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addComponent(editAkunSaveBtn)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout EditAkunFrameLayout = new javax.swing.GroupLayout(EditAkunFrame.getContentPane());
        EditAkunFrame.getContentPane().setLayout(EditAkunFrameLayout);
        EditAkunFrameLayout.setHorizontalGroup(
            EditAkunFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        EditAkunFrameLayout.setVerticalGroup(
            EditAkunFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(153, 0, 51));

        dataServiceTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        dataServiceTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataServiceTblMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(dataServiceTbl);

        jLabel29.setFont(new java.awt.Font("Electroharmonix", 1, 36)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("~ service ~");

        jLabel30.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("NAMA CUSTOMER");

        namaCustomerTF.setBackground(new java.awt.Color(255, 255, 255));
        namaCustomerTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N
        namaCustomerTF.setForeground(new java.awt.Color(0, 0, 0));
        namaCustomerTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namaCustomerTFKeyPressed(evt);
            }
        });

        noTelpTF.setBackground(new java.awt.Color(255, 255, 255));
        noTelpTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N
        noTelpTF.setForeground(new java.awt.Color(0, 0, 0));
        noTelpTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                noTelpTFKeyPressed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("NO. TELPON");

        jLabel32.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("NAMA barang");

        namaBarangTF.setBackground(new java.awt.Color(255, 255, 255));
        namaBarangTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N
        namaBarangTF.setForeground(new java.awt.Color(0, 0, 0));

        jLabel33.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("LAMA SERVICE");

        lamaServiceTF.setBackground(new java.awt.Color(255, 255, 255));
        lamaServiceTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N
        lamaServiceTF.setForeground(new java.awt.Color(0, 0, 0));

        jLabel34.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("HARI");

        biayaTF.setBackground(new java.awt.Color(255, 255, 255));
        biayaTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N
        biayaTF.setForeground(new java.awt.Color(0, 0, 0));

        jLabel35.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("BIAYA");

        serviceDeleteBtn.setBackground(new java.awt.Color(0, 0, 0));
        serviceDeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Garbage-Closed-48.png"))); // NOI18N
        serviceDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serviceDeleteBtnMouseClicked(evt);
            }
        });

        serviceEditBtn.setBackground(new java.awt.Color(0, 0, 0));
        serviceEditBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Data-Edit-48.png"))); // NOI18N
        serviceEditBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serviceEditBtnMouseClicked(evt);
            }
        });

        serviceSaveBtn.setBackground(new java.awt.Color(0, 0, 0));
        serviceSaveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Save-48.png"))); // NOI18N
        serviceSaveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serviceSaveBtnMouseClicked(evt);
            }
        });

        serviceResetbtn.setBackground(new java.awt.Color(0, 0, 0));
        serviceResetbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Command-Reset-48.png"))); // NOI18N
        serviceResetbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serviceResetbtnMouseClicked(evt);
            }
        });

        serviceCancelBtn.setBackground(new java.awt.Color(0, 0, 0));
        serviceCancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Delete-48.png"))); // NOI18N
        serviceCancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serviceCancelBtnMouseClicked(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Tab-History-WF-32.png"))); // NOI18N
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Electroharmonix", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("kembali");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton4)
                                .addGap(102, 102, 102)
                                .addComponent(jLabel29))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel33))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(namaBarangTF)
                                            .addComponent(noTelpTF)
                                            .addComponent(namaCustomerTF)
                                            .addComponent(biayaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton5))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(lamaServiceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel34))))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(serviceEditBtn)
                                .addGap(18, 18, 18)
                                .addComponent(serviceDeleteBtn)
                                .addGap(18, 18, 18)
                                .addComponent(serviceSaveBtn)
                                .addGap(18, 18, 18)
                                .addComponent(serviceCancelBtn)
                                .addGap(18, 18, 18)
                                .addComponent(serviceResetbtn)))
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel29))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(namaCustomerTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(noTelpTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(namaBarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lamaServiceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35)
                            .addComponent(biayaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serviceDeleteBtn)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(serviceEditBtn)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(serviceCancelBtn)
                                    .addComponent(serviceSaveBtn)
                                    .addComponent(serviceResetbtn))))
                        .addGap(54, 54, 54))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout DataServiceFrameLayout = new javax.swing.GroupLayout(DataServiceFrame.getContentPane());
        DataServiceFrame.getContentPane().setLayout(DataServiceFrameLayout);
        DataServiceFrameLayout.setHorizontalGroup(
            DataServiceFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DataServiceFrameLayout.setVerticalGroup(
            DataServiceFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 691, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Mutia-Vapestor-Logo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 525, 164));

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

        pembelianBtn.setBackground(new java.awt.Color(153, 0, 51));
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

        homeBtn.setBackground(new java.awt.Color(0, 0, 0));
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(katalogBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(homeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serviceBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(logoContainer))
                    .addComponent(pembelianBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(98, 98, 98)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 691));

        emailBtn.setBackground(new java.awt.Color(153, 0, 51));
        emailBtn.setForeground(new java.awt.Color(255, 255, 255));
        emailBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/GMail-32.png"))); // NOI18N
        emailBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        emailBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emailBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emailBtnMouseExited(evt);
            }
        });
        jPanel1.add(emailBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, -1, -1));

        jLabel5.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 51));
        jLabel5.setText("mutiavapestore@gmail.com");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, -1, -1));

        instagramBtn.setBackground(new java.awt.Color(153, 0, 51));
        instagramBtn.setForeground(new java.awt.Color(255, 255, 255));
        instagramBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Instagram-32.png"))); // NOI18N
        instagramBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        instagramBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                instagramBtnMouseClicked(evt);
            }
        });
        jPanel1.add(instagramBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, -1, -1));

        jLabel7.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 51));
        jLabel7.setText("koleksi data");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 580, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 10));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 590, 30));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 10));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 660, 590, 30));

        jLabel8.setFont(new java.awt.Font("Electroharmonix", 1, 52)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 51));
        jLabel8.setText("~ HOME ~");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Electroharmonix", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 51));
        jLabel9.setText("DI");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, -1));

        jLabel10.setFont(new java.awt.Font("Electroharmonix", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 51));
        jLabel10.setText("Selamat datang");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        koleksiDataBtn.setBackground(new java.awt.Color(153, 0, 51));
        koleksiDataBtn.setForeground(new java.awt.Color(255, 255, 255));
        koleksiDataBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Data-Edit-48_1.png"))); // NOI18N
        koleksiDataBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        koleksiDataBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                koleksiDataBtnMouseClicked(evt);
            }
        });
        jPanel1.add(koleksiDataBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 570, -1, -1));

        jLabel11.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 51));
        jLabel11.setText("mutiavapestore1");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 500, -1, -1));

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

    //======= ACTION ======
    private void emailBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailBtnMouseClicked
        openLink("https://mail.google.com/mail/u/0/#inbox?compose=CllgCJfrLfqgvSldsDkQlBpvtmCmjCQfGXbKztJmlRkmvTcWFlBZjlPpBdJFvsCLvfZfxMWcXFg");//link Didapat dengan copas saat mau mengirim pesan ke akun gmail tersebut
    }//GEN-LAST:event_emailBtnMouseClicked

    private void instagramBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instagramBtnMouseClicked
        openLink("https://www.instagram.com/mutiavapestore1/?hl=id");
    }//GEN-LAST:event_instagramBtnMouseClicked

    private void pembelianBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembelianBtnMouseExited
        pembelianBtn.setBackground(new Color(153, 0, 51));
    }//GEN-LAST:event_pembelianBtnMouseExited

    private void pembelianBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembelianBtnMouseEntered
        pembelianBtn.setBackground(Color.black);
    }//GEN-LAST:event_pembelianBtnMouseEntered

    private void katalogBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_katalogBtnMouseExited
        katalogBtn.setBackground(new Color(153, 0, 51));
    }//GEN-LAST:event_katalogBtnMouseExited

    private void katalogBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_katalogBtnMouseEntered
        katalogBtn.setBackground(Color.black);
    }//GEN-LAST:event_katalogBtnMouseEntered

    private void katalogBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_katalogBtnMouseClicked
        CatalogFrame cat = new CatalogFrame(myMod);
        this.dispose();
    }//GEN-LAST:event_katalogBtnMouseClicked

    private void homeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseExited
        homeBtn.setBackground(Color.black);
    }//GEN-LAST:event_homeBtnMouseExited

    private void homeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseEntered
        homeBtn.setBackground(new Color(153, 0, 51));
    }//GEN-LAST:event_homeBtnMouseEntered

    private void homeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseClicked
        JOptionPane.showMessageDialog(null, "Anda Sedang Berada Di Menu Home", "Mutia Vapestore : Home", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_homeBtnMouseClicked

    private void koleksiDataBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_koleksiDataBtnMouseClicked
        int res = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Ke Koleksi Data ?" + "\n(Data Akun Diperlukan)", "Mutia Vapestore : Home", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            for (int x = 0; x < 1;) {
                String username = JOptionPane.showInputDialog(null, "Username");
                String password = JOptionPane.showInputDialog(null, "Password");
                myMod.akun.setUsername(username);
                myMod.akun.setPassword(password);
                if (myDao.login(myMod)) {
                    JOptionPane.showMessageDialog(null, "Berhasil Masuk", "Mutia Vapestore : Manipulasi Data", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                    KoleksiDataFrame.setVisible(true);
                    x++;
                } else {
                    int tryAgain = JOptionPane.showConfirmDialog(null, "username atau password salah" + "\nCoba Lagi ?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (tryAgain == JOptionPane.NO_OPTION) {
                        x++;
                    }
                }
            }

        }
    }//GEN-LAST:event_koleksiDataBtnMouseClicked

    private void crudHomeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudHomeBtnMouseClicked
        KoleksiDataFrame.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_crudHomeBtnMouseClicked

    private void pembelianBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembelianBtnMouseClicked
        this.dispose();
        PembelianFrame pf = new PembelianFrame(myMod);
    }//GEN-LAST:event_pembelianBtnMouseClicked

    private void serviceBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceBtnMouseClicked
        ServiceFrame sf = new ServiceFrame(myMod);
        this.dispose();

    }//GEN-LAST:event_serviceBtnMouseClicked

    private void serviceBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceBtnMouseEntered
        serviceBtn.setBackground(new Color(0, 0, 0));
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

    private void crudProdukBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudProdukBtnMouseClicked
        DataProduk.setVisible(true);
        setCrudProdukOff();
        KoleksiDataFrame.dispose();
        this.dispose();

    }//GEN-LAST:event_crudProdukBtnMouseClicked

    private void crudProdukAddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudProdukAddBtnMouseClicked
        int res = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Menambah Data ?\nMenambah Data Diluar Pembelian Langsung", "Mutia Vapestore : Crup Produk", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            crudProdukShowImgBtn.setVisible(false);
            crudProdukUploadImgCB.setVisible(true);
            setCrudProdukOn();
            clearCrudProdukData();
            crudProdukAdd = true;
            crudProdukEdit = false;
            crudProdukIdProdukTF.setEnabled(false);
            int lastIndex = crudProdukTbl.getRowCount() - 1;
            int newId = Integer.parseInt(crudProdukTbl.getValueAt(lastIndex, 0).toString().substring(crudProdukTbl.getValueAt(lastIndex, 0).toString().length() - 2)) + 1;
            String newIdText = "PR0" + newId;
            crudProdukIdProdukTF.setText(newIdText);
        }
    }//GEN-LAST:event_crudProdukAddBtnMouseClicked

    private void crudProdukDeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudProdukDeleteBtnMouseClicked
        int res = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Menghapus Data ?\nPilih Data Di Table Untuk Di Hapus", "Mutia Vapestore : Crup Produk", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            int result = JOptionPane.showConfirmDialog(null, "Hapus Data Yang Dipilih ?", "Mutia Vapestore : Crud Produk", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                myMod.produk.setIdProduk(crudProdukTbl.getValueAt(crudProdukTbl.getSelectedRow(), 0).toString());
                myDao.deleteProduk(myMod);
                clearCrudProdukData();
                setTableProduk();
            }

        }
    }//GEN-LAST:event_crudProdukDeleteBtnMouseClicked

    private void crudProdukEditBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudProdukEditBtnMouseClicked
        int res = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Mengedit Data ?", "Mutia Vapestore : Crup Produk", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            setCrudProdukOn();
            crudProdukEdit = true;
        }
    }//GEN-LAST:event_crudProdukEditBtnMouseClicked

    private void crudProdukTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudProdukTblMouseClicked
        int rows = crudProdukTbl.getSelectedRow();
        int item = 0;
        switch (crudProdukTbl.getValueAt(rows, 4).toString()) {
            case "Device":
                item = 0;
                break;
            case "Attomizer":
                item = 1;
                break;
            case "Liquid":
                item = 2;
                break;
            case "Kapas":
                item = 3;
                break;
            case "Kawat":
                item = 4;
                break;
            case "Batre & Charger":
                item = 5;
                break;
            case "Tools":
                item = 6;
                break;
            default:
                break;
        }
        if (!crudProdukAdd) {
            crudProdukIdProdukTF.setText(crudProdukTbl.getValueAt(rows, 0).toString());
            crudProdukNamaProdukTF.setText(crudProdukTbl.getValueAt(rows, 1).toString());
            crudProdukStokTF.setText(crudProdukTbl.getValueAt(rows, 5).toString());
            crudProdukKategoriCB.setSelectedIndex(item);
            crudProdukHargaBeliTF.setText(crudProdukTbl.getValueAt(rows, 6).toString());
            crudProdukHargaJualTF.setText(crudProdukTbl.getValueAt(rows, 7).toString());
        }


    }//GEN-LAST:event_crudProdukTblMouseClicked

    private void crudProdukShowImgBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudProdukShowImgBtnMouseClicked

        if (crudProdukIdProdukTF.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak Ada Data Yang Dipilih", "Mutia Vapestore : Crud Produk", JOptionPane.WARNING_MESSAGE);
        } else {
            setFullSizeImg();
            DataProdukShowImg.setSize(600, 600);
            DataProdukShowImg.setResizable(false);
            DataProdukShowImg.setLocationRelativeTo(null);
            DataProdukShowImg.setVisible(true);
        }
    }//GEN-LAST:event_crudProdukShowImgBtnMouseClicked

    private void crudProdukIdProdukTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_crudProdukIdProdukTFKeyPressed
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            crudProdukNamaProdukTF.requestFocusInWindow();
        }
    }//GEN-LAST:event_crudProdukIdProdukTFKeyPressed

    private void crudProdukNamaProdukTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_crudProdukNamaProdukTFKeyPressed
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            crudProdukKategoriCB.requestFocusInWindow();
        }
    }//GEN-LAST:event_crudProdukNamaProdukTFKeyPressed

    private void crudProdukKategoriCBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_crudProdukKategoriCBKeyPressed
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            crudProdukAddImgBtn.requestFocusInWindow();
        }
    }//GEN-LAST:event_crudProdukKategoriCBKeyPressed

    private void crudProdukAddImgBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudProdukAddImgBtnMouseClicked
        JFileChooser openFile = new JFileChooser("E:/Java/ProjekJavaFundamental/Database/Resource");
        File pf = new File("");
        int res = openFile.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            pf = openFile.getSelectedFile();
            try {
                is = new FileInputStream(new File(pf.getAbsoluteFile().toString()));
                myMod.produk.setGambarStream(is);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(PembelianFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            crudProdukUploadImgCB.setSelected(true);
        }

    }//GEN-LAST:event_crudProdukAddImgBtnMouseClicked

    private void crudProdukSaveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudProdukSaveBtnMouseClicked

        if (crudProdukEdit && is == null) {
            myMod.produk.setNamaProduk(crudProdukTbl.getValueAt(crudProdukTbl.getSelectedRow(), 1).toString());
            is = new ByteArrayInputStream((byte[]) myDao.showProduk(myMod).get(2));
            myMod.produk.setGambarStream(is);
        }
        if (crudProdukIdProdukTF.getText().equals("") || crudProdukNamaProdukTF.getText().equals("") || crudProdukStokTF.getText().equals("") || crudProdukHargaBeliTF.getText().equals("") || crudProdukHargaJualTF.getText().equals("") || is == null) {
            JOptionPane.showMessageDialog(null, "Data Harus Lengkap", "Mutia Vapestore : Crud Produk", JOptionPane.WARNING_MESSAGE);
        } else {
            if (!cekAngka(crudProdukStokTF.getText().toString()) || !cekAngka(crudProdukHargaBeliTF.getText().toString()) || !cekAngka(crudProdukHargaJualTF.getText().toString())) {
                JOptionPane.showMessageDialog(null, "Data Harus Valid", "Mutia Vapestore : Crud Produk", JOptionPane.WARNING_MESSAGE);
            } else {
                if (Integer.parseInt(crudProdukStokTF.getText().toString()) < 1) {
                    JOptionPane.showMessageDialog(null, "Stok Minimal 1", "Mutia Vapestore : Crud Produk", JOptionPane.WARNING_MESSAGE);
                } else {
                    if ((Integer.parseInt(crudProdukHargaBeliTF.getText()) >= Integer.parseInt(crudProdukHargaJualTF.getText())) || Integer.parseInt(crudProdukHargaJualTF.getText()) < 1000) {
                        JOptionPane.showMessageDialog(null, "Harga Jual Harus Lebih Besar Dari Harga Beli", "Mutia Vapestore : Crud Produk", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (Integer.parseInt(crudProdukHargaJualTF.getText()) % 100 != 0 || Integer.parseInt(crudProdukHargaBeliTF.getText()) % 100 != 0) {
                            JOptionPane.showMessageDialog(null, "Inputan Harga Tidak Valid", "Mutia Vapestore : Crud Produk", JOptionPane.WARNING_MESSAGE);
                        } else {
                            myMod.produk.setIdProduk(crudProdukIdProdukTF.getText());
                            myMod.produk.setNamaProduk(crudProdukNamaProdukTF.getText());
                            myMod.produk.setKategori(crudProdukKategoriCB.getSelectedItem().toString());
                            myMod.produk.setStok(Integer.parseInt(crudProdukStokTF.getText().toString()));
                            myMod.produk.setHargaBeli(Integer.parseInt(crudProdukHargaBeliTF.getText()));
                            myMod.produk.setHarga(Integer.parseInt(crudProdukHargaJualTF.getText()));
                            if (crudProdukAdd) {
                                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah", "Mutia Vapestore : Crud Produk", JOptionPane.INFORMATION_MESSAGE);
                                myDao.insertProduk(myMod);
                                crudProdukAdd = false;
                            } else {
                                JOptionPane.showMessageDialog(null, "Data Berhasil Diedit", "Mutia Vapestore : Crud Produk", JOptionPane.INFORMATION_MESSAGE);
                                myDao.updateProduk(myMod);
                            }
                            setCrudProdukOff();
                            crudProdukShowImgBtn.setVisible(true);
                        }

                    }

                }

            }
        }
    }//GEN-LAST:event_crudProdukSaveBtnMouseClicked

    private void exitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseEntered
        exitBtn.setBackground(Color.black);
    }//GEN-LAST:event_exitBtnMouseEntered

    private void exitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseExited
        exitBtn.setBackground(new Color(153, 0, 51));
    }//GEN-LAST:event_exitBtnMouseExited

    private void emailBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailBtnMouseEntered
        emailBtn.setBackground(Color.black);
    }//GEN-LAST:event_emailBtnMouseEntered

    private void emailBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailBtnMouseExited
        emailBtn.setBackground(new Color(153, 0, 51));
    }//GEN-LAST:event_emailBtnMouseExited

    private void crudProdukSearchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudProdukSearchBtnMouseClicked
        String by = JOptionPane.showInputDialog(null, "Cari Berdasarkan Nama Produk", JOptionPane.INFORMATION_MESSAGE);
        crudProdukTbl.setModel(myDao.searchProduk(by));
    }//GEN-LAST:event_crudProdukSearchBtnMouseClicked

    private void crudProdukCancelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudProdukCancelBtnMouseClicked
        clearCrudProdukData();
        setCrudProdukOff();
        crudProdukDelete = false;
        crudProdukEdit = false;
        crudProdukAdd = false;
    }//GEN-LAST:event_crudProdukCancelBtnMouseClicked

    private void crudProdukResetBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudProdukResetBtnMouseClicked
        clearCrudProdukData();
        setTableProduk();
    }//GEN-LAST:event_crudProdukResetBtnMouseClicked

    private void crudProdukBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudProdukBtnMouseEntered
        crudProdukBtn.setBackground(new Color(0, 0, 0));
        selectedMenuLbl.setText("Produk");
    }//GEN-LAST:event_crudProdukBtnMouseEntered

    private void crudProdukBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudProdukBtnMouseExited
        crudProdukBtn.setBackground(new Color(153, 0, 51));
        selectedMenuLbl.setText("");
    }//GEN-LAST:event_crudProdukBtnMouseExited

    private void crudPenjualanBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudPenjualanBtnMouseEntered
        crudPenjualanBtn.setBackground(new Color(0, 0, 0));
        selectedMenuLbl.setText("Penjualan");
    }//GEN-LAST:event_crudPenjualanBtnMouseEntered

    private void crudPenjualanBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudPenjualanBtnMouseExited
        crudPenjualanBtn.setBackground(new Color(153, 0, 51));
        selectedMenuLbl.setText("Penjualan");
    }//GEN-LAST:event_crudPenjualanBtnMouseExited

    private void crudPembelianBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudPembelianBtnMouseEntered
        crudPembelianBtn.setBackground(new Color(0, 0, 0));
        selectedMenuLbl.setText("Pembelian");
    }//GEN-LAST:event_crudPembelianBtnMouseEntered

    private void crudPembelianBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudPembelianBtnMouseExited
        crudPembelianBtn.setBackground(new Color(153, 0, 51));
        selectedMenuLbl.setText("");
    }//GEN-LAST:event_crudPembelianBtnMouseExited

    private void crudAkunBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudAkunBtnMouseEntered
        crudAkunBtn.setBackground(new Color(0, 0, 0));
        selectedMenuLbl.setText("Akun");
    }//GEN-LAST:event_crudAkunBtnMouseEntered

    private void crudAkunBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudAkunBtnMouseExited
        crudAkunBtn.setBackground(new Color(153, 0, 51));
        selectedMenuLbl.setText("");
    }//GEN-LAST:event_crudAkunBtnMouseExited

    private void crudServiceBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudServiceBtnMouseEntered
        crudServiceBtn.setBackground(new Color(0, 0, 0));
        selectedMenuLbl.setText("Service");
    }//GEN-LAST:event_crudServiceBtnMouseEntered

    private void crudServiceBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudServiceBtnMouseExited
        crudServiceBtn.setBackground(new Color(153, 0, 51));
        selectedMenuLbl.setText("");
    }//GEN-LAST:event_crudServiceBtnMouseExited

    private void crudProdukAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudProdukAddBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crudProdukAddBtnActionPerformed

    private void crudProdukKembaliBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudProdukKembaliBtnMouseClicked
        KoleksiDataFrame.setVisible(true);
        DataProduk.dispose();
    }//GEN-LAST:event_crudProdukKembaliBtnMouseClicked

    private void crudPembelianBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudPembelianBtnMouseClicked
        DataPembelianFrame.setVisible(true);
        setTableDataPembelian();
        KoleksiDataFrame.dispose();
    }//GEN-LAST:event_crudPembelianBtnMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        DataPembelianFrame.dispose();
        KoleksiDataFrame.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        DataPenjualanFrame.dispose();
        KoleksiDataFrame.setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

    private void crudPenjualanBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudPenjualanBtnMouseClicked
        DataPenjualanFrame.setVisible(true);
        KoleksiDataFrame.dispose();
        setTableDataPenjualan();

    }//GEN-LAST:event_crudPenjualanBtnMouseClicked

    private void editAkunUsernameTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editAkunUsernameTFKeyPressed
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            editAkunPasswordTF.requestFocusInWindow();
        }
    }//GEN-LAST:event_editAkunUsernameTFKeyPressed

    private void editAkunPasswordTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editAkunPasswordTFKeyPressed
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            editAkunSaveBtn.requestFocusInWindow();
        }
    }//GEN-LAST:event_editAkunPasswordTFKeyPressed

    private void editAkunSaveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editAkunSaveBtnMouseClicked
        if (editAkunUsernameTF.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong", "Mutia Vapestore : Edit Akun", JOptionPane.WARNING_MESSAGE);
        } else {
            if (editAkunUsernameTF.getText().toString().length() > 20 || editAkunUsernameTF.getText().toString().length() > 50 || editAkunUsernameTF.getText().toString().length() < 8 || editAkunPasswordTF.getText().toString().length() < 8) {
                JOptionPane.showMessageDialog(null, "Username Minimal 8 Karakter,Maksimal 20 karakter\nPassword Minimal 8 Karakter,Maksimal 50 Karakter", "Mutia Vapestore : Edit Akun", JOptionPane.WARNING_MESSAGE);
            } else {
                if (editAkunUsernameTF.getText().toString().contains(" ") || editAkunUsernameTF.getText().toString().contains(" ")) {
                    JOptionPane.showMessageDialog(null, "Username Dan Password Tidak Boleh Mengandung Spasi", "Mutia Vapestore : Edit Akun", JOptionPane.WARNING_MESSAGE);
                } else {
                    myMod.akun.setUsername(JOptionPane.showInputDialog(null, "Masukan Username Lama"));
                    myMod.akun.setPassword(JOptionPane.showInputDialog(null, "Masukan Password Lama"));
                    if (myDao.login(myMod)) {
                        myMod.akun.setUsername(editAkunUsernameTF.getText().toString());
                        myMod.akun.setPassword(editAkunPasswordTF.getText().toString());
                        myDao.updateAkun(myMod);
                        editAkunUsernameTF.setText("");
                        editAkunPasswordTF.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Username Dan Password Tidak Sesuai", "Mutia Vapestore : Edit Akun", JOptionPane.WARNING_MESSAGE);
                    }

                }
            }
        }
    }//GEN-LAST:event_editAkunSaveBtnMouseClicked

    private void crudAkunBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudAkunBtnMouseClicked
        EditAkunFrame.setVisible(true);
        KoleksiDataFrame.dispose();
        editAkunUsernameTF.setText("");
        editAkunPasswordTF.setText("");
    }//GEN-LAST:event_crudAkunBtnMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        EditAkunFrame.dispose();
        KoleksiDataFrame.setVisible(true);
        editAkunUsernameTF.setText("");
        editAkunPasswordTF.setText("");
    }//GEN-LAST:event_jButton3MouseClicked

    private void editAkunSaveBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editAkunSaveBtnKeyPressed
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            if (editAkunUsernameTF.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong", "Mutia Vapestore : Edit Akun", JOptionPane.WARNING_MESSAGE);
            } else {
                if (editAkunUsernameTF.getText().toString().length() < 8 || editAkunPasswordTF.getText().toString().length() < 8) {
                    JOptionPane.showMessageDialog(null, "Username Minimal 8 Karakter,Maksimal 20 karakter\nPassword Minimal 8 Karakter,Maksimal 20 Karakter", "Mutia Vapestore : Edit Akun", JOptionPane.WARNING_MESSAGE);
                } else {
                    myMod.akun.setUsername(JOptionPane.showInputDialog(null, "Masukan Username Lama"));
                    myMod.akun.setPassword(JOptionPane.showInputDialog(null, "Masukan Password Lama"));
                    if (myDao.login(myMod)) {
                        myMod.akun.setUsername(editAkunUsernameTF.getText().toString());
                        myMod.akun.setPassword(editAkunPasswordTF.getText().toString());
                        myDao.updateAkun(myMod);
                        editAkunUsernameTF.setText("");
                        editAkunPasswordTF.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Username Dan Password Tidak Sesuai", "Mutia Vapestore : Edit Akun", JOptionPane.WARNING_MESSAGE);
                    }

                }
            }
        }

    }//GEN-LAST:event_editAkunSaveBtnKeyPressed

    private void namaCustomerTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaCustomerTFKeyPressed
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            noTelpTF.requestFocusInWindow();
        }
    }//GEN-LAST:event_namaCustomerTFKeyPressed

    private void noTelpTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noTelpTFKeyPressed
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            namaBarangTF.requestFocusInWindow();
        }
    }//GEN-LAST:event_noTelpTFKeyPressed

    private void crudServiceBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudServiceBtnMouseClicked
        DataServiceFrame.setVisible(true);
        KoleksiDataFrame.dispose();
        setTableDataService();
        serviceCrudOff();
        setServiceClear();
    }//GEN-LAST:event_crudServiceBtnMouseClicked

    private void dataServiceTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataServiceTblMouseClicked
        int rows = dataServiceTbl.getSelectedRow();
        namaCustomerTF.setText(dataServiceTbl.getValueAt(rows, 1).toString());
        noTelpTF.setText(dataServiceTbl.getValueAt(rows, 2).toString());
        System.out.println(dataServiceTbl.getValueAt(rows, 4).toString());
        //===== MENGAMBIL JARAK ANTARA DUA TANGGAL DENGAN KUERRY
        int jarak = myDao.jarakWaktu(dataServiceTbl.getValueAt(rows, 4).toString(), dataServiceTbl.getValueAt(rows, 5).toString());
        lamaServiceTF.setText(String.valueOf(jarak *= -1));
        namaBarangTF.setText(dataServiceTbl.getValueAt(rows, 3).toString());
        biayaTF.setText(dataServiceTbl.getValueAt(rows, 6).toString());


    }//GEN-LAST:event_dataServiceTblMouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        int res = JOptionPane.showConfirmDialog(null, "Ingin Menapilkan Rimayat Service ?", "Mutia Vapesotre : Data Service", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            setTableDataRimayatService();
        }

    }//GEN-LAST:event_jButton5MouseClicked

    private void serviceEditBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceEditBtnMouseClicked
        int res = JOptionPane.showConfirmDialog(null, "Ingin Mengedit Data?", "Mutia Vapesotre : Data Service", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            serviceCrudOn();
            setTableDataService();
        }
    }//GEN-LAST:event_serviceEditBtnMouseClicked

    private void serviceResetbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceResetbtnMouseClicked
        setServiceClear();
        setTableDataService();
    }//GEN-LAST:event_serviceResetbtnMouseClicked

    private void serviceCancelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceCancelBtnMouseClicked
        setServiceClear();
        setTableDataService();
        serviceCrudOff();
    }//GEN-LAST:event_serviceCancelBtnMouseClicked

    private void serviceSaveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceSaveBtnMouseClicked
        if (namaCustomerTF.getText().equals("") || noTelpTF.getText().equals("") || lamaServiceTF.getText().equals("") || namaBarangTF.getText().equals("") || biayaTF.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Harus Lengkap", "Mutia Vapestore : Data Service", JOptionPane.WARNING_MESSAGE);
        } else {
            myMod.servis.setIdServis(dataServiceTbl.getValueAt(dataServiceTbl.getSelectedRow(), 0).toString());
            myMod.servis.setNamaCustomer(namaCustomerTF.getText());
            myMod.servis.setNoTelp(noTelpTF.getText());
            myMod.servis.setNamaBarang(namaBarangTF.getText());
            myMod.servis.setLamaServis(Integer.parseInt(lamaServiceTF.getText()));
            if (myDao.updateService(myMod, dataServiceTbl.getValueAt(dataServiceTbl.getSelectedRow(), 4).toString()) == 1) {
                JOptionPane.showMessageDialog(null, "Berhasil Mengedit Data Data");
                serviceCrudOff();
                setTableDataService();
            }
        }

    }//GEN-LAST:event_serviceSaveBtnMouseClicked

    private void serviceDeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceDeleteBtnMouseClicked
        setTableDataService();
        int res = JOptionPane.showConfirmDialog(null, "Ingin Menghapus Data?", "Mutia Vapesotre : Data Service", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (res == JOptionPane.YES_OPTION) {
            if (namaCustomerTF.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Tidak Ada Data Yang Dipilih");
            } else {
                myMod.servis.setIdServis((String) dataServiceTbl.getValueAt(dataServiceTbl.getSelectedRow(), 0));
                if (myDao.deleteService(myMod) == 1) {
                    JOptionPane.showMessageDialog(null, "Berhasil Menghapus Data");
                }
            }

            serviceCrudOff();
            setTableDataService();
        }
    }//GEN-LAST:event_serviceDeleteBtnMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        DataServiceFrame.dispose();
        KoleksiDataFrame.setVisible(true);
    }//GEN-LAST:event_jButton4MouseClicked

    public void run() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.setTitle("MUTIA VAPESTORE");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(0);

        KoleksiDataFrame.setUndecorated(true);
        KoleksiDataFrame.setSize(600, 400);
        KoleksiDataFrame.setLocationRelativeTo(null);
        KoleksiDataFrame.setResizable(false);

        DataProduk.setUndecorated(true);
        DataProduk.setSize(600, 750);
        DataProduk.setLocationRelativeTo(null);
        DataProduk.setResizable(false);

        DataPembelianFrame.setUndecorated(true);
        DataPembelianFrame.setSize(600, 500);
        DataPembelianFrame.setLocationRelativeTo(null);
        DataPembelianFrame.setResizable(false);

        DataPenjualanFrame.setUndecorated(true);
        DataPenjualanFrame.setSize(600, 500);
        DataPenjualanFrame.setLocationRelativeTo(null);
        DataPenjualanFrame.setResizable(false);

        EditAkunFrame.setUndecorated(true);
        EditAkunFrame.setSize(600, 500);
        EditAkunFrame.setLocationRelativeTo(null);
        EditAkunFrame.setResizable(false);

        DataServiceFrame.setUndecorated(true);
        DataServiceFrame.setSize(600, 600);
        DataServiceFrame.setLocationRelativeTo(null);
        DataServiceFrame.setResizable(false);

        try {
            img = Toolkit.getDefaultToolkit().createImage(myDao.frameLogo(1));
            imgIcn = new ImageIcon(img);
            this.setIconImage(img);
            KoleksiDataFrame.setIconImage(img);
            DataPembelianFrame.setIconImage(img);
            DataPenjualanFrame.setIconImage(img);
            DataProduk.setIconImage(img);
            EditAkunFrame.setIconImage(img);
            DataServiceFrame.setIconImage(img);
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame DataPembelianFrame;
    private javax.swing.JFrame DataPenjualan;
    private javax.swing.JFrame DataPenjualanFrame;
    private javax.swing.JFrame DataProduk;
    private javax.swing.JDialog DataProdukShowImg;
    private javax.swing.JFrame DataServiceFrame;
    private javax.swing.JFrame EditAkunFrame;
    private javax.swing.JFrame KoleksiDataFrame;
    private javax.swing.JTextField biayaTF;
    private javax.swing.JButton crudAkunBtn;
    private javax.swing.JButton crudHomeBtn;
    private javax.swing.JButton crudPembelianBtn;
    private javax.swing.JButton crudPenjualanBtn;
    private javax.swing.JButton crudProdukAddBtn;
    private javax.swing.JButton crudProdukAddImgBtn;
    private javax.swing.JButton crudProdukBtn;
    private javax.swing.JButton crudProdukCancelBtn;
    private javax.swing.JButton crudProdukDeleteBtn;
    private javax.swing.JButton crudProdukEditBtn;
    private javax.swing.JTextField crudProdukHargaBeliTF;
    private javax.swing.JTextField crudProdukHargaJualTF;
    private javax.swing.JTextField crudProdukIdProdukTF;
    private javax.swing.JComboBox<String> crudProdukKategoriCB;
    private javax.swing.JButton crudProdukKembaliBtn;
    private javax.swing.JTextField crudProdukNamaProdukTF;
    private javax.swing.JButton crudProdukResetBtn;
    private javax.swing.JButton crudProdukSaveBtn;
    private javax.swing.JButton crudProdukSearchBtn;
    private javax.swing.JButton crudProdukShowImgBtn;
    private javax.swing.JTextField crudProdukStokTF;
    private javax.swing.JTable crudProdukTbl;
    private javax.swing.JCheckBox crudProdukUploadImgCB;
    private javax.swing.JButton crudServiceBtn;
    private javax.swing.JTable dataServiceTbl;
    private javax.swing.JTable detailPembelianTbl;
    private javax.swing.JTable detailPenjualanTbl;
    private javax.swing.JTextField editAkunPasswordTF;
    private javax.swing.JButton editAkunSaveBtn;
    private javax.swing.JTextField editAkunUsernameTF;
    private javax.swing.JButton emailBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel imageCont;
    private javax.swing.JButton instagramBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton katalogBtn;
    private javax.swing.JButton koleksiDataBtn;
    private javax.swing.JTextField lamaServiceTF;
    private javax.swing.JLabel logoContainer;
    private javax.swing.JTextField namaBarangTF;
    private javax.swing.JTextField namaCustomerTF;
    private javax.swing.JTextField noTelpTF;
    private javax.swing.JButton pembelianBtn;
    private javax.swing.JTable pembelianTbl;
    private javax.swing.JLabel pembelianTotpemLbl;
    private javax.swing.JTable penjualanTbl;
    private javax.swing.JLabel penjualanTotpenLbl;
    private javax.swing.JLabel selectedMenu1;
    private javax.swing.JLabel selectedMenuLbl;
    private javax.swing.JButton serviceBtn;
    private javax.swing.JButton serviceCancelBtn;
    private javax.swing.JButton serviceDeleteBtn;
    private javax.swing.JButton serviceEditBtn;
    private javax.swing.JButton serviceResetbtn;
    private javax.swing.JButton serviceSaveBtn;
    // End of variables declaration//GEN-END:variables
}
