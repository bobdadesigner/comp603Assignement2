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
    //this class is to display a new panel when lost the game, with exit and restart button

    private JLabel label;
    private Image img;
    private JButton exitButton, restartButton;

    public GuiGameLose() {
        super(new BorderLayout());
        label = new JLabel(new ImageIcon("gameOver.png"));
        //create display picture
        this.exitButton = new JButton("EXIT");
        this.restartButton = new JButton("RESTART");
        //create exit and restart button

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
        //setup exit button

        restartButton.setForeground(Color.white);
        restartButton.setFont(new Font("Helvetica", Font.PLAIN, 16));
        restartButton.setBorderPainted(true);
        restartButton.setBorder(new LineBorder(Color.GRAY));
        restartButton.setBackground(Color.black);
        restartButton.setOpaque(true);
        restartButton.setPreferredSize(new Dimension(120, 50));
        //setup restart button

        exitButton.addMouseListener(new MouseListener() {
            //setup when mouse entered and exited button change colour
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

        restartButton.addMouseListener(new MouseListener() {
            //setup when mouse entered and exited button change colour
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
                restartButton.setBackground(Color.darkGray);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                restartButton.setBackground(Color.BLACK);
                repaint();
            }

        });

        JPanel southPanel = new JPanel();
        southPanel.add(restartButton);
        southPanel.add(exitButton);
        southPanel.setBackground(Color.black);
        this.add(label, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.PAGE_END);
        //add buttons and image to panel

    }

    public void addExitButtonActionListener(ActionListener l) {
        this.exitButton.addActionListener(l);
    }

    public void addContinueButtonActionListener(ActionListener l) {
        this.restartButton.addActionListener(l);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
        //display image background

    }
}
