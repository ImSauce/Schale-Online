
package Classes;

import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class StartupMethods {
    
    
    
    public void ShopResize(JLabel ShopLabel){
    
    ImageIcon icon = new ImageIcon("ShopIcon.png"); // Replace "path_to_your_image.png" with the actual path to your image file

        // Get the original image
        Image image = icon.getImage();

        // Set the icon of the label
        ShopLabel.setIcon(icon);

        // Add a component listener to the label
        ShopLabel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Resize the image to fit the label
                int width = ShopLabel.getWidth();
                int height = ShopLabel.getHeight();
                Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                // Create a scaled ImageIcon
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                // Set the scaled icon of the label
                ShopLabel.setIcon(scaledIcon);
            }
        });
    
    
    }
    
    public void ProductResize(JLabel ProductLabel){
    ImageIcon icon2 = new ImageIcon("ProductIcon.png"); // Replace "path_to_your_image.png" with the actual path to your image file

        // Get the original image
        Image image2 = icon2.getImage();

        // Set the icon of the label
        ProductLabel.setIcon(icon2);

        // Add a component listener to the label
        ProductLabel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Resize the image to fit the label
                int width = ProductLabel.getWidth();
                int height = ProductLabel.getHeight();
                Image scaledImage2 = image2.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                // Create a scaled ImageIcon
                ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);

                // Set the scaled icon of the label
                ProductLabel.setIcon(scaledIcon2);
            }
        });
    
    }
    
    
    public void TransactionResize(JLabel TransactionLabel){
        
        ImageIcon icon3 = new ImageIcon("TransactionIcon.png"); // Replace "path_to_your_image.png" with the actual path to your image file

        // Get the original image
        Image image3 = icon3.getImage();

        // Set the icon of the label
        TransactionLabel.setIcon(icon3);

        // Add a component listener to the label
        TransactionLabel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Resize the image to fit the label
                int width = TransactionLabel.getWidth();
                int height = TransactionLabel.getHeight();
                Image scaledImage = image3.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                // Create a scaled ImageIcon
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                // Set the scaled icon of the label
                TransactionLabel.setIcon(scaledIcon);
            }
        });
    }
}
