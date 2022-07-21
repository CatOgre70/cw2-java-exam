package pro.sky.cw2javaexam.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class QuestionIsNotFoundInTheDatabaseException extends RuntimeException{

    public QuestionIsNotFoundInTheDatabaseException(String message) {
        super(message);
    }

}
