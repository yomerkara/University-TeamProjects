/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songsfile;


/**
 *
 * @author Arthas
 */
public class usersOradmin extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public usersOradmin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kullaniciGirisButton = new javax.swing.JButton();
        adminGirisButton = new javax.swing.JButton();
        BackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("users/admin");
        setMaximumSize(null);
        setPreferredSize(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kullaniciGirisButton.setBackground(new java.awt.Color(0, 0, 0));
        kullaniciGirisButton.setForeground(new java.awt.Color(255, 255, 255));
        kullaniciGirisButton.setText("Kullanıcı Giriş");
        kullaniciGirisButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kullaniciGirisButtonMouseClicked(evt);
            }
        });
        getContentPane().add(kullaniciGirisButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, 130, 40));

        adminGirisButton.setBackground(new java.awt.Color(0, 0, 0));
        adminGirisButton.setForeground(new java.awt.Color(255, 255, 255));
        adminGirisButton.setText("Admin Giriş");
        adminGirisButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminGirisButtonMouseClicked(evt);
            }
        });
        getContentPane().add(adminGirisButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 130, 40));

        BackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.png"))); // NOI18N
        getContentPane().add(BackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminGirisButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminGirisButtonMouseClicked
        new adminPanel().setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_adminGirisButtonMouseClicked

    private void kullaniciGirisButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kullaniciGirisButtonMouseClicked
       new userPanel().setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_kullaniciGirisButtonMouseClicked

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
            java.util.logging.Logger.getLogger(usersOradmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usersOradmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usersOradmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usersOradmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new usersOradmin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackGround;
    private javax.swing.JButton adminGirisButton;
    private javax.swing.JButton kullaniciGirisButton;
    // End of variables declaration//GEN-END:variables
}
