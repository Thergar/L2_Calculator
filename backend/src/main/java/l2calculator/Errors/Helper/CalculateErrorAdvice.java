package l2calculator.Errors.Helper;


import l2calculator.Errors.CustomErrors.NoPathFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The {@code CalculateErrorAdvice} class provides centralized exception handling
 * for the application by converting specific exceptions into appropriate HTTP responses.
 *
 * <p>
 *     It ensures that user input validation and pathfinding failures are reported
 *     to the client in a clean and meaningful way.
 * </p>
 */
@ControllerAdvice
public class CalculateErrorAdvice {

    /**
     * Handles validation errors such as invalid town names or algorithm types.
     *
     * @param message the exception to handle
     * @return the exception message as a plain text HTTP response
     */
    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException message) {
        return message.getMessage();
    }

    /**
     * Handles cases where no path could be found between towns.
     *
     * @param message the exception to handle
     * @return the exception message as a plain text HTTP response
     */
    @ResponseBody
    @ExceptionHandler(NoPathFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoPathFoundException(NoPathFoundException message) {
        return message.getMessage();
    }
}
