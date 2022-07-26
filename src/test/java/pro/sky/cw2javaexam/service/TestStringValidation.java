package pro.sky.cw2javaexam.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStringValidation {

    String validString1;
    String validString2;
    String notValidString1;
    String notValidString2;


    @BeforeEach
    public void varInit(){
        validString1 = "abc";
        validString2 = "папа у Васи силен в математике...";
        notValidString1 = null;
        notValidString2 = "";
    }

    @Test
    public void isStringValid(){
        assertTrue(StringValidation.isStringValid(validString1));
        assertTrue(StringValidation.isStringValid(validString2));
        assertFalse(StringValidation.isStringValid(notValidString1));
        assertFalse(StringValidation.isStringValid(notValidString2));
    }

}
