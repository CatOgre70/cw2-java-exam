package pro.sky.cw2javaexam.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.cw2javaexam.database.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestExamineServiceImpl {

    private static final int VALID_PARAM_ZERO = 0;
    private static final int VALID_PARAM_ONE = 1;
    private static final int VALID_PARAM_TWO = 2;
    private static final int VALID_PARAM_THREE = 3;
    private static final int VALID_PARAM_FOUR = 4;
    private static final int VALID_PARAM_FIVE = 5;
    private static final int VALID_PARAM_SIX = 6;
    private static final int VALID_PARAM_SEVEN = 7;
    private static final int VALID_PARAM_EIGHT = 8;
    private static final int VALID_PARAM_NINE = 9;
    private static final int NOT_VALID_PARAM_TEN = 10;

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExamineServiceImpl examineService;

    private final List<Question> qList = new ArrayList<>(List.of(
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

    @Test
    public void testGetQuestions(){
        int numberOfQuestions = VALID_PARAM_TWO;
        when(javaQuestionService.size()).thenReturn(qList.size());
        when(javaQuestionService.getRandomQuestion()).thenReturn(randomQuestion());
        List<Question> result = examineService.getQuestions(numberOfQuestions);
        Assertions.assertEquals(numberOfQuestions, result.size());
        for(int i = 0; i < result.size(); i++){
            for(int j = i+1; j < result.size(); j++)
                Assertions.assertNotEquals(result.get(i), result.get(j));
        }

    }

    public Question randomQuestion(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(qList.size());
        return qList.get(randomIndex);
    }

}
