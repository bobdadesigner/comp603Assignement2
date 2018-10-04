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
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author xuchang
 */
public class GuiGameLose extends JPanel {

    private JLabel label;
    private String display;
    private Image img;
    private JButton exitButton, continueButton;

    public GuiGameLose() {

        this.img = new ImageIcon("background.png").getImage();

        this.display = "YOU LOSE";
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
        exitButton.setPreferredSize(new Dimension(120, 80));

        continueButton.setForeground(Color.white);
        continueButton.setFont(new Font("Helvetica", Font.PLAIN, 16));
        continueButton.setBorderPainted(true);
        continueButton.setBorder(new LineBorder(Color.GRAY));
        continueButton.setBackground(Color.black);
        continueButton.setOpaque(true);
        continueButton.setPreferredSize(new Dimension(120, 80));

        this.label = new JLabel(display);
        this.setPreferredSize(new Dimension(780, 400));

        this.label.setPreferredSize(new Dimension(145, 350));
        this.label.setForeground(Color.white);

        this.label.setFont(new Font("Helvetica", Font.BOLD, 25));

        this.add(label);
        this.add(continueButton);
        this.add(exitButton);
        buttonListener listener = new buttonListener();
        exitButton.addActionListener(listener);
        continueButton.addActionListener(listener);

    }

    private class buttonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if (source == exitButton) {
                System.exit(0);
            } else if (source == continueButton) {
                
                GuiMain game = new GuiMain();
                game.addButtonListeners();

            }
        }
    }
//    public void addExitButtonActionListener(ActionListener l) {
//        this.exitButton.addActionListener(l);
//    }
//
//    public void addContinueButtonActionListener(ActionListener l) {
//        this.continueButton.addActionListener(l);
//    }

    public void setQuestion(Question q) {
        this.label.setText(q.ask);
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);

    }

    public static void main(String[] args) {

        GuiGameLose game = new GuiGameLose();

        JFrame frame = new JFrame("Who want to be Millionaire"); //create frame to hold our JPanel subclass	

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(game);  //add instance of MyGUI to the frame
        frame.pack(); //resize frame to fit our Jpanel
        frame.setResizable(true);

        //Position frame on center of screen 
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        frame.setLocation(new Point((screenWidth / 2) - (frame.getWidth() / 2), (screenHeight / 2) - (frame.getHeight() / 2)));
        //show the frame	
        frame.setVisible(true);

    }
}
