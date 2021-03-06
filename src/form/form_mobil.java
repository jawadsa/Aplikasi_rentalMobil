/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing .table.DefaultTableModel;
/**
 *
 * @author asus
 */
public class form_mobil extends javax.swing.JFrame {
    private Connection con;
    private Statement st;
    private ResultSet rsMobil;
    private String sql="";
    
    private String id, mobil, merk, plat, status;
    private int harga;
    /**
     * Creates new form form_mobil
     */
    public form_mobil() {
        initComponents();
        koneksiMobil();
        tampilData(sql);
    }
    
    private void koneksiMobil(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_rental_mobil", "root", "");
            System.out.println("Koneksi berhasil");
            JOptionPane.showMessageDialog(null, "Anda akan masuk ke form mobil");
        } catch (Exception e) {
            System.out.println("Koneksi gagal \n"+e);
        }
    }
    
    private void bersihData(){
        t_idMobil.setText("");
        t_namaMobil.setText("");
        t_merkMobil.setText("");
        t_plat.setText("");
        t_hargaSewa.setText("");
        
    }
    
    private void tampilData(String sql) {
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("No");
        datalist.addColumn("Id Mobil");
        datalist.addColumn("Nama Mobil");
        datalist.addColumn("Merk Mobil");
        datalist.addColumn("Plat Mobil");
        datalist.addColumn("Harga Sewa");
        datalist.addColumn("Status");
        try {
            int i = 1;
            st=con.createStatement();
            rsMobil=st.executeQuery("select * from tb_mobil");
            while (rsMobil.next())
                datalist.addRow(new Object[]{
                    (""+i++),
                        rsMobil.getString(1), rsMobil.getString(2),
                        rsMobil.getString(3), rsMobil.getString(4),
                        rsMobil.getString(5), rsMobil.getString(6),
                });
            tb_mobil.setModel(datalist);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan \n"+e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbb_status = new javax.swing.JComboBox<>();
        b_keluar = new javax.swing.JButton();
        t_hargaSewa = new javax.swing.JTextField();
        t_merkMobil = new javax.swing.JTextField();
        b_simpan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        b_batal = new javax.swing.JButton();
        t_plat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        t_namaMobil = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        b_edit = new javax.swing.JButton();
        t_idMobil = new javax.swing.JTextField();
        b_hapus = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_mobil = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Form Tambah Data Mobil");

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Tambah Data Mobil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 18))); // NOI18N
        jPanel2.setFocusTraversalPolicyProvider(true);

        jLabel1.setText("Id Mobil");

        cbb_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Siap", "Belum Siap" }));
        cbb_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_statusActionPerformed(evt);
            }
        });

        b_keluar.setText("Keluar");
        b_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_keluarActionPerformed(evt);
            }
        });

        b_simpan.setText("Simpan");
        b_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_simpanActionPerformed(evt);
            }
        });

        jLabel6.setText("Status");

        b_batal.setText("Batal");
        b_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_batalActionPerformed(evt);
            }
        });

        jLabel4.setText("Plat Mobil");

        t_namaMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_namaMobilActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama Mobil");

        b_edit.setText("Edit");
        b_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editActionPerformed(evt);
            }
        });

        t_idMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_idMobilActionPerformed(evt);
            }
        });
        t_idMobil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_idMobilKeyPressed(evt);
            }
        });

        b_hapus.setText("Hapus");
        b_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_hapusActionPerformed(evt);
            }
        });

        jLabel5.setText("Harga Sewa");

        jLabel3.setText("Merk Mobil");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_plat)
                            .addComponent(t_merkMobil)
                            .addComponent(t_namaMobil)
                            .addComponent(t_hargaSewa, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(t_idMobil)))
                    .addComponent(jLabel4))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_batal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(t_idMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_simpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_namaMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(b_batal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_merkMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(b_edit))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(t_plat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_hapus)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_hargaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbb_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(b_keluar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tb_mobil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID MOBIL", "NAMA MOBIL", "MERK MOBIL", "PLAT MOBIL", "HARGA SEWA", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(tb_mobil);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/JOYRENT-MASCOTTE_1_200x160.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu3.setText("Master");

        jMenuItem1.setText("Mobil");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Penyewa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Transaksi");

        jMenuItem3.setText("Sewa");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem4.setText("Kembali");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbb_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_statusActionPerformed

    private void b_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_batalActionPerformed
        // TODO add your handling code here:
        bersihData();
    }//GEN-LAST:event_b_batalActionPerformed

    private void b_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_simpanActionPerformed
        // TODO add your handling code here:
        id=String.valueOf(t_idMobil.getText());
        mobil=String.valueOf(t_namaMobil.getText());
        merk=String.valueOf(t_merkMobil.getText());
        plat=String.valueOf(t_plat.getText());
        harga=Integer.parseInt(t_hargaSewa.getText());
        status=String.valueOf(cbb_status.getSelectedItem());
        if (cbb_status.getSelectedItem().equals("pilih")){
            JOptionPane.showMessageDialog(null, "Ooopss status belum dipilih");
        }
        else if (cbb_status.getSelectedItem().equals("Belum Siap")){
            JOptionPane.showMessageDialog(null, "Maaf mobil sudah disewakan");
        }else {
        try {
            sql="INSERT INTO tb_mobil(id_mobil, nama_mobil, "
                    + "merk_mobil,plat_mobil, harga_sewa, "
                    + "status)value "
                    + "('"+ id +"','"+ mobil +"','"+ merk +"','"+plat +"',"
                    + "'"+ harga +"','"+ status +"')";
            st=con.createStatement();
            st.execute(sql);
            
            bersihData();
            tampilData(sql);
            JOptionPane.showMessageDialog(null, 
                    "Data Berhasil Disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "Data Gagal Disimpan \n"+e.getMessage());
        }
    }
    }//GEN-LAST:event_b_simpanActionPerformed

    private void t_namaMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_namaMobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_namaMobilActionPerformed

    private void t_idMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_idMobilActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_t_idMobilActionPerformed

    private void t_idMobilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_idMobilKeyPressed
        // TODO add your handling code here:
        id=t_idMobil.getText();
        int tekanenter=evt.getKeyCode();
        if (tekanenter==10){
            try {
                sql="select * from tb_mobil "
                        + "where id_mobil='"+ id +"'";
                st=con.createStatement();
                rsMobil=st.executeQuery(sql);
                while (rsMobil.next()){
                    t_namaMobil.setText(rsMobil.getString("nama_mobil"));
                    t_merkMobil.setText(rsMobil.getString(3));
                    t_plat.setText(rsMobil.getString(4));
                    t_hargaSewa.setText(rsMobil.getString(5));
                    cbb_status.setSelectedItem(rsMobil.getString(6));
                    JOptionPane.showMessageDialog(null, "Data Ditemukan");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gak Ketemu \n"
                    +e.getMessage());
                t_namaMobil.requestFocus();
            }
        }
    }//GEN-LAST:event_t_idMobilKeyPressed

    private void b_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_editActionPerformed
        // TODO add your handling code here:
        id=String.valueOf(t_idMobil.getText());
        mobil=String.valueOf(t_namaMobil.getText());
        merk=String.valueOf(t_merkMobil.getText());
        plat=String.valueOf(t_plat.getText());
        harga=Integer.parseInt(t_hargaSewa.getText());
        status=String.valueOf(cbb_status.getSelectedItem());
        try {
            sql="update tb_mobil set nama_mobil='"+ mobil +"',merk_mobil='"+ merk +"',plat_mobil='"+ plat +"',harga_sewa='"+ harga +"',status='"+ status +"' where id_mobil = '"+ id +"'";
            st=con.createStatement();
            st.execute(sql);
            bersihData();
            tampilData(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Edit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Edit \n"+e.getMessage());
        }
    }//GEN-LAST:event_b_editActionPerformed

    private void b_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_hapusActionPerformed
        // TODO add your handling code here:
        id=String.valueOf(t_idMobil.getText());
        try {
            sql="DELETE FROM tb_mobil"
                    +" where id_mobil='"+ id +"'";
            st=con.createStatement();
            st.execute(sql);
            bersihData();
            tampilData(sql);
            JOptionPane.showMessageDialog(null, 
                    "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus \n"+e.getMessage());
        }
    }//GEN-LAST:event_b_hapusActionPerformed

    private void b_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_keluarActionPerformed
        // TODO add your handling code here:
        String ObjButtons[] = {"Yes","No"};
        int pilihan = JOptionPane.showOptionDialog(null,"Apakah Anda Yakin Ingin keluar ?","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(pilihan == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_b_keluarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        form_mobil m=new form_mobil();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        form_penyewa m=new form_penyewa();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        form_rental m=new form_rental();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        form_pengembalian m=new form_pengembalian();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(form_mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_mobil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_batal;
    private javax.swing.JButton b_edit;
    private javax.swing.JButton b_hapus;
    private javax.swing.JButton b_keluar;
    private javax.swing.JButton b_simpan;
    private javax.swing.JComboBox<String> cbb_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t_hargaSewa;
    private javax.swing.JTextField t_idMobil;
    private javax.swing.JTextField t_merkMobil;
    private javax.swing.JTextField t_namaMobil;
    private javax.swing.JTextField t_plat;
    private javax.swing.JTable tb_mobil;
    // End of variables declaration//GEN-END:variables
}
