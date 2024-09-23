
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP
 */
public class demo extends javax.swing.JFrame {

    /**
     * Creates new form demo
     */
    public demo() {
        initComponents();
        setSize(700,700);
        loadmovies1();
    }
    
    
    
    void loadmovies(String name)
    {
        try
        {
       // mainpanel.removeAll();
       if(!tf.getText().equals(" "))
        {
        mainpanel.removeAll();
            mainpanel.repaint();
        String ans=myClient.search(name);
        StringTokenizer st=new StringTokenizer(ans,";;");
        int n=st.countTokens();
        JButton arr[]=new JButton[n];
        int x=10,y=30;
        for(int i=0;i<=n-1;i++)
        {
            String row=st.nextToken();
            StringTokenizer st1=new StringTokenizer(row,"$");
            int id=Integer.parseInt(st1.nextToken());
            String category=st1.nextToken();
            String photo=st1.nextToken();
            arr[i]=new JButton(category);
            //arr[i].setIcon(new ImageIcon(photo));
            arr[i].setBounds(x, y,200 ,100 );
            
            ImageIcon ic=new ImageIcon(photo);
            Image im=ic.getImage().getScaledInstance(arr[i].getWidth()/2, arr[i].getHeight()-15, Image.SCALE_SMOOTH);
            arr[i].setIcon(new ImageIcon(im));
            arr[i].setIconTextGap(10);
            
            arr[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Movie_detail obj=new Movie_detail(id);
                    obj.setVisible(true);
               //     JOptionPane.showMessageDialog(rootPane, "login first");
                 //   userlogin obj=new userlogin();
                   // obj.setVisible(true);
                    dispose();
                    
                    
                }
            }
            
            );
            
            mainpanel.add(arr[i]);
            mainpanel.repaint();
            if(x<=520)
            {
                x=x+250;
            }
            else
            {
                x=10;
                y=y+150;
            }
            
        }
        
         mainpanel.setPreferredSize(new Dimension(520,n*80));
        
        }
        else
        {
            mainpanel.removeAll();
            mainpanel.repaint();
            //tf.setText("not found");
        }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, "not found");
        }
      
        
        
    }
    
    
    void loadmovies1()
    {
        try
        {
       // mainpanel.removeAll();
       if(!tf.getText().equals(" "))
        {
       
        String ans=myClient.search(tf.getText());
        StringTokenizer st=new StringTokenizer(ans,";;");
        int n=st.countTokens();
        JButton arr[]=new JButton[n];
        int x=10,y=30;
        for(int i=0;i<=n-1;i++)
        {
            String row=st.nextToken();
            StringTokenizer st1=new StringTokenizer(row,"$");
            int id=Integer.parseInt(st1.nextToken());
            String category=st1.nextToken();
            String photo=st1.nextToken();
            arr[i]=new JButton(category);
            //arr[i].setIcon(new ImageIcon(photo));
            arr[i].setBounds(x, y,200 ,100 );
            
            ImageIcon ic=new ImageIcon(photo);
            Image im=ic.getImage().getScaledInstance(arr[i].getWidth()/2, arr[i].getHeight()-15, Image.SCALE_SMOOTH);
            arr[i].setIcon(new ImageIcon(im));
            arr[i].setIconTextGap(10);
            
            arr[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Movie_detail obj=new Movie_detail(id);
                    obj.setVisible(true);
               //     JOptionPane.showMessageDialog(rootPane, "login first");
                 //   userlogin obj=new userlogin();
                   // obj.setVisible(true);
                    dispose();
                    
                    
                }
            }
            
            );
            
            mainpanel.add(arr[i]);
            mainpanel.repaint();
            if(x<=520)
            {
                x=x+250;
            }
            else
            {
                x=10;
                y=y+150;
            }
            
        }
        
         mainpanel.setPreferredSize(new Dimension(520,n*80));
        
        }
        else
        {
            mainpanel.removeAll();
            mainpanel.repaint();
            //tf.setText("not found");
        }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, "not found");
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

        tf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfCaretUpdate(evt);
            }
        });
        tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfActionPerformed(evt);
            }
        });
        getContentPane().add(tf);
        tf.setBounds(90, 20, 470, 60);

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 620, 480);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 20, 80, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfActionPerformed

    private void tfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfCaretUpdate
      String name=tf.getText();
        
        loadmovies(name);
    }//GEN-LAST:event_tfCaretUpdate

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
            java.util.logging.Logger.getLogger(demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new demo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}
