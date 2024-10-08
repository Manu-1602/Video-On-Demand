
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP
 */
public class otp_send extends javax.swing.JFrame {

    /**
     * Creates new form otp_send
     */
    String backotp;
    String password;
    String mail;
    String mobile;
    public otp_send(String email,String password,String mobile,String ans) {
        initComponents();
        setSize(590,536);
         ImageIcon ic=new ImageIcon("src/otp.jpeg");
        Image im=ic.getImage().getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH);
        background.setIcon(new ImageIcon(im));
         mail=email;
        backotp=ans;
        this.password=password;
        this.mobile=mobile;
        emailid.setText(mail);
        //otplabel.setEnabled(false);
        otplabel.setVisible(false);
        nlb1.setVisible(false);
        nlb2.setVisible(false);
        nlb3.setVisible(false);
        nlb4.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emailid = new javax.swing.JLabel();
        otp = new javax.swing.JTextField();
        verifybt = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        otplabel = new javax.swing.JLabel();
        nlb1 = new javax.swing.JLabel();
        nlb2 = new javax.swing.JLabel();
        nlb3 = new javax.swing.JLabel();
        nlb4 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Verify email address");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(14, 59, 560, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("VOD");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 590, 70);

        jLabel3.setText("To  verify  you  email ,we've  sent  a one Time ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 130, 410, 20);

        jLabel4.setText("Password(OTP) to ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 170, 110, 20);
        getContentPane().add(emailid);
        emailid.setBounds(120, 170, 140, 20);
        getContentPane().add(otp);
        otp.setBounds(10, 220, 280, 40);

        verifybt.setBackground(new java.awt.Color(255, 204, 0));
        verifybt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        verifybt.setText("Verify");
        verifybt.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                verifybtStateChanged(evt);
            }
        });
        verifybt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifybtActionPerformed(evt);
            }
        });
        getContentPane().add(verifybt);
        verifybt.setBounds(10, 300, 280, 50);

        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 210, 90, 40);

        jLabel6.setText("Enter OTP:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 196, 90, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 51));
        jLabel7.setText("Resend OTP");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7);
        jLabel7.setBounds(110, 370, 120, 20);

        otplabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        otplabel.setForeground(new java.awt.Color(0, 153, 51));
        otplabel.setText("A  new code has been sent to your email");
        getContentPane().add(otplabel);
        otplabel.setBounds(10, 270, 280, 20);

        nlb1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nlb1.setText("Note:  if you didn't recieve our verification email:");
        getContentPane().add(nlb1);
        nlb1.setBounds(10, 410, 280, 20);

        nlb2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nlb2.setText(". confirm that your email address was entered");
        getContentPane().add(nlb2);
        nlb2.setBounds(20, 436, 250, 20);

        nlb3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nlb3.setText("  correctly above");
        getContentPane().add(nlb3);
        nlb3.setBounds(20, 460, 240, 20);

        nlb4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nlb4.setText(". check your spam or junk email folder");
        getContentPane().add(nlb4);
        nlb4.setBounds(20, 486, 240, 20);
        getContentPane().add(background);
        background.setBounds(0, 0, 590, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verifybtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifybtActionPerformed
        // TODO add your handling code here:
        String otp1=otp.getText();
        if(backotp.equals(otp1.trim()))
        {
           String ans1=myClient.usersignup(mail, password, mobile);
                   System.out.println(ans1);
                   if(ans1.equals("sucess"))
                   {
                      JOptionPane.showMessageDialog(rootPane, "signup sucessfully");
                      userlogin obj=new userlogin();
                      obj.setVisible(true);
                      dispose();
                   }
                   else if(ans1.equals("mobile"))
                   {
                       JOptionPane.showMessageDialog(rootPane, "Mobile Already Exist");
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(rootPane, "signup failed");

                   }
       
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "OTP don't matched!!!");

        }
    }//GEN-LAST:event_verifybtActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        otplabel.setVisible(true);
        nlb1.setVisible(true);
        nlb2.setVisible(true);
        nlb3.setVisible(true);
        nlb4.setVisible(true);
        
//        otp_send.verifybtActionPerformed();
        String ans2=myClient.verifyemail(mail);
        if(ans2.equals("exist"))
        {
            JOptionPane.showMessageDialog(rootPane, "email already exist");
        }
        else
        {
            String otp1=otp.getText();
            if(otp1.trim().equals(ans2.trim()))
            {
                   String ans3=myClient.usersignup(mail, password, mobile);
                   System.out.println(ans2);
                   if(ans3.equals("sucess"))
                   {
                      JOptionPane.showMessageDialog(rootPane, "signup sucessfully");
                      userlogin obj=new userlogin();
                      obj.setVisible(true);
                      dispose();
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(rootPane, "signup failed");

                   }
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "OTP DON'T MATCHED!!");
            }
        }

        
    }//GEN-LAST:event_jLabel7MouseClicked

    private void verifybtStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_verifybtStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_verifybtStateChanged

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
            java.util.logging.Logger.getLogger(otp_send.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(otp_send.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(otp_send.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(otp_send.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new otp_send("","","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel emailid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel nlb1;
    private javax.swing.JLabel nlb2;
    private javax.swing.JLabel nlb3;
    private javax.swing.JLabel nlb4;
    private javax.swing.JTextField otp;
    private javax.swing.JLabel otplabel;
    private javax.swing.JButton verifybt;
    // End of variables declaration//GEN-END:variables
}
