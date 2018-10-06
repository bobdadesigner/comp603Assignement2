/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp603assignment2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author xuchang
 */
public class GuiGameCenter extends JPanel {

    private JLabel label;
    private String display;
    private Image img;

    public GuiGameCenter(String question) {
        this.img = new ImageIcon("background.png").getImage();
        this.display = question;
        init();
    }

    public void init() {
        this.label = new JLabel(display);
        this.label.setPreferredSize(new Dimension(600, 200));
        this.label.setForeground(Color.white);
        this.label.setFont(new Font("Helvetica", Font.PLAIN, 22));
        this.add(label);

    }

    public void setQuestion(Question q) {
        this.label.setText(q.ask);
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);

    }
}
