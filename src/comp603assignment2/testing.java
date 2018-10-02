/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp603assignment2;
    import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author xuchang
 */
public class testing {



  public static void main(String[] args) {
     JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Who wants to be a Millionaire!");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    frame.setLayout(null);
    frame.setVisible(true);

    ImageIcon image = new ImageIcon("image1.png");
    JButton b1=new JButton(image);
    frame.add(b1);

    ImageIcon bg = new ImageIcon("image2.png");
    JLabel b2=new JLabel(bg);
    frame.add(b2);

    frame.setSize(1280, 800);
    b1.setBounds(400,650,414,60);
    b2.setBounds(1,1,1280,800);

    b1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {   

         frame.dispose();
         JFrame popup = new JFrame("Who wants to be a Millionaire!");
         ImageIcon q1 = new ImageIcon("question1.png");
         ImageIcon c1 = new ImageIcon("choice1.png");
         ImageIcon c2 = new ImageIcon("choice2.png");
         popup.setLayout(null);
         popup.setVisible(true);
         popup.setSize(1280, 800);

         JButton qC1=new JButton(c1);
         popup.add(qC1);
         JButton qC2=new JButton(c2);
         popup.add(qC2);
         JLabel qL1=new JLabel(q1);
         popup.add(qL1);



         qL1.setBounds(1,1,1280,800);
         qC1.setBounds(80,580,526,82);
         qC2.setBounds(650,580,526,82);

         qC1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {  
        JFrame correct = new JFrame("Who wants to be a Millionaire!");
        ImageIcon correct1 = new ImageIcon("correct.png");
        correct.setLayout(null);
        correct.setVisible(true);
        correct.setSize(420, 230);
        JLabel correct2=new JLabel(correct1);
        correct.add(correct2);
        correct2.setBounds(1,1,420,230);


      }});
      }
    });
  }
}