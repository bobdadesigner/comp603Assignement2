/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp603assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author xuchang
 */
public class GuiGameLose extends JPanel {

    private JLabel label;
    private Image img;
    private JButton exitButton, continueButton;

    public GuiGameLose() {
        super(new BorderLayout());
        label = new JLabel(new ImageIcon("gameOver.png"));
        this.exitButton = new JButton("EXIT");
        this.continueButton = new JButton("RESTART");
        init();
    }

    public void init() {

        exitButton.setForeground(Color.white);
        exitButton.setFont(new Font("Helvetica", Font.PLAIN, 16));
        exitButton.setBorderPainted(true);
        exitButton.setBorder(new LineBorder(Color.GRAY));
        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);
        exitButton.setPreferredSize(new Dimension(120, 50));

        continueButton.setForeground(Color.white);
        continueButton.setFont(new Font("Helvetica", Font.PLAIN, 16));
        continueButton.setBorderPainted(true);
        continueButton.setBorder(new LineBorder(Color.GRAY));
        continueButton.setBackground(Color.black);
        continueButton.setOpaque(true);
        continueButton.setPreferredSize(new Dimension(120, 50));

        exitButton.addMouseListener(new MouseListener() {
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
                exitButton.setBackground(Color.darkGray);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setBackground(Color.BLACK);
                repaint();
            }

        });

        continueButton.addMouseListener(new MouseListener() {
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
                continueButton.setBackground(Color.darkGray);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                continueButton.setBackground(Color.BLACK);
                repaint();
            }

        });

        JPanel southPanel = new JPanel();
        southPanel.add(continueButton);
        southPanel.add(exitButton);
        southPanel.setBackground(Color.black);
        this.add(label, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.PAGE_END);

    }

    public void addExitButtonActionListener(ActionListener l) {
        this.exitButton.addActionListener(l);
    }

    public void addContinueButtonActionListener(ActionListener l) {
        this.continueButton.addActionListener(l);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);

    }
}
