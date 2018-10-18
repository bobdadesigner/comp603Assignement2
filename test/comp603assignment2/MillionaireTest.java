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
    public void testQuestionSize() {
        //test the size of the question, there are total 30 question so the size should be 30.

        QuestionLoader loader = new QuestionLoader();

        List<Question> list = loader.load();

        assertEquals(list.size(), 30);
    }

    @Test
    public void testCorrectAnswer() {
        //test the correct answer, no matter if i giving a uppercase letter or lowercase letter should return correct.
        GuiMain game = new GuiMain();
        game.addButtonListeners();
        Question q = new Question("correct answer is c", "a", "b", "c", "d", "c");
        game.setCurrentQuestion(q, 4);

        assertEquals(game.correctAnswerOption, "C");
    }

    @Test
    public void testCurrentScore() {
        //test the current score.
        GuiMain game = new GuiMain();
        game.addButtonListeners();
        Question q = new Question("correct answer is c", "a", "b", "c", "d", "c");
        game.setCurrentQuestion(q, 4);

        assertEquals(game.score, 4);
    }

    @Test
    public void testRestartGame() {
        //test if restartGame method is call, the score should be restart to 0.
        GuiMain game = new GuiMain();
        game.addButtonListeners();
        Question q = new Question("correct answer is c", "a", "b", "c", "d", "c");
        game.setCurrentQuestion(q, 4);
        game.restartGame();

        assertEquals(game.score, 0);
    }

    @Test
    public void testCheckWrongAnswer() {
        //test if the answer is incorrect, than the score return 0.
        GuiMain game = new GuiMain();
        game.addButtonListeners();
        Question q = new Question("correct answer is c", "a", "b", "c", "d", "c");
        game.setCurrentQuestion(q, 4);
        game.checkAnswerAndStepForward("b");

        assertEquals(game.score, 0);
    }

    @Test
    public void testCorrectAnswerAndStepForward() {
        //test if the answer is correct, the socre plus 1.
        GuiMain game = new GuiMain();
        game.addButtonListeners();
        Question q = new Question("correct answer is c", "a", "b", "c", "d", "c");
        game.setCurrentQuestion(q, 4);
        game.checkAnswerAndStepForward("C");

        assertEquals(game.score, 5);
    }
}
