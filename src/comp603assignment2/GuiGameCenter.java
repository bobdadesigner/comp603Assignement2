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
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
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

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);

    }

//    public static void main(String[] args) {
//
//        GuiGameCenter game = new GuiGameCenter("questions");
//
//        JFrame frame = new JFrame("Who want to be Millionaire"); //create frame to hold our JPanel subclass	
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(game);  //add instance of MyGUI to the frame
//        frame.pack(); //resize frame to fit our Jpanel
//        frame.setResizable(true);
//
//        //Position frame on center of screen 
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        Dimension d = tk.getScreenSize();
//        int screenHeight = d.height;
//        int screenWidth = d.width;
//        frame.setLocation(new Point((screenWidth / 2) - (frame.getWidth() / 2), (screenHeight / 2) - (frame.getHeight() / 2)));
//        //show the frame	
//        frame.setVisible(true);
//
//    }
}
