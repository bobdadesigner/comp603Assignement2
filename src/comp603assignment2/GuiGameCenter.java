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
    //this class is a center panel for display questions and background picture

    private JLabel label;
    private String display;
    private Image img;

    public GuiGameCenter(String question) {
        this.img = new ImageIcon("background.png").getImage();
        //set background picture to img
        this.display = question;
        //set question in display area
        init();
    }

    public void init() {
        this.label = new JLabel(display);
        this.label.setPreferredSize(new Dimension(600, 200));
        this.label.setForeground(Color.white);
        this.label.setFont(new Font("Helvetica", Font.PLAIN, 22));
        this.add(label);
        //display question on display area

    }

    public void setQuestion(Question q) {
        this.label.setText(q.ask);
        //set new question
        this.repaint();
        //repaint question area
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
        //display background picture
    }
}
