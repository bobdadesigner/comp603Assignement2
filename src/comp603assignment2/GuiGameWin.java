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
 * @author xuchangs
 */
public class GuiGameWin extends JPanel {

    private Image img;
    private JButton exitButton;

    public GuiGameWin() {
                super(new BorderLayout());

        this.exitButton = new JButton("EXIT");
        this.img = new ImageIcon("win.png").getImage();
        init();
    }

    private void init() {
        exitButton.setForeground(Color.white);
        exitButton.setFont(new Font("Helvetica", Font.PLAIN, 16));
        exitButton.setBorderPainted(true);
        exitButton.setBorder(new LineBorder(Color.GRAY));
        exitButton.setBackground(Color.BLACK);
        exitButton.setOpaque(true);

        this.add(exitButton, BorderLayout.SOUTH);
//        this.add(this.img);
        this.setPreferredSize(new Dimension(800, 400));
        exitButton.setPreferredSize(new Dimension(200, 50));
        buttonListener listener = new buttonListener();
        exitButton.addActionListener(listener);

    }
    
    private class buttonListener implements ActionListener {
//
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if (source == exitButton) {
                System.exit(0);
            }
        }
    }

    public void addExitButtonActionListener(ActionListener l) {
        this.exitButton.addActionListener(l);
    }
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);

    }
    public static void main(String[] args) {

        GuiGameWin game = new GuiGameWin();

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
