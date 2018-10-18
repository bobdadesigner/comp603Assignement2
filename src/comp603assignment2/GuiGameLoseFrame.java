/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp603assignment2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author xuchang
 */
public class GuiGameLoseFrame extends JFrame {
    //create a new JFrame when user lost the game, only display jpanel from GuiGameLose

    private GuiGameLose losePanel;

    public GuiGameLoseFrame() {
        losePanel = new GuiGameLose();
        this.add(this.losePanel, BorderLayout.SOUTH);
        this.losePanel.addContinueButtonActionListener(l -> this.setVisible(false));
        this.losePanel.addExitButtonActionListener(l -> System.exit(0));
        this.setSize(new Dimension(780, 400));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);
        //setup JFrame

    }


}
