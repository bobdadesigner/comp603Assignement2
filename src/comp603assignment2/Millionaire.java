package comp603assignment2;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JFrame;

public class Millionaire {

    public static void main(String[] args) {

        //load list
        List<Question> list = new ArrayList<>();
        String str = null;
        BufferedReader br;
        try {
            //Create a IO stream
            br = new BufferedReader(new FileReader("/Users/xuchang/Documents/GitHub/comp603Assignment2/Comp603Assignment2/question.txt"));
            int i = 0;

            do {
                Question q = new Question();
                for (int j = 0; j < 10; j++) {
                    str = br.readLine();
                    //if is in the second line
                    if (i % 10 == 1) {
                        q.setAsk(str.trim());
                    }
                    //if is in the fourth line
                    if (i % 10 == 3) {
                        q.setA(str.trim().substring(1));
                    }
                    //if is in the fifth line
                    if (i % 10 == 4) {
                        q.setB(str.trim().substring(1));
                    }
                    //if is in the sixth line
                    if (i % 10 == 5) {
                        q.setC(str.trim().substring(1));
                    }
                    //if is in the seventh line
                    if (i % 10 == 6) {
                        q.setD(str.trim().substring(1));
                    }
                    //if is in the ninth line
                    if (i % 10 == 8) {
                        q.setAnswer(str.trim().split(":")[1].trim());
                    }

                    i++;
                }
                //add q to the list
                list.add(q);
            } while (str != null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //to make the questions in random order
        Collections.shuffle(list);
        //��ʼ����
        startgame(list);

    }

    public static Object startgame(List<Question> list) {
        System.out.println("***************Who Wants To Be A Millionaire****************");
        System.out.println("You have to answer 20 questions correctly.Wrong, program exit");
        System.out.println(" ***********************Game Start***************************");

        Scanner sc = new Scanner(System.in);
        int bonus = 0;
        for (int i = 0; i < 20; i++) {
            Question q = list.get(i);
            System.out.println(q.getAsk());
            System.out.println("A " + q.getA());
            System.out.println("B " + q.getB());
            System.out.println("C " + q.getC());
            System.out.println("D " + q.getD());
            System.out.println("Your Answer is:");

            //////////////////////////////////         
//            GuiGame game = new GuiGame(q.getAsk(), q.getA(), q.getB(), q.getC(), q.getD());
//
//            JFrame frame = new JFrame("Who want to be Millionaire"); //create frame to hold our JPanel subclass	
//
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.getContentPane().add(game);  //add instance of MyGUI to the frame
//            frame.pack(); //resize frame to fit our Jpanel
//            frame.setResizable(true);
//
//            //Position frame on center of screen 
//            Toolkit tk = Toolkit.getDefaultToolkit();
//            Dimension d = tk.getScreenSize();
//            int screenHeight = d.height;
//            int screenWidth = d.width;
//            frame.setLocation(new Point((screenWidth / 2) - (frame.getWidth() / 2), (screenHeight / 2) - (frame.getHeight() / 2)));
//            //show the frame	
//            frame.setVisible(true);

            //////////////////////////////////          
            Map<String, String> map = new HashMap<>();

            map.put(q.getA(), "A");
            map.put(q.getB(), "B");
            map.put(q.getC(), "C");
            map.put(q.getD(), "D");

            String inp = sc.nextLine();
            //if your input equals the answer of the question
            if (inp.equals(map.get(q.getAnswer())) || inp.equals(map.get(q.getAnswer()).toLowerCase())) {
                bonus += 50000;
                System.out.println("Congratulations, you're right.Bonus plus 50000$.");
                System.out.println("Now your total bonus is " + bonus + "$.");
            } else {
                System.out.println("Sorry, challenge failed.");
                return startgame(list);
            }
        }

        System.out.println(
                "You have been a millionaire!");
        //Write the player's name to the file.
        try {
            FileWriter out = new FileWriter("e:\\record.txt", true);
            BufferedWriter bw = new BufferedWriter(out);
            System.out.println("Please input your name:");
            String name = sc.nextLine();
            try {
                bw.write(name);
                bw.newLine();
                bw.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return null;
    }

}
