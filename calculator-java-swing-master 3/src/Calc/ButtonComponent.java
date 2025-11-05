
package Calc;

import javax.swing.JButton;
import java.awt.event.MouseListener;

public interface ButtonComponent {
    JButton getButton();
    void addDecoration(MouseListener listener);
}