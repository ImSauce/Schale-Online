
package Frame;

import Classes.Sounds;
import Classes.UIcolors;
import Run.run;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



//ssadasdasdasdasd
public class receipt extends javax.swing.JFrame {
 Connection con;
PreparedStatement pst;
    
    Sounds sound = new Sounds();
    private Clip clip;
    
        
    public String serverIP ;
    public String userID ;
    public String passwordID ;
    
    private final main mainInstance;
    
   
    public void forConnection(Connection conn, String serverIP,String userID ,String passwordID){
        this.con = conn;
        this.serverIP = serverIP;
        this.userID = userID;
        this.passwordID = passwordID;
        
        ip.setText(mainInstance.local2.getText());
        user.setText(mainInstance.local.getText());
        pass.setText(mainInstance.local3.getText());
        
    }
    
    private void connect(){
   
        forConnection(con,serverIP,userID,passwordID);
        
        
    serverCredentials sv = new serverCredentials();
    sv.setServerIP(ip.getText());
    sv.setUserID(user.getText());
    sv.setPass(pass.getText()); // Get password as char array and convert to String
   System.out.println(sv.getServerIP()+"     SERVER IP ----------");
    try {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://" + sv.getServerIP() + "/schale_online", sv.getUserID(), sv.getPass());
  
        System.out.println(sv.getServerIP()+"     SERVER IP ----------");
        
        
   
    } catch (ClassNotFoundException ex) { } catch (SQLException ex) {}
   
    }
    
    
    
    
    public receipt(main mainInstance) {
    initComponents(); 
     this.mainInstance = mainInstance;
     
     
    ip.setText(mainInstance.local.getText());
    user.setText(mainInstance.local2.getText());
    pass.setText(mainInstance.local3.getText());
    
    
    connect();
   
    
    
    setResizable(false);
    ImageIcon Mainicon = new ImageIcon("SCHALE_resized.jpg");
    setIconImage(Mainicon.getImage());
    setTitle("receipt");

    format_JTable();
    receiptInfo();
    
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Add a WindowListener to handle the closing event
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                // Hide the frame instead of closing
                setVisible(false);
                sound.playSound4(clip);
//                UIcolors receiptColor = new UIcolors();
//                receiptColor.UIcolor();
                

            }
        });
       
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        r_date = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        receiptTablePane = new javax.swing.JScrollPane();
        receiptTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        r_subtotal = new javax.swing.JLabel();
        r_tax = new javax.swing.JLabel();
        r_total = new javax.swing.JLabel();
        r_payment = new javax.swing.JLabel();
        r_change = new javax.swing.JLabel();
        r_number = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        pass = new javax.swing.JLabel();
        ip = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(457, 576));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/receipt title.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("<html>Schale WS Corp.\n<br> 16 avenue Kivotos Main St. </html>");

        r_date.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        r_date.setForeground(new java.awt.Color(0, 0, 0));
        r_date.setText("March 5, 2024");

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Receipt Number:");

        receiptTablePane.setBackground(new java.awt.Color(255, 255, 255));
        receiptTablePane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        receiptTablePane.setForeground(new java.awt.Color(255, 255, 255));
        receiptTablePane.setFocusable(false);
        receiptTablePane.setRequestFocusEnabled(false);

        receiptTable.setBackground(new java.awt.Color(255, 255, 255));
        receiptTable.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        receiptTable.setForeground(new java.awt.Color(0, 0, 0));
        receiptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "product", "cost", "stock", "total price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        receiptTable.setEnabled(false);
        receiptTable.setGridColor(new java.awt.Color(255, 255, 255));
        receiptTable.getTableHeader().setReorderingAllowed(false);
        receiptTablePane.setViewportView(receiptTable);
        if (receiptTable.getColumnModel().getColumnCount() > 0) {
            receiptTable.getColumnModel().getColumn(0).setResizable(false);
            receiptTable.getColumnModel().getColumn(1).setResizable(false);
            receiptTable.getColumnModel().getColumn(2).setResizable(false);
            receiptTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Item(s)");

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Unit Price");

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Quantity");

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Total Cost");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("-----------------------------------------------------------------------------------------");

        jLabel11.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("-----------------------------------------------------------------------------------------");

        jLabel12.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Thank you !");

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        r_subtotal.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        r_subtotal.setForeground(new java.awt.Color(0, 0, 0));
        r_subtotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_subtotal.setText("-----------------------------------------------------------------------------------");

        r_tax.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        r_tax.setForeground(new java.awt.Color(0, 0, 0));
        r_tax.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_tax.setText("-----------------------------------------------------------------------------------");

        r_total.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        r_total.setForeground(new java.awt.Color(0, 0, 0));
        r_total.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_total.setText("-----------------------------------------------------------------------------------");

        r_payment.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        r_payment.setForeground(new java.awt.Color(0, 0, 0));
        r_payment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_payment.setText("-----------------------------------------------------------------------------------");

        r_change.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        r_change.setForeground(new java.awt.Color(0, 0, 0));
        r_change.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        r_change.setText("-----------------------------------------------------------------------------------");

        r_number.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        r_number.setForeground(new java.awt.Color(0, 0, 0));
        r_number.setText("88002134");

        user.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        user.setForeground(new java.awt.Color(0, 0, 0));
        user.setText("Change:");

        pass.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        pass.setForeground(new java.awt.Color(0, 0, 0));
        pass.setText("Change:");

        ip.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        ip.setForeground(new java.awt.Color(0, 0, 0));
        ip.setText("Change:");

        jLabel9.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Subtotal");

        jLabel13.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Sales Tax");

        jLabel14.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Grand Total");

        jLabel15.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Payment");

        jLabel16.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Change");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sigma.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(r_payment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(r_total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(r_tax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(r_subtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_change, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(ip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(user)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pass))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel7)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel8)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(receiptTablePane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(r_date)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r_number, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(r_date)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(r_number))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(receiptTablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_tax)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_total)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_payment)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_change)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ip)
                    .addComponent(user)
                    .addComponent(pass))
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
    
    
    
    
    
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel pass;
    public javax.swing.JLabel r_change;
    public javax.swing.JLabel r_date;
    public javax.swing.JLabel r_number;
    public javax.swing.JLabel r_payment;
    public javax.swing.JLabel r_subtotal;
    public javax.swing.JLabel r_tax;
    public javax.swing.JLabel r_total;
    private javax.swing.JTable receiptTable;
    private javax.swing.JScrollPane receiptTablePane;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables



