/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songsfile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author Arthas
 */
public class userMainPage extends javax.swing.JFrame implements TableModelListener {
     String kullanıcıadi;
    static userPanel isim=new userPanel();
       
    /**
     * Creates new form userMainPage
     */
    public userMainPage() {  
        kullanıcıadi = isim.getKullanıcıAdi();
        
        initComponents();
        showAlbums();
       // System.out.println(showUyeTipi());
    }
    private ArrayList<UyelikArama> uyelikTipi(){
        ArrayList<UyelikArama> UyeList = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
         try {
            st = connection.connect().createStatement();
            String searchQuery = "SELECT * FROM 'users'";
            rs = st.executeQuery(searchQuery);
            UyelikArama arama;
            while (rs.next()) {
                
                arama = new UyelikArama( 
                        rs.getInt("usersSubscription"),
                        rs.getString("usersNickName")
                        
                );
                UyeList.add(arama);
            }
        

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                st.close();
            } catch (Exception e) {

            }
        }
         
        return UyeList;
    }
    private int showUyeTipi(){
        int a = 0;
        ArrayList<UyelikArama> sonuc= uyelikTipi();
        for (int i = 0; i < sonuc.size(); i++) {
        if(sonuc.get(i).getUyelikAdi() == null ? isim.getKullanıcıAdi() == null : sonuc.get(i).getUyelikAdi().equals(isim.getKullanıcıAdi()))
        {
             a= sonuc.get(i).getUyelikTipi();
        }
        }
        return a;
    }
        
    
    public ArrayList<Arama> albumList() {
        ArrayList<Arama> albumList = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.connect().createStatement();
            String searchQuery = "SELECT * FROM 'album'";
            rs = st.executeQuery(searchQuery);
            Arama arama;
            while (rs.next()) {
                arama = new Arama(
                        rs.getInt("albumid"),
                        rs.getString("albumName"),
                        rs.getString("albumAuthor"),
                        rs.getString("albumSong"),
                        rs.getString("albumType"),
                        rs.getString("albumDate"),
                        rs.getInt("albumcount")
                );
                albumList.add(arama);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                st.close();
            } catch (Exception e) {

            }
        }

        return albumList;
    }

    private void showAlbums() {
        ArrayList<Arama> sonuc = albumList();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[7];

        for (int i = 0; i < sonuc.size(); i++) {
            row[0] = sonuc.get(i).getAlbumid();
            row[1] = sonuc.get(i).getAlbumName();
            row[2] = sonuc.get(i).getAlbumAuthor();
            row[3] = sonuc.get(i).getAlbumSong();
            row[4] = sonuc.get(i).getAlbumType();
            row[5] = sonuc.get(i).getAlbumDate();
            row[6] = sonuc.get(i).getAlbumCount();
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        PlaylistEkle = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        tüm = new javax.swing.JMenu();
        playlist = new javax.swing.JMenu();
        others = new javax.swing.JMenu();
        top10 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 525));
        setPreferredSize(new java.awt.Dimension(800, 525));
        setSize(new java.awt.Dimension(800, 525));

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        PlaylistEkle.setText("Ekle");
        PlaylistEkle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlaylistEkleMouseClicked(evt);
            }
        });
        PlaylistEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaylistEkleActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Albüm ID","Albüm Adı", "Şarkıcı", "Şarkı", "Tür", "Çıkış Tarihi","Din. Sayısı"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guitar.jpg"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("<---");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PlaylistEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(PlaylistEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        tüm.setText("Tüm Şarkılar");
        jMenuBar1.add(tüm);

        playlist.setText("Çalma Listelerim");
        playlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playlistMouseClicked(evt);
            }
        });
        jMenuBar1.add(playlist);

        others.setText("Diğer Kullanıcılar");
        others.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                othersMouseClicked(evt);
            }
        });
        jMenuBar1.add(others);

        top10.setText("Top 10");
        top10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                top10MouseClicked(evt);
            }
        });
        jMenuBar1.add(top10);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleParent(jPanel1);

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playlistMouseClicked
        new userPlaylist().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_playlistMouseClicked

    private void PlaylistEkleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlaylistEkleMouseClicked
        
        PreparedStatement ps = null;
        try {
            String Query = "INSERT INTO 'playlist'('playlistsahibi','playlistalbumadi','playlistsarkici','playlistadi','playlistturu','playlistçıkıs','playlistdinleme')VALUES(?,?,?,?,?,?,?)";
            ps = connection.connect().prepareStatement(Query);
            int i = table.getSelectedRow();
            TableModel model = table.getModel();
            ps.setString(1,isim.getKullanıcıAdi());
            ps.setString(2, model.getValueAt(i, 1).toString());
            ps.setString(3, model.getValueAt(i, 2).toString());
            ps.setString(4, model.getValueAt(i, 3).toString());
            ps.setString(5, model.getValueAt(i, 4).toString());
            ps.setString(6, model.getValueAt(i, 5).toString());
            ps.setString(7, model.getValueAt(i, 6).toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "ALBUM EKLENDİ");

           
            
           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                ps.close();
                
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_PlaylistEkleMouseClicked

    private void PlaylistEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaylistEkleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlaylistEkleActionPerformed

    private void othersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_othersMouseClicked
         new userOthers().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_othersMouseClicked

    private void top10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_top10MouseClicked
         new userTop10().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_top10MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        new userPanel().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(userMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userMainPage().setVisible(true);
                
            }
        });
        
        
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PlaylistEkle;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu others;
    private javax.swing.JMenu playlist;
    private javax.swing.JTable table;
    private javax.swing.JMenu top10;
    private javax.swing.JMenu tüm;
    // End of variables declaration//GEN-END:variables

    @Override
    public void tableChanged(TableModelEvent tme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
