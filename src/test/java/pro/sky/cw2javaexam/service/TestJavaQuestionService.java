package pro.sky.cw2javaexam.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.cw2javaexam.database.Question;
import pro.sky.cw2javaexam.exceptions.QuestionIsAlreadyInTheDatabaseException;
import pro.sky.cw2javaexam.exceptions.QuestionIsNotFoundInTheDatabaseException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestJavaQuestionService {

    List<Question> expected;
    JavaQuestionService javaQuestionService;
    private static final String VALID_TEST1 = "abc";
    private static final String VALID_TEST2 = "Папа у Васи силен в математике...";

    @BeforeEach
    public void variablesInit(){
        expected = new ArrayList<>(List.of(
                new Question("Что такое Java?", "Java - это язык программирования"),
                new Question("К какому типу языков относиться Java?", "Java - это интерпретируемый язык, " +
                        "реализующий принципы объектно-ориентированного программирования (ООП)"),
                new Question("Какие примитивные типы данных используются в Java?", "Примитивные типы " +
                        "данных - это boolean, char, byte, short, int, long, float и double"),
                new Question("Что такое классы-обертки?", "Классы-обертки - это классы Java, каждый из " +
                        "которых \"обертывает\" примитивный тип в класс Java"),
                new Question("Какие условные операторы есть в языке Java?", "Условными операторами в " +
                        "Java являются два оператора: оператор if, и оператор switch"),
                new Question("Какие циклы вы знаете, в чем их отличия?", "Я знаю четыре типа операторов " +
                        "цикла в Java: цикл while, цикл do-while, цикл for и цикл for-each. " +
                        "Самым часто используемым оператором цикла является оператор for"),
                new Question("Методы каких типов бывают? Приведите примеры использования каждого типа",
                        "Методы бывают статические и нестатические. Статические методы принадлежат классу, т.е. " +
                                "могут вызываться через имя класса с точкой, после которой следует имя метода и " +
                                "параметры метода в круглых скобках. А нестатические методы — это методы, которые " +
                                "вызываются только через объекты класса аналогичным образом"),
                new Question("Расскажите о переменных примитивного и ссылочного типа? В чём различия данных " +
                        "переменных?", "Примитивные типы переменных они такие примитивные, примитивные! У них " +
                        "даже своего массажиста, косметолога, тренера и кучера нет! Ничего у них нет, кроме имени и " +
                        "значения. А кто сказал, что имя переменной — это не ссылка на ячейку памяти, где она лежит? " +
                        "Разделение условно. Некоторые аспекты работы с этими типами переменных скрыты от программиста " +
                        "в Java, в отличие, например, от языка C++, где программист может сам определить ссылочный " +
                        "тип переменной или обычный. Собственно в этом и заключается скрытый смысл этих двух " +
                        "определений. Примитивные типы переменных — это не классы, это базовые конструкты языка. " +
                        "Ссылочные типы — это объекты классов, у которых есть методы классов, возможна работа с " +
                        "полями класса и его методами. Для сохранения и всяческого развития принципов ООП в Java у " +
                        "каждого типа примитивных переменных есть свои классы-оболочки, у которых есть все то, чего " +
                        "нет у примитивных типов. Особенно разница между примитивными и ссылочными типами переменных " +
                        "проявляется при передаче переменных в качестве параметров метода. Всегда и только по значению " +
                        "происходит передача параметров в методы Java"),
                new Question("Что такое инкапсуляция? Дайте определение и опишите основные особенности " +
                        "данного принципа ООП",
                        "Принцип инкапсуляции: поля класса, а также внутренние методы класса, которые выполняют " +
                                "внутреннюю работу, не должны быть видны снаружи класса, поэтому должны описываться " +
                                "как приватные (private). Доступ к полям класса осуществляется только через публичные " +
                                "методы класса, которые частенько называются геттерами и сеттерами"),
                new Question("Что такое коллекции? Какие основные типы коллекций вам известны?",
                        "Коллекции — это базовый интерфейс языка Java, который вместе с некоторыми абстрактными " +
                                "классами и другими интерфейсами описывает различные структуры данных")
        ));
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    public void testConstructor(){
        List<Question> result = javaQuestionService.getAll();
        assertEquals(expected, result);
    }

    @Test
    public void testAddStringVersion(){
        Question expected1 = new Question(VALID_TEST1, VALID_TEST2);
        expected.add(expected1);
        Question result1 = javaQuestionService.add(VALID_TEST1, VALID_TEST2);
        List<Question> result = javaQuestionService.getAll();
        assertEquals(expected1, result1);
        assertEquals(expected, result);
    }

    @Test
    public void testAddQuestionVersion(){
        Question expected1 = new Question(VALID_TEST1, VALID_TEST2);
        expected.add(expected1);
        Question result1 = javaQuestionService.add(expected1);
        List<Question> result = javaQuestionService.getAll();
        assertEquals(expected1, result1);
        assertEquals(expected, result);
    }

    @Test
    public void testAddOnException(){
        Question q = new Question(VALID_TEST1, VALID_TEST2);
        javaQuestionService.add(q);
        assertThrows(QuestionIsAlreadyInTheDatabaseException.class,() -> javaQuestionService.add(q));
    }

    @Test
    public void testRemove(){
        Question expected1 = new Question("Что такое коллекции? Какие основные типы коллекций вам известны?",
                "Коллекции — это базовый интерфейс языка Java, который вместе с некоторыми абстрактными " +
                        "классами и другими интерфейсами описывает различные структуры данных");
        Question result1 = javaQuestionService.remove(expected1);
        List<Question> result = javaQuestionService.getAll();
        expected.remove(expected1);

        assertEquals(expected1, result1);
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveOnException(){
        Question expected1 = new Question(VALID_TEST1, VALID_TEST2);
        assertThrows(QuestionIsNotFoundInTheDatabaseException.class, () -> javaQuestionService.remove(expected1));
    }

    @Test
    public void testGetAll(){
        List<Question> result = javaQuestionService.getAll();
        assertEquals(expected, result);
    }

    @Test
    public void testSize(){
        assertEquals(expected.size(), javaQuestionService.size());
    }

    @Test
    public void testGetRandomQuestion(){
        int numberOfTests = 1_000_000;
        int indexMin = 100;
        int indexMax = -1;
        List<Question> test = javaQuestionService.getAll();
        for(int i = 0; i < numberOfTests; i++){
            Question q = javaQuestionService.getRandomQuestion();
            int index = test.indexOf(q);
            assertTrue(index >= 0 && index < javaQuestionService.size());
            if(index < indexMin)
                indexMin = index;
            if(index > indexMax)
                indexMax = index;
        }
        assertEquals(0, indexMin);
        assertEquals(javaQuestionService.size()-1, indexMax);
    }
}
