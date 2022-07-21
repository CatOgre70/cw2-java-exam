package pro.sky.cw2javaexam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.cw2javaexam.database.Question;
import pro.sky.cw2javaexam.service.JavaQuestionService;


import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService){
        this.javaQuestionService = javaQuestionService;
    }

    @RequestMapping("")
    public List<Question> getQuestions(){
        return javaQuestionService.getAll();
    }

    @RequestMapping("/add")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer){
        return javaQuestionService.add(question, answer);
    }

    @RequestMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer){
        Question q = new Question(question, answer);
        return javaQuestionService.remove(q);
    }

}
