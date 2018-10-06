/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp603assignment2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author xuchang
 */
public class GuiGameSouth extends JPanel {

    private JButton aButton, bButton, cButton, dButton;

    String A, B, C, D;
    public final int WIDTH = 500;
    public final int HEIGTH = 500;

    public GuiGameSouth(String aAnswer, String bAnswer, String cAnswer, String dAnswer) {

        this.A = aAnswer;
        this.B = bAnswer;
        this.C = cAnswer;
        this.D = dAnswer;

        init();

    }

    public void setQuestion(Question q) {
        this.A = q.a;
        this.B = q.b;
        this.C = q.c;
        this.D = q.d;

        this.aButton.setText(A);
        this.bButton.setText(B);
        this.cButton.setText(C);
        this.dButton.setText(D);
//        this.repaint();
    }

    public void init() {

        aButton = new JButton(A);
        bButton = new JButton(B);
        cButton = new JButton(C);
        dButton = new JButton(D);

        aButton.setForeground(Color.white);
        aButton.setFont(new Font("Helvetica", Font.PLAIN, 16));
        aButton.setBorderPainted(true);
        aButton.setBorder(new LineBorder(Color.GRAY));
        aButton.setBackground(Color.black);
        aButton.setOpaque(true);

        bButton.setForeground(Color.white);
        bButton.setFont(new Font("Helvetica", Font.PLAIN, 16));
        bButton.setBorderPainted(true);
        bButton.setBorder(new LineBorder(Color.GRAY));
        bButton.setBackground(Color.black);
        bButton.setOpaque(true);

        cButton.setForeground(Color.white);
        cButton.setFont(new Font("Helvetica", Font.PLAIN, 16));
        cButton.setBorderPainted(true);
        cButton.setBorder(new LineBorder(Color.GRAY));
        cButton.setBackground(Color.black);
        cButton.setOpaque(true);

        dButton.setForeground(Color.white);
        dButton.setFont(new Font("Helvetica", Font.PLAIN, 16));
        dButton.setBorderPainted(true);
        dButton.setBorder(new LineBorder(Color.GRAY));
        dButton.setBackground(Color.black);
        dButton.setOpaque(true);

        aButton.setPreferredSize(new Dimension(200, 80));
        bButton.setPreferredSize(new Dimension(200, 80));
        cButton.setPreferredSize(new Dimension(200, 80));
        dButton.setPreferredSize(new Dimension(200, 80));

        aButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                aButton.setBackground(Color.darkGray);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                aButton.setBackground(Color.BLACK);
                repaint();
            }

        });

        bButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bButton.setBackground(Color.darkGray);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bButton.setBackground(Color.BLACK);
                repaint();
            }

        });

        cButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cButton.setBackground(Color.darkGray);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cButton.setBackground(Color.BLACK);
                repaint();
            }

        });

        dButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                dButton.setBackground(Color.darkGray);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                dButton.setBackground(Color.BLACK);
                repaint();
            }

        });

        this.add(aButton);
        this.add(bButton);
        this.add(cButton);
        this.add(dButton);
    }

    public void addAButtonActionListener(ActionListener l) {
        this.aButton.addActionListener(l);
    }

    public void addBButtonActionListener(ActionListener l) {
        this.bButton.addActionListener(l);
    }

    public void addCButtonActionListener(ActionListener l) {
        this.cButton.addActionListener(l);
    }

    public void addDButtonActionListener(ActionListener l) {
        this.dButton.addActionListener(l);
    }
}
