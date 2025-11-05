package Calc;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.JButton;

public final class Calculator extends javax.swing.JFrame {
    private CalculatorFacade calculator;
    private int x, y;

    public Calculator() {
        initComponents();
        calculator = new CalculatorFacade();
        setupCalculatorSimple();
        addEvents();
    }

    private void setupCalculatorSimple() {
        app.add(calculator.getView(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 320, 110));
    }

public void addEvents() {
    
    JButton[] allButtons = {
        btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
        btnDiv, btnDot, btnEqual, btnDel, btnMult, btnPlus, btnPlusSub, btnSub, btnClear
    };

    // Number buttons
    btn0.addActionListener(e -> calculator.pressNumber("0"));
    btn1.addActionListener(e -> calculator.pressNumber("1"));
    btn2.addActionListener(e -> calculator.pressNumber("2"));
    btn3.addActionListener(e -> calculator.pressNumber("3"));
    btn4.addActionListener(e -> calculator.pressNumber("4"));
    btn5.addActionListener(e -> calculator.pressNumber("5"));
    btn6.addActionListener(e -> calculator.pressNumber("6"));
    btn7.addActionListener(e -> calculator.pressNumber("7"));
    btn8.addActionListener(e -> calculator.pressNumber("8"));
    btn9.addActionListener(e -> calculator.pressNumber("9"));

    // Operation buttons
    btnPlus.addActionListener(e -> calculator.pressOperation("+"));
    btnSub.addActionListener(e -> calculator.pressOperation("-"));
    btnMult.addActionListener(e -> calculator.pressOperation("×"));
    btnDiv.addActionListener(e -> calculator.pressOperation("÷"));
    
    btnEqual.addActionListener(e -> calculator.pressEquals());
    btnClear.addActionListener(e -> calculator.pressClear());
    btnDel.addActionListener(e -> calculator.pressDelete());
    btnPlusSub.addActionListener(e -> calculator.pressPlusMinus()); 
    btnDot.addActionListener(e -> calculator.pressDot());


    for (JButton btn : allButtons) {
        btn.setOpaque(true);
        btn.setContentAreaFilled(true);
        
        ButtonComponent decoratedBtn = new ColorChangeDecorator(new SimpleButton(btn));
        decoratedBtn.addDecoration(null); 
    }
}

