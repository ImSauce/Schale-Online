
package panels;

import Classes.ColorMouseEvent;
import Classes.MouseEnteredClass;
import Classes.ProductMethods;
import Classes.Sounds;
import Frame.View;
import Frame.main;
import Frame.serverCredentials;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.TableModel;


public class itemPanel extends javax.swing.JPanel {
    
Connection con = null;
PreparedStatement pst = null;
Statement st;

File f1 = null;
String  path1 = null;
private ImageIcon format1 = null;
String fname1=null;
int s1 =0;
byte [] pimage1=null;
    
   
    
    
    
    
    
private Clip clip;
  Sounds sound = new Sounds();
    private String productName;
    private int productPrice;
    private String productType;
    private String productDescription;
    public int productStock;
    public int productID;
    public ImageIcon productImage;
    private main main;
    
    public int power;
    public int firerate;
    public int reloadspeed;
    public int ammo;
    
    double money =0;
    
    public String serverIP ;
    public String userID ;
    public String passwordID ;
    
    
    public void forConnection(Connection conn, String serverIP,String userID ,String passwordID){
        this.con = conn;
        this.serverIP = serverIP;
        this.userID = userID;
        this.passwordID = passwordID;
        
        ip.setText(main.local2.getText());
        user.setText(main.local.getText());
        pass.setText(main.local3.getText());
        
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
    
    
    
    
    
    public itemPanel(main main) {
        initComponents();
       this.main = main;
       
       connect();
       
        System.out.println(money+"   -   1");
        if (productPrice <= money)
        {
            ProductCost.setForeground(new java.awt.Color(52, 196, 57));
        } 
        else {
        ProductCost.setForeground(new java.awt.Color(201,15,15));
        }
       
       
       
    }
    
    public void setStock(int productStock){
        
        
    
    
    }
    
    public void setDetails(String productName, int productPrice, String productType, String productDescription, int productStock, int productID, double money , int power , int firerate , int reloadspeed , int ammo) {
        ProductName.setText(productName);
        ProductCost.setText(String.valueOf(productPrice));
        ProductType.setText(productType);
        ProductStock.setText(Integer.toString(productStock));
        
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productType;
        this.productDescription = productDescription;
        this.productStock = productStock;
        this.productID = productID;
        this.money = money;
        
        this.power = power;
        this.firerate = firerate;
        this.reloadspeed = reloadspeed;
        this.ammo = ammo;
        System.out.println(money+"   -   2");
        
        
        if (productPrice <= money)
        {
            ProductCost.setForeground(new java.awt.Color(52, 196, 57));
        } 
        else {
        ProductCost.setForeground(new java.awt.Color(201,15,15));
        }
        
         
    }
     public void setProductImage(ImageIcon imageIcon) {
        ProductIcon.setIcon(imageIcon);
        
        this.productImage = imageIcon;
    }

    
    
            
     
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ItemPanel = new javax.swing.JPanel();
        ProductIcon = new javax.swing.JLabel();
        ProductName = new javax.swing.JLabel();
        ProductCost = new javax.swing.JLabel();
        ProductType = new javax.swing.JLabel();
        ProductType1 = new javax.swing.JLabel();
        ProductCost1 = new javax.swing.JLabel();
        ProductStock = new javax.swing.JLabel();
        ip = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        pass = new javax.swing.JLabel();

        ItemPanel.setBackground(new java.awt.Color(21, 21, 21));
        ItemPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ItemPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ItemPanelMouseExited(evt);
            }
        });

        ProductIcon.setToolTipText("right click to view details");
        ProductIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        ProductIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProductIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProductIconMouseExited(evt);
            }
        });

        ProductName.setFont(new java.awt.Font("Agency FB", 0, 20)); // NOI18N
        ProductName.setForeground(new java.awt.Color(255, 255, 255));
        ProductName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProductName.setText("AWT-59");

        ProductCost.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        ProductCost.setForeground(new java.awt.Color(52, 196, 57));
        ProductCost.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ProductCost.setText("200$");

        ProductType.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        ProductType.setForeground(new java.awt.Color(255, 255, 255));
        ProductType.setText("Sniper Rifle");

        ProductType1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        ProductType1.setForeground(new java.awt.Color(255, 255, 255));
        ProductType1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ProductType1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/smol gun.jpg"))); // NOI18N
        ProductType1.setIconTextGap(8);

        ProductCost1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        ProductCost1.setForeground(new java.awt.Color(255, 255, 255));
        ProductCost1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ProductCost1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/earnings.jpg"))); // NOI18N

        ProductStock.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        ProductStock.setForeground(new java.awt.Color(30, 30, 30));

        javax.swing.GroupLayout ItemPanelLayout = new javax.swing.GroupLayout(ItemPanel);
        ItemPanel.setLayout(ItemPanelLayout);
        ItemPanelLayout.setHorizontalGroup(
            ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemPanelLayout.createSequentialGroup()
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ItemPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ItemPanelLayout.createSequentialGroup()
                                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ProductCost1)
                                    .addComponent(ProductType1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ProductCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ProductType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(ProductIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ProductStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ItemPanelLayout.createSequentialGroup()
                                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        ItemPanelLayout.setVerticalGroup(
            ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemPanelLayout.createSequentialGroup()
                .addComponent(ProductName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ItemPanelLayout.createSequentialGroup()
                        .addComponent(ip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(user)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pass))
                    .addComponent(ProductIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProductType1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ProductType)
                        .addComponent(ProductStock)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProductCost1)
                    .addComponent(ProductCost))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ItemPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ItemPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemPanelMouseExited
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorPanelBlack(ItemPanel);
        
    }//GEN-LAST:event_ItemPanelMouseExited

    private void ItemPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemPanelMouseEntered
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorPanelGray(ItemPanel);
        
         
    }//GEN-LAST:event_ItemPanelMouseEntered

    private void ProductIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductIconMouseClicked

        if (evt.getButton() == MouseEvent.BUTTON3) {
        ViewDetails();
        
                
        sound.playSound3(clip);
        }else{
         main.setProductDetails(productName, productImage, productPrice, productType, productDescription, productStock, productID, power, firerate, reloadspeed, ammo);
         sound.playSound3(clip);
         }
    }//GEN-LAST:event_ProductIconMouseClicked

    private void ProductIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductIconMouseEntered
        ColorMouseEvent PanelColor = new ColorMouseEvent();
        PanelColor.ColorPanelGray2(ItemPanel);
    }//GEN-LAST:event_ProductIconMouseEntered

    private void ProductIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductIconMouseExited
       ColorMouseEvent PanelColor = new ColorMouseEvent();
       PanelColor.ColorPanelBlack(ItemPanel);
    }//GEN-LAST:event_ProductIconMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ItemPanel;
    private javax.swing.JLabel ProductCost;
    private javax.swing.JLabel ProductCost1;
    private javax.swing.JLabel ProductIcon;
    private javax.swing.JLabel ProductName;
    public javax.swing.JLabel ProductStock;
    private javax.swing.JLabel ProductType;
    private javax.swing.JLabel ProductType1;
    private javax.swing.JLabel ip;
    private javax.swing.JLabel pass;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables

