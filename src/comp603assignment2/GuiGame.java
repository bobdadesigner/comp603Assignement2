/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp603assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author xuchang
 */
public class GuiGame extends JPanel {

    private JButton aButton, bButton, cButton, dButton;
    private JLabel label;
    String A, B, C, D;
    String question;
    public final int WIDTH = 500;
    public final int HEIGTH = 500;

    public GuiGame(String question, String aAnswer, String bAnswer, String cAnswer, String dAnswer) {
//        super();
        this.label = new JLabel(question);
        this.label.setPreferredSize(new Dimension(WIDTH, HEIGTH));

//        super.setPreferredSize(new Dimension(WIDTH, HEIGTH));
        super.setBackground(Color.WHITE);
        super.add(label);

        this.A = aAnswer;
        this.B = bAnswer;
        this.C = cAnswer;
        this.D = dAnswer;

        init();

    }

    private void init() {

//        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        aButton = new JButton(A);
        bButton = new JButton(B);
        cButton = new JButton(C);
        dButton = new JButton(D);

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
    
    private void addButtonListeners(){
        this.addAButtonActionListener(l->System.out.println("A"));
        this.addBButtonActionListener(l->System.out.println("B"));
        this.addCButtonActionListener(l->System.out.println("C"));
        this.addDButtonActionListener(l->System.out.println("D"));
    }

    public static void main(String[] args) {
   
        GuiGame game = new GuiGame("question", "ab", "bc", "cd", "ef");

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
        
        game.addButtonListeners();

        

    }

}
