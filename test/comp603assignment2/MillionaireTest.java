/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp603assignment2;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author xuchang
 */
public class MillionaireTest {
    
    public MillionaireTest() {
    }

    @Test
    public void testSomeMethod() {
                
        QuestionLoader loader = new QuestionLoader();
        
        List<Question> list = loader.load();
        
        assertEquals(list.size(), 3);
        
    }
    
}
