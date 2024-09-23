
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP
 */
public class fetch_movies extends javax.swing.JFrame {

    /**
     * Creates new form add_movies
     */
    String catname;
    public fetch_movies(String name) {
        initComponents();
        catname=name;
        setSize(600,600);
        loadmovies();
        //mainpanel.setOpaque(true);
        //mainpanel.setBackground(Color.RED);
        
        
    }
    void loadmovies()
    {
        String ans=myClient.fetchmovies(catname);
        StringTokenizer st=new StringTokenizer(ans,";;");
        int n=st.countTokens();
        JButton arr[]=new JButton[n];
        int x=10,y=100;
        for(int i=0;i<=n-1;i++)
        {
            String row=st.nextToken();
            StringTokenizer st1=new StringTokenizer(row,"$");
            int id=Integer.parseInt(st1.nextToken());
            String category=st1.nextToken();
            String photo=st1.nextToken();
            arr[i]=new JButton(category);
            //arr[i].setIcon(new ImageIcon(photo));
            arr[i].setBounds(x, y,250 ,100 );
            
            ImageIcon ic=new ImageIcon(photo);
            Image im=ic.getImage().getScaledInstance(arr[i].getWidth()/2, arr[i].getHeight()-15, Image.SCALE_SMOOTH);
            arr[i].setIcon(new ImageIcon(im));
            arr[i].setIconTextGap(10);
            
            arr[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Movie_detail obj=new Movie_detail(id);
                    obj.setVisible(true);
                    
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 580, 440);

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
            java.util.logging.Logger.getLogger(fetch_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fetch_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fetch_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fetch_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fetch_movies("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}
