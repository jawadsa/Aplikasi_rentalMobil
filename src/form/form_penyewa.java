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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class form_penyewa extends javax.swing.JFrame {

    private Connection con;
    private Statement st;
    private ResultSet RsPenyewa;
    private String sql="";
    
    private String idpenyewa,namapenyewa,alamat,hp,ktp,status;
    /**
     * Creates new form form_penyewa
     */
    public form_penyewa() {
        initComponents();
        koneksiPenyewa();
        tampilData(sql);
    }
    private void koneksiPenyewa(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_rental_mobil", "root","");
            System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            System.out.println("Koneksi Gagal \n"+e);
        }
    }
    
    private void tampilData (String sql){
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("NO");
        datalist.addColumn("ID PENYEWA");
        datalist.addColumn("NAMA PENYEWA");
        datalist.addColumn("ALAMAT");
        datalist.addColumn("NO HP");
        datalist.addColumn("NO KTP");
        datalist.addColumn("STATUS");
        try {
            int i = 1;
            st=con.createStatement();
            RsPenyewa=st.executeQuery("SELECT * FROM tb_penyewa") ;
            while (RsPenyewa.next())
                datalist.addRow(new Object[]{
                    (""+i++),
                    RsPenyewa.getString(1), RsPenyewa.getString(2), 
                    RsPenyewa.getString(3), RsPenyewa.getString(4), 
                    RsPenyewa.getString(5), RsPenyewa.getString(6)
                });
            tb_penyewa.setModel(datalist);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Gagal Tampil \n"+e.getMessage());
        }
    }
    
    private void bersihData(){
        t_alamat.setText("");
        t_noHp.setText("");
        t_idPenyewa.setText("");
        t_noKtp.setText("");
        t_namaPenyewa.setText("");
        cbb_status.setSelectedItem("Pilih");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        t_idPenyewa = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        t_namaPenyewa = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        t_alamat = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        t_noHp = new javax.swing.JTextField();
        t_noKtp = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        b_simpan = new javax.swing.JButton();
        b_ubah = new javax.swing.JButton();
        b_hapus = new javax.swing.JButton();
        b_batal = new javax.swing.JButton();
        b_keluar = new javax.swing.JButton();
        cbb_status = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_penyewa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Form Data Penyewa");

        jPanel4.setBackground(new java.awt.Color(102, 153, 255));

        jPanel5.setBackground(new java.awt.Color(153, 153, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Tambah Data Penyewa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 18))); // NOI18N

        jLabel13.setText("Id Penyewa");

        t_idPenyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_idPenyewaActionPerformed(evt);
            }
        });
        t_idPenyewa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_idPenyewaKeyPressed(evt);
            }
        });

        jLabel14.setText("Nama Penyewa");

        jLabel15.setText("Alamat");

        jLabel16.setText("Nomor Hp");

        jLabel17.setText("Nomor Ktp ");

        t_noHp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_noHpActionPerformed(evt);
            }
        });

        jLabel18.setText("Status");

        b_simpan.setText("Simpan");
        b_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_simpanActionPerformed(evt);
            }
        });

        b_ubah.setText("Ubah");
        b_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ubahActionPerformed(evt);
            }
        });

        b_hapus.setText("Hapus");
        b_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_hapusActionPerformed(evt);
            }
        });

        b_batal.setText("Batal");
        b_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_batalActionPerformed(evt);
            }
        });

        b_keluar.setText("Keluar");
        b_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_keluarActionPerformed(evt);
            }
        });

        cbb_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Siap", "Belum Siap" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t_idPenyewa)
                            .addComponent(t_namaPenyewa)
                            .addComponent(t_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b_simpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_ubah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_hapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(t_noHp, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                .addComponent(t_noKtp))
                            .addComponent(cbb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_batal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(t_idPenyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_simpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_namaPenyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(b_ubah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(b_hapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(t_noHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_batal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_noKtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(b_keluar)
                    .addComponent(cbb_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tb_penyewa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NO", "ID PENYEWA", "NAMA PENYEWA", "ALAMAT", "NOMOR HP", "NOMOR KTP", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(tb_penyewa);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/6-2-customer-png-picture.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Master");

        jMenuItem1.setText("Mobil");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Penyewa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Transaksi");

        jMenuItem3.setText("Sewa");
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Kembali");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void b_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_hapusActionPerformed
        // TODO add your handling code here:
        idpenyewa=String.valueOf(t_idPenyewa.getText());
        try {
            sql="delete from tb_penyewa where id_penyewa='"+ idpenyewa +"'";
            st=con.createStatement();
            st.execute(sql);
            bersihData();
            tampilData(sql);
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DIHAPUS");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DATA GAGAL DIHAPUS"+e.getMessage());
        }
    }//GEN-LAST:event_b_hapusActionPerformed

    private void t_idPenyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_idPenyewaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_idPenyewaActionPerformed

    private void t_noHpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_noHpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_noHpActionPerformed

    private void b_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_simpanActionPerformed
        // TODO add your handling code here:
        idpenyewa=String.valueOf(t_idPenyewa.getText());
        namapenyewa=String.valueOf(t_namaPenyewa.getText());
        alamat=String.valueOf(t_alamat.getText());
        hp=String.valueOf(t_noHp.getText());
        ktp=String.valueOf(t_noKtp.getText());
        status=String.valueOf(cbb_status.getSelectedItem());
        if (cbb_status.getSelectedItem().equals("Pilih")){
            JOptionPane.showMessageDialog(null, "Anda belum memilih status");
        }
        else if (cbb_status.getSelectedItem().equals("Belum Siap")){
            JOptionPane.showMessageDialog(null, "Penyewa sudah terdaftar");
        }else {
        try {
            sql="INSERT INTO tb_penyewa(id_penyewa, nama_penyewa, "
                    + "alamat, no_hp, no_ktp, status)VALUE"
                    + "('"+ idpenyewa +"','"+ namapenyewa +"','"+ alamat +"','"+ hp +"',"
                    + "'"+ ktp +"','"+ status +"')";
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

    private void t_idPenyewaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_idPenyewaKeyPressed
        // TODO add your handling code here:
        idpenyewa=t_idPenyewa.getText();
        int tekanenter=evt.getKeyCode();
        if (tekanenter==10){
            try {
                sql="select * from tb_penyewa "
                        + "where id_penyewa='"+ idpenyewa +"'";
                st=con.createStatement();
                RsPenyewa=st.executeQuery(sql);
                while (RsPenyewa.next()){
                    t_namaPenyewa.setText(RsPenyewa.getString("nama_penyewa"));
                    t_alamat.setText(RsPenyewa.getString(3));
                    t_noHp.setText(RsPenyewa.getString(4));
                    t_noKtp.setText(RsPenyewa.getString(5));
                    cbb_status.setSelectedItem(RsPenyewa.getString(6));
                    JOptionPane.showMessageDialog(null, "Data Ditemukan");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gak Ketemu \n"
                    +e.getMessage());
            }
        }
    }//GEN-LAST:event_t_idPenyewaKeyPressed

    private void b_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_keluarActionPerformed
        // TODO add your handling code here:
         String ObjButtons[] = {"Yes","No"};
         int pilihan = JOptionPane.showOptionDialog(null,"Apakah Anda Yakin Ingin keluar ?","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,ObjButtons,ObjButtons[1]);
         if(pilihan == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_b_keluarActionPerformed

    private void b_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ubahActionPerformed
        // TODO add your handling code here:
        idpenyewa=String.valueOf(t_idPenyewa.getText());
        namapenyewa=String.valueOf(t_namaPenyewa.getText());
        alamat=String.valueOf(t_alamat.getText());
        hp=String.valueOf(t_noHp.getText());
        ktp=String.valueOf(t_noKtp.getText());
        status=String.valueOf(cbb_status.getSelectedItem());
        try {
            sql="UPDATE tb_penyewa SET nama_penyewa='"+ namapenyewa +"', "
                    + "alamat='"+ alamat +"', no_hp='"+ hp +"', "
                    + "no_ktp='"+ ktp +"', status='"+ status +"' "
                    + "where id_penyewa='"+ idpenyewa +"'";
            st=con.createStatement();
            st.execute(sql);
            bersihData();
            tampilData(sql);
            JOptionPane.showMessageDialog(null, 
                    "Data berhasil di ubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal di ubah \n"+e.getMessage());
        }
    }//GEN-LAST:event_b_ubahActionPerformed

    private void b_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_batalActionPerformed
        // TODO add your handling code here:
        bersihData();
    }//GEN-LAST:event_b_batalActionPerformed

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
            java.util.logging.Logger.getLogger(form_penyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_penyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_penyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_penyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_penyewa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_batal;
    private javax.swing.JButton b_hapus;
    private javax.swing.JButton b_keluar;
    private javax.swing.JButton b_simpan;
    private javax.swing.JButton b_ubah;
    private javax.swing.JComboBox<String> cbb_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t_alamat;
    private javax.swing.JTextField t_idPenyewa;
    private javax.swing.JTextField t_namaPenyewa;
    private javax.swing.JTextField t_noHp;
    private javax.swing.JTextField t_noKtp;
    private javax.swing.JTable tb_penyewa;
    // End of variables declaration//GEN-END:variables

}