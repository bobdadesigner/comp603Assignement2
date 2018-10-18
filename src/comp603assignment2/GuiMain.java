/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp603assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author xuchang
 */
public class GuiMain extends JFrame {
    //this class is main contrl Gui panel

    private GuiGameSouth southPanel;
    //create botton buttons area
    private GuiGameCenter centerPanel;
    //create center questions display area
    private GuiGameEast eastPanel;
    //create right hand side score display area
    private Question currentQuestion;
    //create cuttent question
    private int score;
    private int currentIndex;
    //current index is keep track on how many question did user answer correct
    private String correctAnswerOption;
    private List<Question> questions;
    //create list of question
    private GuiGameLoseFrame gameLose;

    public GuiMain() {

        gameLose = new GuiGameLoseFrame();
        this.gameLose.setVisible(false);
        //create lose frame display when lost the game, set it unvisible in begining
        this.questions = new QuestionLoader().load();
        //create question loader method
        this.currentIndex = 0;
        Question q = this.questions.get(this.currentIndex);
        this.currentQuestion = q;
        int score = 0;

        this.southPanel = new GuiGameSouth(q.a, q.b, q.c, q.d);
        this.southPanel.setBackground(Color.black);
        this.add(this.southPanel, BorderLayout.SOUTH);
        //set up button panal and add to frame

        this.centerPanel = new GuiGameCenter(q.ask);
        this.centerPanel.setBackground(Color.black);
        this.add(this.centerPanel, BorderLayout.CENTER);
        //set up center panal and add to frame

        this.eastPanel = new GuiGameEast(score);
        this.eastPanel.setBackground(Color.BLACK);
        this.add(this.eastPanel, BorderLayout.EAST);
        //set up score display panal and add to frame

        this.centerPanel.setFocusable(true);
        this.centerPanel.requestFocusInWindow();

        this.setSize(new Dimension(950, 520));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setCurrentQuestion(q, score);
        //set up frame
    }

    public void setCurrentQuestion(Question q, int score) {
        //set up current question

        this.score = score;
        this.currentQuestion = q;
        if (q.a.equals(q.answer)) {
            this.correctAnswerOption = "A";
        } else if (q.b.equals(q.answer)) {
            this.correctAnswerOption = "B";
        } else if (q.c.equals(q.answer)) {
            this.correctAnswerOption = "C";
        } else {
            this.correctAnswerOption = "D";
        }
        this.centerPanel.setQuestion(q);
        this.southPanel.setQuestion(q);
        System.out.println("Correct Answer: " + this.correctAnswerOption);
        //this print method only for showing the correct answer in console, for testing only

    }

    private void checkAnswerAndStepForward(String answer) {
        //to check answer is correct or not, if correct go to next question, if not show lose panel.
        if (this.correctAnswerOption.equals(answer) && this.score < 9) {

            this.score += 1;
            this.eastPanel.setScore(score);
            if (++this.currentIndex == this.questions.size()) {
            }
            this.setCurrentQuestion(this.questions.get(this.currentIndex), score);
        } else if (this.correctAnswerOption.equals(answer) && this.score == 9) {
            this.score += 1;
            this.eastPanel.setScore(score);
            GuiGameWin win = new GuiGameWin();
            Frame(win);
        } else {

            this.score = 0;
            this.eastPanel.setScore(score);
            this.gameLose.setVisible(true);
            //lost panel set visible when lose the game
            System.out.println("Wrong answer!");
            //this print method only for testing only

        }
    }

    private void Frame(JPanel a) {
        //this method is for setup a new frame and JPanel to frame, I only use it for win panel
        JFrame frame = new JFrame("Who want to be Millionaire"); //create frame to hold our JPanel subclass	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(a);  //add instance of MyGUI to the frame
        frame.pack(); //resize frame to fit our Jpanel
        frame.setResizable(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        frame.setLocation(new Point((screenWidth / 2) - (frame.getWidth() / 2), (screenHeight / 2) - (frame.getHeight() / 2)));
        frame.setVisible(true);
    }

    private void restartGame() {
        //when lose set index and score to 0, and ready to restart
        this.currentIndex = 0;
        this.score = 0;
        this.setCurrentQuestion(this.questions.get(0), 0);
    }

    public void addButtonListeners() {
        //setup 4 bottons, when pressed, goto checkAnswerAndStepForwardMethod
        this.southPanel.addAButtonActionListener(l -> this.checkAnswerAndStepForward("A"));
        this.southPanel.addBButtonActionListener(l -> this.checkAnswerAndStepForward("B"));
        this.southPanel.addCButtonActionListener(l -> this.checkAnswerAndStepForward("C"));
        this.southPanel.addDButtonActionListener(l -> this.checkAnswerAndStepForward("D"));
    }

    public static void main(String[] args) {

        GuiMain game = new GuiMain();
        game.addButtonListeners();

    }

}
