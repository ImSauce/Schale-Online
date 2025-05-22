
package Frame;

import Classes.ColorMouseEvent;
import Classes.Sounds;
import Classes.UIcolors;
import Run.run;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class createaccount extends javax.swing.JFrame {
     Connection con;
    PreparedStatement pat;
    ResultSet rs;
    int test;
    PreparedStatement pst;
    private Clip clip;
    
    Sounds sound = new Sounds();
    
        
    public String serverIP ;
    public String userID ;
    public String passwordID ;
    
    private final login loginInstance;
    
    public void forConnection(Connection conn, String serverIP,String userID ,String passwordID){
        this.con = conn;
        this.serverIP = serverIP;
        this.userID = userID;
        this.passwordID = passwordID;
        
        serverIP_txtfld.setText(loginInstance.s1.getText());
        userID_txtfld.setText(loginInstance.s2.getText());
        pass_txtfld.setText(loginInstance.s3.getText());
        
    }
    
    
    private void connect(){
        
        
    serverCredentials sv = new serverCredentials();
    sv.setServerIP(serverIP_txtfld.getText());
    sv.setUserID(userID_txtfld.getText());
    sv.setPass(pass_txtfld.getText()); // Get password as char array and convert to String
 
    try {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://" + sv.getServerIP() + "/schale_online", sv.getUserID(), sv.getPass());
     
     
        // Pass the connection to the login frame and open it
        
        forConnection(con,serverIP,userID,passwordID);
       
        
        
        
        
        
    } catch (ClassNotFoundException ex) {
       
    } catch (SQLException ex) {
       
    }
    
    }
    
    
ColorMouseEvent color = new ColorMouseEvent();
    public createaccount(login loginInstance) {
        initComponents();
        this.loginInstance = loginInstance;
        
        serverIP_txtfld.setText(loginInstance.s1.getText());
        userID_txtfld.setText(loginInstance.s2.getText());
        pass_txtfld.setText(loginInstance.s3.getText());

        connect();
        
        setSize(505, 329);
        setResizable(false);
        
        ImageIcon Mainicon = new ImageIcon ("SCHALE_resized.jpg");
        setIconImage(Mainicon.getImage());
        setTitle("create account");
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        signinlabel = new javax.swing.JLabel();
        password = new SystemOtherComps.PH_TextField();
        username = new SystemOtherComps.PH_TextField();
        currency = new SystemOtherComps.PH_TextField();
        createaccountlabel = new javax.swing.JLabel();
        signupBT = new SystemOtherComps.PH_Button();
        pass_txtfld = new javax.swing.JLabel();
        userID_txtfld = new javax.swing.JLabel();
        serverIP_txtfld = new javax.swing.JLabel();
        imagelabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signinlabel.setBackground(new java.awt.Color(33, 33, 33));
        signinlabel.setForeground(new java.awt.Color(62, 62, 62));
        signinlabel.setText("sign in?");
        signinlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signinlabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signinlabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signinlabelMouseExited(evt);
            }
        });
        getContentPane().add(signinlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 60, 20));

        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        password.setAA_TextHint("password");
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 400, -1));

        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        username.setAA_TextHint("username");
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 400, -1));

        currency.setForeground(new java.awt.Color(255, 255, 255));
        currency.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        currency.setAA_TextHint("cash");
        getContentPane().add(currency, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 400, -1));

        createaccountlabel.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        createaccountlabel.setText("CREATE ACCOUNT");
        createaccountlabel.setToolTipText("");
        getContentPane().add(createaccountlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 30));

        signupBT.setBackground(new java.awt.Color(0, 0, 0));
        signupBT.setForeground(new java.awt.Color(255, 255, 255));
        signupBT.setText("SIGN UP");
        signupBT.setAA_BorderColor(new java.awt.Color(38, 38, 38));
        signupBT.setAA_ButtonColor(new java.awt.Color(0, 0, 0));
        signupBT.setAA_DrawBorder(true);
        signupBT.setAA_HoverColor(new java.awt.Color(20, 20, 20));
        signupBT.setAA_PressColor(new java.awt.Color(39, 39, 39));
        signupBT.setAA_RippleColor(new java.awt.Color(80, 80, 80));
        signupBT.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        signupBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupBTActionPerformed(evt);
            }
        });
        getContentPane().add(signupBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 210, 40));

        pass_txtfld.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        pass_txtfld.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(pass_txtfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        userID_txtfld.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        userID_txtfld.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(userID_txtfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        serverIP_txtfld.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        serverIP_txtfld.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(serverIP_txtfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        imagelabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/elaina.gif"))); // NOI18N
        getContentPane().add(imagelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signinlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinlabelMouseClicked
     sound.playSound3(clip);
        loginInstance.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_signinlabelMouseClicked

    private void signinlabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinlabelMouseEntered
        color.ColorlabelWhiteF(signinlabel);
    }//GEN-LAST:event_signinlabelMouseEntered

    private void signinlabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinlabelMouseExited
        color.ColorlabelGrayF(signinlabel);
    }//GEN-LAST:event_signinlabelMouseExited

    private void signupBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupBTActionPerformed
        signUp();
        
    }//GEN-LAST:event_signupBTActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel createaccountlabel;
    private SystemOtherComps.PH_TextField currency;
    private javax.swing.JLabel imagelabel;
    private javax.swing.JLabel pass_txtfld;
    private SystemOtherComps.PH_TextField password;
    private javax.swing.JLabel serverIP_txtfld;
    private javax.swing.JLabel signinlabel;
    private SystemOtherComps.PH_Button signupBT;
    private javax.swing.JLabel userID_txtfld;
    private SystemOtherComps.PH_TextField username;
    // End of variables declaration//GEN-END:variables

public void signUp() {
    char[] enteredPasswordChars = password.getPassword();
    String enteredPassword = new String(enteredPasswordChars);
    
    try {
        // Check if any of the input fields are empty
        if (username.getText().isEmpty() || enteredPassword.isEmpty() || currency.getText().isEmpty()) {
            sound.playSound4(clip);
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            return;
        }
        
        String query2 = "INSERT INTO user(`username`, `password`, `money`, `admin`) VALUES(?,?,?,?)";
        
        pst = con.prepareStatement(query2);
       
        pst.setString(1, username.getText());
        pst.setString(2, enteredPassword);
        pst.setDouble(3, Double.parseDouble(currency.getText()));
        pst.setInt(4,0);
       
        pst.executeUpdate(); 
        
       
        signinlabelMouseClicked(null);
        sound.playSound5(clip);
            
    } catch (SQLException ex) {
        sound.playSound4(clip);
        if (ex.getMessage().contains("MySQLIntegrityConstraintViolationException")) {
            JOptionPane.showMessageDialog(null, "User already exists in the database.");
        } else {
            JOptionPane.showMessageDialog(null, "Error connecting to the database: " + ex.getMessage());
        }
    } catch (NumberFormatException ex) {
        sound.playSound4(clip);
        JOptionPane.showMessageDialog(null, "Invalid currency format. Please enter a valid number.");
    } catch (Exception ex) {
        sound.playSound4(clip);
        JOptionPane.showMessageDialog(null, "Error connecting to the database");
    }
}
}


