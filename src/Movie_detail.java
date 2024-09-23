
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.util.StringTokenizer;
import javax.swing.Action;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP
 */
public class Movie_detail extends javax.swing.JFrame {

    /**
     * Creates new form Movie_detail
     */
    int movie_id;
    public Movie_detail(int id) {
        initComponents();
        movie_id=id;
        setSize(810, 520);
        
//         ImageIcon ic=new ImageIcon("src/download.jpeg");
//        Image im=ic.getImage().getScaledInstance(imb.getWidth(), imb.getHeight(), Image.SCALE_SMOOTH);
//        imb.setIcon(new ImageIcon(im));
        


        imb.setPreferredSize(new Dimension(100, 100)); // Set a preferred size for the label

        // Load the image
        ImageIcon originalIcon = new ImageIcon("src/imbd.jpeg");

        // Scale the image to fit the label while maintaining the aspect ratio
        Image originalImage = originalIcon.getImage();
        int labelWidth = imb.getPreferredSize().width;
        int labelHeight = imb.getPreferredSize().height;
        int imageWidth = originalImage.getWidth(null);
        int imageHeight = originalImage.getHeight(null);

        double widthRatio = (double) labelWidth / imageWidth;
        double heightRatio = (double) labelHeight / imageHeight;
        double ratio = Math.min(widthRatio, heightRatio);

        int newWidth = (int) (imageWidth * ratio);
        int newHeight = (int) (imageHeight * ratio);

        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Set the scaled icon to the label
        imb.setIcon(scaledIcon);
        
        
        // stars
        
        
        stars.setPreferredSize(new Dimension(150, 150)); // Set a preferred size for the label

        // Load the image
        ImageIcon starIconOriginal = new ImageIcon("src/startsss.png");

        // Scale the image to fit the label while maintaining the aspect ratio
        Image starImageOriginal = starIconOriginal.getImage();
        int starLabelWidth = stars.getPreferredSize().width;
        int starLabelHeight = stars.getPreferredSize().height;
        int starImageWidth = starImageOriginal.getWidth(null);
        int starImageHeight = starImageOriginal.getHeight(null);

        double widthRatioStar = (double) starLabelWidth / starImageWidth;
        double heightRatioStar = (double) starLabelHeight / starImageHeight;
        double ratioStar = Math.min(widthRatioStar, heightRatioStar);

        int newStarWidth = (int) (starImageWidth * ratioStar);
        int newStarHeight = (int) (starImageHeight * ratioStar);

        Image starImageScaled = starImageOriginal.getScaledInstance(newStarWidth, newStarHeight, Image.SCALE_SMOOTH);
        ImageIcon starIconScaled = new ImageIcon(starImageScaled);

        // Set the scaled icon to the label
        stars.setIcon(starIconScaled);
       
        
        
        
        
        
        
        
        
        
        moviename.setEditable(false);
        directorname.setEditable(false);
        castname.setEditable(false);
        loadmovies();
    }
    void loadmovies()
    {
        String ans=myClient.moviedetail(movie_id);
        StringTokenizer st=new StringTokenizer(ans,"$");
        String name=st.nextToken();
        String director=st.nextToken();
        String cast=st.nextToken();
        String youtube_id=st.nextToken();
        String photo=st.nextToken();
        String movie_link=st.nextToken();
        
        ImageIcon ic =new ImageIcon(photo);
        Image img=ic.getImage().getScaledInstance(photolb.getWidth(), photolb.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic1=new ImageIcon(img);
        photolb.setIcon(ic1);
        moviename.setText(name);
        directorname.setText(director);
        castname.setText(cast);
        
        trailerbt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    try
                {
                    URI uri = new URI("https://www.youtube.com/watch?v="+youtube_id);
                    Desktop d=Desktop.getDesktop();
                    d.browse(uri);
                }
                    catch(Exception ex)
                {
                    
                }
                    
                                       
                }
            }
            
            );
        bt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    try
                {
                  File f=new File(movie_link);
                  Desktop d=Desktop.getDesktop();
                  d.open(f);

                }
                    catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                    
                                       
                }
            }
            
            );

       
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        photolb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        moviename = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        castname = new javax.swing.JTextField();
        bt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        directorname = new javax.swing.JTextField();
        trailerbt = new javax.swing.JButton();
        imb = new javax.swing.JLabel();
        stars = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(photolb);
        photolb.setBounds(0, 0, 330, 500);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("movie name:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(380, 40, 110, 40);
        getContentPane().add(moviename);
        moviename.setBounds(511, 42, 240, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setText("star cast:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(380, 190, 120, 30);
        getContentPane().add(castname);
        castname.setBounds(510, 190, 240, 30);

        bt.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        bt.setText("play movie");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(590, 330, 180, 70);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setText("director:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(380, 120, 120, 30);
        getContentPane().add(directorname);
        directorname.setBounds(510, 110, 240, 40);

        trailerbt.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        trailerbt.setText("Play Trailer");
        getContentPane().add(trailerbt);
        trailerbt.setBounds(350, 330, 180, 70);
        getContentPane().add(imb);
        imb.setBounds(370, 250, 100, 50);
        getContentPane().add(stars);
        stars.setBounds(490, 260, 150, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btActionPerformed

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
            java.util.logging.Logger.getLogger(Movie_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Movie_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Movie_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Movie_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Movie_detail(0).setVisible(true);
                            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JTextField castname;
    private javax.swing.JTextField directorname;
    private javax.swing.JLabel imb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField moviename;
    private javax.swing.JLabel photolb;
    private javax.swing.JLabel stars;
    private javax.swing.JButton trailerbt;
    // End of variables declaration//GEN-END:variables
}
