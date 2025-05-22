
package Frame;

import Classes.Sounds;
import Run.run;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class serverConfig extends javax.swing.JFrame {
    
    Clip clip;
    
    Sounds sound = new Sounds();
    private String serverIP ;
    private String userID ;
    private String passwordID ;

    public serverConfig() {
        initComponents();
        ImageIcon Mainicon = new ImageIcon ("SCHALE_resized.jpg");
        setIconImage(Mainicon.getImage());
        setSize(495, 290);
        setResizable(false);
        
    }

    Connection conn;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ConnectBT = new SystemOtherComps.PH_Button();
        pass_txtfld = new SystemOtherComps.PH_PasswordField();
        serverIP_txtfld = new SystemOtherComps.PH_TextField();
        userID_txtfld = new SystemOtherComps.PH_TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ConnectBT.setBackground(new java.awt.Color(0, 0, 0));
        ConnectBT.setForeground(new java.awt.Color(255, 255, 255));
        ConnectBT.setText("CONNECT");
        ConnectBT.setAA_BorderColor(new java.awt.Color(38, 38, 38));
        ConnectBT.setAA_ButtonColor(new java.awt.Color(0, 0, 0));
        ConnectBT.setAA_DrawBorder(true);
        ConnectBT.setAA_HoverColor(new java.awt.Color(20, 20, 20));
        ConnectBT.setAA_PressColor(new java.awt.Color(39, 39, 39));
        ConnectBT.setAA_RippleColor(new java.awt.Color(39, 39, 39));
        ConnectBT.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        ConnectBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectBTActionPerformed(evt);
            }
        });
        jPanel1.add(ConnectBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 370, 40));

        pass_txtfld.setForeground(new java.awt.Color(255, 255, 255));
        pass_txtfld.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pass_txtfld.setAA_TextHint("password");
        jPanel1.add(pass_txtfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 370, -1));

        serverIP_txtfld.setForeground(new java.awt.Color(255, 255, 255));
        serverIP_txtfld.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        serverIP_txtfld.setAA_TextHint("server IP");
        jPanel1.add(serverIP_txtfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 370, -1));

        userID_txtfld.setForeground(new java.awt.Color(255, 255, 255));
        userID_txtfld.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        userID_txtfld.setAA_TextHint("username");
        jPanel1.add(userID_txtfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 370, -1));

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel1.setText("SERVER CONFIGURATION");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 260, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/createacc.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, -10, 500, 300));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 260));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ConnectBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectBTActionPerformed
        serverCredentials sv = new serverCredentials();
        sv.setServerIP(serverIP_txtfld.getText());
        sv.setUserID(userID_txtfld.getText());
        sv.setPass(new String(pass_txtfld.getPassword())); // Get password as char array and convert to String

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + sv.getServerIP() + "/schale_online", sv.getUserID(), sv.getPass());
            sound.playSound3(clip);
            JOptionPane.showMessageDialog(this, "Connection Established!");
            serverIP = serverIP_txtfld.getText();
            userID = userID_txtfld.getText();
            passwordID = new String(pass_txtfld.getPassword());
            // Pass the connection to the login frame and open it
           // login loginFrame = new login(this);
//            loginFrame.forConnection(conn,serverIP,userID,passwordID);
//            loginFrame.setVisible(true);

            dispose(); // Close the current frame

        } catch (ClassNotFoundException ex) {
            sound.playSound4(clip);
            JOptionPane.showMessageDialog(this, "Error: MySQL JDBC Driver not found!", "Connection Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(serverConfig.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            sound.playSound4(clip);
            JOptionPane.showMessageDialog(this, "Error: Failed to connect to the database! Check server IP, username, and password.", "Connection Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(serverConfig.class.getName()).log(Level.SEVERE, null, ex);

        }

    }//GEN-LAST:event_ConnectBTActionPerformed

    
   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private SystemOtherComps.PH_Button ConnectBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private SystemOtherComps.PH_PasswordField pass_txtfld;
    private SystemOtherComps.PH_TextField serverIP_txtfld;
    private SystemOtherComps.PH_TextField userID_txtfld;
    // End of variables declaration//GEN-END:variables
}
