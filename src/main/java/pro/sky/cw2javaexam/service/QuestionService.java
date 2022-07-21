package pro.sky.cw2javaexam.service;

import pro.sky.cw2javaexam.database.Question;

import java.util.List;

public interface QuestionService {

    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    List<Question> getAll();
    Question getRandomQuestion();
    int size();
}
