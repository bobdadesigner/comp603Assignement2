/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp603assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author xuchang
 */
public class GuiMain extends JFrame {

    private GuiGameSouth southPanel;
    private GuiGameCenter centerPanel;
    private GuiGameEast eastPanel;
    private String question;
    private int score;
    private String A, B, C, D;
    
    


    public GuiMain() {

    }

    public void init(String questions, String A, String B, String C, String D, int score) {

        this.score = score;
        this.question = questions;

        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;

        this.southPanel = new GuiGameSouth(this.A, this.B, this.C, this.D);
        this.southPanel.setBackground(Color.black);
        this.add(this.southPanel, BorderLayout.SOUTH);

        this.centerPanel = new GuiGameCenter(question);
        this.centerPanel.setBackground(Color.black);
        this.add(this.centerPanel, BorderLayout.CENTER);

        this.eastPanel = new GuiGameEast(score);
        this.eastPanel.setBackground(Color.BLACK);

        this.add(this.eastPanel, BorderLayout.EAST);

        this.centerPanel.setFocusable(true);
        this.centerPanel.requestFocusInWindow();

        this.setSize(new Dimension(950, 520));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);

    }

    public void addButtonListeners() {
        this.southPanel.addAButtonActionListener(l -> System.out.println("A"));
        this.southPanel.addBButtonActionListener(l -> System.out.println("B"));
        this.southPanel.addCButtonActionListener(l -> System.out.println("C"));
        this.southPanel.addDButtonActionListener(l -> System.out.println("D"));
    }

    public static void main(String[] args) {

        GuiMain game = new GuiMain();
        

 
        
        

            game.init("question", "A", "B", "C", "D", 5);
            game.addButtonListeners();


//        game.init("question", "A", "B", "C", "D", 5);
//        game.addButtonListeners();

    }

}
