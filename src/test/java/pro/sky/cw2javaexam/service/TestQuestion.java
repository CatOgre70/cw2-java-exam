package pro.sky.cw2javaexam.service;

import org.junit.jupiter.api.Test;
import pro.sky.cw2javaexam.database.Question;
import pro.sky.cw2javaexam.exceptions.WrongQuestionOrAnswerException;
import static org.junit.jupiter.api.Assertions.*;

public class TestQuestion {

    private static final String VALID_TEST1 = "abc";
    private static final String VALID_TEST2 = "Папа у Васи силен в математике...";
    private static final String NOT_VALID_TEST1 = null;
    private static final String NOT_VALID_TEST2 = "";


    @Test
    public void testConstructorOnException(){

        assertThrows(WrongQuestionOrAnswerException.class, () -> new Question(VALID_TEST1, NOT_VALID_TEST1));
        assertThrows(WrongQuestionOrAnswerException.class, () -> new Question(VALID_TEST2, NOT_VALID_TEST1));
        assertThrows(WrongQuestionOrAnswerException.class, () -> new Question(VALID_TEST1, NOT_VALID_TEST2));
        assertThrows(WrongQuestionOrAnswerException.class, () -> new Question(VALID_TEST2, NOT_VALID_TEST2));

    }

    @Test
    public void testGetQuestion(){
        Question q = new Question(VALID_TEST1, VALID_TEST2);
        assertEquals(VALID_TEST1, q.getQuestion());
    }

    @Test
    public void testGetAnswer(){
        Question q = new Question(VALID_TEST1, VALID_TEST2);
        assertEquals(VALID_TEST2, q.getAnswer());
    }

    @Test
    public void testEquals(){
        Question q = new Question(VALID_TEST1, VALID_TEST2);
        Question q1 = new Question(VALID_TEST1, VALID_TEST2);
        Question q2 = new Question(VALID_TEST1 + "def", VALID_TEST2 + " Учится папа за Васю весь год...");
        Question q3 = new Question(VALID_TEST1, VALID_TEST2 + " Учится папа за Васю весь год...");
        Question q4 = new Question(VALID_TEST1 + "def", VALID_TEST2);

        assertTrue(q.equals(q1));
        assertTrue(q1.equals(q));
        assertFalse(q.equals(q2));
        assertFalse(q.equals(q3));
        assertFalse(q.equals(q4));

    }

}
