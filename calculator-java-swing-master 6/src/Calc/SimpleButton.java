package Calc;

import javax.swing.JButton;
import java.awt.event.MouseListener;

public class SimpleButton implements ButtonComponent {
    private final JButton button;

    public SimpleButton(JButton button) {
        this.button = button;
        button.setOpaque(true);          
        button.setContentAreaFilled(true);  
        button.setBorderPainted(false);
    }

    @Override
    public JButton getButton() {
        return button;
    }

    @Override
    public void addDecoration(MouseListener listener) {
        this.button.addMouseListener(listener);
    }
}