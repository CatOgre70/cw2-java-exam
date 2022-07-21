package pro.sky.cw2javaexam.service;

import org.springframework.stereotype.Service;
import pro.sky.cw2javaexam.database.Question;
import pro.sky.cw2javaexam.exceptions.NotEnoughQuestionsException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamineServiceImpl implements ExamineService {

    QuestionService questionService;

    public ExamineServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        if(amount > questionService.size())
            throw new NotEnoughQuestionsException("There is not enough questions in the database to generate such " +
                    "number of examine tickets");
        List<Question> qList = new ArrayList<>(amount);
        Question randomQuestion;
        int i = 0;
        while(i < amount){
            randomQuestion = questionService.getRandomQuestion();
            if(!qList.contains(randomQuestion)) {
                qList.add(randomQuestion);
                i++;
            }
        }
        return qList;
    }
}
