
package Frame;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ImageView extends javax.swing.JFrame {
  
 Connection con = null;
PreparedStatement pst = null;



ResultSet rs;

private ImageIcon format1 = null;




  public String serverIP ;
    public String userID ;
    public String passwordID ;
    
  
    
   
    public void forConnection(Connection conn, String serverIP,String userID ,String passwordID){
        this.con = conn;
        this.serverIP = serverIP;
        this.userID = userID;
        this.passwordID = passwordID;
        
        
    }
    
    private void connect(){
   
        forConnection(con,serverIP,userID,passwordID);
        
        
    serverCredentials sv = new serverCredentials();
    sv.setServerIP(ip.getText());
    sv.setUserID(user.getText());
    sv.setPass(pass.getText()); // Get password as char array and convert to String
   
    try {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://" + sv.getServerIP() + "/schale_online", sv.getUserID(), sv.getPass());
  
        
        
        
   
    } catch (ClassNotFoundException ex) { } catch (SQLException ex) {}
   
    }
    
    
    

    public ImageView() {
        initComponents();
        
        connect();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        view = new javax.swing.JLabel();
        ip = new javax.swing.JLabel();
        pass = new javax.swing.JLabel();
        user = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        view.setText("image");
        view.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(20, 20, 20), 3));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pass)
                            .addComponent(ip)
                            .addComponent(user))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(ip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel ip;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel pass;
    public javax.swing.JLabel user;
    private javax.swing.JLabel view;
    // End of variables declaration//GEN-END:variables
public void LoadImageID1(String ID){
      
       
  try {
       
        System.out.println(ID);
        
        pst = con.prepareStatement("SELECT imageFile FROM product WHERE id=?");
        pst.setString(1, ID);
        System.out.println(pst);
        // Execute the query and assign the result set to rs
        rs = pst.executeQuery();

        if (rs.next()){
        LoadImage1();
        
        
        
        } else {
            JOptionPane.showMessageDialog(this, "no image found");
        }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(ImageView.class.getName()).log(Level.SEVERE, null, ex);
    }
  
  
  
   }
   
   public void LoadImage1() {
    try {
        byte[] imagedata = rs.getBytes("imageFile");
        format1 = new ImageIcon(imagedata);
        Image img = format1.getImage();
        
        // Get the original width and height of the image
        int originalWidth = img.getWidth(null);
        int originalHeight = img.getHeight(null);
        
        // Set the ImageIcon to your label
        view.setIcon(format1);
        
        // Adjust the size of the label to fit the image
        view.setSize(originalWidth, originalHeight);
    } catch (SQLException ex) {
        Logger.getLogger(ImageView.class.getName()).log(Level.SEVERE, null, ex);
    }
}
   



}
