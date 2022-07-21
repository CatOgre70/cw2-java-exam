package pro.sky.cw2javaexam.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class QuestionIsAlreadyInTheDatabaseException extends RuntimeException{

    public QuestionIsAlreadyInTheDatabaseException(String message) {
        super(message);
    }

}
