
package Classes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Popups {
    
    
    
    public void ElainaPopup(){
    
     ImageIcon icon2 = new ImageIcon("elaina.gif"); // Replace with your icon file path
            JLabel label2 = new JLabel("<html>calm down anon",icon2, JLabel.CENTER);

            label2.setHorizontalTextPosition(JLabel.CENTER);
            label2.setVerticalTextPosition(JLabel.BOTTOM);

            JOptionPane.showMessageDialog(null,label2,"Are you okay bruh?",JOptionPane.DEFAULT_OPTION);
    }
    
    public void NoStockPopup() {
        ImageIcon icon2 = new ImageIcon("out of stock icon.jpg"); // Replace with your icon file path
        
        JLabel label2 = new JLabel("OUT OF STOCK", icon2, JLabel.CENTER);
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setVerticalTextPosition(JLabel.BOTTOM);
        
        //JOptionPane.showMessageDialog(null, "SORRY OUT OF STOCK", "Error", JOptionPane.ERROR_MESSAGE);
        
        JOptionPane.showMessageDialog(null, "SORRY OUT OF STOCK", "oops", JOptionPane.ERROR_MESSAGE, icon2);
    }
    
    public void CheckPopup() {
        ImageIcon icon2 = new ImageIcon("checkmark.jpg"); // Replace with your icon file path
        
        JLabel label2 = new JLabel("OUT OF STOCK", icon2, JLabel.CENTER);
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setVerticalTextPosition(JLabel.BOTTOM);
        
        //JOptionPane.showMessageDialog(null, "SORRY OUT OF STOCK", "Error", JOptionPane.ERROR_MESSAGE);
        
        JOptionPane.showMessageDialog(null, "Connection Established", "SUCCESS", JOptionPane.ERROR_MESSAGE, icon2);
    }

    
    
    
}