public void updateProductStock(int newStock) {
    this.productStock = newStock;
}

public void refreshUI() {
    ProductStock.setText(Integer.toString(productStock));
  
}



public void ViewDetails(){
View view = new View();

view.powernum.setText(Integer.toString(power));
view.fireratenum.setText(Integer.toString(firerate));
view.reloadspeednum.setText(Integer.toString(reloadspeed));
view.ammonum.setText(Integer.toString(ammo));


view.cost.setText(Integer.toString(productPrice));
view.stock.setText(Integer.toString(productStock));
view.type.setText(productType);
view.name.setText(productName);
view.description.setText(productDescription);
view.id.setText(Integer.toString(productID));

view.powerstats();
view.fireratestats();
view.reloadspeedstats();
view.ammostats();


Image originalImage = productImage.getImage();
Image scaledImage = originalImage.getScaledInstance(200, 160, Image.SCALE_SMOOTH);
ImageIcon scaledIcon = new ImageIcon(scaledImage);
view.Icon.setIcon(scaledIcon);

view.setVisible(true);
}

public void ImageView(){
 
        String sql = "SELECT `imageName`, `imagePath`, `imageFile` FROM `product` WHERE id=?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, productID);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
//                imageName = rs.getString("syear1");
//                imagePath = rs.getString("syear2");
//                imageFile = rs.getString("bday");
//             
                
                
                
                
            } else {
                // Handle the case where no rows were found
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    
        
//        
//        studentView.setVisible(true);
//        studentView.pack();
//        studentView.setLocationRelativeTo(null);

//     
//        studentView.lastname.setText(Ln);
//        studentView.firstname.setText(Fn);
//        studentView.middlename.setText(Mn);
//        studentView.lrn.setText(Lrn);
//        studentView.contact.setText(Con);
     
        }

        

    }
