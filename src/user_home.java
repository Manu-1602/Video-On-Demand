
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class user_home extends javax.swing.JFrame {

    /**
     * Creates new form user_home
     */
    //String category;
    public user_home(String email) 
    {
        initComponents();
        setSize(650,600);
        lb.setText("welcome: "+email);
       // text.setText(email);
        //System.out.println(email);
        loadcategory();
        mainpanel.setOpaque(true);
        mainpanel.setBackground(Color.RED);
        
    }
    void loadcategory()
    {
        String ans= myClient.fetchcat();
        System.out.println(ans);
        StringTokenizer st=new StringTokenizer(ans,";;");
        int n=st.countTokens();
        //System.out.println(n);
        JButton arr[]=new JButton[n];
        int x=15,y=100;
        for(int i=0;i<n;i++)
        {
           String row  =st.nextToken();
           StringTokenizer st1=new StringTokenizer(row,"$");
           String name=st1.nextToken();
           //category=name;
           String photo=st1.nextToken();
           
           arr[i]=new JButton(name);
           
           arr[i].setIcon(new ImageIcon(photo));
           arr[i].setBounds(x, y, 120, 40);
           arr[i].addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   
                 //  JOptionPane.showMessageDialog(rootPane, "add moveies");
                 //fetch_movies obj=new fetch_movies(name);
                 demo obj=new demo();
                 obj.setVisible(true);
                 dispose();
                 
               }
           });
           mainpanel.add(arr[i]);
           mainpanel.repaint(); //resrech thev panel
           if(x<=410)
           {
             x=x+120;  
           }
           else
           {
               x=15;
               y=y+50;
           }
           
           
        }
        mainpanel.setPreferredSize(new Dimension(450,n*50));  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("WELCOME :");
        getContentPane().add(lb);
        lb.setBounds(0, 0, 630, 80);

        jScrollPane2.setViewportView(mainpanel);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 100, 590, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_home("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}