    private void addButtonHoverEffects() {
        JButton[] allButtons = {
            btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnDiv, btnDot, btnEqual, btnDel, btnMult, btnPlus, 
            btnPlusSub, btnSub, btnClear
        };

        for (JButton btn : allButtons) {
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    ((JButton) e.getSource()).setBackground(new Color(73, 69, 78));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    Object b = e.getSource();
                    if (b == btnDiv || b == btnEqual || b == btnDel || 
                        b == btnMult || b == btnSub || b == btnPlus || b == btnClear || b == btnPlusSub) {
                        ((JButton) b).setBackground(new Color(41, 39, 44));
                    } else {
                        ((JButton) b).setBackground(new Color(21, 20, 22));
                    }
                }
            });
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        titleBar = new javax.swing.JPanel();
        btnMini = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        app = new javax.swing.JPanel();
        buttonsPanel = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnPlusSub = new javax.swing.JButton();
        btnDiv = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnMult = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btnSub = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btnPlus = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnDot = new javax.swing.JButton();
        btnEqual = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        titleBar.setBackground(new java.awt.Color(21, 20, 22));
        titleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titleBarMouseDragged(evt);
            }
        });
        titleBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titleBarMousePressed(evt);
            }
        });
        titleBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMini.setBackground(new java.awt.Color(21, 20, 22));
        btnMini.setFont(new java.awt.Font("Century Gothic", 0, 14));
        btnMini.setForeground(new java.awt.Color(255, 255, 255));
        btnMini.setText("−");
        btnMini.setBorder(null);
        btnMini.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMiniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMiniMouseExited(evt);
            }
        });
        btnMini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiniActionPerformed(evt);
            }
        });
        titleBar.add(btnMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 30, 30));

        btnClose.setBackground(new java.awt.Color(21, 20, 22));
        btnClose.setFont(new java.awt.Font("Century Gothic", 0, 14));
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("×");
        btnClose.setBorder(null);
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        titleBar.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 30, 30));

        title.setFont(new java.awt.Font("Century Gothic", 1, 14));
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Calculator");
        titleBar.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 250, 30));

        getContentPane().add(titleBar, java.awt.BorderLayout.PAGE_START);

        app = new javax.swing.JPanel();
        app.setBackground(new java.awt.Color(34, 34, 34));
        app.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonsPanel = new javax.swing.JPanel();
        buttonsPanel.setBackground(new java.awt.Color(34, 34, 34));
        buttonsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClear = new javax.swing.JButton();
        btnClear.setBackground(new java.awt.Color(41, 39, 44));
        btnClear.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("C");
        btnClear.setBorder(null);
        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 70));

        btnDel = new javax.swing.JButton();
        btnDel.setBackground(new java.awt.Color(41, 39, 44));
        btnDel.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btnDel.setForeground(new java.awt.Color(255, 255, 255));
        btnDel.setText("DEL");
        btnDel.setBorder(null);
        btnDel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 80, 70));

        // changed button ± to =
        btnPlusSub = new javax.swing.JButton();
        btnPlusSub.setBackground(new java.awt.Color(41, 39, 44));
        btnPlusSub.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btnPlusSub.setForeground(new java.awt.Color(255, 255, 255));
        btnPlusSub.setText("="); // changed symbol
        btnPlusSub.setBorder(null);
        btnPlusSub.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btnPlusSub, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 80, 70));

        btnDiv = new javax.swing.JButton();
        btnDiv.setBackground(new java.awt.Color(41, 39, 44));
        btnDiv.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btnDiv.setForeground(new java.awt.Color(255, 255, 255));
        btnDiv.setText("÷");
        btnDiv.setBorder(null);
        btnDiv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btnDiv, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 80, 70));

        btn7 = new javax.swing.JButton();
        btn7.setBackground(new java.awt.Color(21, 20, 22));
        btn7.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btn7.setForeground(new java.awt.Color(255, 255, 255));
        btn7.setText("7");
        btn7.setBorder(null);
        btn7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 80, 70));

        btn8 = new javax.swing.JButton();
        btn8.setBackground(new java.awt.Color(21, 20, 22));
        btn8.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btn8.setForeground(new java.awt.Color(255, 255, 255));
        btn8.setText("8");
        btn8.setBorder(null);
        btn8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 80, 70));

        btn9 = new javax.swing.JButton();
        btn9.setBackground(new java.awt.Color(21, 20, 22));
        btn9.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btn9.setForeground(new java.awt.Color(255, 255, 255));
        btn9.setText("9");
        btn9.setBorder(null);
        btn9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 80, 70));

        btnMult = new javax.swing.JButton();
        btnMult.setBackground(new java.awt.Color(41, 39, 44));
        btnMult.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btnMult.setForeground(new java.awt.Color(255, 255, 255));
        btnMult.setText("×");
        btnMult.setBorder(null);
        btnMult.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btnMult, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 80, 70));

        btn4 = new javax.swing.JButton();
        btn4.setBackground(new java.awt.Color(21, 20, 22));
        btn4.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btn4.setForeground(new java.awt.Color(255, 255, 255));
        btn4.setText("4");
        btn4.setBorder(null);
        btn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 80, 70));

        btn5 = new javax.swing.JButton();
        btn5.setBackground(new java.awt.Color(21, 20, 22));
        btn5.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btn5.setForeground(new java.awt.Color(255, 255, 255));
        btn5.setText("5");
        btn5.setBorder(null);
        btn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 80, 70));

        btn6 = new javax.swing.JButton();
        btn6.setBackground(new java.awt.Color(21, 20, 22));
        btn6.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btn6.setForeground(new java.awt.Color(255, 255, 255));
        btn6.setText("6");
        btn6.setBorder(null);
        btn6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 80, 70));

        btnSub = new javax.swing.JButton();
        btnSub.setBackground(new java.awt.Color(41, 39, 44));
        btnSub.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btnSub.setForeground(new java.awt.Color(255, 255, 255));
        btnSub.setText("-");
        btnSub.setBorder(null);
        btnSub.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btnSub, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 80, 70));

        btn1 = new javax.swing.JButton();
        btn1.setBackground(new java.awt.Color(21, 20, 22));
        btn1.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btn1.setForeground(new java.awt.Color(255, 255, 255));
        btn1.setText("1");
        btn1.setBorder(null);
        btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 80, 70));

        btn2 = new javax.swing.JButton();
        btn2.setBackground(new java.awt.Color(21, 20, 22));
        btn2.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btn2.setForeground(new java.awt.Color(255, 255, 255));
        btn2.setText("2");
        btn2.setBorder(null);
        btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 80, 70));

        btn3 = new javax.swing.JButton();
        btn3.setBackground(new java.awt.Color(21, 20, 22));
        btn3.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btn3.setForeground(new java.awt.Color(255, 255, 255));
        btn3.setText("3");
        btn3.setBorder(null);
        btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 80, 70));

        btnPlus = new javax.swing.JButton();
        btnPlus.setBackground(new java.awt.Color(41, 39, 44));
     btnPlus.setFont(new java.awt.Font("Century Gothic", 1, 20));
