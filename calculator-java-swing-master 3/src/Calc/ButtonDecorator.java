
package Calc;

import javax.swing.JButton;
import java.awt.event.MouseListener;

public abstract class ButtonDecorator implements ButtonComponent {
    protected ButtonComponent decoratedButton;

    public ButtonDecorator(ButtonComponent decoratedButton) {
        this.decoratedButton = decoratedButton;
    }

    @Override
    public JButton getButton() {
        return decoratedButton.getButton();
    }
    
    @Override
    public void addDecoration(MouseListener listener) {
        decoratedButton.addDecoration(listener);
    }
}
