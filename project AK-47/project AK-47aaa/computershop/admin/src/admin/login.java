/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import codes.BDconect;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author InspireTech
 */
public class login extends javax.swing.JFrame {

    Connection conn = null;
        PreparedStatement pat = null;
        ResultSet rs = null;
     
    public login() {
        initComponents();
        conn = BDconect.getConnection();
    }

 public void loginCheck(){
        String Uname=txtName.getText();
        String Pword=pswrd.getText();
        String dbUname;
        String dbPword;

        try {
            String Sql="SELECT * FROM `loging`";
            pat=(PreparedStatement) conn.prepareStatement(Sql);
            rs=pat.executeQuery();
            
            if(rs.next()){
                 dbUname=rs.getString("username");
                 dbPword=rs.getString("password");
            
                 if(Uname.equals(dbUname) && Pword.equals(dbPword)){
                     Menu m1=new Menu();
                     m1.setVisible(true);
                     this.dispose();
                     System.out.println("dd");
                 }
                 
                 else if(Uname.equals("ak47s") && Pword.equals("admin")){
                     Menu m1=new Menu();
                     m1.setVisible(true);
                     this.dispose();
                     
                 }
                 else if(Uname.equals(dbUname)){
                JOptionPane.showMessageDialog(null,"Password Incorrect","",JOptionPane.ERROR_MESSAGE);
                     pswrd.setText("");
                     
            }
//                 else if(Pword.equals(dbPword)){
//                     JOptionPane.showMessageDialog(null,"User Name Incorrect","",JOptionPane.ERROR_MESSAGE);
//                     txtName.setText("");
//                     
//                 }
                 else{

                     JOptionPane.showMessageDialog(null,"User Name or Password Incorrect","",JOptionPane.ERROR_MESSAGE);
                     txtName.setText("");
                     pswrd.setText("");
                     txtName.requestFocus();
                 }  
            } 
        
        } catch (Exception e) {
            System.out.println(e);
        }
   
    }

   

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pswrd = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        foggetlabel = new javax.swing.JLabel();
        loginbtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1912, 1047));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1912, 1047));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/login (2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 1060));

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
        jLabel2.setText("     USER LOGIN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 90, 360, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/lock.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 444, 90, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/user.png"))); // NOI18N
        jLabel4.setText("jLabel3");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 300, 90, 70));

        pswrd.setBackground(new java.awt.Color(51, 204, 255));
        pswrd.setDisabledTextColor(new java.awt.Color(51, 204, 255));
        pswrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswrdActionPerformed(evt);
            }
        });
        jPanel1.add(pswrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 460, 300, 40));

        txtName.setBackground(new java.awt.Color(51, 204, 255));
        txtName.setDisabledTextColor(new java.awt.Color(102, 204, 255));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 310, 300, 40));

        nameLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(51, 153, 255));
        nameLabel.setText("  Password");
        jPanel1.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 430, 110, 30));

        nameLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        nameLabel1.setForeground(new java.awt.Color(51, 153, 255));
        nameLabel1.setText("  Username");
        jPanel1.add(nameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 280, 120, 30));

        foggetlabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        foggetlabel.setForeground(new java.awt.Color(51, 153, 255));
        foggetlabel.setText("Forget Password ?");
        foggetlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foggetlabelMouseClicked(evt);
            }
        });
        jPanel1.add(foggetlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, 610, 140, 20));

        loginbtn.setBackground(new java.awt.Color(0, 153, 255));
        loginbtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        loginbtn.setForeground(new java.awt.Color(255, 255, 255));
        loginbtn.setText("LOGIN");
        loginbtn.setBorder(null);
        loginbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginbtnMouseClicked(evt);
            }
        });
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });
        jPanel1.add(loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 800, 170, 50));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/right.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1800, 0, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1951, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pswrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswrdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pswrdActionPerformed

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
        
         loginCheck();
    }//GEN-LAST:event_loginbtnActionPerformed

    private void foggetlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foggetlabelMouseClicked
       JOptionPane.showMessageDialog(null,"CHEK ON THE GUID BOOK.AND FOLLOW THE STEPS."); 
    }//GEN-LAST:event_foggetlabelMouseClicked

    private void loginbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtnMouseClicked
        
    }//GEN-LAST:event_loginbtnMouseClicked
      
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel foggetlabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginbtn;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JTextField pswrd;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
