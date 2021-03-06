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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author xuchang
 */
public class GuiGameEast extends JPanel {
    //this calss is for display score on the right hand side.
    //the score is fixed, but the colour block behide will indicate what score level you are on.
    //for example, if socre is 1, the block will behide $100,000, if score is 2, the block will behide $200,000 so on and so forth.

    private JLabel label;
    private String score;
    private int squareX = 28;
    private int squareW = 105;
    private int squareH = 20;
    //coordinate where to draw the colour block behide the score board
    private int scoreY;
    private int[] squareY;

    public GuiGameEast(int scoreY) {
        this.scoreY = scoreY;
        squareY = new int[11];
        this.score = "<html><div style='text-align: center;'>1,000,000<BR>900,000<BR>800,000<BR>700,000<BR>600,000<BR>500,000<BR>400,000<BR>300,000<BR>200,000<BR>100,000</html>";
        //set score
        init();
    }

    public void init() {

        this.label = new JLabel(score);
        this.label.setForeground(Color.white);
        this.label.setBackground(Color.black);
        this.label.setFont(new Font("Helvetica", Font.BOLD, 20));
        this.label.setPreferredSize(new Dimension(150, 400));
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.label.setVerticalAlignment(JLabel.CENTER);
        this.add(label);
        //add a colour block to current score

    }

    public void setScore(int score) {
        this.scoreY = score;
        this.repaint();
        //set new score and repaint
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(70, 115, 140));

        int j = 289;
        squareY[0] = 500;
        for (int i = 1; i < squareY.length; i++) {
            squareY[i] = j;
            j -= 21;
        }
        g.fillRoundRect(squareX, squareY[scoreY], squareW, squareH, 12, 12);
        //draw a colour block to current score
    }

}
