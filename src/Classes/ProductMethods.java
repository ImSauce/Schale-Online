
package Classes;

import javax.swing.JLabel;
import java.awt.*;
import static java.awt.Color.BLACK;
import java.io.File;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProductMethods {
    Sounds sound = new Sounds();
    Clip clip;
    
  
    public void MenuClicked(int EditClicked, JLabel EditProductLabelProduct, int AddClicked, JLabel AddProductLabelProduct, int ShopClicked, JLabel FirearmLabelShop, int CartClicked, JLabel CartLabelShop, int TransactionClicked, JLabel TransactionLabelTransaction, int ImportClicked, JLabel ImportLabelTransaction, int EarningClicked,JLabel EarningLabelTransaction){
    if(EditClicked == 1){
    EditProductLabelProduct.setBorder(BorderFactory.createLineBorder(new Color(80,80,80)));
    }else{
        EditProductLabelProduct.setBorder(BorderFactory.createLineBorder(BLACK)); 
    }
 
    if(AddClicked == 1){
    AddProductLabelProduct.setBorder(BorderFactory.createLineBorder(new Color(80,80,80))); 
    }else{
        AddProductLabelProduct.setBorder(BorderFactory.createLineBorder(BLACK)); 
    }
    
    if(ShopClicked == 1){
    FirearmLabelShop.setBorder(BorderFactory.createLineBorder(new Color(80,80,80))); 
    }else{
        FirearmLabelShop.setBorder(BorderFactory.createLineBorder(BLACK)); 
    }
    
    if(CartClicked == 1){
    CartLabelShop.setBorder(BorderFactory.createLineBorder(new Color(80,80,80))); 
    }else{
        CartLabelShop.setBorder(BorderFactory.createLineBorder(BLACK)); 
    }
    
    if(TransactionClicked == 1){
    TransactionLabelTransaction.setBorder(BorderFactory.createLineBorder(new Color(80,80,80))); 
    }else{
        TransactionLabelTransaction.setBorder(BorderFactory.createLineBorder(BLACK)); 
    }
    
    if(ImportClicked == 1){
    ImportLabelTransaction.setBorder(BorderFactory.createLineBorder(new Color(80,80,80))); 
    }else{
        ImportLabelTransaction.setBorder(BorderFactory.createLineBorder(BLACK)); 
    }
    
    if(EarningClicked == 1){
    EarningLabelTransaction.setBorder(BorderFactory.createLineBorder(new Color(80,80,80))); 
    }else{
        EarningLabelTransaction.setBorder(BorderFactory.createLineBorder(BLACK)); 
    }
 
    }

    
    
    
    
  
    
    
     public void resetAddProduct(JTextField add_id, JTextField add_name, JTextField add_cost, JTextField add_stock, JTextPane add_description, JComboBox add_type, JTextField add_imageName, JTextField add_imagePath, JLabel productImage,JTextField add_importFee, JTextField add_power,JTextField add_firerate,JTextField add_reloadspeed,JTextField add_ammo){
        add_id.setText("");
        add_name.setText("");
        add_cost.setText("");
        add_stock.setText("");
        add_description.setText("");
        add_type.setSelectedItem("Handgun");
        add_imageName.setText("");
        add_imagePath.setText("");
        add_importFee.setText("0");
        //add_importFee.setForeground(new java.awt.Color(52, 196, 57));
        productImage.setIcon(new ImageIcon("insertimage.jpg"));
        
        add_power.setText("0");
        add_firerate.setText("0");
        add_reloadspeed.setText("0");
        add_ammo.setText("0");
       
        
        
 }
  
     
     public void resetEditProduct(JTextField add_id, JTextField add_name, JTextField add_cost, JTextField add_stock, JTextArea add_description, JComboBox add_type, JTextField add_imageName, JTextField add_imagePath, JLabel productImage,JTextField add_power,JTextField add_firerate,JTextField add_reloadspeed,JTextField add_ammo){
        add_id.setText("");
        add_name.setText("");
        add_cost.setText("");
        add_stock.setText("");
        add_description.setText("");
        add_type.setSelectedItem("Handgun");
        add_imageName.setText("");
        add_imagePath.setText("");
        productImage.setIcon(null);
        
        add_power.setText("");
        add_firerate.setText("");
        add_reloadspeed.setText("");
        add_ammo.setText("");
 }
     
     
     
     
     
     public void clicked(int powernum, JTextField p1, JTextField p2, JTextField p3, JTextField p4, JTextField p5, JTextField p6, JTextField p7, JTextField p8, JTextField p9, JTextField p10){
    switch (powernum){
        case 0: 
        p1.setBackground(new Color (21,21,21));
        p2.setBackground(new Color (21,21,21));
        p3.setBackground(new Color (21,21,21));
        p4.setBackground(new Color (21,21,21));
        p5.setBackground(new Color (21,21,21));
        p6.setBackground(new Color (21,21,21));
        p7.setBackground(new Color (21,21,21));
        p8.setBackground(new Color (21,21,21));
        p9.setBackground(new Color (21,21,21));
        p10.setBackground(new Color (21,21,21));
        break;
        
        case 1: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(21, 21, 21));
        p3.setBackground(new Color(21, 21, 21));
        p4.setBackground(new Color(21, 21, 21));
        p5.setBackground(new Color(21, 21, 21));
        p6.setBackground(new Color(21, 21, 21));
        p7.setBackground(new Color(21, 21, 21));
        p8.setBackground(new Color(21, 21, 21));
        p9.setBackground(new Color(21, 21, 21));
        p10.setBackground(new Color(21, 21, 21));
        break;

        case 2: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(21, 21, 21));
        p4.setBackground(new Color(21, 21, 21));
        p5.setBackground(new Color(21, 21, 21));
        p6.setBackground(new Color(21, 21, 21));
        p7.setBackground(new Color(21, 21, 21));
        p8.setBackground(new Color(21, 21, 21));
        p9.setBackground(new Color(21, 21, 21));
        p10.setBackground(new Color(21, 21, 21));
        break;

        case 3: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(204, 204, 204));
        p4.setBackground(new Color(21, 21, 21));
        p5.setBackground(new Color(21, 21, 21));
        p6.setBackground(new Color(21, 21, 21));
        p7.setBackground(new Color(21, 21, 21));
        p8.setBackground(new Color(21, 21, 21));
        p9.setBackground(new Color(21, 21, 21));
        p10.setBackground(new Color(21, 21, 21));
        break;

        case 4: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(204, 204, 204));
        p4.setBackground(new Color(204, 204, 204));
        p5.setBackground(new Color(21, 21, 21));
        p6.setBackground(new Color(21, 21, 21));
        p7.setBackground(new Color(21, 21, 21));
        p8.setBackground(new Color(21, 21, 21));
        p9.setBackground(new Color(21, 21, 21));
        p10.setBackground(new Color(21, 21, 21));
        break;

        case 5: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(204, 204, 204));
        p4.setBackground(new Color(204, 204, 204));
        p5.setBackground(new Color(204, 204, 204));
        p6.setBackground(new Color(21, 21, 21));
        p7.setBackground(new Color(21, 21, 21));
        p8.setBackground(new Color(21, 21, 21));
        p9.setBackground(new Color(21, 21, 21));
        p10.setBackground(new Color(21, 21, 21));
        break;
        
        case 6: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(204, 204, 204));
        p4.setBackground(new Color(204, 204, 204));
        p5.setBackground(new Color(204, 204, 204));
        p6.setBackground(new Color(204, 204, 204));
        p7.setBackground(new Color(21, 21, 21));
        p8.setBackground(new Color(21, 21, 21));
        p9.setBackground(new Color(21, 21, 21));
        p10.setBackground(new Color(21, 21, 21));
        break;

    case 7: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(204, 204, 204));
        p4.setBackground(new Color(204, 204, 204));
        p5.setBackground(new Color(204, 204, 204));
        p6.setBackground(new Color(204, 204, 204));
        p7.setBackground(new Color(204, 204, 204));
        p8.setBackground(new Color(21, 21, 21));
        p9.setBackground(new Color(21, 21, 21));
        p10.setBackground(new Color(21, 21, 21));
        break;

    case 8: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(204, 204, 204));
        p4.setBackground(new Color(204, 204, 204));
        p5.setBackground(new Color(204, 204, 204));
        p6.setBackground(new Color(204, 204, 204));
        p7.setBackground(new Color(204, 204, 204));
        p8.setBackground(new Color(204, 204, 204));
        p9.setBackground(new Color(21, 21, 21));
        p10.setBackground(new Color(21, 21, 21));
        break;

    case 9: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(204, 204, 204));
        p4.setBackground(new Color(204, 204, 204));
        p5.setBackground(new Color(204, 204, 204));
        p6.setBackground(new Color(204, 204, 204));
        p7.setBackground(new Color(204, 204, 204));
        p8.setBackground(new Color(204, 204, 204));
        p9.setBackground(new Color(204, 204, 204));
        p10.setBackground(new Color(21, 21, 21));
        break;

    case 10: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(204, 204, 204));
        p4.setBackground(new Color(204, 204, 204));
        p5.setBackground(new Color(204, 204, 204));
        p6.setBackground(new Color(204, 204, 204));
        p7.setBackground(new Color(204, 204, 204));
        p8.setBackground(new Color(204, 204, 204));
        p9.setBackground(new Color(204, 204, 204));
        p10.setBackground(new Color(204, 204, 204));
        break;

    }

    sound.playSound3(clip);
    }   
     
     
     
     
     public void clicked2(int powernum, JTextField p1, JTextField p2, JTextField p3, JTextField p4, JTextField p5, JTextField p6, JTextField p7, JTextField p8, JTextField p9, JTextField p10){
    switch (powernum){
        case 0: 
        p1.setBackground(new Color (21,21,21));
        p2.setBackground(new Color (21,21,21));
        p3.setBackground(new Color (21,21,21));
        p4.setBackground(new Color (21,21,21));
        p5.setBackground(new Color (21,21,21));
        p6.setBackground(new Color (21,21,21));
        p7.setBackground(new Color (21,21,21));
        p8.setBackground(new Color (21,21,21));
        p9.setBackground(new Color (21,21,21));
        p10.setBackground(new Color (21,21,21));
        break;
        
    }

 
    }   
     
     
     
     public void clicked3(int powernum, JTextField p1, JTextField p2, JTextField p3, JTextField p4, JTextField p5, JTextField p6, JTextField p7, JTextField p8, JTextField p9, JTextField p10){
    switch (powernum){
        case 0: 
        p1.setBackground(new Color (21,21,21));
        p2.setBackground(new Color (21,21,21));
        p3.setBackground(new Color (21,21,21));
        p4.setBackground(new Color (21,21,21));
        p5.setBackground(new Color (21,21,21));
        p6.setBackground(new Color (21,21,21));
        p7.setBackground(new Color (21,21,21));
        p8.setBackground(new Color (21,21,21));
        p9.setBackground(new Color (21,21,21));
        p10.setBackground(new Color (21,21,21));
        break;
        
        case 1: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(21, 21, 21));
        p3.setBackground(new Color(21, 21, 21));
        p4.setBackground(new Color(21, 21, 21));
        p5.setBackground(new Color(21, 21, 21));
        p6.setBackground(new Color(21, 21, 21));
        p7.setBackground(new Color(21, 21, 21));
        p8.setBackground(new Color(21, 21, 21));
        p9.setBackground(new Color(21, 21, 21));
        p10.setBackground(new Color(21, 21, 21));
        break;

        case 2: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(21, 21, 21));
        p4.setBackground(new Color(21, 21, 21));
        p5.setBackground(new Color(21, 21, 21));
        p6.setBackground(new Color(21, 21, 21));
        p7.setBackground(new Color(21, 21, 21));
        p8.setBackground(new Color(21, 21, 21));
        p9.setBackground(new Color(21, 21, 21));
        p10.setBackground(new Color(21, 21, 21));
        break;

        case 3: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(204, 204, 204));
        p4.setBackground(new Color(21, 21, 21));
        p5.setBackground(new Color(21, 21, 21));
        p6.setBackground(new Color(21, 21, 21));
        p7.setBackground(new Color(21, 21, 21));
        p8.setBackground(new Color(21, 21, 21));
        p9.setBackground(new Color(21, 21, 21));
        p10.setBackground(new Color(21, 21, 21));
        break;

        case 4: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(204, 204, 204));
        p4.setBackground(new Color(204, 204, 204));
        p5.setBackground(new Color(21, 21, 21));
        p6.setBackground(new Color(21, 21, 21));
        p7.setBackground(new Color(21, 21, 21));
        p8.setBackground(new Color(21, 21, 21));
        p9.setBackground(new Color(21, 21, 21));
        p10.setBackground(new Color(21, 21, 21));
        break;

        case 5: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(204, 204, 204));
        p4.setBackground(new Color(204, 204, 204));
        p5.setBackground(new Color(204, 204, 204));
        p6.setBackground(new Color(21, 21, 21));
        p7.setBackground(new Color(21, 21, 21));
        p8.setBackground(new Color(21, 21, 21));
        p9.setBackground(new Color(21, 21, 21));
        p10.setBackground(new Color(21, 21, 21));
        break;
        
        case 6: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(204, 204, 204));
        p4.setBackground(new Color(204, 204, 204));
        p5.setBackground(new Color(204, 204, 204));
        p6.setBackground(new Color(204, 204, 204));
        p7.setBackground(new Color(21, 21, 21));
        p8.setBackground(new Color(21, 21, 21));
        p9.setBackground(new Color(21, 21, 21));
        p10.setBackground(new Color(21, 21, 21));
        break;

    case 7: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(204, 204, 204));
        p4.setBackground(new Color(204, 204, 204));
        p5.setBackground(new Color(204, 204, 204));
        p6.setBackground(new Color(204, 204, 204));
        p7.setBackground(new Color(204, 204, 204));
        p8.setBackground(new Color(21, 21, 21));
        p9.setBackground(new Color(21, 21, 21));
        p10.setBackground(new Color(21, 21, 21));
        break;

    case 8: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(204, 204, 204));
        p4.setBackground(new Color(204, 204, 204));
        p5.setBackground(new Color(204, 204, 204));
        p6.setBackground(new Color(204, 204, 204));
        p7.setBackground(new Color(204, 204, 204));
        p8.setBackground(new Color(204, 204, 204));
        p9.setBackground(new Color(21, 21, 21));
        p10.setBackground(new Color(21, 21, 21));
        break;

    case 9: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(204, 204, 204));
        p4.setBackground(new Color(204, 204, 204));
        p5.setBackground(new Color(204, 204, 204));
        p6.setBackground(new Color(204, 204, 204));
        p7.setBackground(new Color(204, 204, 204));
        p8.setBackground(new Color(204, 204, 204));
        p9.setBackground(new Color(204, 204, 204));
        p10.setBackground(new Color(21, 21, 21));
        break;

    case 10: 
        p1.setBackground(new Color(204, 204, 204));
        p2.setBackground(new Color(204, 204, 204));
        p3.setBackground(new Color(204, 204, 204));
        p4.setBackground(new Color(204, 204, 204));
        p5.setBackground(new Color(204, 204, 204));
        p6.setBackground(new Color(204, 204, 204));
        p7.setBackground(new Color(204, 204, 204));
        p8.setBackground(new Color(204, 204, 204));
        p9.setBackground(new Color(204, 204, 204));
        p10.setBackground(new Color(204, 204, 204));
        break;

    }

  
    }   
     
     
     
}
