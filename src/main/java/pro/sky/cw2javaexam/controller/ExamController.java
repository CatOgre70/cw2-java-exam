package pro.sky.cw2javaexam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.cw2javaexam.database.Question;
import pro.sky.cw2javaexam.service.ExamineService;

import java.util.List;

@RestController
@RequestMapping("/exam/get")
public class ExamController {

    private final ExamineService examineService;

    public ExamController(ExamineService examineService) {
        this.examineService = examineService;
    }

    @RequestMapping("")
    public String instructionOutput(){
        return "Usage: /exam/get/amount?number=<number of tickets for exam>";
    }

    @RequestMapping("/amount")
    public List<Question> getQuestions(@RequestParam("number") int number){
        return examineService.getQuestions(number);
    }

}
