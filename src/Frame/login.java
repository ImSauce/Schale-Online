
package Frame;

import Classes.ColorMouseEvent;
import Classes.Popups;
import Classes.Sounds;
import Run.run;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class login extends javax.swing.JFrame {
    Popups pop = new Popups();
    ColorMouseEvent color = new ColorMouseEvent();
    
    Connection con;
    PreparedStatement pat;
    ResultSet rs;
    int test;
    PreparedStatement pst;
    private Clip clip;
    public double moners = 0;
    
    public String serverIP ;
    public String userID ;
    public String passwordID ;
    
    Sounds sound = new Sounds();
    
    
    public void forConnection(Connection conn, String serverIP,String userID ,String passwordID){
        this.con = conn;
        this.serverIP = serverIP;
        this.userID = userID;
        this.passwordID = passwordID;
    }
    
    
    
    
    public login() {
        initComponents(); 
        sound.playSound3(clip);
        serverconfigpanel.setVisible(false);
        
        setSize(505, 333);
        setResizable(false);
        
        
        ImageIcon Mainicon = new ImageIcon ("SCHALE_resized.jpg");
        setIconImage(Mainicon.getImage());
        setTitle("login");
        connect();
        
    }

 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serverconfigpanel = new javax.swing.JPanel();
        ConnectBT = new SystemOtherComps.PH_Button();
        pass_txtfld = new SystemOtherComps.PH_PasswordField();
        serverIP_txtfld = new SystemOtherComps.PH_TextField();
        userID_txtfld = new SystemOtherComps.PH_TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backtologin = new javax.swing.JLabel();
        loginpanel = new SystemOtherComps.PH_Panel();
        titlelabel3 = new javax.swing.JLabel();
        ConnectionIcon = new javax.swing.JLabel();
        password = new SystemOtherComps.PH_PasswordField();
        logo = new javax.swing.JLabel();
        createanaccountlabel = new javax.swing.JLabel();
        enterBT = new SystemOtherComps.PH_Button();
        username = new SystemOtherComps.PH_TextField();
        titlelabel2 = new javax.swing.JLabel();
        titlelabel = new javax.swing.JLabel();
        s1 = new javax.swing.JLabel();
        s2 = new javax.swing.JLabel();
        s3 = new javax.swing.JLabel();
        imagelabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        serverconfigpanel.setBackground(new java.awt.Color(0, 0, 0));
        serverconfigpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ConnectBT.setBackground(new java.awt.Color(0, 0, 0));
        ConnectBT.setForeground(new java.awt.Color(255, 255, 255));
        ConnectBT.setText("CONNECT");
        ConnectBT.setAA_BorderColor(new java.awt.Color(38, 38, 38));
        ConnectBT.setAA_ButtonColor(new java.awt.Color(0, 0, 0));
        ConnectBT.setAA_DrawBorder(true);
        ConnectBT.setAA_HoverColor(new java.awt.Color(20, 20, 20));
        ConnectBT.setAA_PressColor(new java.awt.Color(30, 30, 30));
        ConnectBT.setAA_RippleColor(new java.awt.Color(80, 80, 80));
        ConnectBT.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        ConnectBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectBTActionPerformed(evt);
            }
        });
        serverconfigpanel.add(ConnectBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 370, 40));

        pass_txtfld.setForeground(new java.awt.Color(255, 255, 255));
        pass_txtfld.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pass_txtfld.setAA_TextHint("password");
        serverconfigpanel.add(pass_txtfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 370, -1));

        serverIP_txtfld.setForeground(new java.awt.Color(255, 255, 255));
        serverIP_txtfld.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        serverIP_txtfld.setText("localhost");
        serverIP_txtfld.setAA_TextHint("server IP");
        serverconfigpanel.add(serverIP_txtfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 370, -1));

        userID_txtfld.setForeground(new java.awt.Color(255, 255, 255));
        userID_txtfld.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        userID_txtfld.setText("root");
        userID_txtfld.setAA_TextHint("username");
        serverconfigpanel.add(userID_txtfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 370, -1));

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel1.setText("SERVER CONFIGURATION");
        serverconfigpanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 250, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/createacc.jpg"))); // NOI18N
        serverconfigpanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, -10, 500, 300));

        backtologin.setForeground(new java.awt.Color(62, 62, 62));
        backtologin.setText("<back");
        backtologin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backtologinMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backtologinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backtologinMouseExited(evt);
            }
        });
        serverconfigpanel.add(backtologin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(serverconfigpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 300));

        loginpanel.setBackground(new java.awt.Color(0, 0, 0));
        loginpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titlelabel3.setFont(new java.awt.Font("Agency FB", 0, 10)); // NOI18N
        titlelabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titlelabel3.setText("CONNECTION");
        loginpanel.add(titlelabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 60, 30));

        ConnectionIcon.setBackground(new java.awt.Color(55, 67, 89));
        ConnectionIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ConnectionIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nocon.jpg"))); // NOI18N
        ConnectionIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        ConnectionIcon.setOpaque(true);
        ConnectionIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConnectionIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ConnectionIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ConnectionIconMouseExited(evt);
            }
        });
        loginpanel.add(ConnectionIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 40, 40));

        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        password.setText("123");
        password.setAA_TextHint("password");
        loginpanel.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 400, -1));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginlogo.jpg"))); // NOI18N
        loginpanel.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 30, 30));

        createanaccountlabel.setBackground(new java.awt.Color(33, 33, 33));
        createanaccountlabel.setForeground(new java.awt.Color(62, 62, 62));
        createanaccountlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        createanaccountlabel.setText("create an account?");
        createanaccountlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createanaccountlabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createanaccountlabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createanaccountlabelMouseExited(evt);
            }
        });
        loginpanel.add(createanaccountlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 260, 110, 40));

        enterBT.setBackground(new java.awt.Color(0, 0, 0));
        enterBT.setForeground(new java.awt.Color(255, 255, 255));
        enterBT.setText("ENTER");
        enterBT.setAA_BorderColor(new java.awt.Color(38, 38, 38));
        enterBT.setAA_ButtonColor(new java.awt.Color(0, 0, 0));
        enterBT.setAA_DrawBorder(true);
        enterBT.setAA_HoverColor(new java.awt.Color(20, 20, 20));
        enterBT.setAA_PressColor(new java.awt.Color(39, 39, 39));
        enterBT.setAA_RippleColor(new java.awt.Color(80, 80, 80));
        enterBT.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        enterBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterBTActionPerformed(evt);
            }
        });
        loginpanel.add(enterBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 210, 40));

        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        username.setText("sam");
        username.setAA_TextHint("username");
        loginpanel.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 400, -1));

        titlelabel2.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        titlelabel2.setText("WEAPON STORE");
        loginpanel.add(titlelabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 60, 30));

        titlelabel.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        titlelabel.setText("SCHALE      NLINE");
        titlelabel.setToolTipText("");
        loginpanel.add(titlelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        s1.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        s1.setForeground(new java.awt.Color(0, 0, 0));
        loginpanel.add(s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        s2.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        s2.setForeground(new java.awt.Color(0, 0, 0));
        loginpanel.add(s2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        s3.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        s3.setForeground(new java.awt.Color(0, 0, 0));
        loginpanel.add(s3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        imagelabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gunlogin.jpg"))); // NOI18N
        loginpanel.add(imagelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(loginpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createanaccountlabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createanaccountlabelMouseEntered
        color.ColorlabelWhiteF(createanaccountlabel);
    }//GEN-LAST:event_createanaccountlabelMouseEntered

    private void createanaccountlabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createanaccountlabelMouseExited
        color.ColorlabelGrayF(createanaccountlabel);
    }//GEN-LAST:event_createanaccountlabelMouseExited

    private void createanaccountlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createanaccountlabelMouseClicked
        username.setText("");
        password.setText("");
        sound.playSound3(clip);
        createaccount create = new createaccount(this);
        create.serverIP = serverIP;
        create.userID = userID;
        create.passwordID = passwordID;
        
        create.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_createanaccountlabelMouseClicked

    private void enterBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterBTActionPerformed
      
        loginBT();
    }//GEN-LAST:event_enterBTActionPerformed

    private void backtologinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backtologinMouseClicked
        sound.playSound3(clip);
        loginpanel.setVisible(true);
        serverconfigpanel.setVisible(false);
    }//GEN-LAST:event_backtologinMouseClicked

    private void ConnectBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectBTActionPerformed
        connect();
        if (connected == true){
        sound.playSound5(clip);
        pop.CheckPopup();
        }
    }//GEN-LAST:event_ConnectBTActionPerformed

    private void ConnectionIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConnectionIconMouseClicked
        sound.playSound3(clip);
        loginpanel.setVisible(false);
        serverconfigpanel.setVisible(true);
    }//GEN-LAST:event_ConnectionIconMouseClicked

    private void ConnectionIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConnectionIconMouseEntered
        ConnectionIcon.setBackground(new Color (48,48,48));
    }//GEN-LAST:event_ConnectionIconMouseEntered

    private void ConnectionIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConnectionIconMouseExited
        ConnectionIcon.setBackground(new Color (55,67,89));
    }//GEN-LAST:event_ConnectionIconMouseExited

    private void backtologinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backtologinMouseEntered
        color.ColorlabelWhiteF(backtologin);
    }//GEN-LAST:event_backtologinMouseEntered

    private void backtologinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backtologinMouseExited
        color.ColorlabelGrayF(backtologin);
    }//GEN-LAST:event_backtologinMouseExited

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private SystemOtherComps.PH_Button ConnectBT;
    private javax.swing.JLabel ConnectionIcon;
    private javax.swing.JLabel backtologin;
    private javax.swing.JLabel createanaccountlabel;
    private SystemOtherComps.PH_Button enterBT;
    private javax.swing.JLabel imagelabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private SystemOtherComps.PH_Panel loginpanel;
    private javax.swing.JLabel logo;
    private SystemOtherComps.PH_PasswordField pass_txtfld;
    private SystemOtherComps.PH_PasswordField password;
    public javax.swing.JLabel s1;
    public javax.swing.JLabel s2;
    public javax.swing.JLabel s3;
    private SystemOtherComps.PH_TextField serverIP_txtfld;
    private javax.swing.JPanel serverconfigpanel;
    private javax.swing.JLabel titlelabel;
    private javax.swing.JLabel titlelabel2;
    private javax.swing.JLabel titlelabel3;
    private SystemOtherComps.PH_TextField userID_txtfld;
    private SystemOtherComps.PH_TextField username;
    // End of variables declaration//GEN-END:variables


    boolean connected = false;
    private void connect(){
    serverCredentials sv = new serverCredentials();
    sv.setServerIP(serverIP_txtfld.getText());
    sv.setUserID(userID_txtfld.getText());
    sv.setPass(new String(pass_txtfld.getPassword())); // Get password as char array and convert to String
    
    s1.setText(serverIP_txtfld.getText());
    s2.setText(userID_txtfld.getText());
    s3.setText(new String(pass_txtfld.getText()));
 
    try {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://" + sv.getServerIP() + "/schale_online", sv.getUserID(), sv.getPass());
        
        connected = true;
        serverIP = serverIP_txtfld.getText();
        userID = userID_txtfld.getText();
        passwordID = new String(pass_txtfld.getPassword());
        // Pass the connection to the login frame and open it
        
        forConnection(con,serverIP,userID,passwordID);
        loginpanel.setVisible(true);
        serverconfigpanel.setVisible(false);
        
    
        ImageIcon icon = new ImageIcon("connected.jpg");
        ConnectionIcon.setIcon(icon);
       
 
        
        
    } catch (ClassNotFoundException ex) {
        sound.playSound4(clip);
        JOptionPane.showMessageDialog(this, "Error: MySQL JDBC Driver not found!", "Connection Error", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(serverConfig.class.getName()).log(Level.SEVERE, null, ex);
        ImageIcon icon = new ImageIcon("nocon.jpg");
        ConnectionIcon.setIcon(icon);
        connected = false;
        
    } catch (SQLException ex) {
        sound.playSound4(clip);
        JOptionPane.showMessageDialog(this, "Connection Unsuccesful", "Connection Error", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(serverConfig.class.getName()).log(Level.SEVERE, null, ex);
        ImageIcon icon = new ImageIcon("nocon.jpg");
        ConnectionIcon.setIcon(icon);
        connected = false;
        
    }
    
    }
    
    
    
    
    private void loginBT() {
    char[] enteredPasswordChars = password.getPassword();
    String enteredPassword = new String(enteredPasswordChars);
    
    
    String sqlQuery = "SELECT * FROM user WHERE username = ? AND password = ?";
    try {
        pst = con.prepareStatement(sqlQuery);
        pst.setString(1, username.getText()); // Set the username parameter
        pst.setString(2, enteredPassword);
        rs = pst.executeQuery();
        
        if (rs.next()) {
            String usernameDB = rs.getString("username");
            String passwordDB = rs.getString("password");
            moners = rs.getDouble("money");
            
            // Check if the entered credentials are correct 
            if (usernameDB.equals(username.getText()) && passwordDB.equals(enteredPassword)) {
                
                setVisible(false);
                
                
                main main = new main(this);
                main.forConnection(con, serverIP, userID, passwordID);
                main.setVisible(true);
                
                
                NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
                DecimalFormat df = (DecimalFormat)nf;
                df.applyPattern("###,###.##");

                main.walletTxt.setText(df.format(moners));
                main.usernameMain.setText(usernameDB);
                main.passwordMain.setText(passwordDB);
                
               
            }
            
            else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            sound.playSound4(clip);
            JOptionPane.showMessageDialog(this, "User not found", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }

        // Close the ResultSet and PreparedStatement
        rs.close();
        pst.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
        System.out.println(ex);
    }
}

}
