
package Classes;
import javax.swing.*;
import javax.swing.event.*;

public class TextPaneUtils {
    
    public static void applyAutoLineBreak(JTextPane textPane, JScrollPane scrollPane) {
        textPane.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateText();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateText();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateText();
            }
            
            private void updateText() {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // Calculate number of visible lines
                        int visibleLines = scrollPane.getViewport().getHeight() / textPane.getFontMetrics(textPane.getFont()).getHeight();
                        // Get total lines in the document
                        int totalLines = (int) Math.ceil((double) textPane.getDocument().getLength() / textPane.getWidth());
                        // Check if total lines exceed visible lines
                        if (totalLines > visibleLines) {
                            // Insert line breaks
                            StringBuilder newText = new StringBuilder(textPane.getText());
                            for (int i = visibleLines; i < totalLines; i += visibleLines + 1) {
                                newText.insert(i * textPane.getWidth(), "\n");
                            }
                            textPane.setText(newText.toString());
                        }
                    }
                });
            }
        });
        
        scrollPane.getViewport().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateText();
            }
            
            private void updateText() {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        textPane.revalidate();
                        textPane.repaint();
                    }
                });
            }
        });
    }
}