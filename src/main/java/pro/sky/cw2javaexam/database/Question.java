package pro.sky.cw2javaexam.database;

import pro.sky.cw2javaexam.exceptions.WrongQuestionOrAnswerException;
import pro.sky.cw2javaexam.service.StringValidation;

import java.util.Objects;

public class Question {

    String question;
    String answer;

    public Question(String question, String answer) {
        if(!StringValidation.isStringValid(question))
            throw new WrongQuestionOrAnswerException("Wrong question " + question + " parameter in Question constructor");
        if(!StringValidation.isStringValid(answer))
            throw new WrongQuestionOrAnswerException("Wrong answer " + answer + " parameter in Question constructor");
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return question.equals(question1.question) && answer.equals(question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

}