private void format_JTable() {
    JTableHeader header = receiptTable.getTableHeader();
    header.setVisible(false);
    
    DefaultTableCellRenderer Center = new DefaultTableCellRenderer();
    Center.setHorizontalAlignment(JLabel.CENTER);
    
    for (int i=0; i< 4;i++){
    
    receiptTable.getColumnModel().getColumn(i).setCellRenderer(Center);
    }
    
    receiptTable.setShowGrid(false);
    
    receiptTablePane.getColumnHeader().setVisible(false);
    
    receiptTablePane.getViewport().setBackground(Color.WHITE);
    receiptTablePane.getVerticalScrollBar().setBackground(Color.WHITE);
    receiptTablePane.getHorizontalScrollBar().setBackground(Color.WHITE);
   
       
}




public void receiptInfo(){
String sql = "SELECT * FROM cart";

    
    try {
        DefaultTableModel model = (DefaultTableModel) receiptTable.getModel();
        model.setRowCount(0);

        pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        
    while (rs.next()) {
    
        
        model.addRow(new Object[] {

            rs.getString(2),
            rs.getString(3),
            rs.getString(5),
            rs.getString(6)
           
            

        });
    }
        // update the student count shown in the upper right corner
       
   
        
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex); System.out.println(ex);
    }





}


}
