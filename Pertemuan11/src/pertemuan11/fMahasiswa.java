/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pertemuan11;

import javax.swing.table.DefaultTableModel;
import static pertemuan11.dbkoneksi.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LAB F
 */
public class fMahasiswa extends javax.swing.JFrame {

    DefaultTableModel DM = new DefaultTableModel();
          
    /**
     * Creates new form fMahasiswa
     */
    public fMahasiswa() throws SQLException {
        initComponents();
        TM.setModel(DM);
        DM.addColumn("NIM");
        DM.addColumn("Nama Mahasiswa");
        DM.addColumn("Alamat");
        
        cleartextField();
        ListDataTable();
        tombol(false);
        cBARU.setEnabled(true);
        //cUBAH.setEnabled(true);
        //cHAPUS.setEnabled(true);
        fieldIsian(false);
        
    }
    private void storedta ()throws SQLException{
        if (!txNIM.getText().equals("")){
            
            Connection cnn = koneksi();
            if(!cnn.isClosed()){
                PreparedStatement PS = cnn.prepareStatement("INSERT INTO mhs (NIM, NAMA, Alamat) VALUES (?,?,?);");
                PS.setString(1, txNIM.getText());
                PS.setString(2, txNAMA.getText());
                PS.setString(3, txALAMAT.getText());
                PS.executeUpdate();
                cnn.close();
            }
        }
    }
    private void updatedta ()throws SQLException{
        Connection cnn = koneksi();
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement("UPDATE mhs SET NAMA=?, ALAMAT=? WHERE NIM = ?;");
            PS.setString(1, txNAMA.getText());
            PS.setString(2, txALAMAT.getText());
            PS.setString(3, txNIM.getText());
            PS.executeUpdate();
            cnn.close();
        }
    }
    
    private void destroydta (String nim) throws SQLException{
        //String sql = "DELETE FROM mhs WHERE NIM = '?';";
        Connection cnn = koneksi();
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement("DELETE FROM mhs WHERE NIM = ?;");
            PS.setString(1, nim);
            PS.executeUpdate();
            cnn.close();
        }
    }
    private void tombol (boolean opsi){
        cBARU.setEnabled(opsi);
        cUBAH.setEnabled(opsi);
        cHAPUS.setEnabled(opsi);
    }
    private void fieldIsian(boolean opsi){
        txNIM.setEnabled(opsi);
        txNAMA.setEnabled(opsi);
        txALAMAT.setEnabled(opsi);
    }
    private void cleartextField(){
        txNIM.setText("");
        txNAMA.setText("");
        txALAMAT.setText("");
    }
    private void ListDataTable () throws SQLException{
        Connection cnn = koneksi();
        
        DM.getDataVector().removeAllElements();
        DM.fireTableDataChanged();
        
        if (!cnn.isClosed()) {
            PreparedStatement PS= cnn.prepareStatement("SELECT * FROM mhs;");
            ResultSet RS = PS.executeQuery();
            
            while (RS.next()){                
                Object[] dta = new Object[3];
                dta[0]=RS.getString("NIM");
                dta[1]=RS.getString("NAMA");
                dta[2]=RS.getString("ALAMAT");
                
                DM.addRow(dta);
            }
            cnn.close();
            
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TM = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jlabel1 = new javax.swing.JLabel();
        txNIM = new javax.swing.JTextField();
        txNama = new javax.swing.JLabel();
        txNAMA = new javax.swing.JTextField();
        txAlamat = new javax.swing.JLabel();
        txALAMAT = new javax.swing.JTextField();
        cBARU = new javax.swing.JButton();
        cUBAH = new javax.swing.JButton();
        cHAPUS = new javax.swing.JButton();
        cTUTUP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(0, 204, 153));
        jLabel1.setFont(new java.awt.Font("Zilla Slab", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Data Mahasiswa");

        TM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        TM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TM);

        jLabel2.setText("Edit View Data");

        jlabel1.setText("NIM");

        txNIM.setText("jTextField1");

        txNama.setText("Nama Mahasiswa");

        txNAMA.setText("jTextField1");

        txAlamat.setText("Alamat");

        txALAMAT.setText("jTextField1");

        cBARU.setText("ADD");
        cBARU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBARUActionPerformed(evt);
            }
        });

        cUBAH.setText("UPDATE");
        cUBAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cUBAHActionPerformed(evt);
            }
        });

        cHAPUS.setText("DELETE");
        cHAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cHAPUSActionPerformed(evt);
            }
        });

        cTUTUP.setText("CLOSE");
        cTUTUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTUTUPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txAlamat)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cBARU)
                        .addGap(18, 18, 18)
                        .addComponent(cUBAH)
                        .addGap(18, 18, 18)
                        .addComponent(cHAPUS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cTUTUP))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txNIM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txNama)
                            .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txALAMAT)
                    .addComponent(jScrollPane1))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txNama)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(txAlamat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txALAMAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBARU, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cUBAH, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cTUTUP, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TMMouseClicked
        txNIM.setText(TM.getValueAt(TM.getSelectedRow(), 0).toString());
        txNAMA.setText(TM.getValueAt(TM.getSelectedRow(), 1).toString());
        txALAMAT.setText(TM.getValueAt(TM.getSelectedRow(), 2).toString());
        cUBAH.setEnabled(true);
        cHAPUS.setEnabled(true);
    }//GEN-LAST:event_TMMouseClicked

    private void cBARUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBARUActionPerformed
        if (cBARU.getText().equals("ADD")){
            cBARU.setText("SAVE");
            cTUTUP.setText("CANCEL");
            cUBAH.setEnabled(false);
            cHAPUS.setEnabled(false);
            cleartextField();
            fieldIsian(true);
        }else{
            cBARU.setText("ADD");
            cTUTUP.setText("CLOSE");
            try {
                storedta();
                ListDataTable();
            } catch (SQLException ex) {
                Logger.getLogger(fMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
            cleartextField();
            fieldIsian(false);
        }
    }//GEN-LAST:event_cBARUActionPerformed

    private void cTUTUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTUTUPActionPerformed
        if (cTUTUP.getText().equals("CLOSE")){
            int jwb = JOptionPane.showOptionDialog(this, 
                        "Yakin akan menutup aplikasi", 
                        "Konfirmasi Tutup Aplikasi", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.ERROR_MESSAGE, 
                        null, null, null);
            if(jwb == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }else{
            cTUTUP.setText("CLOSE");
            cBARU.setText("NEW");
            cUBAH.setText("UPDATE");
            cBARU.setEnabled(true);
            cHAPUS.setEnabled(false);
            cUBAH.setEnabled(false);
            cleartextField();
            fieldIsian(false);
        }       
    }//GEN-LAST:event_cTUTUPActionPerformed

    private void cHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cHAPUSActionPerformed
        if (cHAPUS.getText().equals("DELETE")){
            
            String nim = txNIM.getText();
            int jwb = JOptionPane.showOptionDialog(this, 
                    "Yakin akan Menghapus data dengan NIM: "+ nim, 
                    "Konfirmasi Hapus Data", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.ERROR_MESSAGE, 
                    null, null, null);
            if (jwb == JOptionPane.YES_OPTION){
                try {
                destroydta(nim);
                ListDataTable();
                } catch (SQLException ex) {
                    Logger.getLogger(fMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
                }
                cleartextField();
                fieldIsian(false);
                cBARU.setEnabled(true);
                cUBAH.setEnabled(false);
                cHAPUS.setEnabled(false);
                
            }     
        }
        
    }//GEN-LAST:event_cHAPUSActionPerformed

    private void cUBAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cUBAHActionPerformed
        if (cUBAH.getText().equals("UPDATE")){
            cUBAH.setText("SAVE");
            cTUTUP.setText("CANCEL");
            cBARU.setEnabled(false);
            cHAPUS.setEnabled(false);
            fieldIsian(true);
            txNIM.setEditable(false);
        }else{
            cUBAH.setText("UPDATE");
            cTUTUP.setText("CLOSE");
            try {
                updatedta();
                ListDataTable();
            } catch (SQLException ex) {
                Logger.getLogger(fMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
            cleartextField();
            fieldIsian(false);
            cBARU.setEnabled(true);
            cUBAH.setEnabled(false);
        }
    }//GEN-LAST:event_cUBAHActionPerformed

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
            java.util.logging.Logger.getLogger(fMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new fMahasiswa().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(fMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TM;
    private javax.swing.JButton cBARU;
    private javax.swing.JButton cHAPUS;
    private javax.swing.JButton cTUTUP;
    private javax.swing.JButton cUBAH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JTextField txALAMAT;
    private javax.swing.JLabel txAlamat;
    private javax.swing.JTextField txNAMA;
    private javax.swing.JTextField txNIM;
    private javax.swing.JLabel txNama;
    // End of variables declaration//GEN-END:variables
}
