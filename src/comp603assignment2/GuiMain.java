/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp603assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author xuchang
 */
public class GuiMain extends JFrame {

    private GuiGameSouth southPanel;
    private GuiGameCenter centerPanel;
    private GuiGameEast eastPanel;
    private Question currentQuestion;
    private int score;
    private int currentIndex;
    private String correctAnswerOption;
    private List<Question> questions;


    public GuiMain() {
        this.questions = new QuestionLoader().load();
        
        this.currentIndex = 0;
        Question q = this.questions.get(this.currentIndex);
        this.currentQuestion = q;
        int score = 0;
        this.southPanel = new GuiGameSouth(q.a, q.b, q.c, q.d);
        this.southPanel.setBackground(Color.black);
        this.add(this.southPanel, BorderLayout.SOUTH);

        this.centerPanel = new GuiGameCenter(q.ask);
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
        
        this.setCurrentQuestion(q, score);
    }

    public void setCurrentQuestion(Question q, int score) {

        this.score = score;
        this.currentQuestion = q;
        
        if (q.a.equals(q.answer)) this.correctAnswerOption = "A";
        else if (q.b.equals(q.answer)) this.correctAnswerOption = "B";
        else if (q.c.equals(q.answer)) this.correctAnswerOption = "C";
        else this.correctAnswerOption = "D";
            
        
        this.centerPanel.setQuestion(q);
        this.southPanel.setQuestion(q);

    }
    
    private void checkAnswerAndStepForward(String answer) {
        
        if (this.correctAnswerOption.equals(answer)) {
            this.score += 1;
            
            if (++this.currentIndex == this.questions.size()) {
                // TODO: Show won panel.
            }
            this.setCurrentQuestion(this.questions.get(this.currentIndex), score);
        } else {
            this.score = 0;
            // TODO:
            // Show failed, and start new game.
            System.out.println("Wrong answer!");
        }
    }
    
    
    private void restartGame() {
        this.currentIndex = 0;
        this.score = 0;
        
        this.setCurrentQuestion(this.questions.get(0), 0);
    }

    public void addButtonListeners() {
        this.southPanel.addAButtonActionListener(l -> this.checkAnswerAndStepForward("A"));
        this.southPanel.addBButtonActionListener(l -> this.checkAnswerAndStepForward("B"));
        this.southPanel.addCButtonActionListener(l -> this.checkAnswerAndStepForward("C"));
        this.southPanel.addDButtonActionListener(l -> this.checkAnswerAndStepForward("D"));
    }

    public static void main(String[] args) {

        GuiMain game = new GuiMain();
        
        game.addButtonListeners();


//        game.init("question", "A", "B", "C", "D", 5);
//        game.addButtonListeners();

    }
    
    private static void loadData() {
    }

}
