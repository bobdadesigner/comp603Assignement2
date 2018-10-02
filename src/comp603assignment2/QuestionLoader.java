/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp603assignment2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author xuchang
 */
public class QuestionLoader {
    
    public List<Question> load() {
        return loadFromFile();
    }
    
    private List<Question> loadFromDatabase() {
        return null;
    }
    
    private List<Question> loadFromFile() {
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
        
        return list;
    }
}
