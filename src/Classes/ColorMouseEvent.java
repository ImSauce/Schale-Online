
package Classes;

import java.awt.Color;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorMouseEvent {
    private Clip clip;
    
    //GRAY #262626 // (38, 38, 38)
    //BLACK #000000 // (0, 0, 0)
    
    
    
    public void ColorlabelWhiteF (JLabel label)//mouse entered
    {
        
        label.setForeground(new Color (255,255,255));
    }
    
    public void ColorlabelGrayF (JLabel label)//mouse exited
    {
        
        label.setForeground(new Color (62,62,62));
    }
    
    
    public void AdminColorlabelGray (JLabel label)//mouse exited
    {
        
        label.setForeground(new Color (102,102,102));
    }
    
    
    
    public void ColorlabelBlack (JLabel label)//mouse exited
    {
        label.setBackground(new Color (0,0,0));  
        label.setForeground(new Color (255,255,255));
    }
    
    public void ColorlabelGray (JLabel label)//mouse entered
    {
        label.setBackground(new Color (38, 38, 38));  
        label.setForeground(new Color (255,255,255)); 
        playSound();
    }   
    
    
    
    public void ColorPanelBlack (JPanel panel)//mouse exited
    {
        panel.setBackground(new Color (21,21,21));  
        panel.setForeground(new Color (255,255,255));
        
    }
    
    public void ColorPanelGray (JPanel panel)//mouse entered
    {
        panel.setBackground(new Color (38, 38, 38));  
        panel.setForeground(new Color (255,255,255));
        playSound();
    }
    
    
    public void ColorPanelGray2 (JPanel panel)//mouse entered
    {
        panel.setBackground(new Color (38, 38, 38));  
        panel.setForeground(new Color (255,255,255));
        
    }
    
    
    
    
    
    
    
     private void playSound() {
        // Play the audio clip
        
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("GTAselect.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        if (clip != null) {
            clip.setFramePosition(0); // Rewind to the beginning
            clip.start();
        }
    }
    
    
}

