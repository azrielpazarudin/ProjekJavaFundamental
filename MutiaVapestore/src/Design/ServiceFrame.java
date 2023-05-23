/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Design;

import Database.*;
import Model.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Big Nigga Dude
 */
public class ServiceFrame extends javax.swing.JFrame {

    DAO myDao = new DAO();
    Model myMod = new Model();
    Image img = null;
    ImageIcon imgIcn = null;

    public ServiceFrame(Model mod) {
        this.myMod = mod;
        initComponents();
        run();
        setLogo();
        dataSeviceSetInput();
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Ingin Keluar", "Mutia Vapestore : Login", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    //=========== METHODE =======
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

    public boolean checkInputString(String str) {
        String checker = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}";
        return str.matches(checker);

    }

    public void checkNoTelp(String str) {
        for (int x = 0; x < str.length(); x++) {
            if (!(str.charAt(x) >= '0' && str.charAt(x) <= '9')) {
                if (!(str.charAt(0) == '0' || str.charAt(1) == '8' || str.charAt(2) == '1')) {
                    System.out.println("Bener");
                }
                System.out.println("salah");
            } else {

            }
        }
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
                if (namaBarangTF.getText().length() >= 25 || !(e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z' || e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z' || e.getKeyChar() == ' ') ) {
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

    public void clearDataServis() {
        namaCustomerTF.setText("");
        noTelpTF.setText("");
        namaBarangTF.setText("");
        lamaServiceTF.setText("");
        biayaTF.setText("");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        logoContainer = new javax.swing.JLabel();
        katalogBtn = new javax.swing.JButton();
        pembelianBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();
        serviceBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        namaCustomerTF = new javax.swing.JTextField();
        noTelpTF = new javax.swing.JTextField();
        namaBarangTF = new javax.swing.JTextField();
        lamaServiceTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        biayaTF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

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

        serviceBtn.setBackground(new java.awt.Color(0, 0, 0));
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(katalogBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(homeBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(logoContainer))
                    .addComponent(pembelianBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serviceBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jLabel8.setText("~ service ~");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, -1));

        jPanel2.setBackground(new java.awt.Color(153, 0, 51));

        jLabel3.setFont(new java.awt.Font("Electroharmonix", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DATA SERVICE");

        jLabel4.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NO. TELPON");

        jLabel5.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NAMA CUSTOMER");

        jLabel6.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("BIAYA");

        jLabel7.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NAMA barang");

        jLabel9.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("HARI");

        namaCustomerTF.setBackground(new java.awt.Color(255, 255, 255));
        namaCustomerTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N
        namaCustomerTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namaCustomerTFKeyPressed(evt);
            }
        });

        noTelpTF.setBackground(new java.awt.Color(255, 255, 255));
        noTelpTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N
        noTelpTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                noTelpTFKeyPressed(evt);
            }
        });

        namaBarangTF.setBackground(new java.awt.Color(255, 255, 255));
        namaBarangTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N

        lamaServiceTF.setBackground(new java.awt.Color(255, 255, 255));
        lamaServiceTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Electroharmonix", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("LAMA SERVICE");

        biayaTF.setBackground(new java.awt.Color(255, 255, 255));
        biayaTF.setFont(new java.awt.Font("Swis721 BT", 1, 18)); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Electroharmonix", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("C A T A T");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(190, 190, 190))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(namaBarangTF, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(noTelpTF, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(namaCustomerTF)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lamaServiceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9))
                            .addComponent(biayaTF)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel3)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel3)
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(namaCustomerTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(noTelpTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(namaBarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lamaServiceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(biayaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 570, 480));

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

    //============= ACTION ==========
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

    private void pembelianBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembelianBtnMouseClicked
        PembelianFrame pf = new PembelianFrame(myMod);
        this.dispose();
    }//GEN-LAST:event_pembelianBtnMouseClicked

    private void pembelianBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembelianBtnMouseEntered
        pembelianBtn.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_pembelianBtnMouseEntered

    private void pembelianBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembelianBtnMouseExited
        pembelianBtn.setBackground(new Color(153, 0, 51));
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

    private void serviceBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceBtnMouseEntered
        serviceBtn.setBackground(new Color(153, 0, 51));
    }//GEN-LAST:event_serviceBtnMouseEntered

    private void serviceBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceBtnMouseExited
        serviceBtn.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_serviceBtnMouseExited

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (namaCustomerTF.getText().equals("") || noTelpTF.getText().equals("") || namaBarangTF.getText().equals("") || lamaServiceTF.getText().equals("") || biayaTF.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong", "Mutia Vapestore : Servis", JOptionPane.WARNING_MESSAGE);
        } else {
            myMod.servis.setNamaCustomer(namaCustomerTF.getText());
            myMod.servis.setNoTelp(noTelpTF.getText());
            myMod.servis.setNamaBarang(namaBarangTF.getText());
            myMod.servis.setLamaServis(Integer.parseInt(lamaServiceTF.getText()));
            myMod.servis.setBiaya(Integer.parseInt(biayaTF.getText()));
            myDao.insertService(myMod);
            JOptionPane.showMessageDialog(null, "Berhasil ");
            clearDataServis();
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void serviceBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceBtnMouseClicked
        JOptionPane.showMessageDialog(null, "Anda Sedang Di Menu Service", "Mutia Vapestore : Service", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_serviceBtnMouseClicked

    private void exitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseEntered
        exitBtn.setBackground(Color.black);
    }//GEN-LAST:event_exitBtnMouseEntered

    private void exitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseExited
        exitBtn.setBackground(new Color(153, 0, 51));
    }//GEN-LAST:event_exitBtnMouseExited

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        int res = JOptionPane.showConfirmDialog(null, "Ingin Keluar", "Mutia Vapestore : Login", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitBtnMouseClicked

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

    void run() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.setTitle("MUTIA VAPESTORE");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(0);

        try {
            img = Toolkit.getDefaultToolkit().createImage(myDao.frameLogo(1));
            imgIcn = new ImageIcon(img);
            this.setIconImage(img);

        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField biayaTF;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton homeBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JButton katalogBtn;
    private javax.swing.JTextField lamaServiceTF;
    private javax.swing.JLabel logoContainer;
    private javax.swing.JTextField namaBarangTF;
    private javax.swing.JTextField namaCustomerTF;
    private javax.swing.JTextField noTelpTF;
    private javax.swing.JButton pembelianBtn;
    private javax.swing.JButton serviceBtn;
    // End of variables declaration//GEN-END:variables
}
