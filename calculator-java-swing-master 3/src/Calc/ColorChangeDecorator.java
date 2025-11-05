package Calc;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorChangeDecorator extends ButtonDecorator {

    public ColorChangeDecorator(ButtonComponent decoratedButton) {
        super(decoratedButton);
    }

    @Override
    public void addDecoration(MouseListener listener) {
        decoratedButton.getButton().addMouseListener(new MouseAdapter() { 

            @Override
            public void mouseEntered(MouseEvent e) {
                decoratedButton.getButton().setBackground(new Color(73, 69, 78));
                decoratedButton.getButton().repaint(); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                String text = decoratedButton.getButton().getText();
                
                if ("÷".equals(text) || "=".equals(text) 
                        || "←".equals(text) || "×".equals(text)
                        || "-".equals(text) || "+".equals(text)
                        || "C".equals(text)) {
                    decoratedButton.getButton().setBackground(new Color(41, 39, 44));
                } else {
                    decoratedButton.getButton().setBackground(new Color(21, 20, 22));
                }
                
                decoratedButton.getButton().repaint(); 
            }
        });
        
        decoratedButton.getButton().revalidate();
    }
}