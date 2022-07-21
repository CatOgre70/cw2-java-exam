package pro.sky.cw2javaexam.service;

import pro.sky.cw2javaexam.database.Question;

import java.util.List;

public interface ExamineService {

    List<Question> getQuestions(int amount);

}
