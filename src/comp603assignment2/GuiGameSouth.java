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

        aButton.setPreferredSize(new Dimension(200, 100));
        bButton.setPreferredSize(new Dimension(200, 100));
        cButton.setPreferredSize(new Dimension(200, 100));
        dButton.setPreferredSize(new Dimension(200, 100));

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

//    public static void main(String[] args) {
//
//        GuiGameSouth game = new GuiGameSouth("ab", "bc", "cd", "ef");
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
//    }

}