btnPlus.setText(" + "); 
btnPlus.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
btnPlus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnPlus.setForeground(new java.awt.Color(255, 255, 255));
    
        btnPlus.setBorder(null);
        btnPlus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btnPlus, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 80, 70));

        btn0 = new javax.swing.JButton();
        btn0.setBackground(new java.awt.Color(21, 20, 22));
        btn0.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btn0.setForeground(new java.awt.Color(255, 255, 255));
        btn0.setText("0");
        btn0.setBorder(null);
        btn0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 160, 70));

        btnDot = new javax.swing.JButton();
        btnDot.setBackground(new java.awt.Color(21, 20, 22));
        btnDot.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btnDot.setForeground(new java.awt.Color(255, 255, 255));
        btnDot.setText(".");
        btnDot.setBorder(null);
        btnDot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btnDot, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 80, 70));

        btnEqual = new javax.swing.JButton();
        btnEqual.setBackground(new java.awt.Color(41, 39, 44));
        btnEqual.setFont(new java.awt.Font("Century Gothic", 1, 18));
        btnEqual.setForeground(new java.awt.Color(255, 255, 255));
        btnEqual.setText("=");
        btnEqual.setBorder(null);
        btnEqual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonsPanel.add(btnEqual, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 80, 70));

        app.add(buttonsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 320, 350));

        getContentPane().add(app, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {
        btnClose.setBackground(new Color(255, 75, 75));
        btnClose.setForeground(new Color(31, 30, 33));
    }

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {
        btnClose.setBackground(new Color(21,20,22));
        btnClose.setForeground(Color.WHITE);
    }

    private void btnMiniMouseEntered(java.awt.event.MouseEvent evt) {
        btnMini.setBackground(new Color(73,69,78));
    }

    private void btnMiniMouseExited(java.awt.event.MouseEvent evt) {
        btnMini.setBackground(new Color(21,20,22));
    }

    private void btnMiniActionPerformed(java.awt.event.ActionEvent evt) {
        this.setState(ICONIFIED);
    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void titleBarMousePressed(java.awt.event.MouseEvent evt) {
        x = evt.getX();
        y = evt.getY();
    }

    private void titleBarMouseDragged(java.awt.event.MouseEvent evt) {
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx - x, yy - y);
    }

    private javax.swing.JPanel app;
    private javax.swing.JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private javax.swing.JButton btnClear, btnClose, btnDel, btnDiv, btnDot, btnEqual, btnMini, btnMult, btnPlus, btnPlusSub, btnSub;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JLabel title;
    private javax.swing.JPanel titleBar;
}