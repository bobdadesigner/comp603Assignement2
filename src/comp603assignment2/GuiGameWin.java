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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author xuchangs
 */
public class GuiGameWin extends JPanel {
    //this class is for create a panel when win the game, only display a win picture and exit button.

    private Image img;
    private JButton exitButton;

    public GuiGameWin() {
        super(new BorderLayout());
        this.exitButton = new JButton("EXIT");
        this.img = new ImageIcon("win.png").getImage();
        //create a exit button and image
        init();
    }

    private void init() {
        //thie method is mainly setup button and all mouse listener to change button colour when entered and exited
        exitButton.setForeground(Color.white);
        exitButton.setFont(new Font("Helvetica", Font.PLAIN, 16));
        exitButton.setBorderPainted(true);
        exitButton.setBorder(new LineBorder(Color.GRAY));
        exitButton.setBackground(Color.black);
        exitButton.setOpaque(true);
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

        this.add(exitButton, BorderLayout.SOUTH);
        this.setPreferredSize(new Dimension(800, 400));
        exitButton.setPreferredSize(new Dimension(200, 50));
        buttonListener listener = new buttonListener();
        exitButton.addActionListener(listener);
    }

    private class buttonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if (source == exitButton) {
                System.exit(0);
                //when exit button is press, problem quit.
            }
        }
    }

    public void addExitButtonActionListener(ActionListener l) {
        this.exitButton.addActionListener(l);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
        //draw image background

    }
}
