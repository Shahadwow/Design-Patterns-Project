package Calc;

import java.awt.*;
import javax.swing.*;

// Handles ONLY the display - NO business logic
class DisplayManager {
    private JPanel resultsPanel;
    private JTextField current;
    private JTextField previous;
    
    public DisplayManager() {
        createUI();
    }
    
    private void createUI() {
        resultsPanel = new JPanel();
        resultsPanel.setBackground(new Color(34, 34, 34));
        resultsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        resultsPanel.setPreferredSize(new Dimension(320, 110));
        
        previous = new JTextField();
        previous.setEditable(false);
        previous.setBackground(new Color(21, 20, 22));
        previous.setFont(new Font("Century Gothic", Font.BOLD, 18));
        previous.setForeground(new Color(203, 198, 213));
        previous.setHorizontalAlignment(JTextField.RIGHT);
        previous.setBorder(null);
        resultsPanel.add(previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 50));
        
        current = new JTextField();
        current.setEditable(false);
        current.setBackground(new Color(41, 39, 44));
        current.setFont(new Font("Century Gothic", Font.BOLD, 24));
        current.setForeground(Color.WHITE);
        current.setHorizontalAlignment(JTextField.RIGHT);
        current.setBorder(null);
        resultsPanel.add(current, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 320, 60));
    }
    
    public void updateDisplay(String currentText, String previousText) {
        current.setText(currentText);
        previous.setText(previousText);
    }
    
    public JPanel getView() {
        return resultsPanel;
    }
}