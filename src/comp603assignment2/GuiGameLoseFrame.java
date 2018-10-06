/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp603assignment2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author xuchang
 */
public class GuiGameLoseFrame extends JFrame {

    private GuiGameLose losePanel;
    private Image img;
    private JLabel label;
//    private JLabel img;

    public GuiGameLoseFrame() {

        this.img = new ImageIcon("logo.png").getImage();

        label = new JLabel(new ImageIcon("logo.png"));
        losePanel = new GuiGameLose();
        this.add(this.losePanel, BorderLayout.SOUTH);

        this.losePanel.addContinueButtonActionListener(l -> this.setVisible(false));
        this.losePanel.addExitButtonActionListener(l -> System.exit(0));
        this.setSize(new Dimension(780, 400));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);
        
    }

    public void paintComponent(Graphics g) {

        g.drawImage(img, 0, 0, this);

    }

    public static void main(String[] args) {
        GuiGameLoseFrame a = new GuiGameLoseFrame();
    }

}
