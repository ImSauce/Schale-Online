
package Classes;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class MouseExitedClass {
    
    public void MouseEnteredShop(JLabel label){
    ImageIcon icon = new ImageIcon("ShopIcon.png"); // Replace "path_to_your_image.png" with the actual path to your image file

        // Get the original image
        Image image = icon.getImage();

        // Set the icon of the label
        label.setIcon(icon);

        // Add a component listener to the label
       
                // Resize the image to fit the label
                int width = label.getWidth();
                int height = label.getHeight();
                Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                // Create a scaled ImageIcon
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                // Set the scaled icon of the label
                label.setIcon(scaledIcon);
    
    }
    
    public void MouseEnteredProduct(JLabel label){
    ImageIcon icon = new ImageIcon("ProductIcon.png"); // Replace "path_to_your_image.png" with the actual path to your image file

        // Get the original image
        Image image = icon.getImage();

        // Set the icon of the label
        label.setIcon(icon);

        // Add a component listener to the label
       
                // Resize the image to fit the label
                int width = label.getWidth();
                int height = label.getHeight();
                Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                // Create a scaled ImageIcon
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                // Set the scaled icon of the label
                label.setIcon(scaledIcon);
    
    }
    
    public void MouseEnteredTransaction(JLabel label){
    ImageIcon icon = new ImageIcon("TransactionIcon.png"); // Replace "path_to_your_image.png" with the actual path to your image file

        // Get the original image
        Image image = icon.getImage();

        // Set the icon of the label
        label.setIcon(icon);

        // Add a component listener to the label
       
                // Resize the image to fit the label
                int width = label.getWidth();
                int height = label.getHeight();
                Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                // Create a scaled ImageIcon
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                // Set the scaled icon of the label
                label.setIcon(scaledIcon);
    
    }
    
}
