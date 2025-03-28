package Lineage2Calculator.Errors;

import Lineage2Calculator.Errors.CustomErrors.NoPathFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CalculateErrorAdvice {

    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException message) {
        return new ResponseEntity<>(message.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(NoPathFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoPathFoundException(NoPathFoundException message) {
        return message.getMessage();
    }
}
